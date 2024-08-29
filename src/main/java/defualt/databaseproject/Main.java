package defualt.databaseproject;

import ActiveRecordPattern.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        DatabaseOperations.initilizeConnection();

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