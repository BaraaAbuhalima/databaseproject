package ActiveRecordPattern;

import java.util.AbstractMap;
import java.util.ArrayList;

public class Component extends ActiveRecordPattern<Component> {
    private String name;
    private int price;
    private int id;
    private String type;
    private int quantity;
    private final static String entityName = "Component";
    private static final String primaryKey = "id";

    public Component(String name, int price, String type, int quantity) {
        super(entityName, primaryKey);
        setObj(this);
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }

    public Component(int ComponentID) {
        super(entityName, primaryKey);
        setObj(this);
        this.id = ComponentID;
        super.setId(this.id);
    }

    public Component() {
        super(entityName, primaryKey);
        setObj(this);
    }

    public String getName() {
        return name;
    }

    public Component setId(int id) {
        this.id = id;
        super.setId(this.id);
        return this;
    }

    public int getId() {
        return id;
    }

    public Component setName(String name) {
        this.name = name;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Component setPrice(int price) {
        this.price = price;
        return this;
    }

    public String gettype() {
        return type;

    }

    public Component setType(String type) {
        this.type = type;
        return this;
    }

    public int getQuantity() {
        return quantity;

    }

    public Component setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public static void delete(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
        ActiveRecordPattern.delete(criteria, entityName);
    }

    public static int size() {
        return findCount(entityName);
    }

    public static Component findById(int id) {
        return ActiveRecordPattern.findById(id, entityName, primaryKey);
    }

    public static ArrayList<Component> find(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
        return ActiveRecordPattern.find(criteria, entityName);
    }

    public static void delete(int id) {
        ArrayList<AbstractMap.SimpleEntry<String, String>> criteria = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
        criteria.add(new AbstractMap.SimpleEntry<String, String>("id", "" + id));
        ActiveRecordPattern.delete(criteria, entityName);
    }
}
