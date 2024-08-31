package TableView;

import javafx.beans.property.*;

public class CustomerTableView extends TableViewPattern {
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
    private final StringProperty birthDate;

    public CustomerTableView(int id, String firstName, String secondName, String lastName,
                             String country, String city, String street, String zipCode,
                             String phone, String email, String gender, String birthDate) {
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
        this.gender = new SimpleStringProperty(gender);
        this.birthDate = new SimpleStringProperty(birthDate);
    }

    public String getZipCode() {
        return zipCode.get();
    }

    public StringProperty zipCodeProperty() {
        return zipCode;
    }

    public String getStreet() {
        return street.get();
    }

    public StringProperty streetProperty() {
        return street;
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public String getCountry() {
        return country.get();
    }

    public StringProperty countryProperty() {
        return country;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getSecondName() {
        return secondName.get();
    }

    public StringProperty secondNameProperty() {
        return secondName;
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public String getBirthDate() {
        return birthDate.get();
    }

    public StringProperty birthDateProperty() {
        return birthDate;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public void setSecondName(String secondName) {
        this.secondName.set(secondName);
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public void setCity(String city) {
        this.city.set(city);

    }

    public void setStreet(String street) {
        this.street.set(street);

    }

    public void setZipCode(String zipCode) {
        this.zipCode.set(zipCode);

    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public void setPhone(String phone) {
        this.phone.set(phone);

    }

    public void setEmail(String email) {
        this.email.set(email);

    }

    public void setBirthDate(String birthDate) {
        this.birthDate.set(birthDate);

    }

}
