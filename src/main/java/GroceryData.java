import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroceryData {
    private String name;
    private String price;
    private String type;
    private String expiration;

    public GroceryData() {
    }

    public GroceryData(String name, String price, String type, String expiration) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = groceryNamesList(name);
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String groceryNamesList(String name){
        Pattern pattern=Pattern.compile("c[oo?i]kies]",Pattern.CASE_INSENSITIVE);
        Matcher matcher=pattern.matcher(name);
        while(matcher.find()){name=matcher.replaceAll("Cookies");}
        matcher.reset();

        matcher.usePattern(Pattern.compile("apples",Pattern.CASE_INSENSITIVE));
        while(matcher.find()){name=matcher.replaceAll("Apples");}
        matcher.reset();

        matcher.usePattern(Pattern.compile("bread",Pattern.CASE_INSENSITIVE));
        while(matcher.find()){name=matcher.replaceAll("Bread");}
        matcher.reset();

        matcher.usePattern(Pattern.compile("milk",Pattern.CASE_INSENSITIVE));
        while(matcher.find()){name=matcher.replaceAll("Milk");}
        return name;
    }
}
