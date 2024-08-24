package defualt.databaseproject;

import ActiveRecordPattern.*;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        DatabaseOperations.initilizeConnection();
//        System.out.println(Employee.findById(1).getlastName());
//        SupplierComponent.find(null).forEach(supplierComponent -> {
//            System.out.println(supplierComponent.getComponentId() + " " + supplierComponent.getSupplierId());
//            supplierComponent.delete();
//        });
//        SupplierComponent.find(null).forEach(supplierComponent -> {
//            System.out.println(supplierComponent.getComponentId() + " " + supplierComponent.getSupplierId());
//        });
//        new SupplierComponent(1, 17).save();
//        Employee employee = Employee.findByID(1);
//        System.out.println(employee.getFirstName());
//        ArrayList<SimpleEntry<String, String>> criteria = new ArrayList<>();
//        criteria.add(new SimpleEntry<>("middlename", "Mohannad"));
//
//        Employee employee = new Employee();
//        employee.save();
//        Employee.findById(1);
//        System.out.println(Customer.find(criteria).get(0).getId());
////        Customer customer = new Customer(4);
////        customer.update(criteria);
////        Customer.delete(criteria);
//        LocalDate specificDate = LocalDate.of(2024, 8, 21);
//        Customer customer = new Customer("Bara", "fjd", "fdf", specificDate, "M", "dfdsf@dlf.com", "2342", "df", "fdsf", "fd", "fs");
//        customer.save();
//        Try.brr();
//        Try t = new Try("Customer", "customerId");
//        t.save();
//        System.out.println(Component.findByID(1).getComponentName());
//        System.out.println(Component.find(criteria).get(0).getComponentType());
////        criteria.add(new SimpleEntry<>("first_name", "jack"));
//        ArrayList<Employee> ffd = Employee.find(criteria);
//        ffd.forEach(ele -> {
//            System.out.println(ele.getEmployeeId());
//        });


//        Supplier supplier = new Supplier();
////        supplier.setId(14);
//        supplier.setSupplierName("fdfdf");
//        supplier.setSupplierCity("dfsdf");
//        supplier.setSupplierCountry("fdsf");
//        supplier.setSupplierStreet("dfdfsdf");
//        supplier.setSupplierPhone("dfdsf");
//        supplier.setSupplierEmail("b.k.gg@dfgks.com");
//        supplier.update(criteria);
//        supplier.save();
//        Supplier supplier1 = Supplier.findByID(17);
//        ArrayList<Supplier> suu = Supplier.find(criteria);
//        suu.forEach(supplier -> {
//            System.out.println(supplier.getSupplierEmail());

//        });
//        System.out.println(Supplier.size());
//        Employee employee = new Employee();
//        employee.setEmployeeId(15);
//        employee.setFirstName("John");
//        employee.setSecondName("Doe");
//        employee.setLastNameS("Smith");
//        employee.setEmail("john.doe@example.com");
//        employee.update(criteria);

//        employee.save();

//        employee.setEmployeeId(14);
//        employee.delete();

//        ArrayList<SimpleEntry<String, String>> criteria = new ArrayList<>();
//        criteria.add(new SimpleEntry<>("user_name", "br"));
//        criteria.add(new SimpleEntry<>("user_role", "user"));
//        Users.delete(criteria);

        StageManager.setStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LogIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Welcome Back !");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        Main.launch();
    }

    ///////////////////////////////////////////////chooseSupplierNameComponent

}