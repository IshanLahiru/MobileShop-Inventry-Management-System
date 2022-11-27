package com.codercrope.mobileinventrymanagement.controler;

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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemViewController {

    public Button btnAddOrder;
    public Button AddItem;
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
    private Button btnEditWarranty;

    public void initialize() throws SQLException, ClassNotFoundException {
        tblItemId.setCellValueFactory(new PropertyValueFactory<MainItemTM, String>("ItemId"));
        tblWorrantyId.setCellValueFactory(new PropertyValueFactory<MainItemTM, String>("WorrantyId"));
        tblItemName.setCellValueFactory(new PropertyValueFactory<MainItemTM, String>("ItemName"));
        tblAddedDateTime.setCellValueFactory(new PropertyValueFactory<MainItemTM, String>("AddedDateTime"));
        tblStockPrice.setCellValueFactory(new PropertyValueFactory<MainItemTM, Double>("StockPrice"));
        tblMoreDtl.setCellValueFactory(new PropertyValueFactory<MainItemTM, Button>("MoreDtl"));


        setData();
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

    public void btnAddOrderOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/subwindows/AddOnlineOrderView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        //((ItemMoreDetailViewController) fxmlLoader.getController()).getObject(item.getOb());
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();

    }

    @FXML
    void btnEditWarrantyOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/subwindows/EditWarrantyView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        //((ItemMoreDetailViewController) fxmlLoader.getController()).getObject(item.getOb());
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();

    }

    public void btnAddItemOnAction(ActionEvent actionEvent) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/AddItemsView.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            //((ItemMoreDetailViewController) fxmlLoader.getController()).getObject(item.getOb());
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

    }
}
