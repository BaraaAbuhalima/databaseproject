package defualt.databaseproject;

import ActiveRecordPattern.Employee;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.ArrayList;

import TableView.*;
import ActiveRecordPattern.*;
import javafx.util.converter.DefaultStringConverter;
import javafx.util.converter.IntegerStringConverter;

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
        AdminMainPage.setVisible(false);
        AddEmployee.setVisible(false);
        ViewEmployee.setVisible(false);
        AddSupplier.setVisible(false);
        ViewSupplier.setVisible(false);
        AddComponent.setVisible(false);
        ViewComponent.setVisible(false);
        SelectComponent.setVisible(false);
        ResetPassword.setVisible(false);
        DeleteEmployeeView.setVisible(false);
        if (choice == 1) {
            AdminMainPage.setVisible(true);
        } else if (choice == 2) {
            AddEmployee.setVisible(true);
        } else if (choice == 3) {
            ViewEmployee.setVisible(true);
        } else if (choice == 4) {
            AddSupplier.setVisible(true);
        } else if (choice == 5) {
            ViewSupplier.setVisible(true);
        } else if (choice == 6) {
            AddComponent.setVisible(true);
        } else if (choice == 7) {
            ViewComponent.setVisible(true);
        } else if (choice == 8) {
            SelectComponent.setVisible(true);
        } else if (choice == 9) {
            ResetPassword.setVisible(true);
        } else if (choice == 10) {
            DeleteEmployeeView.setVisible(true);
        }
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
        NumberOfOrdersLable.setText(String.valueOf(numberOfOrders()));
        NumberOfProductsLable.setText(String.valueOf(numberOfProducts()));
        NumberOfCustomersLable.setText(Customer.size() + "");
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
        employeeSearchList.getItems().addAll("Id", "First name", "Second Name", "Last name", "Id", "Salary", "Email", "Phone", "City", "Country", "Street", "Zipcode", "Gender");
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
        Employee employee = new Employee(firstName, middleName, lastName, salary, email, phone, country, city, street, zip, gender, birthDate);
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
//        System.out.println(supplierName.getText());
//        System.out.println(supplierPhone.getText());
//        System.out.println(supplierEmail.getText());
//        System.out.println(supplierCountry.getText());
//        System.out.println(supplierStreet.getText());
//        System.out.println(supplierCity.getText());
//        System.out.println(supplierZipCode.getText());

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
    public void searchOnEmployee() {

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    public void logoutButtonClick(ActionEvent actionEvent) {

        StageManager.switchScene("LogIn.fxml");

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    public void printButtonClick(ActionEvent actionEvent) {
//        System.out.println("printing.......");
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
        new Component(componentName.getText(), Integer.parseInt(componentPrice.getText()), componentType.getText(), Integer.parseInt(componentQuantity.getText())).save();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
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

        System.out.println("Selected item: " + selectedItem + "   , Search Value" + searchValue);
    }

    @FXML
    public void viewAllEmployeesButton() {
        displayOnEmployeeTable(Employee.find(null));

    }

    @FXML
    public void deleteEmployeeButton() {
        ObservableList<EmployeeTableView> selectedItems = employeeTable.getItems().filtered(EmployeeTableView::isSelected);
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
            System.out.println(employee.getFirstName() + "   " + employee.getGender());
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
        ObservableList<SupplierTableView> selectedItems = supplierTable.getItems().filtered(SupplierTableView::isSelected);
        selectedItems.forEach(selectedItem -> {
            System.out.println(selectedItem.getId());
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

        System.out.println("Selected item: " + selectedItem + "   , Search Value" + searchValue);
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
        configureStringColumn(viewSupplierCountryColumn, SupplierTableView::countryProperty, SupplierTableView::setCountry);
        configureStringColumn(viewSupplierCityColumn, SupplierTableView::cityProperty, SupplierTableView::setCity);
        configureStringColumn(viewSupplierStreetColumn, SupplierTableView::streetProperty, SupplierTableView::setStreet);
        configureStringColumn(viewSupplierZipCodeColumn, SupplierTableView::zipCodeProperty, SupplierTableView::setZipCode);
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
            System.out.println(supplier.getName() + "   " + supplier.getId());
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
    private TextField somponentSearch;
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
        System.out.println("fdfsfdsfsdfdsfsdf");
        String selectedItem = componentSearchList.getValue();
        String searchValue = componentSearch.getText();

        ArrayList<AbstractMap.SimpleEntry<String, String>> criteria = new ArrayList<>();
        criteria.add(new AbstractMap.SimpleEntry<>(selectedItem.replace(" ", ""), searchValue));
        displayOnComponentsTable(Component.find(criteria));

        System.out.println("Selected item: " + selectedItem + "   , Search Value" + searchValue);
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
        configureIntegerColumn(viewComponentQuantity, ComponentTableView::quantityProperty, ComponentTableView::setQuantity);
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
            System.out.println(component.getName() + "   " + component.getId());
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
        int componentId = Component.find(criteria).get(0).getId();
        criteria.clear();
        criteria.add(new AbstractMap.SimpleEntry<>("name", selectedSupplierName));
        int supplierId = Supplier.find(criteria).get(0).getId();
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
        Users.find(criteria).get(0).update(criteria2);


    }

    ///////////////////////////////////////////////////////////////////////////
    @FXML
    private TextField deleteEmployeeIdSearch;
    @FXML
    private AnchorPane DeleteEmployeeView;

    @FXML
    public void DeleteEmployee() {
        setView(10);
    }

    @FXML
    public void deleteComponentButton() {
        ObservableList<ComponentTableView> selectedItems = componentTable.getItems().filtered(ComponentTableView::isSelected);
        selectedItems.forEach(selectedItem -> {
            Component.delete(selectedItem.getId());
        });
        componentTable.getItems().removeAll(selectedItems);

    }

}
