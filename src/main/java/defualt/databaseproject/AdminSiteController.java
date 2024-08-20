package defualt.databaseproject;

import ActiveRecordPattern.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import defualt.databaseproject.LogInController;

import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import static ActiveRecordPattern.Employee.findByID;

import defualt.databaseproject.ActiveRecordPattern.*;

public class AdminSiteController {
    private static Users staticuser;

    @FXML
    private AnchorPane AdminMainPage;
    @FXML
    private AnchorPane AddEmployee;
    @FXML
    private AnchorPane ViewEmployee;
    @FXML
    private AnchorPane AddSupplier;
    @FXML
    private AnchorPane ViewSupplier;
    @FXML
    private AnchorPane AddComponent;
    @FXML
    private AnchorPane ViewComponent;
    @FXML
    private Label NumberOfEmployeeLable;
    @FXML
    private Label NumberOfOrdersLable;
    @FXML
    private Label NumberOfSuppliersLable;
    @FXML
    private Label NumberOfComponentsLable;
    @FXML
    private Label NumberOfCustomersLable;
    @FXML
    private Label NumberOfProductsLable;
    @FXML
    private Label AdminNameDisplay;

    public AdminSiteController() {
//        this.NumberOfEmployeeLable.setText("dfsdfdsfdsfsd");
    }

    public static void setUser(Users user) {
        staticuser = user;
    }

    @FXML
    private void initialize() {
        homeButtonClick(null);
        AdminNameDisplay.setText(staticuser.getUserName());
    }

    public static int numberOfEmployee() {
        int Count = 0;
        try {
            ResultSet numberOfEmployee = DatabaseOperations.makeQuery("SELECT COUNT(*) FROM employee;");
            if (numberOfEmployee.next()) {
                Count = numberOfEmployee.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Count;
    }

    public static int numberOfOrders() {
        int Count = 0;
        try {
            ResultSet numberOfOrders = DatabaseOperations.makeQuery("SELECT COUNT(*) FROM orders;");
            if (numberOfOrders.next()) {
                Count = numberOfOrders.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Count;
    }

    public static int numberOfProducts() {
        int Count = 0;
        try {
            ResultSet numberOfProducts = DatabaseOperations.makeQuery("SELECT COUNT(*) FROM product;");
            if (numberOfProducts.next()) {
                Count = numberOfProducts.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Count;
    }

    public static int numberOfCustomers() {
        int Count = 0;
        try {
            ResultSet numberOfCustomers = DatabaseOperations.makeQuery("SELECT COUNT(*) FROM customer;");
            if (numberOfCustomers.next()) {
                Count = numberOfCustomers.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Count;
    }

    public static int numberOfSuppliers() {
        int Count = 0;
        try {
            ResultSet numberOfSuppliers = DatabaseOperations.makeQuery("SELECT COUNT(*) FROM supplier;");
            if (numberOfSuppliers.next()) {
                Count = numberOfSuppliers.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Count;
    }

    public static int numberOfComponents() {
        int Count = 0;
        try {
            ResultSet numberOfComponents = DatabaseOperations.makeQuery("SELECT COUNT(*) FROM component;");
            if (numberOfComponents.next()) {
                Count = numberOfComponents.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Count;
    }

    @FXML
    public void homeButtonClick(ActionEvent actionEvent) {
        AdminMainPage.setVisible(true);
        AddEmployee.setVisible(false);
        ViewEmployee.setVisible(false);
        AddSupplier.setVisible(false);
        ViewSupplier.setVisible(false);
        AddComponent.setVisible(false);
        ViewComponent.setVisible(false);
        String Number_Of_Employee = String.valueOf(numberOfEmployee());
        String Number_Of_Orders = String.valueOf(numberOfOrders());
        String Number_Of_Products = String.valueOf(numberOfProducts());
        String Number_Of_Customers = String.valueOf(numberOfCustomers());
        String Number_Of_Suppliers = String.valueOf(numberOfSuppliers());
        String Number_Of_Components = String.valueOf(numberOfComponents());
        NumberOfEmployeeLable.setText(String.valueOf(numberOfEmployee()));
        NumberOfOrdersLable.setText(String.valueOf(numberOfOrders()));
        NumberOfProductsLable.setText(String.valueOf(numberOfProducts()));
        NumberOfCustomersLable.setText(String.valueOf(numberOfCustomers()));
        NumberOfSuppliersLable.setText(String.valueOf(numberOfCustomers()));
        NumberOfComponentsLable.setText(String.valueOf(numberOfComponents()));


    }

    @FXML
    public void addEmployeeButtonClick(ActionEvent actionEvent) {
        AdminMainPage.setVisible(false);
        AddEmployee.setVisible(true);
        ViewEmployee.setVisible(false);
        AddSupplier.setVisible(false);
        ViewSupplier.setVisible(false);
        AddComponent.setVisible(false);
        ViewComponent.setVisible(false);

    }

    @FXML
    private TextField textfieldaddemployeefirstname;
    @FXML
    private TextField textfieldaddemployeelastname;
    @FXML
    private TextField textfieldaddemployeeemail;
    @FXML
    private TextField textfieldaddemployeephone;
    @FXML
    private TextField textfieldaddemployeemiddlename;
    @FXML
    private TextField textfieldaddemployeepassword;
    @FXML
    private TextField textfieldaddemployeecountry;
    @FXML
    private TextField textfieldaddemployeestreet;
    @FXML
    private TextField textfieldaddemployeecity;
    @FXML
    private TextField textfieldaddemployeezipcode;
    @FXML
    private DatePicker textfieldaddemployeedate;
    @FXML
    private TextField textfieldaddemployeesalary;
    @FXML
    private RadioButton textfieldaddemployeedategendermale;
    @FXML
    private RadioButton textfieldaddemployeedategenderfemale;


    @FXML
    public void savsAddEmployeeButtonClick(ActionEvent actionEvent) {
        ToggleGroup toggleGroup = new ToggleGroup();
        textfieldaddemployeedategenderfemale.setToggleGroup(toggleGroup);
        textfieldaddemployeedategendermale.setToggleGroup(toggleGroup);

        System.out.println("save employee");
        String firstName = textfieldaddemployeefirstname.getText();
        String middleName = textfieldaddemployeemiddlename.getText();
        String lastName = textfieldaddemployeelastname.getText();
        String email = textfieldaddemployeeemail.getText();
        String phone = textfieldaddemployeephone.getText();
        String password = textfieldaddemployeepassword.getText();
        String country = textfieldaddemployeecountry.getText();
        String street = textfieldaddemployeestreet.getText();
        String city = textfieldaddemployeecity.getText();
        String zip = textfieldaddemployeezipcode.getText();
        int salary = Integer.parseInt(textfieldaddemployeesalary.getText());

        char gender = toggleGroup.getToggles().equals(textfieldaddemployeedategendermale) ? 'M' : 'F';

//        DatePicker date = textfieldaddemployeedate;
        Employee employee = new Employee(firstName, middleName, lastName, salary, email, phone, country, city, street, zip, gender);
        System.out.println(employee.save());
//        Users user = new Users(firstName, "user", password);
//        user.save();
    }


    @FXML
    public void viewEmployeeButtonClick(ActionEvent actionEvent) {
        AdminMainPage.setVisible(false);
        AddEmployee.setVisible(false);
        ViewEmployee.setVisible(true);
        AddSupplier.setVisible(false);
        ViewSupplier.setVisible(false);
        AddComponent.setVisible(false);
        ViewComponent.setVisible(false);


    }

    @FXML
    TextField textfieldidviewemployee;
    @FXML
    TableView<Employee> viewEmployeTable;
    @FXML
    TableColumn<Employee, String> viewEmployeID;
    @FXML
    TableColumn<Employee, String> viewEmployePhone;
    @FXML
    TableColumn<Employee, String> viewEmployeEmail;
    @FXML
    TableColumn<Employee, String> viewEmployeCountry;
    @FXML
    TableColumn<Employee, String> viewEmployeStreet;
    @FXML
    TableColumn<Employee, String> viewEmployeCity;
    @FXML
    TableColumn<Employee, String> viewEmployeZipCode;
    @FXML
    TableColumn<Employee, String> viewEmployeSalary;

    @FXML
    private Label viewEmployeeFirstName;
    @FXML
    private Label viewEmployeeLastName;
    @FXML
    private Label viewEmployeeMidName;
    @FXML
    private Label viewEmployeeGender;


    @FXML
    public void IDviewEmployeeButtonClick(ActionEvent actionEvent) {
        Employee employee = Employee.findByID(Integer.parseInt(textfieldidviewemployee.getText()));
        System.out.println(employee.getFirstName());
        viewEmployeeFirstName.setText(employee.getFirstName());
        viewEmployeeMidName.setText(employee.getSecondName());
        viewEmployeeLastName.setText(employee.getLastNameS());
        viewEmployeeGender.setText(String.valueOf(employee.getGender()));


    }

    @FXML
    public void addSupplierButtonClick(ActionEvent actionEvent) {
        AdminMainPage.setVisible(false);
        AddEmployee.setVisible(false);
        ViewEmployee.setVisible(false);
        AddSupplier.setVisible(true);
        ViewSupplier.setVisible(false);
        AddComponent.setVisible(false);
        ViewComponent.setVisible(false);

    }

    @FXML
    public void viewSupplierButtonClick(ActionEvent actionEvent) {
        AdminMainPage.setVisible(false);
        AddEmployee.setVisible(false);
        ViewEmployee.setVisible(false);
        AddSupplier.setVisible(false);
        ViewSupplier.setVisible(true);
        AddComponent.setVisible(false);
        ViewComponent.setVisible(false);

    }

    @FXML
    public void addComponentButtonClick(ActionEvent actionEvent) {
        AdminMainPage.setVisible(false);
        AddEmployee.setVisible(false);
        ViewEmployee.setVisible(false);
        AddSupplier.setVisible(false);
        ViewSupplier.setVisible(false);
        AddComponent.setVisible(true);
        ViewComponent.setVisible(false);

    }

    @FXML
    public void viewComponentButtonClick(ActionEvent actionEvent) {
        AdminMainPage.setVisible(false);
        AddEmployee.setVisible(false);
        ViewEmployee.setVisible(false);
        AddSupplier.setVisible(false);
        ViewSupplier.setVisible(false);
        AddComponent.setVisible(false);
        ViewComponent.setVisible(true);

    }

    @FXML
    public void logoutButtonClick(ActionEvent actionEvent) {
        AdminMainPage.setVisible(false);
        AddEmployee.setVisible(false);
        ViewEmployee.setVisible(false);
        AddSupplier.setVisible(false);
        ViewSupplier.setVisible(false);
        AddComponent.setVisible(false);
        ViewComponent.setVisible(false);
        StageManager.switchScene("LogIn.fxml");

    }


    @FXML
    public void printButtonClick(ActionEvent actionEvent) {
        AdminMainPage.setVisible(false);
        AddEmployee.setVisible(false);
        ViewEmployee.setVisible(false);
        AddSupplier.setVisible(false);
        ViewSupplier.setVisible(false);
        AddComponent.setVisible(false);
        ViewComponent.setVisible(false);
//        Connection con;
//        InputStream input;
//        JasperDesign jasperDesign;
//        JasperReport jasperReport;
//        JasperPrint jasperPrint;
//        OutputStream output;
//        try {
//            Class.forName("org.postgresql.Driver");
//            con = DriverManager.getConnection(
//                    "jdbc:postgresql://194.164.76.4:5432/baraamoh",
//                    "baraamoh",
//                    "baraamoh12345"
//            );
//
//            jasperDesign = JRXmlLoader.load("src/main/resources/defualt/databaseproject/companyreport.jrxml");
//            jasperReport = JasperCompileManager.compileReport(jasperDesign);
//            jasperPrint = JasperFillManager.fillReport(jasperReport, null, con);
//            JasperViewer.viewReport(jasperPrint);
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

    }


}
