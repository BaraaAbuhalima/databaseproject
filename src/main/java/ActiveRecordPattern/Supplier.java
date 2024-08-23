package ActiveRecordPattern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.ArrayList;

public class Supplier extends Try<Supplier> {
    private String name;
    private String country;
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

    public int getSupplierId() {
        return getId();
    }

    public void setSupplierId(int supplierId) {
        this.setId(supplierId);
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getcountry() {
        return country;
    }

    public void setcountry(String country) {
        this.country = country;
    }

    public String getcity() {
        return city;
    }

    public void setcity(String city) {
        this.city = city;

    }

    public String getstreet() {
        return street;
    }

    public void setstreet(String street) {
        this.street = street;
    }

    public String getzipCode() {
        return zipCode;
    }

    public void setzipCode(String zipCode) {
        this.zipCode = zipCode;

    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public static void delete(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
        Try.delete(criteria, entityName);
    }

    public static int size() {
        System.out.println(findCount(entityName));
        return findCount(entityName);
    }

    public static <Supplier> Supplier findById(int id) {
        return Try.findByID(id, entityName, primaryKey);
    }

    public static <Supplier> ArrayList<Supplier> find(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
        return Try.find(criteria, entityName);
    }
}
