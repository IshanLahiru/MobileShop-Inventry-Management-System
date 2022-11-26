package com.codercrope.mobileinventrymanagement.view.subwindows;

import com.codercrope.mobileinventrymanagement.controler.subwindows.ItemMoreDetailViewController;
import com.codercrope.mobileinventrymanagement.controler.tmlist.MainItemTM;
import com.codercrope.mobileinventrymanagement.model.ItemModel;
import com.codercrope.mobileinventrymanagement.to.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddItemsViewController {


    @FXML
    private GridPane pane1;

    @FXML
    private TableView<MainItemTM> tblItemView;

    @FXML
    private TableColumn<MainItemTM, String> tblItemId;

    @FXML
    private TableColumn<MainItemTM, String> tblWorrantyId;

    @FXML
    private TableColumn<MainItemTM, String> tblItemName;

    @FXML
    private TableColumn<MainItemTM, String> tblAddedDateTime;

    @FXML
    private TableColumn<MainItemTM, Double> tblStockPrice;

    @FXML
    private TableColumn<MainItemTM, Button> tblMoreDtl;

    @FXML
    private TextField txtSearch;

    @FXML
    private Button btnSearch;

    @FXML
    private ListView<?> itemDtlView;

    @FXML
    private TextField txtEnterItemDtlTopic;

    @FXML
    private TextArea txtEnterItemDtl;

    @FXML
    private ListView<?> itemDtlComponentLWOnAction;

    @FXML
    private Label lblItemIdPT;

    @FXML
    private Label lblItemId;

    @FXML
    private Label lblWarrantyId;

    @FXML
    private Label lblWarrantyIdPt;

    @FXML
    private Label lblProfitPercentage;

    @FXML
    private TextField txtItemProfitPercentage;

    @FXML
    private Label LblItemName;

    @FXML
    private TextField txtItemName;

    @FXML
    private Label lblItemPrice;

    @FXML
    private TextField txtItemPrice;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    public void initialize() throws SQLException, ClassNotFoundException {
        tblItemId.setCellValueFactory(new PropertyValueFactory<MainItemTM, String>("ItemId"));
        tblWorrantyId.setCellValueFactory(new PropertyValueFactory<MainItemTM, String>("WorrantyId"));
        tblItemName.setCellValueFactory(new PropertyValueFactory<MainItemTM, String>("ItemName"));
        tblAddedDateTime.setCellValueFactory(new PropertyValueFactory<MainItemTM, String>("AddedDateTime"));
        tblStockPrice.setCellValueFactory(new PropertyValueFactory<MainItemTM, Double>("StockPrice"));
        tblMoreDtl.setCellValueFactory(new PropertyValueFactory<MainItemTM, Button>("MoreDtl"));
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);

        setData();
        lblItemId.setText(ItemModel.getItemId());
    }

    @FXML
    void ItemDtlComponentOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void btnAddOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOrderOnAction(ActionEvent event) {

    }

    @FXML
    void tblMouseClickedOnAction(MouseEvent event) {
        btnDelete.setDisable(false);
        btnUpdate.setDisable(false);

    }

    @FXML
    void txtEnterItemDtlOnKeyPressed(KeyEvent event) {

    }

    @FXML
    void txtEnterItemDtlTopicOnAction(ActionEvent event) {

    }

    @FXML
    void txtItemNAmeOnAction(ActionEvent event) {

    }

    @FXML
    void txtItemPriceOnAction(ActionEvent event) {

    }

    @FXML
    void txtItemProfitPercentageOnAction(ActionEvent event) {

    }

    public void setData() throws SQLException, ClassNotFoundException {
        ArrayList<Item> items = ItemModel.getItems();
        for (Item ob : items) {
            System.out.println(ob.getItemDtlHM());//to check the hash map object
            System.out.println("json is passed");
        }
        ObservableList<MainItemTM> cust = FXCollections.observableArrayList();
        for (Item ob : items) {
            Button tem = new Button("  More Details  ");
            MainItemTM temp = new MainItemTM(ob, ob.getItemId(), ob.getWarrentyId().getWarrantyId(), ob.getItemName(), ob.getItemAddedDateTime(), ob.getItemPriceStock(), tem);
            tem.setOnAction(e -> {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/subwindows/ItemMoreDetailView.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    ((ItemMoreDetailViewController) fxmlLoader.getController()).getObject(ob);
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            cust.add(temp);
        }
        tblItemView.setItems(cust);
    }

}