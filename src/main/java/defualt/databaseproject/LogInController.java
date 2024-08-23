package defualt.databaseproject;

import ActiveRecordPattern.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.AbstractMap.*;
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
        ArrayList<SimpleEntry<String, String>> criterias = new ArrayList<>();
        criterias.add(new SimpleEntry<>("name", userName));
        ArrayList<Users> userList = Users.find(criterias);
        userList.forEach(user -> {
            if (user.getName().equals(userName) && user.getPassword().equals(password)) {
                userId = user.getId();
                userRole = user.getRole();
            }
        });
        if (userId == -1) {
            System.out.println("Username or password are not correct");
            wrongUsernameOrPassword.setText("Username or password are not correct");

        } else {

            wrongUsernameOrPassword.setText("");
            if (userRole.equals("admin")) {

                AdminSiteController.setUser(userList.get(0));
                StageManager.switchScene("admin.fxml");
            } else {
                StageManager.switchScene("dash.fxml");
            }
        }

    }


}
