package com.codercrope.mobileinventrymanagement.util;

/*
    @author DanujaV
    @created 10/21/22 - 1:53 PM   
*/

import com.codercrope.mobileinventrymanagement.controler.ButtonDBSideVBController;
import com.codercrope.mobileinventrymanagement.controler.ButtonOrderSideVBController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Navigation {
    private static AnchorPane pane;

    /*public static void navigate(GridPane pane, GridPane grid, String event, String type){
        switch(type){
            case "DB":
                try {
                    URL resourse = getClass().getResource(event);
                    FXMLLoader fxmlLoader = new FXMLLoader(resourse);
                    //System.out.println(fxmlLoader);
                    Parent load = (Parent) fxmlLoader.load();
                    ((ButtonDBSideVBController)fxmlLoader.getController()).getPane(this.grid);
                    pane.getChildren().clear();
                    pane.getChildren().add(load);
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    URL resourse = getClass().getResource(event);
                    FXMLLoader fxmlLoader = new FXMLLoader(resourse);
                    //System.out.println(fxmlLoader);
                    Parent load = (Parent) fxmlLoader.load();
                    ((ButtonOrderSideVBController)fxmlLoader.getController()).getPane(this.grid);
                    pane.getChildren().clear();
                    pane.getChildren().add(load);
                }catch(Exception e){
                    e.printStackTrace();
                }break;
        }

    }*/

    public static void navigate(com.codercrope.mobileinventrymanagement.util.Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage)Navigation.pane.getScene().getWindow();

        switch (route) {
            case DASHBOARD:
                window.setTitle("Customer Manage");
                initUI("CustomerForm.fxml");
                break;
            case BILLING:
                window.setTitle("Place Order");
                initUI("PlaceOrderForm.fxml");
                break;
            case STATS:
                window.setTitle("Dashboard");
                initUI("DashboardForm.fxml");
                break;
            case ITEM:
                window.setTitle("Item Manage");
                initUI("ItemForm.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
    public static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/thogakade/view/" + location)));
    }
}
