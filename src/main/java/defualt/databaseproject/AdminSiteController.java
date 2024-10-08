
package defualt.databaseproject;

import ActiveRecordPattern.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.ArrayList;

import TableView.*;
import ActiveRecordPattern.*;

import static TableView.TableViewEditor.*;

public class AdminSiteController {

    private static Users staticuser;

    public static void setUser(Users user) {
        staticuser = user;
    }

    @FXML
    private void initialize() {
        genderToggleGroup = new ToggleGroup();
        textfieldaddemployeedategendermale.setToggleGroup(genderToggleGroup);
        textfieldaddemployeedategenderfemale.setToggleGroup(genderToggleGroup);
        homeButtonClick(null);
        AdminNameDisplay.setText(staticuser.getName());
    }

    private void setView(int choice) {
        AdminMainPage.setVisible(1 == choice);
        AddEmployee.setVisible(2 == choice);
        ViewEmployee.setVisible(choice == 3);
        AddSupplier.setVisible(choice == 4);
        ViewSupplier.setVisible(choice == 5);
        AddComponent.setVisible(choice == 6);
        ViewComponent.setVisible(choice == 7);
        SelectComponent.setVisible(choice == 8);
        ResetPassword.setVisible(choice == 9);
        DeleteEmployeeView.setVisible(choice == 10);
        AddProdcutView.setVisible(choice == 11);
        ViewProduct.setVisible(choice == 12);
    }


    ////////////////////////////////////////////////////////////////////////////////////////
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
    private AnchorPane SelectComponent;
    @FXML
    private AnchorPane AddProdcutView;
    @FXML
    private AnchorPane ViewProduct;
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
    @FXML
    private ToggleGroup genderToggleGroup;


    @FXML
    public void homeButtonClick(ActionEvent actionEvent) {
        setView(1);


        NumberOfEmployeeLable.setText("" + Employee.size());
        NumberOfOrdersLable.setText("" + Orders.size());
        NumberOfProductsLable.setText("" + Product.size());
        NumberOfCustomersLable.setText("" + Customer.size());
        NumberOfSuppliersLable.setText("" + Supplier.size());
        NumberOfComponentsLable.setText("" + Component.size());

    }

    @FXML
    public void addEmployeeButtonClick(ActionEvent actionEvent) {
        setView(2);
    }

    @FXML
    public void viewEmployeeButtonClick(ActionEvent actionEvent) {
        employeeSearchList.getItems().clear();
        employeeSearchList.getItems()
                .addAll("Id", "First name", "Second Name", "Last name", "Id", "Salary", "Email", "Phone", "City",
                        "Country", "Street", "Zipcode", "Gender");
        employeeSearchList.getSelectionModel().select("Id");
        setView(3);
    }

    @FXML
    public void addSupplierButtonClick(ActionEvent actionEvent) {
        setView(4);
    }

    @FXML
    public void viewSupplierButtonClick(ActionEvent actionEvent) {
        supplierSearchLIst.getItems().clear();
        supplierSearchLIst.getItems().addAll("Id", "Name", "Country", "City", "Street", "Zip Code", "phone", "Eamil");
        supplierSearchLIst.getSelectionModel().select("Id");
        setView(5);

    }

    @FXML
    public void addComponentButtonClick(ActionEvent actionEvent) {
        setView(6);

    }

    @FXML
    public void viewComponentButtonClick(ActionEvent actionEvent) {
        componentSearchList.getItems().clear();
        componentSearchList.getItems().addAll("Id", "Name", "Price", "Type", "Quantity");
        componentSearchList.getSelectionModel().select("Id");
        setView(7);

    }


    //////////////////////////////////////////////////////////////////////////////////////////////


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

        RadioButton selectedRadioButton = (RadioButton) genderToggleGroup.getSelectedToggle();
        LocalDate birthDate = textfieldaddemployeedate.getValue();
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
        String gender = selectedRadioButton != null ? selectedRadioButton.getText() : null;
        Employee employee = new Employee(firstName, middleName, lastName, salary, email, phone, country, city, street,
                zip, gender, birthDate);

        employee.save();
    }


    /////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private TextField supplierName;
    @FXML
    private TextField supplierPhone;
    @FXML
    private TextField supplierEmail;
    @FXML
    private TextField supplierCountry;
    @FXML
    private TextField supplierStreet;
    @FXML
    private TextField supplierCity;

    @FXML
    private TextField supplierZipCode;

    @FXML
    public void saveSupplier() {

        new Supplier(supplierName.getText(),
                supplierCountry.getText(),
                supplierCity.getText(),
                supplierStreet.getText(),
                supplierZipCode.getText(),
                supplierPhone.getText(),
                supplierEmail.getText()
        ).save();
    }
    /////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////////////////////////////////////////////


    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    public void logoutButtonClick(ActionEvent actionEvent) {

        StageManager.switchScene("LogIn.fxml");

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    public void printButtonClick(ActionEvent actionEvent) {

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    TextField componentName;
    @FXML
    TextField componentType;
    @FXML
    TextField componentPrice;
    @FXML
    TextField componentQuantity;

    @FXML
    public void saveComponent(ActionEvent actionEvent) {
        new Component(componentName.getText(), Integer.parseInt(componentPrice.getText()), componentType.getText(),
                Integer.parseInt(componentQuantity.getText())).save();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////


    ////////////////////////////////


    //////////////////////////
    @FXML
    private ComboBox<String> employeeSearchList;
    @FXML
    private TextField employeeSearch;

    @FXML
    private void employeeSearchMethod() {
        // Handle the ComboBox action event


    }

    @FXML
    private TableView<EmployeeTableView> employeeTable;

    @FXML
    private TableColumn<EmployeeTableView, Integer> employeeIdColumn;
    @FXML
    private TableColumn<EmployeeTableView, Boolean> selectEmployeeComlumn;
    @FXML
    private TableColumn<EmployeeTableView, String> employeeFirstNameColumn;
    @FXML
    private TableColumn<EmployeeTableView, String> employeeSecondNameColumn;
    @FXML
    private TableColumn<EmployeeTableView, String> employeeFinalNameColumn;
    @FXML
    private TableColumn<EmployeeTableView, String> employeeCountryColumn;
    @FXML
    private TableColumn<EmployeeTableView, String> employeeCityColumn;
    @FXML
    private TableColumn<EmployeeTableView, String> employeeStreetColumn;
    @FXML
    private TableColumn<EmployeeTableView, String> employeeZipCodeColumn;
    @FXML
    private TableColumn<EmployeeTableView, String> employeePhoneColumn;
    @FXML
    private TableColumn<EmployeeTableView, String> employeeEmailColumn;
    @FXML
    private TableColumn<EmployeeTableView, Integer> employeeSalaryColumn;
    @FXML
    private TableColumn<EmployeeTableView, String> employeeGenderColumn;
    @FXML
    private TableColumn<EmployeeTableView, String> employeeBirthDateColumn;

    @FXML
    public void SearchEmpoyeeButton() {
        String selectedItem = employeeSearchList.getValue();
        String searchValue = employeeSearch.getText();

        ArrayList<AbstractMap.SimpleEntry<String, String>> criteria = new ArrayList<>();
        criteria.add(new AbstractMap.SimpleEntry<>(selectedItem.replace(" ", ""), searchValue));
        displayOnEmployeeTable(Employee.find(criteria));

    }

    @FXML
    public void viewAllEmployeesButton() {
        displayOnEmployeeTable(Employee.find(null));

    }

    @FXML
    public void deleteEmployeeButton() {

        ObservableList<EmployeeTableView> selectedItems = employeeTable.getItems()
                .filtered(EmployeeTableView::isSelected);

        selectedItems.forEach(selectedItem -> {
            Employee.delete(selectedItem.getId());
        });

        employeeTable.getItems().removeAll(selectedItems);
    }

    public void displayOnEmployeeTable(ArrayList<Employee> employeeArrayList) {
        employeeTable.setEditable(true);
        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        employeeFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        employeeSecondNameColumn.setCellValueFactory(new PropertyValueFactory<>("secondName"));
        employeeFinalNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        employeeCountryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        employeeCityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        employeeStreetColumn.setCellValueFactory(new PropertyValueFactory<>("street"));
        employeeZipCodeColumn.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
        employeePhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        employeeEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        employeeSalaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        employeeGenderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        employeeBirthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        selectEmployeeComlumn.setCellFactory(CheckBoxTableCell.forTableColumn(selectEmployeeComlumn));
        selectEmployeeComlumn.setCellValueFactory(cellData -> cellData.getValue().selectedProperty());
        configureIntegerColumn(
                employeeIdColumn,
                EmployeeTableView::idProperty,
                EmployeeTableView::setId
        );
        configureStringColumn(
                employeeFirstNameColumn,
                EmployeeTableView::firstNameProperty,
                EmployeeTableView::setFirstName
        );

        configureStringColumn(
                employeeSecondNameColumn,
                EmployeeTableView::secondNameProperty,
                EmployeeTableView::setSecondName
        );

        configureStringColumn(
                employeeFinalNameColumn,
                EmployeeTableView::lastNameProperty,
                EmployeeTableView::setLastName
        );

        configureStringColumn(
                employeeCountryColumn,
                EmployeeTableView::countryProperty,
                EmployeeTableView::setCountry
        );

        configureStringColumn(
                employeeCityColumn,
                EmployeeTableView::cityProperty,
                EmployeeTableView::setCity
        );

        configureStringColumn(
                employeeStreetColumn,
                EmployeeTableView::streetProperty,
                EmployeeTableView::setStreet
        );

        configureStringColumn(
                employeeZipCodeColumn,
                EmployeeTableView::zipCodeProperty,
                EmployeeTableView::setZipCode
        );

        configureStringColumn(
                employeePhoneColumn,
                EmployeeTableView::phoneProperty,
                EmployeeTableView::setPhone
        );

        configureStringColumn(
                employeeEmailColumn,
                EmployeeTableView::emailProperty,
                EmployeeTableView::setEmail
        );
        configureStringColumn(
                employeeGenderColumn,
                EmployeeTableView::genderProperty,
                EmployeeTableView::setGender
        );
        configureIntegerColumn(
                employeeSalaryColumn,
                EmployeeTableView::salaryProperty,
                EmployeeTableView::setSalary
        );
        configureStringColumn(
                employeeBirthDateColumn,
                EmployeeTableView::birthDateProperty,
                EmployeeTableView::setBirthDate
        );
        ObservableList<EmployeeTableView> data = FXCollections.observableArrayList(

        );
        employeeArrayList.forEach(employee -> {
            data.add(new EmployeeTableView(employee.getId(),
                    employee.getFirstName(),
                    employee.getSecondName(),
                    employee.getlastName(),
                    employee.getCountry(),
                    employee.getCity(),
                    employee.getStreet(),
                    employee.getZipCode(),
                    employee.getPhone(),
                    employee.getEmail(),
                    employee.getSalary(),
                    employee.getGender(),
                    employee.getBirthDate() != null ? employee.getBirthDate().toString() : "null"
            ));
        });
        TableViewEditor util = new TableViewEditor();
        data.forEach(util::addPropertyChangeListeners);
        employeeTable.setItems(data);


    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private TableView<SupplierTableView> supplierTable;

    @FXML
    private ComboBox<String> supplierSearchLIst;
    @FXML
    private TextField supplierSearch;
    @FXML
    private TableColumn<SupplierTableView, Integer> viewSupplierIdColumn;
    @FXML
    private TableColumn<SupplierTableView, String> viewSupplierNameColumn;
    @FXML
    private TableColumn<SupplierTableView, String> viewSupplierCountryColumn;
    @FXML
    private TableColumn<SupplierTableView, String> viewSupplierCityColumn;
    @FXML
    private TableColumn<SupplierTableView, String> viewSupplierStreetColumn;
    @FXML
    private TableColumn<SupplierTableView, String> viewSupplierZipCodeColumn;

    @FXML
    private TableColumn<SupplierTableView, String> viewSupplierEmailColumn;
    @FXML
    private TableColumn<SupplierTableView, String> viewSupplierPhoneColumn;
    @FXML
    private TableColumn<SupplierTableView, Boolean> selectSupplierColumn;

    //    private <T> void deleteSelectedRows(TableView<T> tableView) {
//        ObservableList<T> selectedItems = tableView.getItems().filtered(T::isSelected);
//        tableView.getItems().removeAll(selectedItems);
//    }
    @FXML
    public void deleteSupplier() {
        ObservableList<SupplierTableView> selectedItems = supplierTable.getItems()
                .filtered(SupplierTableView::isSelected);
        selectedItems.forEach(selectedItem -> {
            Supplier.delete(selectedItem.getId());
        });
        supplierTable.getItems().removeAll(selectedItems);
    }

    @FXML
    public void SupplierSearchButton() {
        String selectedItem = supplierSearchLIst.getValue();
        String searchValue = supplierSearch.getText();

        ArrayList<AbstractMap.SimpleEntry<String, String>> criteria = new ArrayList<>();
        criteria.add(new AbstractMap.SimpleEntry<>(selectedItem.replace(" ", ""), searchValue));
        displayOnSuppliersTable(Supplier.find(criteria));

    }

    @FXML
    public void supplierViewAllButton() {
        displayOnSuppliersTable(Supplier.find(null));

    }


    public void displayOnSuppliersTable(ArrayList<Supplier> supplierArrayList) {
        supplierTable.setEditable(true);
        viewSupplierIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        viewSupplierNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        viewSupplierCountryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        viewSupplierCityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        viewSupplierStreetColumn.setCellValueFactory(new PropertyValueFactory<>("street"));
        viewSupplierZipCodeColumn.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
        viewSupplierPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        selectSupplierColumn.setCellFactory(CheckBoxTableCell.forTableColumn(selectSupplierColumn));
        selectSupplierColumn.setCellValueFactory(cellData -> cellData.getValue().selectedProperty());
        configureStringColumn(viewSupplierNameColumn, SupplierTableView::nameProperty, SupplierTableView::setName);
        configureIntegerColumn(viewSupplierIdColumn, SupplierTableView::idProperty, SupplierTableView::setId);
        configureStringColumn(viewSupplierCountryColumn, SupplierTableView::countryProperty,
                SupplierTableView::setCountry);
        configureStringColumn(viewSupplierCityColumn, SupplierTableView::cityProperty, SupplierTableView::setCity);
        configureStringColumn(viewSupplierStreetColumn, SupplierTableView::streetProperty,
                SupplierTableView::setStreet);
        configureStringColumn(viewSupplierZipCodeColumn, SupplierTableView::zipCodeProperty,
                SupplierTableView::setZipCode);
        configureStringColumn(viewSupplierPhoneColumn, SupplierTableView::phoneProperty, SupplierTableView::setPhone);
        configureStringColumn(viewSupplierEmailColumn, SupplierTableView::emailProperty, SupplierTableView::setEmail);

        configureIntegerColumn(
                employeeIdColumn,
                EmployeeTableView::idProperty,
                EmployeeTableView::setId
        );
        ObservableList<SupplierTableView> data = FXCollections.observableArrayList(

        );
        supplierArrayList.forEach(supplier -> {
            data.add(new SupplierTableView(supplier.getId(),
                    supplier.getName(),
                    supplier.getCountry(),
                    supplier.getCity(),
                    supplier.getStreet(),
                    supplier.getZipCode(),
                    supplier.getPhone(),
                    supplier.getEmail()

            ));
        });
        TableViewEditor util = new TableViewEditor();
        data.forEach(util::addPropertyChangeListeners);
        supplierTable.setItems(data);


    }

    //////////////////////////////////////////////////////////////////////////////
    @FXML
    private TableView<ComponentTableView> componentTable;
    @FXML
    private TableColumn<ComponentTableView, Boolean> selectComponentComlumn;
    @FXML
    private ComboBox<String> componentSearchList;

    @FXML
    private TableColumn<ComponentTableView, Integer> viewComponentId;
    @FXML
    private TableColumn<ComponentTableView, String> ViewComponentName;
    @FXML
    private TableColumn<ComponentTableView, Integer> viewComponentPrice;
    @FXML
    private TableColumn<ComponentTableView, String> viewComponentType;
    @FXML
    private TableColumn<ComponentTableView, Integer> viewComponentQuantity;
    @FXML
    private TextField componentSearch;

    @FXML
    public void ComponentSearchButton() {
        String selectedItem = componentSearchList.getValue();
        String searchValue = componentSearch.getText();

        ArrayList<AbstractMap.SimpleEntry<String, String>> criteria = new ArrayList<>();
        criteria.add(new AbstractMap.SimpleEntry<>(selectedItem.replace(" ", ""), searchValue));
        displayOnComponentsTable(Component.find(criteria));

    }

    @FXML
    public void ComponentViewAllButton() {
        displayOnComponentsTable(Component.find(null));

    }


    public void displayOnComponentsTable(ArrayList<Component> componentArrayList) {
        componentTable.setEditable(true);
        viewComponentId.setCellValueFactory(new PropertyValueFactory<>("id"));
        ViewComponentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        viewComponentPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        viewComponentType.setCellValueFactory(new PropertyValueFactory<>("type"));
        viewComponentQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        selectComponentComlumn.setCellValueFactory(cellData -> cellData.getValue().selectedProperty());
        selectComponentComlumn.setCellFactory(CheckBoxTableCell.forTableColumn(selectComponentComlumn));

        configureIntegerColumn(viewComponentId, ComponentTableView::idProperty, ComponentTableView::setId);
        configureIntegerColumn(viewComponentPrice, ComponentTableView::priceProperty, ComponentTableView::setPrice);
        configureIntegerColumn(viewComponentQuantity, ComponentTableView::quantityProperty,
                ComponentTableView::setQuantity);
        configureStringColumn(
                ViewComponentName,
                ComponentTableView::nameProperty,
                ComponentTableView::setName
        );
        configureStringColumn(
                viewComponentType,
                ComponentTableView::typeProperty,
                ComponentTableView::setType
        );

        ObservableList<ComponentTableView> data = FXCollections.observableArrayList();
        componentArrayList.forEach(component -> {
            data.add(new ComponentTableView(
                    component.getId(),
                    component.getName(),
                    component.getPrice(),
                    component.gettype(),
                    component.getQuantity()


            ));
        });

        TableViewEditor util = new TableViewEditor();
        data.forEach(util::addPropertyChangeListeners);
        componentTable.setItems(data);


    }


    ///////////////////////////////////
    @FXML
    private ComboBox<String> chooseSupplierNameComponent;
    @FXML
    private ComboBox<String> chooseComponentNameComponent;

    @FXML
    public void SelectComponentButton() {
        setView(8);
        Supplier.find(null).forEach(supplier -> {
            chooseSupplierNameComponent.getItems().add(supplier.getName());

        });
        Component.find(null).forEach(component -> {
            chooseComponentNameComponent.getItems().add(component.getName());
        });

    }

    @FXML
    public void saveComponentSupplierRelation() {
        String selectedSupplierName = chooseSupplierNameComponent.getValue();
        String selectedComponentName = chooseComponentNameComponent.getValue();
        ArrayList<AbstractMap.SimpleEntry<String, String>> criteria = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
        criteria.add(new AbstractMap.SimpleEntry<>("name", selectedComponentName));
        int componentId = Component.find(criteria).getFirst().getId();
        criteria.clear();
        criteria.add(new AbstractMap.SimpleEntry<>("name", selectedSupplierName));
        int supplierId = Supplier.find(criteria).getFirst().getId();
        criteria.add(new AbstractMap.SimpleEntry<>("name", selectedSupplierName));
        new SupplierComponent(componentId, supplierId).save();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    public void ResetUserPassword() {
        setView(9);
    }

    @FXML
    private AnchorPane ResetPassword;
    @FXML
    private TextField userNameReset;
    @FXML
    private TextField userNewPasswordReset;

    @FXML
    public void ResetPasswordButton() {
        String userName = userNameReset.getText();
        String userNewPassword = userNewPasswordReset.getText();
        ArrayList<AbstractMap.SimpleEntry<String, String>> criteria = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
        criteria.add(new AbstractMap.SimpleEntry<>("name", userName));
        ArrayList<AbstractMap.SimpleEntry<String, String>> criteria2 = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
        criteria2.add(new AbstractMap.SimpleEntry<>("password", userNewPassword));
        Users.find(criteria).getFirst().update(criteria2);


    }

    ///////////////////////////////////////////////////////////////////////////

    @FXML
    private AnchorPane DeleteEmployeeView;

    @FXML

    public void deleteComponentButton() {
        ObservableList<ComponentTableView> selectedItems = componentTable.getItems()
                .filtered(ComponentTableView::isSelected);
        selectedItems.forEach(selectedItem -> {
            Component.delete(selectedItem.getId());
        });
        componentTable.getItems().removeAll(selectedItems);

    }

    ////////////////////////////////////////
    @FXML
    private TextField productName;
    @FXML
    private TextField productItemDetails;
    @FXML
    private TextField productPrice;

    @FXML
    public void addProductButton() {
        setView(11);

    }

    public void saveProduct() {
        String name = productName.getText();
        String price = productPrice.getText();
        String itemDetails = productItemDetails.getText();
        try {
            new Product(Integer.parseInt(price), name, itemDetails).save();

        } catch (NumberFormatException e) {
            e.printStackTrace(System.err);
        }

    }

    //////////////////////////////////////////////////////////////////////////////
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
    private void viewProductButton() {
        setView(12);
        productSearchList.getItems().clear();
        productSearchList.getItems().addAll("id", "name", "price", "itemDetails");
    }

    @FXML
    private void searchProductButton() {
        String value = productSearchBar.getText();
        String key = productSearchList.getValue();
        ArrayList<AbstractMap.SimpleEntry<String, String>> criteria = new ArrayList<>();
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
    private void deleteProductButton() {
        System.out.println("deleteProductButton");
        ObservableList<ProductTableView> selectedItems = productTable.getItems().filtered(ProductTableView::isSelected);
        selectedItems.forEach(selectedItem -> {
            Product.delete(selectedItem.getId());
        });
        productTable.getItems().removeAll(selectedItems);
    }


}
