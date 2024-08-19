package defualt.databaseproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminSiteController {

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


}
