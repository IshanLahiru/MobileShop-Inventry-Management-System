package com.codercrope.mobileinventrymanagement.controler;

import com.codercrope.mobileinventrymanagement.util.user.validation.UserValidation;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class LoginViewController {
    public Stage stage;
    public TextField btnEmail;
    public TextField btnPwd;
    public Button btnLogIn;

    public void getStage(Stage primaryStage){
        this.stage = primaryStage;
    }
    public void initialize(){
        btnEmail.setStyle("-fx-border-color:#C5291B;");
    }
   /* public void setUi() throws IOException {
        Stage stag = new Stage();
        stag.setScene(new Scene(FXMLLoader.load(getClass().getResource("com/codercrope/mobileinventrymanagement/view/MainView.fxml"))));
        stag.setTitle("");
        StageController.login=stag;
        stag.setMaximized(true);
        //primaryStage.initStyle(StageStyle.TRANSPARENT);
        stag.show();
        //grid.getChildren().clear();
        //grid.getChildren().add(load);
    }*/

    public void btnLoginOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        boolean val = UserValidation.initValidation(btnEmail.getText(),btnPwd.getText());
        //User.initUser(UserValidation.getUser(btnEmail.getText(),btnPwd.getText()));
        //System.out.println(User.getUser().getAdministrativeDtlId());
        //System.out.println(val);
        if (val){
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/MainView.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    ((MainViewController) fxmlLoader.getController()).getStage(stage);
                    StageController.stage=stage;
                    StageController.stage.setMaximized(true);
                    stage.show();
                    StageController.login.hide();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            new Alert(Alert.AlertType.ERROR,"Error: Wrong Password! try again").show();
        }


        //stage.close();

    }

    public void btnEmailOnAction(ActionEvent actionEvent) {
    }

    public void btnPwdOnAction(ActionEvent actionEvent) {
    }
}
