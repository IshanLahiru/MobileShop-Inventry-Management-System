package com.codercrope.mobileinventrymanagement.controler;

import com.codercrope.mobileinventrymanagement.controler.tmlist.MainBillingItemTM;
import com.codercrope.mobileinventrymanagement.model.ItemModel;
import com.codercrope.mobileinventrymanagement.to.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.sql.SQLException;
import java.util.ArrayList;

public class BillingViewController {

    public TableColumn tblItemId;
    public TableColumn tblItemName;
    public TableColumn tblMorInfo;
    public TableColumn tblOnStock;
    public TableColumn tblMoreDtl;
    @FXML
    private GridPane pane1;

    @FXML
    private TableView tblBillingView;

    @FXML
    private ListView listViewBilling;

    public void initialize() throws SQLException, ClassNotFoundException {
        tblItemId.setCellValueFactory(new PropertyValueFactory<MainBillingItemTM, String>("custId"));
        tblItemName.setCellValueFactory(new PropertyValueFactory<MainBillingItemTM, String>("custName"));
        tblMorInfo.setCellValueFactory(new PropertyValueFactory<MainBillingItemTM, String>("custAddress"));
        tblOnStock.setCellValueFactory(new PropertyValueFactory<MainBillingItemTM, Double>("salary"));
        tblMoreDtl.setCellValueFactory(new PropertyValueFactory<MainBillingItemTM, Button>("btn"));

        setData();
    }

    @FXML
    void listViewBillingClickEvt(MouseEvent event) {

    }

    @FXML
    void tblBillingViewMouseClickEvent(MouseEvent event) {

    }
    public void setData() throws SQLException, ClassNotFoundException {
        ObservableList<MainBillingItemTM> cust = FXCollections.observableArrayList();
        ArrayList<Item> items = ItemModel.getItems();
        for (Item ob : items) {
            Button tem = new Button("Delete");
            MainBillingItemTM temp = new MainBillingItemTM(ob.getItemId(), ob.getItemName(), "hahah", ob.getItemPriceStock(), tem);
            tem.setOnAction(e -> {
                items.remove(ob);
                try {
                    setData();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            });
            cust.add(temp);
        }
        tblBillingView.setItems(cust);
    }

}
