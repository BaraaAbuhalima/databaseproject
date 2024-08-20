package defualt.databaseproject;

import ActiveRecordPattern.Employee;
import ActiveRecordPattern.Users;
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

    @FXML
    public void homeButtonClick(ActionEvent actionEvent) {
        HomePage.setVisible(true);
        AddCustomerPage.setVisible(false);
        ViewCustomerPage.setVisible(false);
        AddOrderPage.setVisible(false);
        ViewOrderPage.setVisible(false);
        SearchForProductsPage.setVisible(false);
    }

    @FXML
    public void addCustomerClick(ActionEvent actionEvent) {
        HomePage.setVisible(false);
        AddCustomerPage.setVisible(true);
        ViewCustomerPage.setVisible(false);
        AddOrderPage.setVisible(false);
        ViewOrderPage.setVisible(false);
        SearchForProductsPage.setVisible(false);
    }


    @FXML
    public void viewCustomerClick(ActionEvent actionEvent) {
        HomePage.setVisible(false);
        AddCustomerPage.setVisible(false);
        ViewCustomerPage.setVisible(true);
        AddOrderPage.setVisible(false);
        ViewOrderPage.setVisible(false);
        SearchForProductsPage.setVisible(false);
    }

    @FXML
    public void addOrderClick(ActionEvent actionEvent) {
        HomePage.setVisible(false);
        AddCustomerPage.setVisible(false);
        ViewCustomerPage.setVisible(false);
        AddOrderPage.setVisible(true);
        ViewOrderPage.setVisible(false);
        SearchForProductsPage.setVisible(false);
    }

    @FXML
    public void viewOrderClick(ActionEvent actionEvent) {
        HomePage.setVisible(false);
        AddCustomerPage.setVisible(false);
        ViewCustomerPage.setVisible(false);
        AddOrderPage.setVisible(false);
        ViewOrderPage.setVisible(true);
        SearchForProductsPage.setVisible(false);
    }

    @FXML
    public void searchForProductsClick(ActionEvent actionEvent) {
        HomePage.setVisible(false);
        AddCustomerPage.setVisible(false);
        ViewCustomerPage.setVisible(false);
        AddOrderPage.setVisible(false);
        ViewOrderPage.setVisible(false);
        SearchForProductsPage.setVisible(true);
    }

    @FXML
    public void logoutClick(ActionEvent actionEvent) {
        HomePage.setVisible(false);
        AddCustomerPage.setVisible(false);
        ViewCustomerPage.setVisible(false);
        AddOrderPage.setVisible(false);
        ViewOrderPage.setVisible(false);
        SearchForProductsPage.setVisible(false);
        StageManager.switchScene("LogIn.fxml");
    }


}

