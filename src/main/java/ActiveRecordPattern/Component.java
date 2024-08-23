package ActiveRecordPattern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.ArrayList;

public class Component extends Try<Component> {
    private String name;
    private int price;
    private String type;
    private int quantity;
    private static String entityName = "Component";
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
    }

    public Component() {
        super(entityName, primaryKey);
        setObj(this);
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public int getprice() {
        return price;
    }

    public void setprice(int price) {
        this.price = price;
    }

    public String gettype() {
        return type;

    }

    public void settype(String type) {
        this.type = type;
    }

    public int getquantity() {
        return quantity;

    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }

    public static void delete(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
        Try.delete(criteria, entityName);
    }

    public static int size() {
        System.out.println(findCount(entityName));
        return findCount(entityName);
    }

    public static Component findById(int id) {
        return Try.findByID(id, entityName, primaryKey);
    }

    public static ArrayList<Component> find(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
        return Try.find(criteria, entityName);
    }
}
