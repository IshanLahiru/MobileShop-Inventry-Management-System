package com.codercrope.mobileinventrymanagement.controler;

import com.codercrope.mobileinventrymanagement.controler.tmlist.MainBillingItemTM;
import com.codercrope.mobileinventrymanagement.controler.tmlist.MainOrderTM;
import com.codercrope.mobileinventrymanagement.model.CustOrderModel;
import com.codercrope.mobileinventrymanagement.to.CustOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;

public class orderViewController {
    @FXML
    private GridPane pane1;

    @FXML
    private TableView<MainOrderTM> tblItem;

    @FXML
    private TableColumn<MainOrderTM, String> tblOrderId;

    @FXML
    private TableColumn<MainOrderTM, String> tblPaymentType;

    @FXML
    private TableColumn<MainBillingItemTM, String> tblEmployeeId;

    @FXML
    private TableColumn<MainBillingItemTM, String> tblDateTime;

    @FXML
    private TableColumn<MainBillingItemTM, Double> tblPaymentStats;

    @FXML
    private TableColumn<MainBillingItemTM, Button> tblMoreDtl;



    public void initialize() throws SQLException, ClassNotFoundException {
        tblOrderId.setCellValueFactory(new PropertyValueFactory<MainOrderTM, String>("orderId"));
        tblPaymentType.setCellValueFactory(new PropertyValueFactory<MainOrderTM, String>("paymentType"));
        tblEmployeeId.setCellValueFactory(new PropertyValueFactory<MainBillingItemTM, String>("employeeId"));
        tblDateTime.setCellValueFactory(new PropertyValueFactory<MainBillingItemTM, String>("dateTime"));
        tblPaymentStats.setCellValueFactory(new PropertyValueFactory<MainBillingItemTM, Double>("custPaymentSts"));
        tblMoreDtl.setCellValueFactory(new PropertyValueFactory<MainBillingItemTM, Button>("tem"));

        setData();
    }
    public void setData() throws SQLException, ClassNotFoundException {
        ArrayList<CustOrder> orders = CustOrderModel.getItems();
        ObservableList<MainOrderTM> cust = FXCollections.observableArrayList();
        for (CustOrder ob : orders) {
            Button tem = new Button("  More Details  ");
            MainOrderTM temp = new MainOrderTM(ob,ob.getOrderId(), ob.getPaymentTypeId(), ob.getEmployeeId(), ob.getDateTime(), Double.parseDouble(ob.getCustPaymentStats()),tem);
            tem.setOnAction(e -> {
                Stage stage = new Stage();
                stage.show();
            });
            cust.add(temp);
        }
        tblItem.setItems(cust);
    }
}
