package defualt.databaseproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.*;

public class LogInController {

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Label wrongUsernameOrPassword;

    @FXML

    public void handleButtonClick(ActionEvent actionEvent) {

        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        String sqlStatement = "Select * from users where user_name= '" + username + "' and user_password= '" + password + "';";
        ResultSet resultSet = DatabaseOperations.makeQuery(sqlStatement);

        try {
            if (resultSet == null) {

                wrongUsernameOrPassword.setText("Please enter a valid username ");
            }
            if (!resultSet.next()) {

                System.out.println("Username or password are not correct");
                wrongUsernameOrPassword.setText("Username or password are not correct");

            } else {

                wrongUsernameOrPassword.setText("");
                StageManager.switchScene("dash.fxml");

            }
        } catch (SQLException e) {

            System.out.println("Error in printing Result");

        }
    }


}
