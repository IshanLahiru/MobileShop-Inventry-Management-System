package com.codercrope.mobileinventrymanagement.controler.subwindows;

import com.codercrope.mobileinventrymanagement.controler.tmlist.OnlineOrderTM;
import com.codercrope.mobileinventrymanagement.model.OnlineOrderModel;
import com.codercrope.mobileinventrymanagement.to.OnlineOrder;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddOnlineOrderViewController {

    @FXML
    private TableView<OnlineOrderTM> tblOnlineOrder;

    @FXML
    private TableColumn<OnlineOrderTM, String> tblOrderId;

    @FXML
    private TableColumn<OnlineOrderTM, String> tblBatchId;

    @FXML
    private TableColumn<OnlineOrderTM, String> tblPaymentId;

    @FXML
    private TableColumn<OnlineOrderTM, String> tblEmployeeId;

    @FXML
    private TableColumn<OnlineOrderTM, String> tblDateTime;

    @FXML
    private TableColumn<OnlineOrderTM, Button> tblMoreDetails;

    @FXML
    private TextField txtEnterWarrantyDtlTopic;

    @FXML
    private TextArea txtEnterWarrantyDtl;

    @FXML
    private Label LblItemName11;

    @FXML
    private Button btnAddDtl;

    @FXML
    private Button btnUpdateDtl;

    @FXML
    private Button btnDeleteDtl;

    @FXML
    private Label LblItemName111;

    @FXML
    private ListView<?> warrantyDtlListView;

    @FXML
    private TextField txtSearch;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;


    public void initialize() throws SQLException, ClassNotFoundException, IOException {
        tblOrderId.setCellValueFactory(new PropertyValueFactory<OnlineOrderTM, String>("orderId"));
        tblBatchId.setCellValueFactory(new PropertyValueFactory<OnlineOrderTM, String>("batchId"));
        tblPaymentId.setCellValueFactory(new PropertyValueFactory<OnlineOrderTM, String>("paymentId"));
        tblEmployeeId.setCellValueFactory(new PropertyValueFactory<OnlineOrderTM, String>("employeeId"));
        tblDateTime.setCellValueFactory(new PropertyValueFactory<OnlineOrderTM, String>("dateTime"));
        tblMoreDetails.setCellValueFactory(new PropertyValueFactory<OnlineOrderTM, Button>("button"));


        /*warrantyDtlListView.getItems().removeAll(warrantyDtlList);
        warrantyListControllers.clear();
        warrantyDtlList.clear();
        warrantyDtlHM.clear();

        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
        btnAdd.setDisable(false);
        txtEnterWarrantyDtl.setWrapText(true);
        lblWarrantyId.setText(WarrantyTypeModel.getNextWarrantyId());
        txtWarrantyDuration.requestFocus();*/

        setData();
        /*lblItemId.setText(ItemModel.getItemId());
        lblWarrantyId.setText(WarrantyModel.getWarrantyId());
        ArrayList<WarrantyType> ar = WarrantyTypeModel.getWarrantyTypes();
        warrantyTypeSelector.getItems().clear();
        for (WarrantyType w : ar) {
            MenuItem i = new MenuItem(w.getWarrantyTypeId());
            warrantyTypeSelector.getItems().add(i);
            i.setOnAction(event -> {
                warrantyTypeSelector.setText(w.getWarrantyTypeId());
                //warrantyType = w.getWarrantyTypeId();
            });
        }
        warrantyTypeSelector.setText(ar.get(ar.size() - 1).getWarrantyTypeId());
        batchDtlListView.getItems().removeAll(batchListView);
        batchList.clear();
        initBatchDtlList(null);
        btnAdd.setDisable(false);
        btnUpdateDtl.setDisable(false);
        btnAddDtl.setDisable(true);
        btnDeleteDtl.setDisable(false);
        txtEnterItemDtl.setWrapText(true);*/
    }

    public void setData() throws SQLException, ClassNotFoundException {
        ArrayList<OnlineOrder> orders = OnlineOrderModel.getOnlineOrders();
        /*for (Item ob : items) {
            System.out.println(ob.getItemDtlHM());//to check the hash map object
            System.out.println("json is passed");
        }*/
        ObservableList<OnlineOrderTM> ordersTm = FXCollections.observableArrayList();
        for (OnlineOrder ob : orders) {
            Button tem = new Button("  More Details  ");
            OnlineOrderTM temp = new OnlineOrderTM(
                    ob,
                    ob.getOrderId(),
                    ob.getBatchId(),
                    ob.getPaymentId(),
                    ob.getEmployeeId(),
                    ob.getDateTime(),
                    ob.getOnlineOrdersLinks(),
                    tem
            );
            /*tem.setOnAction(e -> {
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
            });*/
            ordersTm.add(temp);
        }
        tblOnlineOrder.setItems(ordersTm);
    }
    @FXML
    void addBatchOnMouseClickedEvent(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/subwindows/AddBatchView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        //((ItemMoreDetailViewController) fxmlLoader.getController()).getObject(item.getOb());
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    void btnAddDtlOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteDtlOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateDtlOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateDtlOnClickEvt(MouseEvent event) {

    }

    @FXML
    void btnUpdateOrderOnAction(ActionEvent event) {

    }

    @FXML
    void txtEnterItemDtlOnKeyPressed(KeyEvent event) {

    }

    @FXML
    void txtEnterItemDtlTopicOnMouseClick(MouseEvent event) {

    }

    @FXML
    void txtEnterWarrantyDtlTopicOnAction(ActionEvent event) {

    }

    @FXML
    void txtEnterWarrantyDtlTopicOnKeyPressed(KeyEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

    @FXML
    void txtSearchOnKeyPressed(KeyEvent event) {

    }

    @FXML
    void warrantyDtlListViewOnMouseClick(MouseEvent event) {

    }

}
