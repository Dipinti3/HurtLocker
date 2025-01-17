import java.util.ArrayList;
import java.util.Collections;

public class GroceryList {
    private ArrayList<GroceryData> groceryList;
    private Integer exceptions;

    private static final GroceryList INSTANCE=new GroceryList();

    private GroceryList() {
        this.groceryList=new ArrayList<GroceryData>();
        this.exceptions=0;
    }

    public static GroceryList getInstance(){
        return INSTANCE;
    }

    public Integer[] countItem(){
        Integer[] countItems=new Integer[]{0,0,0,0};
        for (int i = 0; i < groceryList.size(); i++) {
            if(groceryList.get(i).getName().equals("Milk"))
                countItems[0]++;
            else if(groceryList.get(i).getName().equals("Bread"))
                countItems[1]++;
            else if(groceryList.get(i).getName().equals("Cookies"))
                countItems[2]++;
            else if(groceryList.get(i).getName().equals("Apples"))
                countItems[3]++;
        }
        return countItems;
    }

    public void incrementExceptions(){
        exceptions++;
    }

    public void addItem(GroceryData groceryData){
        groceryList.add(groceryData);
    }

    public ArrayList createPriceList(String data){
        ArrayList<String>priceList=new ArrayList<String>();
        for (int i = 0; i <groceryList.size(); i++) {
             if(groceryList.get(i).getName().equals(data))
                 priceList.add(groceryList.get(i).getPrice());
        }
        return priceList;
    }

    public String countPriceForEachItem(String data){
        int count=1;
        ArrayList<String>priceList=createPriceList(data);
        StringBuilder sb=new StringBuilder();
        Collections.sort(priceList);
        for (int i = 1; i < priceList.size(); i++) {
             if((priceList.get(i-1).equals(priceList.get(i))) && (i!=priceList.size()-1))
                 count++;
             else if(i!=priceList.size()-1){
                 sb.append("Price: "+priceList.get(i-1)+"\t\tseen: "+count+" times\n");
                 count=1;
             }
             else{
                 count++;
                 sb.append("Price: "+priceList.get(i)+"\t\tseen: "+count+" times\n");
                 count=1;
             }
        }
        return sb.toString();
    }

    public void printItems(){
        String milk=countPriceForEachItem("Milk");
        String bread=countPriceForEachItem("Bread");
        String cookie=countPriceForEachItem("Cookies");
        String apple=countPriceForEachItem("Apples");
        Integer[] countItems=countItem();

        System.out.printf(
                                "name:Milk \t\t seen: %d times\n" +
                                "============= \t \t =============\n" +
                                "%s\n"+
                                "name:Bread \t\t seen: %d times\n" +
                                "============= \t \t =============\n" +
                                "%s\n"+
                                "name:Cookies\tseen: %d times\n"+
                                "%s\n"+
                                "name:Apples\t\tseen:  %d times\n"+
                                "%s\n"+
                                "Errors         \tseen: %d times"
                ,countItems[0],milk
                ,countItems[1],bread
                ,countItems[2],cookie
                ,countItems[3],apple
                ,exceptions);
    }


}
