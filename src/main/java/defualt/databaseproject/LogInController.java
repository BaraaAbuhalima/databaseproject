package defualt.databaseproject;

import defualt.databaseproject.ActiveRecordPattern.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.*;
import java.util.ArrayList;

public class LogInController {

    @FXML
    private TextField userNameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Label wrongUsernameOrPassword;

    private int userId = -1;
    private String userRole;

    @FXML
    public void handleButtonClick(ActionEvent actionEvent) {

        String userName = userNameTextField.getText();
        String password = passwordTextField.getText();
        ArrayList<Users> userList = Users.find("user_name", userName);

        userList.forEach(user -> {
            if (user.getUserName().equals(userName) && user.getUserPassword().equals(password)) {
                userId = user.getUserId();
                userRole = user.getUserRole();
            }
        });

        if (userId == -1) {
            System.out.println("Username or password are not correct");
            wrongUsernameOrPassword.setText("Username or password are not correct");

        } else {

            wrongUsernameOrPassword.setText("");
            if (userRole.equals("admin")) {
                StageManager.switchScene("admin.fxml");
            } else {
                StageManager.switchScene("dash.fxml");
            }
        }

    }


}
