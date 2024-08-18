package defualt.databaseproject;

import defualt.databaseproject.ActiveRecordPattern.Users;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Users.find("user_name", "baraa").forEach(user -> {
           
            System.out.println(user.getUserId() + "      " + user.getUserName());
        });
        StageManager.setStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LogIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Main.launch();
    }
}