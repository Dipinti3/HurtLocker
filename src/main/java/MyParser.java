import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyParser {
    private GroceryList lists;
    private String keyValueRegex=":";
    private String pairRegex="[!@%^*;]";
    private String objRegex="##";
    private String parserString;

    MyParser(String parserString) {
        this.parserString = parserString;
        lists=GroceryList.getInstance();
    }

    public String[] parseEachItem(String regex,String stringToParse){
        return Pattern.compile(regex).split(stringToParse);
    }

    public List<List<String[]>> parseRawData(){
        String[] objects=parseEachItem(objRegex,parserString);
        return Stream.of(objects).map(obj->parseEachItem(pairRegex,obj))
                .collect(Collectors.toList())
                .stream()
                .map(
                        array->Stream.of(array)
                        .map(pair->parseEachItem(keyValueRegex,pair))
                        .collect(Collectors.toList()))
                        .collect(Collectors.toList());
    }

    public void createHumanReadableItems(List<List<String[]>> nonReadableList){
        for (int i = 0; i < nonReadableList.size(); i++) {
             try{
                 GroceryData g=new GroceryData();
                 g.setName(nonReadableList.get(i).get(0)[1]);
                 g.setPrice(nonReadableList.get(i).get(1)[1]);
                 g.setType(nonReadableList.get(i).get(2)[1]);
                 g.setExpiration(nonReadableList.get(i).get(3)[1]);
                 lists.addItem(g);
             }
             catch(Exception e){
                 lists.incrementExceptions();
             }
        }
    }
}
