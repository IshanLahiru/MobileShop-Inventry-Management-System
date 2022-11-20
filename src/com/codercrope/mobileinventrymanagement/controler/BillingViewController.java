package com.codercrope.mobileinventrymanagement.controler;

import com.codercrope.mobileinventrymanagement.controler.tmlist.MainBillingItemTM;
import com.codercrope.mobileinventrymanagement.model.ItemModel;
import com.codercrope.mobileinventrymanagement.to.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;

public class BillingViewController {

    public TableColumn tblItemId;
    public TableColumn tblItemName;
    public TableColumn tblMorInfo;
    public TableColumn tblOnStock;
    public TableColumn tblMoreDtl;
    public TextField txtSearch;
    @FXML
    private GridPane pane1;

    @FXML
    private TableView tblBillingView;

    @FXML
    private ListView listViewBilling;

    ObservableList<MainBillingItemTM> cust = FXCollections.observableArrayList();

    public void initialize() throws SQLException, ClassNotFoundException {
        tblItemId.setCellValueFactory(new PropertyValueFactory<MainBillingItemTM, String>("itemId"));
        tblItemName.setCellValueFactory(new PropertyValueFactory<MainBillingItemTM, String>("itemName"));
        tblMorInfo.setCellValueFactory(new PropertyValueFactory<MainBillingItemTM, String>("hahah"));
        tblOnStock.setCellValueFactory(new PropertyValueFactory<MainBillingItemTM, Double>("itemPriceStock"));
        tblMoreDtl.setCellValueFactory(new PropertyValueFactory<MainBillingItemTM, Button>("tem"));

        setData();
    }

    @FXML
    void listViewBillingClickEvt(MouseEvent event) {

    }

    @FXML
    void tblBillingViewMouseClickEvent(MouseEvent event) {
        if(tblBillingView.getSelectionModel().getSelectedItem()!=null) {
            MainBillingItemTM temp = (MainBillingItemTM) tblBillingView.getSelectionModel().getSelectedItem();
            /*txtCustId.setText(temp.getCustId());
            txtCustName.setText(temp.getCustName());
            txtCustAddress.setText(temp.getCustAddress());
            txtCustSallery.setText(String.valueOf(temp.getSalary()));*/
        }
    }
    public void setData() throws SQLException, ClassNotFoundException {
        tblBillingView.getItems().clear();
        ArrayList<Item> items = ItemModel.getItems();
        for (Item ob : items) {
            Button tem = new Button("  More Details  ");
            MainBillingItemTM temp = new MainBillingItemTM(ob,ob.getItemId(), ob.getItemName(), "hahah", ob.getItemPriceStock(), tem);
            tem.setOnAction(e -> {
                Stage stage = new Stage();
                stage.show();
            });
            cust.add(temp);
        }
        tblBillingView.setItems(cust);

    }
    public void setTxtSearchData(ArrayList<Item> item) throws SQLException, ClassNotFoundException {
        //ObservableList<MainBillingItemTM> cust = FXCollections.observableArrayList();
        tblBillingView.getItems().clear();
        for (Item ob : item) {
            Button tem = new Button("  More Details  ");
            MainBillingItemTM temp = new MainBillingItemTM(ob, ob.getItemId(), ob.getItemName(), "hahah", ob.getItemPriceStock(), tem);
            tem.setOnAction(e -> {

                Stage stage = new Stage();
                stage.show();
            });
            cust.add(temp);
        }
        tblBillingView.setItems(cust);
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
    }

    public void txtSearchKeyPressedOnAction(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
        tblBillingView.getItems().clear();
        ArrayList<Item> items = ItemModel.getSearchedItems(("%"+txtSearch.getText()+"%"));
        setTxtSearchData(items);
    }
}
