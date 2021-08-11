import java.util.ArrayList;

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
}
