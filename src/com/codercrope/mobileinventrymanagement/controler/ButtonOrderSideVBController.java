package com.codercrope.mobileinventrymanagement.controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;

public class ButtonOrderSideVBController {
    private GridPane pane;
    @FXML
    void btnClickEvent(MouseEvent event) {
        System.out.println("btn clicked");
        setUi(pane ,"/com/codercrope/mobileinventrymanagement/view/OrderView.fxml");

    }

    public void setUi(GridPane pane , String event){
        try {
            URL resourse = getClass().getResource(event);
            FXMLLoader fxmlLoader = new FXMLLoader(resourse);
            Parent load = (Parent) fxmlLoader.load();
            pane.getChildren().clear();
            pane.getChildren().add(load);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void getPane(GridPane pane) {
        this.pane = pane;
    }

}
