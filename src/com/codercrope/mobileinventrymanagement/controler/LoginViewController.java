package com.codercrope.mobileinventrymanagement.controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginViewController {
    public Stage stage;

    public void getStage(Stage primaryStage){
        this.stage = primaryStage;
    }

    public void setUi() throws IOException {
        Stage stag = new Stage();
        stag.setScene(new Scene(FXMLLoader.load(getClass().getResource("com/codercrope/mobileinventrymanagement/view/MainView.fxml"))));
        stag.setTitle("");
        stag.setMaximized(true);
        //primaryStage.initStyle(StageStyle.TRANSPARENT);
        stag.show();
        //grid.getChildren().clear();
        //grid.getChildren().add(load);
    }

    public void btnLoginOnAction(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/MainView.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            ((MainViewController) fxmlLoader.getController()).getStage(stage);
            stage.setMaximized(true);
            stage.show();
            this.stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //stage.close();

    }
}
