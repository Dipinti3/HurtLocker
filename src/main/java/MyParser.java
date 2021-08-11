import java.util.regex.Pattern;

public class MyParser {
    private GroceryList lists;
    private String keyValueRegex=":";
    private String pairRegex="[!@%^*;]";
    private String objRegex="##";
    private String parserString;

    private MyParser(String parserString) {
        this.parserString = parserString;
        lists=GroceryList.getInstance();
    }

    public String[] parseEachItem(String regex,String stringToParse){
        return Pattern.compile(regex).split(stringToParse);
    }
}
