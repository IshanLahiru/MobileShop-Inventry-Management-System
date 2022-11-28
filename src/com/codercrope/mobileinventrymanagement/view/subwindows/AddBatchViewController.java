package com.codercrope.mobileinventrymanagement.view.subwindows;

import com.codercrope.mobileinventrymanagement.controler.tmlist.BatchTM;
import com.codercrope.mobileinventrymanagement.model.BatchModel;
import com.codercrope.mobileinventrymanagement.to.Batch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddBatchViewController {

    @FXML
    private TableView<BatchTM> tblBatch;

    @FXML
    private TableColumn<BatchTM, String> tblBatchId;

    @FXML
    private TableColumn<BatchTM, String> tblBatchDateTime;

    @FXML
    private TableColumn<BatchTM, Double> tblBatchDollerRate;

    @FXML
    private TableColumn<BatchTM, Button> tblBatchMoreDtl;

    @FXML
    private Label lblBatchId;

    @FXML
    private Label LblItemName1;

    @FXML
    private Label lblWarrantyId;

    @FXML
    private Label LblItemName21;

    @FXML
    private TextField txtWarrantyDuration;

    @FXML
    private Label LblItemName111;

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
        tblBatchId.setCellValueFactory(new PropertyValueFactory<BatchTM, String>("batchId"));
        tblBatchDateTime.setCellValueFactory(new PropertyValueFactory<BatchTM, String>("dateTime"));
        tblBatchDollerRate.setCellValueFactory(new PropertyValueFactory<BatchTM, Double>("dollerRate"));
        tblBatchMoreDtl.setCellValueFactory(new PropertyValueFactory<BatchTM, Button>("btn"));


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
        ArrayList<Batch> batches = BatchModel.getBatches();
        /*for (Item ob : items) {
            System.out.println(ob.getItemDtlHM());//to check the hash map object
            System.out.println("json is passed");
        }*/
        ObservableList<BatchTM> batchesTm = FXCollections.observableArrayList();
        for (Batch ob : batches) {
            Button tem = new Button("  More Details  ");
            BatchTM temp = new BatchTM(
                    ob,
                    ob.getBatchId(),
                    ob.getBatchDtl(),
                    ob.getDateTime(),
                    ob.getDollerRate(),
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
            batchesTm.add(temp);
        }
        tblBatch.setItems(batchesTm);
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
    void tblWarrantyOnMouseClickEvent(MouseEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

    @FXML
    void txtSearchOnKeyPressed(KeyEvent event) {

    }

    @FXML
    void txtWarrantyDurationOnAction(ActionEvent event) {

    }

    @FXML
    void txtWarrantyDurationOnKeyPressed(KeyEvent event) {

    }

}
