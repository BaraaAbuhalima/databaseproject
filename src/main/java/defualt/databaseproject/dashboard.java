
package defualt.databaseproject;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.*;
import ActiveRecordPattern.*;
import TableView.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import static TableView.TableViewEditor.*;

import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.SimpleTimeZone;


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
    AnchorPane AddOrderDetails;
    /////////////////////////////////////////////////////////////////////////////////Labels
    @FXML
    private Label numberOfOrdersLabel;
    @FXML
    private Label numberOfProductsLabel;
    @FXML
    private Label numberOfCustomersLabel;
    @FXML
    private AnchorPane ordersForCustomer;

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
        setView(1);
//        homeButtonClick();
    }

    private void setView(int choice) {
        HomePage.setVisible(choice == 1);
        AddCustomerPage.setVisible(choice == 2);
        ViewCustomerPage.setVisible(choice == 3);
//        AddOrderPage.setVisible(choice == 4);
        ViewOrderPage.setVisible(choice == 5);
        SearchForProductsPage.setVisible(choice == 6);
        ordersForCustomer.setVisible(choice == 7);
        AddOrderDetails.setVisible(choice == 8);
        AddOrderDetails.setVisible(choice == 9);
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
        customerSearchList.getItems().clear();
        customerSearchList.getItems()
                .addAll("id", "firstName", "middleName", "lastName", "country", "city", "street", "zipCode", "phone",
                        "email", "gender", "birthdate");
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


    @FXML
    public void addProductButton() {

    }
//    addProductButton

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

    /////////////////////////////
    @FXML
    private ComboBox<String> customerSearchList;
    @FXML
    private TextField searchCustomerBar;
    @FXML
    private TableView<CustomerTableView> customerTable;
    @FXML
    private TableColumn<CustomerTableView, Integer> customerIdColumn;
    @FXML
    private TableColumn<CustomerTableView, Boolean> selectCustomerColumn;
    @FXML
    private TableColumn<CustomerTableView, String> customerFirstNameColumn;
    @FXML
    private TableColumn<CustomerTableView, String> customerSecondNameColumn;
    @FXML
    private TableColumn<CustomerTableView, String> customerFinalNameColumn;
    @FXML
    private TableColumn<CustomerTableView, String> customerCountryColumn;
    @FXML
    private TableColumn<CustomerTableView, String> customerCityColumn;
    @FXML
    private TableColumn<CustomerTableView, String> customerStreetColumn;
    @FXML
    private TableColumn<CustomerTableView, String> customerZipCodeColumn;
    @FXML
    private TableColumn<CustomerTableView, String> customerPhoneColumn;
    @FXML
    private TableColumn<CustomerTableView, String> customerEmailColumn;
    @FXML
    private TableColumn<CustomerTableView, Integer> customerSalaryColumn;
    @FXML
    private TableColumn<CustomerTableView, String> customerGenderColumn;
    @FXML
    private TableColumn<CustomerTableView, String> customerBirthDateColumn;

    @FXML
    private void searchCustomerButton() {
        String key = customerSearchList.getValue();
        String value = searchCustomerBar.getText();
        ArrayList<AbstractMap.SimpleEntry<String, String>> criteria = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
        criteria.add(new AbstractMap.SimpleEntry<>(key, value));

        setCustomerTable(Customer.find(criteria));
    }

    @FXML
    private void viewAllCustomerButton() {
        setCustomerTable(Customer.find(null));

    }

    private void setCustomerTable(ArrayList<Customer> customerArrayList) {
        customerTable.setEditable(true);
        selectCustomerColumn.setCellFactory(CheckBoxTableCell.forTableColumn(selectCustomerColumn));
        selectCustomerColumn.setCellValueFactory(cellData -> cellData.getValue().selectedProperty());
        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        customerFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        customerSecondNameColumn.setCellValueFactory(new PropertyValueFactory<>("secondName"));
        customerFinalNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        customerCountryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        customerCityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        customerStreetColumn.setCellValueFactory(new PropertyValueFactory<>("street"));
        customerZipCodeColumn.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
        customerPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        customerEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        customerGenderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        customerBirthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        configureIntegerColumn(customerIdColumn, CustomerTableView::idProperty, CustomerTableView::setId);
        configureStringColumn(customerFirstNameColumn, CustomerTableView::firstNameProperty,
                CustomerTableView::setFirstName);
        configureStringColumn(customerSecondNameColumn, CustomerTableView::secondNameProperty,
                CustomerTableView::setSecondName);
        configureStringColumn(customerFinalNameColumn, CustomerTableView::lastNameProperty,
                CustomerTableView::setLastName);
        configureStringColumn(customerCountryColumn, CustomerTableView::countryProperty, CustomerTableView::setCountry);
        configureStringColumn(customerCityColumn, CustomerTableView::cityProperty, CustomerTableView::setCity);
        configureStringColumn(customerStreetColumn, CustomerTableView::streetProperty, CustomerTableView::setStreet);
        configureStringColumn(customerZipCodeColumn, CustomerTableView::zipCodeProperty, CustomerTableView::setZipCode);
        configureStringColumn(customerPhoneColumn, CustomerTableView::phoneProperty, CustomerTableView::setPhone);
        configureStringColumn(customerEmailColumn, CustomerTableView::emailProperty, CustomerTableView::setEmail);
        configureStringColumn(customerGenderColumn, CustomerTableView::genderProperty, CustomerTableView::setGender);
        configureStringColumn(customerBirthDateColumn, CustomerTableView::birthDateProperty,
                CustomerTableView::setBirthDate);
        ObservableList<CustomerTableView> data = FXCollections.observableArrayList(

        );
        customerArrayList.forEach(employee -> {
            data.add(new CustomerTableView(employee.getId(),
                    employee.getFirstName(),
                    employee.getMiddleName(),
                    employee.getLastName(),
                    employee.getCountry(),
                    employee.getCity(),
                    employee.getStreet(),
                    employee.getZipCode(),
                    employee.getGender(),
                    employee.getPhone(),
                    employee.getEmail(),
                    employee.getBirthDate() != null ? employee.getBirthDate().toString() : "null"
            ));
        });
        TableViewEditor util = new TableViewEditor();
        data.forEach(util::addPropertyChangeListeners);
        customerTable.setItems(data);

    }

    @FXML
    private void deleteCustomerButton() {
        ObservableList<CustomerTableView> selectedItems = customerTable.getItems()
                .filtered(CustomerTableView::isSelected);
        selectedItems.forEach(selectedItem -> {
            Customer.delete(selectedItem.getId());
        });
        customerTable.getItems().removeAll(selectedItems);
    }

    int customerId = -1;
    int orderId = -1;
    int orderDetailsId;

    @FXML
    private void ordersForCustomerButton() {
        if (customerTable.getItems()
                .filtered(CustomerTableView::isSelected).size() == 1) {
            customerId = customerTable.getItems()
                    .filtered(CustomerTableView::isSelected).getFirst().getId();
            ArrayList<AbstractMap.SimpleEntry<String, String>> criteria = new ArrayList<>();
            criteria.add(new AbstractMap.SimpleEntry<String, String>("customerid", "" + customerId));
            setOrdersForCustomers(Orders.find(criteria));
            setView(7);
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Be Careful");
            alert.setHeaderText(null);
            alert.setContentText("You should choose just one row to view customer orders");
            alert.showAndWait();

        }
    }

    @FXML
    private TableView<OrdersTableView> ordersTable;

    @FXML
    private TableColumn<OrdersTableView, Integer> orderIdColumn;

    @FXML
    private TableColumn<OrdersTableView, String> orderCreatedTimeColumn;
    @FXML
    private TableColumn<OrdersTableView, Integer> orderTotalPriceColumn;
    @FXML
    private TableColumn<OrdersTableView, Integer> orderDiscountColumn;
    @FXML
    private TableColumn<OrdersTableView, Integer> orderEmployeeIdColumn;
    @FXML
    private TableColumn<OrdersTableView, Integer> orderSubtotalColumn;
    @FXML
    private TableColumn<OrdersTableView, Integer> orderCustomerIdColumn;
    @FXML
    private
    TableColumn<OrdersTableView, Boolean> ordersSelectColumn;

    private void setOrdersForCustomers(ArrayList<Orders> ordersArrayList) {
        ordersTable.setEditable(true);
        ordersSelectColumn.setCellFactory(CheckBoxTableCell.forTableColumn(ordersSelectColumn));
        ordersSelectColumn.setCellValueFactory(cellData -> cellData.getValue().selectedProperty());
        selectCustomerColumn.setCellFactory(CheckBoxTableCell.forTableColumn(selectCustomerColumn));
        selectCustomerColumn.setCellValueFactory(cellData -> cellData.getValue().selectedProperty());
        orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        orderCreatedTimeColumn.setCellValueFactory(new PropertyValueFactory<>("createdTime"));
        orderTotalPriceColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        orderDiscountColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
        orderCustomerIdColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        orderEmployeeIdColumn.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        orderSubtotalColumn.setCellValueFactory(new PropertyValueFactory<>("subTotal"));
        configureIntegerColumn(orderIdColumn, OrdersTableView::idProperty, OrdersTableView::setId);
        configureIntegerColumn(orderTotalPriceColumn, OrdersTableView::totalPriceProperty,
                OrdersTableView::setTotalPrice);
        configureIntegerColumn(orderDiscountColumn, OrdersTableView::discountProperty, OrdersTableView::setDiscount);
        configureIntegerColumn(orderCustomerIdColumn, OrdersTableView::customerIdProperty,
                OrdersTableView::setCustomerId);
        configureIntegerColumn(orderEmployeeIdColumn, OrdersTableView::employeeIdProperty,
                OrdersTableView::setEmployeeId);
        configureIntegerColumn(orderSubtotalColumn, OrdersTableView::subTotalProperty, OrdersTableView::setSubTotal);

        // String columns
        configureStringColumn(orderCreatedTimeColumn, OrdersTableView::createdTimeProperty,
                OrdersTableView::setCreatedTime);

        ObservableList<OrdersTableView> data = FXCollections.observableArrayList(

        );
        ordersArrayList.forEach(order -> {
            data.add(new OrdersTableView(
                    order.getId(),
                    order.getCreatedAt().toString(),
                    order.getTotalPrice(),
                    order.getDiscount(),
                    order.getCustomerId(),
                    order.getEmployeeId(),
                    order.getSubTotal()

            ));
        });
        TableViewEditor util = new TableViewEditor();
        data.forEach(util::addPropertyChangeListeners);
        ordersTable.setItems(data);

    }

    @FXML
    private void deleteOrderButton() {
        ObservableList<OrdersTableView> selectedItems = ordersTable.getItems()
                .filtered(OrdersTableView::isSelected);
        selectedItems.forEach(selectedItem -> {
            Orders.delete(selectedItem.getId());
        });
        ordersTable.getItems().removeAll(selectedItems);
    }

    @FXML
    private void addOrderDetailsButton() {
        if (ordersTable.getItems()
                .filtered(OrdersTableView::isSelected).size() == 1) {
            orderId = ordersTable.getItems()
                    .filtered(OrdersTableView::isSelected).getFirst().getId();
            ArrayList<AbstractMap.SimpleEntry<String, String>> criteria = new ArrayList<>();
            criteria.add(new AbstractMap.SimpleEntry<String, String>("orderId", "" + orderId));
//            setOrdersForCustomers(Orders.find(criteria));
            productSearchList.getItems().clear();
            productSearchList.getItems().addAll("id", "name", "price", "itemDetails");
            setView(9);
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Be Careful");
            alert.setHeaderText(null);
            alert.setContentText("You should choose just one row to view customer order details");
            alert.showAndWait();

        }
    }

    @FXML
    private void addOrderButton() {
        Orders order = new Orders();
        order.setSubTotal(0).setCustomerId(customerId).setEmployeeId(1);
        order.save();
        ordersForCustomerButton();
    }

    ///////////////////////////////////////
    @FXML
    private TableView<ProductTableView> productTable;
    @FXML
    private TableColumn<ProductTableView, Boolean> selectProductColumn;
    @FXML
    private ComboBox<String> productSearchList;
    @FXML
    private TableColumn<ProductTableView, Integer> viewProductId;
    @FXML
    private TableColumn<ProductTableView, String> ViewProductName;
    @FXML
    private TableColumn<ProductTableView, Integer> viewProductPrice;
    @FXML
    private TableColumn<ProductTableView, String> viewProductItemDetails;

    @FXML
    private TextField productSearchBar;


    @FXML
    private void searchProductButton() {
        String value = productSearchBar.getText();
        String key = productSearchList.getValue();
        ArrayList<AbstractMap.SimpleEntry<String, String>> criteria = new ArrayList<>();
        criteria.add(new AbstractMap.SimpleEntry<>(key, value));
        criteria.add(new AbstractMap.SimpleEntry<>(key, value));
        ArrayList<Product> products = Product.find(criteria);
        displayProductsOnTable(products);
    }

    @FXML
    private void viewAllProductsButton() {
        displayProductsOnTable(Product.find(null));
    }

    private void displayProductsOnTable(ArrayList<Product> productArrayList) {
        productTable.setEditable(true);
//        viewProductId.setCellValueFactory(new PropertyValueFactory<>("id"));
//        ViewProductName.setCellValueFactory(new PropertyValueFactory<>("name"));
//        viewProductPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
//        viewProductItemDetails.setCellValueFactory(new PropertyValueFactory<>("itemDetails"));
        selectProductColumn.setCellFactory(CheckBoxTableCell.forTableColumn(selectProductColumn));
        selectProductColumn.setCellValueFactory(cellData -> cellData.getValue().selectedProperty());
        configureIntegerColumn(viewProductId, ProductTableView::idProperty, ProductTableView::setId);
        configureStringColumn(ViewProductName, ProductTableView::nameProperty, ProductTableView::setName);
        configureIntegerColumn(viewProductPrice, ProductTableView::priceProperty, ProductTableView::setPrice);
        configureStringColumn(viewProductItemDetails, ProductTableView::itemDetailsProperty,
                ProductTableView::setItemDetails);


        ObservableList<ProductTableView> data = FXCollections.observableArrayList();
        productArrayList.forEach(product -> {
            data.add(new ProductTableView(
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getItemDetails()


            ));
        });

        TableViewEditor util = new TableViewEditor();
        data.forEach(util::addPropertyChangeListeners);
        productTable.setItems(data);


    }

    @FXML
    TextField orderDetailsQuantity;

    @FXML
    private void saveOrderDetailsRelation() {
        if (!orderDetailsQuantity.getText().isEmpty()) {
            if (productTable.getItems()
                    .filtered(ProductTableView::isSelected).size() == 1) {
                int productId = productTable.getItems()
                        .filtered(ProductTableView::isSelected).getFirst().getId();

                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setOrderId(orderId);
                orderDetails.setQuantity(Integer.parseInt(orderDetailsQuantity.getText()));
                orderDetails.setProductId(productId);
                orderDetails.setTotalPrice(Product.findById(productId).getPrice() * orderDetails.getQuantity());
                System.out.println(Product.findById(productId).getPrice() + "   " + Product.findById(productId)
                        .getPrice() * orderDetails.getQuantity());
                orderDetails.save();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Be Careful");
                alert.setHeaderText(null);
                alert.setContentText("You should choose one product");
                alert.showAndWait();

            }

        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Be Careful");
            alert.setHeaderText(null);
            alert.setContentText("You should enter the quantity");
            alert.showAndWait();

        }
    }


}

