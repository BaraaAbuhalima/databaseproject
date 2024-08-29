package ActiveRecordPattern;

import java.util.AbstractMap;
import java.util.ArrayList;

public class Product extends ActiveRecordPattern<Product> {
    private final static String entityName = "Product";
    private final static String primaryKey = "id";
    private int id;
    private int price;
    private String name;
    private String itemDetails;

    public Product() {
        super(entityName, primaryKey);
        setObj(this);
    }

    public Product(int price, String name, String itemDetails) {
        super(entityName, primaryKey);
        setObj(this);
        this.price = price;
        this.name = name;
        this.itemDetails = itemDetails;


    }

    public Product(int id) {
        super(entityName, primaryKey);
        setObj(this);
        this.id = id;
    }

    public int getId() {
        return id;

    }

    public Product setId(int id) {
        this.id = id;
        return this;
    }

    public int getPrice() {
        return price;

    }

    public Product setPrice(int price) {
        this.price = price;
        return this;

    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getItemDetails() {
        return itemDetails;
    }

    public Product setItemDetails(String itemDetails) {
        this.itemDetails = itemDetails;
        return this;
    }


    public static void delete(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
        ActiveRecordPattern.delete(criteria, entityName);
    }

    public static int size() {
        return findCount(entityName);
    }

    public static Product findById(int id) {
        return ActiveRecordPattern.findById(id, entityName, primaryKey);
    }

    public static ArrayList<Product> find(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
        return ActiveRecordPattern.find(criteria, entityName);
    }

    public static void delete(int id) {
        ArrayList<AbstractMap.SimpleEntry<String, String>> criteria = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
        criteria.add(new AbstractMap.SimpleEntry<String, String>("id", "" + id));
        ActiveRecordPattern.delete(criteria, entityName);
    }
}
