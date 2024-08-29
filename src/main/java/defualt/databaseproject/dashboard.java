
package defualt.databaseproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.layout.AnchorPane;


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

    @FXML
    public void PrintOrder() {

    }


}

