package defualt.databaseproject;

import ActiveRecordPattern.*;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.AbstractMap.*;
import java.util.ArrayList;

public class LogInController {

    private int userId = -1;
    private String userRole;

    @FXML
    private TextField userNameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Label wrongUsernameOrPassword;

    @FXML
    public void handleButtonClick() {

        String userName = userNameTextField.getText();
        String password = passwordTextField.getText();
        ArrayList<SimpleEntry<String, String>> criteria = new ArrayList<>();
        criteria.add(new SimpleEntry<>("name", userName));
        ArrayList<Users> userList = Users.find(criteria);
        userList.forEach(user -> {
            if (user.getName().equals(userName) && user.getPassword().equals(password)) {
                userId = user.getId();
                userRole = user.getRole();
            }
        });
        if (userId == -1) {
            wrongUsernameOrPassword.setText("Username or password are not correct");

        } else {

            wrongUsernameOrPassword.setText("");
            if (userRole.equals("admin")) {

                AdminSiteController.setUser(userList.getFirst());
                StageManager.switchScene("admin.fxml");
            } else {
                StageManager.switchScene("dash.fxml");
            }
        }

    }


}
