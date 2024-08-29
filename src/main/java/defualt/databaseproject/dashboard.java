
package defualt.databaseproject;

import ActiveRecordPattern.Customer;
import ActiveRecordPattern.Orders;
import ActiveRecordPattern.Product;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;


public class dashboard {
    @FXML
    AnchorPane HomePage;
    @FXML
    AnchorPane AddCustomerPage;
    @FXML
    AnchorPane ViewCustomerPage;
    @FXML
    AnchorPane AddOrderPage;
    @FXML
    AnchorPane ViewOrderPage;
    @FXML
    AnchorPane SearchForProductsPage;
    /////////////////////////////////////////////////////////////////////////////////Labels
    @FXML
    private Label numberOfOrdersLabel;
    @FXML
    private Label numberOfProductsLabel;
    @FXML
    private Label numberOfCustomersLabel;

    ////////////////////////////////////////////////////////////////////////////////////TextFields
    @FXML
    private TextField customerFirstNameField;

    @FXML
    private TextField customerLastNameField;
    @FXML
    private TextField customerMiddleNameField;
    @FXML
    private TextField customerEmailField;
    @FXML
    private TextField customerPhoneField;
    @FXML
    private TextField customerCountryField;
    @FXML
    private TextField customerCityField;
    @FXML
    private TextField customerStreetField;
    @FXML
    private TextField customerZipCodeField;
    ///////////////////////////////////////////////
    @FXML
    private DatePicker customerBirthDateField;

    //////////////////////////////////////////////////////////////////ToggleGroup
    @FXML
    private ToggleGroup customerGenderToggleGroup;
    @FXML
    private RadioButton customerGenderRadioButtonM;
    @FXML
    private RadioButton CustomerGenderRadioButtonF;

    ////////////////////////////////////////////////
    @FXML
    public void initialize() {
        customerGenderToggleGroup = new ToggleGroup();
        customerGenderRadioButtonM.setToggleGroup(customerGenderToggleGroup);
        CustomerGenderRadioButtonF.setToggleGroup(customerGenderToggleGroup);
//        homeButtonClick();
    }

    private void setView(int choice) {
        HomePage.setVisible(choice == 1);
        AddCustomerPage.setVisible(choice == 2);
        ViewCustomerPage.setVisible(choice == 3);
        AddOrderPage.setVisible(choice == 4);
        ViewOrderPage.setVisible(choice == 5);
        SearchForProductsPage.setVisible(choice == 6);
    }

    //////////////////////////////////////////////////////////////////////
    @FXML
    public void homeButtonClick() {
        setView(1);
        numberOfCustomersLabel.setText("" + Customer.size());
        numberOfOrdersLabel.setText("" + Orders.size());
        numberOfProductsLabel.setText("" + Product.size());
    }

    @FXML
    public void addCustomerClick() {
        setView(2);
    }


    @FXML
    public void viewCustomerClick() {
        setView(3);
    }

    @FXML
    public void addOrderClick() {
        setView(4);
    }

    @FXML
    public void viewOrderClick() {
        setView(5);
    }

    @FXML
    public void searchForProductsClick() {
        setView(6);
    }

    @FXML
    public void logoutClick() {
        StageManager.switchScene("LogIn.fxml");
    }

    @FXML
    public void PrintOrder() {

    }

    ////////////////////////////////////////////////////////////////////////////
    @FXML
    private void addEmployeeButton() {
        String firstName = customerFirstNameField.getText();
        String lastName = customerLastNameField.getText();
        String middleName = customerMiddleNameField.getText();
        String email = customerEmailField.getText();
        String phone = customerPhoneField.getText();
        String country = customerCountryField.getText();
        String city = customerCityField.getText();
        String street = customerStreetField.getText();
        String zipCode = customerZipCodeField.getText();
        LocalDate birthDate = customerBirthDateField.getValue();
        RadioButton selectedGender = (RadioButton) customerGenderToggleGroup.getSelectedToggle();

        String gender = null;
        try {

            gender = selectedGender.getText().equals("Male") ? "M" : "F";
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        new Customer(firstName, lastName, middleName, birthDate, gender, email, phone, country, city, street,
                zipCode).save();
    }
}

