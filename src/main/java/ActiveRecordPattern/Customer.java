package ActiveRecordPattern;

import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;

public class Customer extends ActiveRecordPattern<Customer> {

    private static final String entityName = "Customer";
    private static final String primaryKey = "id";
    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDate;
    private String gender;
    private String email;
    private String phone;
    private String country;
    private String city;
    private String street;
    private String zipCode;


    public Customer() {
        super(entityName, primaryKey);
        setObj(this);
    }


    public Customer(int customerId) {
        super(entityName, primaryKey);
        this.id = customerId;
        super.setId(this.id);
        setObj(this);
    }

    //
    public Customer(String firstName, String lastName, String middleName, LocalDate birthDate,
                    String gender, String email, String phone, String country,
                    String city, String street, String zipCode) {

        super(entityName, primaryKey);
        setObj(this);
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    public Customer setId(int id) {
        this.id = id;
        super.setId(this.id);
        return this;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public Customer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Customer setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Customer setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Customer setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Customer setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Customer setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Customer setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Customer setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Customer setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;

    }

    public static void delete(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
        ActiveRecordPattern.delete(criteria, entityName);
    }

    public static int size() {
        System.out.println(findCount(entityName));
        return findCount(entityName);
    }

    public static Customer findById(int id) {
        return ActiveRecordPattern.findByID(id, entityName, primaryKey);
    }

    public static ArrayList<Customer> find(ArrayList<SimpleEntry<String, String>> criteria) {
        return ActiveRecordPattern.find(criteria, entityName);
    }
}
