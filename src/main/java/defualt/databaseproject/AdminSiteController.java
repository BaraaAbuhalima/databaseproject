package defualt.databaseproject;

import ActiveRecordPattern.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.SQLException;

import ActiveRecordPattern.*;


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
        NumberOfCustomersLable.setText(String.valueOf(numberOfCustomers()));
        NumberOfSuppliersLable.setText("" + Supplier.size());
        NumberOfComponentsLable.setText("" + Component.size());

    }

    @FXML
    public void addEmployeeButtonClick(ActionEvent actionEvent) {
        setView(2);
    }

    @FXML
    public void viewEmployeeButtonClick(ActionEvent actionEvent) {
        setView(3);
    }

    @FXML
    public void addSupplierButtonClick(ActionEvent actionEvent) {
        setView(4);
    }

    @FXML
    public void viewSupplierButtonClick(ActionEvent actionEvent) {
        setView(5);

    }

    @FXML
    public void addComponentButtonClick(ActionEvent actionEvent) {
        setView(6);

    }

    @FXML
    public void viewComponentButtonClick(ActionEvent actionEvent) {
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
        char gender = selectedRadioButton != null ? selectedRadioButton.getText().charAt(0) : null;
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

}
