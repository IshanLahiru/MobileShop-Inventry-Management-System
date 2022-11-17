package com.codercrope.mobileinventrymanagement.controler;

import com.codercrope.mobileinventrymanagement.controler.btncontrollers.*;
import com.codercrope.mobileinventrymanagement.util.NavBtn;
import com.codercrope.mobileinventrymanagement.util.SetNavBtn;
import com.codercrope.mobileinventrymanagement.util.StyleController;
import com.codercrope.mobileinventrymanagement.util.User;
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
import java.util.HashMap;

import static com.codercrope.mobileinventrymanagement.util.NavBtn.*;

public class MainViewController {

    public Button btnLogOut;
    public Tooltip modChazngerTTD1;
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

    HashMap<String,ImageView> navIco = new HashMap<>();

    HashMap<String,SideBarController> navIcoController = new HashMap<>();

    private Stage stage;

    public void getStage(Stage primaryStage){
        this.stage = primaryStage;
    }


    public void initialize() throws IOException {
        //SetNavBtn.setGrid(grid);
        //stage.close();
        //mainViewSideBar.getChildren().add(new Button("kamnal"));
        setUi(grid ,"/com/codercrope/mobileinventrymanagement/view/BillingView.fxml");
        SetNavBtn.grid = grid;
        SetNavBtn.setBtn(sideBarBtn01 , "/com/codercrope/mobileinventrymanagement/view/btn/buttonDBSideVB.fxml",DB);
        SetNavBtn.setBtn(sideBarBtn02 , "/com/codercrope/mobileinventrymanagement/view/btn/buttonOrderSideVB.fxml",ORDER);
        SetNavBtn.setBtn(sideBarBtn03 , "/com/codercrope/mobileinventrymanagement/view/btn/buttonItemSideVB.fxml",ITEM);
        SetNavBtn.setBtn(sideBarBtn04 , "/com/codercrope/mobileinventrymanagement/view/btn/buttonRepairSideVB.fxml",REPAIR);
        SetNavBtn.setBtn(sideBarBtn05 , "/com/codercrope/mobileinventrymanagement/view/btn/buttonWorkerSideVB.fxml",WORKER);
        SetNavBtn.setBtn(sideBarBtn06 , "/com/codercrope/mobileinventrymanagement/view/btn/buttonReportSideVB.fxml",REPORT);
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
    /*public void setBtn(GridPane pane , GridPane grid, String event, String type){
        switch(type){
            case "DB":
                try {
                    URL resourse = getClass().getResource(event);
                    FXMLLoader fxmlLoader = new FXMLLoader(resourse);
                    //System.out.println(fxmlLoader);
                    Parent load = (Parent) fxmlLoader.load();
                    ButtonDBSideVBController controller = ((ButtonDBSideVBController)fxmlLoader.getController());
                    navIcoController.put("db",controller);
                    controller.getPane(this.grid);
                    ImageView img = controller.getImage();
                    navIco.put("db",img);
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
                    ButtonOrderSideVBController controller = ((ButtonOrderSideVBController)fxmlLoader.getController());
                    navIcoController.put("order",controller);
                    controller.getPane(this.grid);
                    ImageView img = controller.getImage();
                    navIco.put("order",img);
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
                    ButtonItemSideVBController controller = ((ButtonItemSideVBController)fxmlLoader.getController());
                    navIcoController.put("item",controller);
                    controller.getPane(this.grid);
                    ImageView img = controller.getImage();
                    navIco.put("item",img);
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
                    ButtonRepairSideVBController controller = ((ButtonRepairSideVBController)fxmlLoader.getController());
                    navIcoController.put("repair",controller);
                    controller.getPane(this.grid);
                    ImageView img = controller.getImage();
                    navIco.put("repair",img);
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
                    ButtonWorkerSideVBController controller = ((ButtonWorkerSideVBController)fxmlLoader.getController());
                    navIcoController.put("worker",controller);
                    controller.getPane(this.grid);
                    ImageView img = controller.getImage();
                    navIco.put("worker",img);
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
                    ButtonReportSideVBController controller = ((ButtonReportSideVBController)fxmlLoader.getController());
                    navIcoController.put("report",controller);
                    controller.getPane(this.grid);
                    ImageView img = controller.getImage();
                    navIco.put("report",img);
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
                    ButtonOrderSideVBController controller = ((ButtonOrderSideVBController)fxmlLoader.getController());
                    navIcoController.put("orders",controller);
                    controller.getPane(this.grid);
                    ImageView img = controller.getImage();
                    navIco.put("order",img);
                    pane.getChildren().clear();
                    pane.getChildren().add(load);
                }catch(Exception e){
                    e.printStackTrace();
                }break;
        }

    }*/

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
        setnavImgToBtn("dashboard-layout-b.png",navIco.get("db"));
        setnavImgToBtn("shopping-cart-b.png",navIco.get("order"));
        setnavImgToBtn("product-b.png",navIco.get("item"));
        setnavImgToBtn("repair-b.png",navIco.get("repair"));
        setnavImgToBtn("change-user-b.png",navIco.get("worker"));
        setnavImgToBtn("reports-b.png",navIco.get("report"));
        setnavImgToBtn("shopping-cart-b.png",navIco.get("order"));
    }

    private void setnavImgToBtn(String name, ImageView img) {
        Image image = new Image("com/codercrope/mobileinventrymanagement/assets/buttons/"+name);
        img.setImage(image);
    }

    private void setDarkMode(){
        StyleController.setLight(parent);
        setImgToBtn("lightmode.png",modeSelector);
        setImgToBtn("restore-down-w.png",btnMaxImg);
        setImgToBtn("subtract-w.png",btnMinImg);
        setImgToBtn("close-w.png",btnClsImg);
        setnavImgToBtn("dashboard-layout-w.png", navIco.get("db"));
        setnavImgToBtn("shopping-cart-w.png",navIco.get("order"));
        setnavImgToBtn("product-w.png",navIco.get("item"));
        setnavImgToBtn("repair-w.png",navIco.get("repair"));
        setnavImgToBtn("change-user-w.png",navIco.get("worker"));
        setnavImgToBtn("reports-w.png",navIco.get("report"));
        setnavImgToBtn("shopping-cart-w.png",navIco.get("order"));
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

    public void btnLogOutOnAction(ActionEvent actionEvent) {
        User.logout();
        StageController.stage.hide();
        StageController.login.show();
    }
}
