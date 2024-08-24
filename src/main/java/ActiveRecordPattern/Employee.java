package ActiveRecordPattern;

import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;

import java.util.ArrayList;

public class Employee extends ActiveRecordPattern<Employee> {

    private static String entityName = "Employee";
    private static final String primaryKey = "id";
    private String firstName;
    private int id;
    private String secondName;
    private String lastName;
    private int salary;
    private String email;
    private String phone;
    private String city;
    private String street;
    private String zipCode;
    private String country;
    private String gender;
    private LocalDate birthDate;

    public Employee(String firstName, String secondName, String lastName, int salary,
                    String email, String phone, String country, String city, String street, String zipCode, String gender, LocalDate birthDate) {
        super(entityName, primaryKey);
        setObj(this);
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.salary = salary;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.gender = gender;
        this.country = country;
        this.birthDate = birthDate;
    }

    public Employee() {
        super(entityName, primaryKey);
        setObj(this);
    }


    public Employee(int employeeId) {
        super(entityName, primaryKey);
        setObj(this);
        this.id = employeeId;
        super.setId(this.id);
    }


    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
        super.setId(id);
    }


    public String getCountry() {
        return country;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getlastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getGender() {
        return gender;
    }

    public void setEmployeeId(int employeeId) {
        setId(employeeId);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static void delete(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
        ActiveRecordPattern.delete(criteria, entityName);
    }

    public static int size() {
        return findCount(entityName);
    }

    public static Employee findById(int id) {
        return ActiveRecordPattern.findByID(id, entityName, primaryKey);
    }

    public static ArrayList<Employee> find(ArrayList<SimpleEntry<String, String>> criteria) {
        return ActiveRecordPattern.find(criteria, entityName);
    }


}
