package defualt.databaseproject;

import ActiveRecordPattern.Employee;
import ActiveRecordPattern.Orders;
import ActiveRecordPattern.Users;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.ZonedDateTime;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Employee employee = Employee.findByID(1);
        System.out.println(employee.getFirstName());
        DatabaseOperations.initilizeConnection();
        ArrayList<SimpleEntry<String, String>> criteria = new ArrayList<>();
        criteria.add(new SimpleEntry<>("city", "Nablus"));
//        criteria.add(new SimpleEntry<>("first_name", "jack"));
        ArrayList<Employee> ffd = Employee.find(criteria);
        ffd.forEach(ele -> {
            System.out.println(ele.getEmployeeId());
        });
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
}