package com.codercrope.mobileinventrymanagement.controler;

import com.codercrope.mobileinventrymanagement.model.TabModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Optional;

public class MainViewController {
    @FXML
    public TableView tblReceptionMain;

    @FXML
    public TableColumn txtId;

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
    private Button btnLast;

    @FXML
    private Label labelMode;

    private boolean isLightMode = true;

    public void setImgToBtn(String name, ImageView img){
        Image image = new Image("com/codercrope/mobileinventrymanagement/assets/"+name);
        img.setImage(image);
    }


    private void setLightMode(){
        parent.getStylesheets().remove("com/codercrope/mobileinventrymanagement/assets/Styles/DarkMode.css");
        parent.getStylesheets().add("com/codercrope/mobileinventrymanagement/assets/Styles/lightMode.css");
        labelMode.setText("Light Mode");
        modChangerTTD.setShowDelay(Duration.seconds(2));
        setImgToBtn("nightmode.png",modeSelector);
        setImgToBtn("restore-down-b.png",btnMaxImg);
        setImgToBtn("subtract-b.png",btnMinImg);
        setImgToBtn("close-b.png",btnClsImg);
    }
    private void setDarkMode(){
        parent.getStylesheets().remove("com/codercrope/mobileinventrymanagement/assats/Styles/lightMode.css");
        parent.getStylesheets().add("com/codercrope/mobileinventrymanagement/assets/Styles/DarkMode.css");
        modChangerTTD.setShowDelay(Duration.seconds(2));
        setImgToBtn("lightmode.png",modeSelector);
        setImgToBtn("restore-down-w.png",btnMaxImg);
        setImgToBtn("subtract-w.png",btnMinImg);
        setImgToBtn("close-w.png",btnClsImg);
    }

    public void btnModeControllerOnAction(ActionEvent actionEvent) {
        isLightMode = !isLightMode;
        if (isLightMode){
            setLightMode();
        }else{
            setDarkMode();
        }
    }

    @FXML
    void btnLastClickEvent(ActionEvent event) {
        TabModel tab = new TabModel(btnLast.getText());
        tab.setText(btnLast.getText());
        tab.setContent(new Rectangle(200,200, Color.LIGHTSTEELBLUE));
        //mainTabPane.getTabs().add(tab);
    }

    public void btnClsOnAction(ActionEvent actionEvent) {

    }

    public void btnClsClickEvt(MouseEvent mouseEvent) {
        System.exit(1);
    }

    public void btnExitOnMouseEnterEvt(MouseEvent mouseEvent) {

    }
    public void initialize() {
        txtId.setCellValueFactory(new PropertyValueFactory<>("id"));
        setData();
        //  tblCustomer.getSelectionModel().selectedItemProperty().addListener();
    }
    public static ArrayList<recMainTblViewCm>
            table=new ArrayList<recMainTblViewCm>();
    static {
        table.add(new recMainTblViewCm());
    }

    private void setData(){
        ObservableList tmList= FXCollections.observableArrayList();
        for (recMainTblViewCm c:table){
            recMainTblViewCm comp= new recMainTblViewCm();
            tmList.add(comp);
        }
        tblReceptionMain.setItems(tmList);
    }

}
