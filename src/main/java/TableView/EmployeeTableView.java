package TableView;

import javafx.beans.property.*;

public class EmployeeTableView {
    private final IntegerProperty id;
    private final StringProperty firstName;
    private final StringProperty secondName;
    private final StringProperty lastName;
    private final StringProperty country;
    private final StringProperty city;
    private final StringProperty street;
    private final StringProperty zipCode;
    private final StringProperty gender;
    private final StringProperty phone;
    private final StringProperty email;
    private final IntegerProperty salary;
    private final StringProperty birthDate;


    public EmployeeTableView(int id, String firstName, String secondName, String lastName, String country,
                             String city, String street, String zipCode, String phone, String email, int salary, String gender, String birthDate) {
        this.id = new SimpleIntegerProperty(id);
        this.firstName = new SimpleStringProperty(firstName);
        this.secondName = new SimpleStringProperty(secondName);
        this.lastName = new SimpleStringProperty(lastName);
        this.country = new SimpleStringProperty(country);
        this.city = new SimpleStringProperty(city);
        this.street = new SimpleStringProperty(street);
        this.zipCode = new SimpleStringProperty(zipCode);
        this.phone = new SimpleStringProperty(phone);
        this.email = new SimpleStringProperty(email);
        this.salary = new SimpleIntegerProperty(salary);
        this.birthDate = new SimpleStringProperty(birthDate);
        this.gender = new SimpleStringProperty(gender);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getSecondName() {
        return secondName.get();
    }

    public void setSecondName(String secondName) {
        this.secondName.set(secondName);
    }

    public StringProperty secondNameProperty() {
        return secondName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getCountry() {
        return country.get();
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public StringProperty countryProperty() {
        return country;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public StringProperty cityProperty() {
        return city;
    }

    public String getStreet() {
        return street.get();
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public StringProperty streetProperty() {
        return street;
    }

    public String getZipCode() {
        return zipCode.get();
    }

    public void setZipCode(String zipCode) {
        this.zipCode.set(zipCode);
    }

    public StringProperty zipCodeProperty() {
        return zipCode;
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }

    public int getSalary() {
        return salary.get();
    }

    public void setSalary(int salary) {
        this.salary.set(salary);
    }

    public IntegerProperty salaryProperty() {
        return salary;
    }

    public String getBirthDate() {
        return birthDate.get();
    }

    public void setBirthDate(String birthDate) {
        this.birthDate.set(birthDate);
    }

    public StringProperty birthDateProperty() {
        return birthDate;
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public StringProperty genderProperty() {
        return gender;
    }
}
