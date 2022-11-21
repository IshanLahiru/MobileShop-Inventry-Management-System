package com.codercrope.mobileinventrymanagement.controler.btncontrollers;

import com.codercrope.mobileinventrymanagement.util.user.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.net.URL;

public class ButtonDBSideVBController implements SideBarController {
    public ImageView img;
    private GridPane pane;
    @FXML
    void btnClickEvent(MouseEvent event) {
        //System.out.println("btn clicked");
        switch(User.user){
            case "admin":
                setUi(pane ,"/com/codercrope/mobileinventrymanagement/view/ReportView.fxml");
                break;
            case "worker":
                setUi(pane ,"/com/codercrope/mobileinventrymanagement/view/BillingView.fxml");
                break;
            case "technician":
                setUi(pane ,"/com/codercrope/mobileinventrymanagement/view/RepairView.fxml");

        }


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

    @Override
    public void getPane(GridPane pane) {
        this.pane = pane;
    }
    @Override
    public ImageView getImage() {
        return this.img;
    }
}
