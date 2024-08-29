package ActiveRecordPattern;

import java.util.AbstractMap;
import java.util.ArrayList;

public class Supplier extends ActiveRecordPattern<Supplier> {
    private static final String entityName = "Supplier";
    private static final String primaryKey = "id";
    private int id;
    private String name;
    private String country;
    private String city;
    private String street;
    private String zipCode;
    private String phone;
    private String email;

    public Supplier() {
        super(entityName, primaryKey);
        setObj(this);
    }

    public Supplier(int supplierId) {
        super(entityName, primaryKey);
        setObj(this);
        this.id = supplierId;
        super.setId(id);
    }

    public Supplier(String name, String country, String city, String street, String zipCode, String phone, String email) {
        super(entityName, primaryKey);
        setObj(this);
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.phone = phone;
        this.email = email;

    }

    public int getEmployeeId() {
        return this.id;
    }

    public Supplier setId(int id) {
        this.id = id;
        super.setId(id);
        return this;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Supplier setName(String name) {
        this.name = name;
        return this;
    }


    public String getCountry() {
        return country;
    }

    public Supplier setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Supplier setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Supplier setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Supplier setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;

    }

    public String getPhone() {
        return phone;
    }

    public Supplier setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Supplier setEmail(String email) {
        this.email = email;
        return this;
    }

    public static void delete(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
        ActiveRecordPattern.delete(criteria, entityName);
    }

    public static int size() {
        System.out.println(findCount(entityName));
        return findCount(entityName);
    }

    public static Supplier findById(int id) {
        return ActiveRecordPattern.findById(id, entityName, primaryKey);
    }

    public static ArrayList<Supplier> find(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
        return ActiveRecordPattern.find(criteria, entityName);
    }

    public static void delete(int id) {
        ArrayList<AbstractMap.SimpleEntry<String, String>> criteria = new ArrayList<>();
        criteria.add(new AbstractMap.SimpleEntry<String, String>("id", "" + id));
        ActiveRecordPattern.delete(criteria, entityName);
    }
}
