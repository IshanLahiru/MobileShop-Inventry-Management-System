package com.codercrope.mobileinventrymanagement.controler;

import com.codercrope.mobileinventrymanagement.util.StyleController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class MainViewController {

    @FXML
    private BorderPane parent;

    @FXML
    private Button btnMode;

    @FXML
    private Tooltip modChangerTTD;

    @FXML
    private ImageView modeSelector;

    @FXML
    private Button btnMin;

    @FXML
    private ImageView btnMinImg;

    @FXML
    private Button btnMax;

    @FXML
    private ImageView btnMaxImg;

    @FXML
    private Button btnCls;

    @FXML
    private ImageView btnClsImg;

    @FXML
    private VBox mainViewSideBar;

    @FXML
    private GridPane sideBarBtn01;

    @FXML
    private GridPane sideBarBtn02;

    @FXML
    private GridPane sideBarBtn03;

    @FXML
    private GridPane sideBarBtn04;

    @FXML
    private GridPane sideBarBtn05;

    @FXML
    private GridPane sideBarBtn06;

    @FXML
    private GridPane grid;

    private Stage stage;

    public void getStage(Stage primaryStage){
        this.stage = primaryStage;
    }


    public void initialize() throws IOException {
        //stage.close();
        //mainViewSideBar.getChildren().add(new Button("kamnal"));
        setUi(grid ,"/com/codercrope/mobileinventrymanagement/view/BillingView.fxml");
        setBtn(sideBarBtn01 ,grid, "/com/codercrope/mobileinventrymanagement/view/btn/buttonDBSideVB.fxml","DB");
        setBtn(sideBarBtn02 , grid, "/com/codercrope/mobileinventrymanagement/view/btn/buttonOrderSideVB.fxml","order");
        setBtn(sideBarBtn03 , grid, "/com/codercrope/mobileinventrymanagement/view/btn/buttonItemSideVB.fxml","item");
        setBtn(sideBarBtn04 , grid, "/com/codercrope/mobileinventrymanagement/view/btn/buttonRepairSideVB.fxml","repair");
        setBtn(sideBarBtn05 , grid, "/com/codercrope/mobileinventrymanagement/view/btn/buttonWorkerSideVB.fxml","worker");
        setBtn(sideBarBtn06 , grid, "/com/codercrope/mobileinventrymanagement/view/btn/buttonReportSideVB.fxml","report");
        modChangerTTD.setShowDelay(Duration.seconds(2));
    }

    public void setUi(GridPane pane ,String event){
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
    public void setBtn(GridPane pane , GridPane grid, String event, String type){
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
            case "order":
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
                }
                break;
            case "item":
                try {
                    URL resourse = getClass().getResource(event);
                    FXMLLoader fxmlLoader = new FXMLLoader(resourse);
                    //System.out.println(fxmlLoader);
                    Parent load = (Parent) fxmlLoader.load();
                    ((ButtonItemSideVBController)fxmlLoader.getController()).getPane(this.grid);
                    pane.getChildren().clear();
                    pane.getChildren().add(load);
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;
            case "repair":
                try {
                    URL resourse = getClass().getResource(event);
                    FXMLLoader fxmlLoader = new FXMLLoader(resourse);
                    //System.out.println(fxmlLoader);
                    Parent load = (Parent) fxmlLoader.load();
                    ((ButtonRepairSideVBController)fxmlLoader.getController()).getPane(this.grid);
                    pane.getChildren().clear();
                    pane.getChildren().add(load);
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;
            case "worker":
                try {
                    URL resourse = getClass().getResource(event);
                    FXMLLoader fxmlLoader = new FXMLLoader(resourse);
                    //System.out.println(fxmlLoader);
                    Parent load = (Parent) fxmlLoader.load();
                    ((ButtonWorkerSideVBController)fxmlLoader.getController()).getPane(this.grid);
                    pane.getChildren().clear();
                    pane.getChildren().add(load);
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;
            case "report":
                try {
                    URL resourse = getClass().getResource(event);
                    FXMLLoader fxmlLoader = new FXMLLoader(resourse);
                    //System.out.println(fxmlLoader);
                    Parent load = (Parent) fxmlLoader.load();
                    ((ButtonReportSideVBController)fxmlLoader.getController()).getPane(this.grid);
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

    }

    public void setImgToBtn(String name, ImageView img){
        Image image = new Image("com/codercrope/mobileinventrymanagement/assets/"+name);
        img.setImage(image);
    }


    private void setLightMode(){
        StyleController.setDark(parent);
        setImgToBtn("nightmode.png",modeSelector);
        setImgToBtn("restore-down-b.png",btnMaxImg);
        setImgToBtn("subtract-b.png",btnMinImg);
        setImgToBtn("close-b.png",btnClsImg);
    }
    private void setDarkMode(){
        StyleController.setLight(parent);
        setImgToBtn("lightmode.png",modeSelector);
        setImgToBtn("restore-down-w.png",btnMaxImg);
        setImgToBtn("subtract-w.png",btnMinImg);
        setImgToBtn("close-w.png",btnClsImg);
    }
    @FXML
    void btnClsClickEvt(MouseEvent event) {
        System.exit(1);

    }

    @FXML
    void btnExitOnMouseEnterEvt(MouseEvent event) {

    }

    @FXML
    void btnModeControllerOnAction(ActionEvent event) {
        StyleController.isEnadled = !StyleController.isEnadled;
        if (StyleController.isEnadled){
            setDarkMode();
        }else{
            setLightMode();
        }
    }

}
