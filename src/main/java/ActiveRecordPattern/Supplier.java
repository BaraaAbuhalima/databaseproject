package ActiveRecordPattern;

import java.util.AbstractMap;
import java.util.ArrayList;

public class Supplier extends ActiveRecordPattern<Supplier> {
    private String name;
    private String country;
    private int id;
    private String city;
    private String street;
    private String zipCode;
    private String phone;
    private String email;
    private static final String entityName = "Supplier";
    private static final String primaryKey = "id";

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

    public void setId(int id) {
        this.id = id;
        super.setId(id);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static void delete(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
        ActiveRecordPattern.delete(criteria, entityName);
    }

    public static int size() {
        System.out.println(findCount(entityName));
        return findCount(entityName);
    }

    public static Supplier findById(int id) {
        return ActiveRecordPattern.findByID(id, entityName, primaryKey);
    }

    public static ArrayList<Supplier> find(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
        return ActiveRecordPattern.find(criteria, entityName);
    }
}
