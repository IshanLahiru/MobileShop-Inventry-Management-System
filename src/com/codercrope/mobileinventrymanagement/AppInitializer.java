package com.codercrope.mobileinventrymanagement;

import com.codercrope.mobileinventrymanagement.controler.LoginViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/LoginView.fxml"));
            Parent root = (Parent)loader.load();
            LoginViewController controller = (LoginViewController) loader.getController();
            primaryStage.setResizable(false);
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("");
            primaryStage.show();
            controller.getStage(primaryStage);
    }
}
