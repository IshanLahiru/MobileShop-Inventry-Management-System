package com.codercrope.mobileinventrymanagement.controler.subwindows;

import com.codercrope.mobileinventrymanagement.controler.tmlist.MainItemTM;
import com.codercrope.mobileinventrymanagement.controler.tmlist.WarrantyTM;
import com.codercrope.mobileinventrymanagement.model.*;
import com.codercrope.mobileinventrymanagement.to.*;
import com.codercrope.mobileinventrymanagement.view.listview.AddItemViewDtlTileListViewCompController;
import com.codercrope.mobileinventrymanagement.view.listview.WarrantyDtlListViewComponentController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddWarrantyTypeViewController {

    public ArrayList<WarrantyDtlListViewComponentController> warrantyListControllers = new ArrayList<>();
    public ArrayList<Button> warrantyDtlList = new ArrayList<>();
    public HashMap<String, String> warrantyDtlHM = new HashMap<>();

    @FXML
    private TableView<WarrantyTM> tblWarranty;
    @FXML
    private TableColumn<MainItemTM, String> tblWarrantyId;
    @FXML
    private TableColumn<MainItemTM, Integer> tblWarrantyDuration;
    @FXML
    private TableColumn<MainItemTM, Double> tblWarrantyCost;
    @FXML
    private TableColumn<MainItemTM, Button> tblMoreDtl;
    @FXML
    private Label LblItemName1;
    @FXML
    private Label lblWarrantyId;
    @FXML
    private Label LblItemName2;
    @FXML
    private TextField txtWarrantyCost;
    @FXML
    private Label LblItemName21;
    @FXML
    private TextField txtWarrantyDuration;
    @FXML
    private TextField txtEnterWarrantyDtlTopic;
    @FXML
    private TextArea txtEnterWarrantyDtl;
    @FXML
    private Label LblItemName11;
    @FXML
    public Button btnAddDtl;
    @FXML
    public Button btnUpdateDtl;
    @FXML
    public Button btnDeleteDtl;
    @FXML
    private Label LblItemName111;
    @FXML
    private ListView<Button> warrantyDtlListView;
    @FXML
    private TextField txtSearch;
    @FXML
    private Button btnSearch;
    @FXML
    public Button btnAdd;
    @FXML
    public Button btnDelete;
    @FXML
    public Button btnUpdate;

    public void initialize() throws SQLException, ClassNotFoundException, IOException {
        tblWarrantyId.setCellValueFactory(new PropertyValueFactory<MainItemTM, String>("warrantyTypeId"));
        tblWarrantyDuration.setCellValueFactory(new PropertyValueFactory<MainItemTM, Integer>("warrantyDuration"));
        tblWarrantyCost.setCellValueFactory(new PropertyValueFactory<MainItemTM, Double>("warrantyCost"));
        tblMoreDtl.setCellValueFactory(new PropertyValueFactory<MainItemTM, Button>("btn"));

        warrantyDtlListView.getItems().removeAll(warrantyDtlList);
        warrantyListControllers.clear();
        warrantyDtlList.clear();
        warrantyDtlHM.clear();

        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
        btnAdd.setDisable(false);
        txtEnterWarrantyDtl.setWrapText(true);
        lblWarrantyId.setText(WarrantyTypeModel.getNextWarrantyId());
        txtWarrantyDuration.requestFocus();

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
        ArrayList<WarrantyType> types = WarrantyTypeModel.getWarrantyTypes();
        /*for (Item ob : items) {
            System.out.println(ob.getItemDtlHM());//to check the hash map object
            System.out.println("json is passed");
        }*/
        ObservableList<WarrantyTM> warranty = FXCollections.observableArrayList();
        for (WarrantyType ob : types) {
            Button tem = new Button("  More Details  ");
            WarrantyTM temp = new WarrantyTM(ob,
                    ob.getWarrantyTypeId(),
                    ob.getWarrantyDuration(),
                    ob.getWarrantyCost(),
                    ob.getWarrantyTypeDtl(),
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
            warranty.add(temp);
        }
        tblWarranty.setItems(warranty);
    }

    @FXML
    void btnAddDtlOnAction(ActionEvent event) throws IOException {
        warrantyDtlHM.put(txtEnterWarrantyDtlTopic.getText(), txtEnterWarrantyDtl.getText());
        txtEnterWarrantyDtlTopic.setText("");
        txtEnterWarrantyDtl.setText("");
        setDataToDtlTmList();

    }
    private void setDataToDtlTmList() throws IOException {
        warrantyDtlListView.getItems().removeAll(warrantyDtlList);
        warrantyDtlList.clear();
        for (Map.Entry<String, String> entry : warrantyDtlHM.entrySet()) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/listview/WarrantyDtlListViewComponent.fxml"));
            Button root1 = (Button) fxmlLoader.load();
            WarrantyDtlListViewComponentController batch = ((WarrantyDtlListViewComponentController) fxmlLoader.getController());
            batch.setData(this, entry.getKey(), entry.getValue(), txtEnterWarrantyDtlTopic, txtEnterWarrantyDtl);
            warrantyDtlList.add(root1);
            warrantyListControllers.add(batch);
        }
        warrantyDtlListView.getItems().addAll(warrantyDtlList);
    }

    @FXML
    void btnAddOrderOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        /*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = dtf.format(now);
        System.out.println(dateTime);
        System.out.println(warrantyTypeSelector.getText());*/
        /*for (WarrantyDtlListViewComponentController b : warrantyListControllers) {
            warrantyDtlHM.put(b.getId(), b.getContent());
        }*/
        boolean sta = WarrantyTypeModel.save(new AddWarrantyType(lblWarrantyId.getText(), txtWarrantyDuration.getText(), txtWarrantyCost.getText(), warrantyDtlHM));
        if (sta) {
            initialize();
            new Alert(Alert.AlertType.INFORMATION, "Item Added successfully").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Error: not added! try again").show();
        }


    }

    @FXML
    void btnUpdateOrderOnAction(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        /*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = dtf.format(now);
        System.out.println(dateTime);
        System.out.println(warrantyTypeSelector.getText());*/
        /*for (WarrantyDtlListViewComponentController b : warrantyListControllers) {
            warrantyDtlHM.put(b.getId(), b.getContent());
        }*/
        boolean sta = WarrantyTypeModel.update(new AddWarrantyType(lblWarrantyId.getText(), txtWarrantyDuration.getText(), txtWarrantyCost.getText(), warrantyDtlHM));
        if (sta) {
            initialize();
            new Alert(Alert.AlertType.INFORMATION, "Item Updated successfully").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Error: not updated! try again").show();
        }

    }

    @FXML
    void btnDeleteOrderOnAction(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        /*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = dtf.format(now);
        System.out.println(dateTime);
        System.out.println(warrantyTypeSelector.getText());*/
        for (WarrantyDtlListViewComponentController b : warrantyListControllers) {
            warrantyDtlHM.put(b.getId(), b.getContent());
        }
        boolean sta = WarrantyTypeModel.delete(lblWarrantyId.getText());
        if (sta) {
            initialize();
            new Alert(Alert.AlertType.INFORMATION, "Item deleted successfully").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Error: not deleted! try again").show();
        }
    }

    @FXML
    void btnDeleteDtlOnAction(ActionEvent event) throws IOException {
        warrantyDtlHM.remove(txtEnterWarrantyDtlTopic.getText());
        txtEnterWarrantyDtlTopic.setText("");
        txtEnterWarrantyDtl.setText("");
        setDataToDtlTmList();

    }



    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateDtlOnAction(ActionEvent event) throws IOException {
        warrantyDtlHM.put(txtEnterWarrantyDtlTopic.getText(), txtEnterWarrantyDtl.getText());
        txtEnterWarrantyDtlTopic.setText("");
        txtEnterWarrantyDtl.setText("");
        setDataToDtlTmList();

    }

    @FXML
    void btnUpdateDtlOnClickEvt(MouseEvent event) {

    }



    @FXML
    void tblWarrantyOnMouseClickEvent(MouseEvent event) throws SQLException, IOException, ClassNotFoundException {
        btnDelete.setDisable(false);
        btnUpdate.setDisable(false);
        btnAdd.setDisable(true);
        if (event.getButton() == MouseButton.PRIMARY) {
            //if (tblItemView.getSelectionModel().getSelectedItem() != null) {
            warrantyDtlListView.getItems().removeAll(warrantyDtlList);
            warrantyListControllers.clear();
            warrantyDtlList.clear();
            warrantyDtlHM.clear();
            WarrantyTM temp = tblWarranty.getSelectionModel().getSelectedItem();
            txtEnterWarrantyDtlTopic.setEditable(true);
            initData(temp);
            btnUpdateDtl.setDisable(true);
            btnAddDtl.setDisable(false);
            btnDeleteDtl.setDisable(true);
            btnAdd.setDisable(true);
            btnDelete.setDisable(false);
            btnUpdate.setDisable(false);
            txtEnterWarrantyDtlTopic.setText("");
            txtEnterWarrantyDtl.setText("");
        } else if (event.getButton() == MouseButton.SECONDARY) {
            //System.out.println("rightClicked on the table");
            txtEnterWarrantyDtlTopic.setEditable(true);
            txtEnterWarrantyDtlTopic.setText("");
            txtEnterWarrantyDtl.setText("");
            initialize();
            txtWarrantyDuration.setText("");
            txtWarrantyCost.setText("");
            btnUpdateDtl.setDisable(true);
            btnAddDtl.setDisable(false);
            btnDeleteDtl.setDisable(true);
        }
    }

    private void initData(WarrantyTM temp) throws SQLException, ClassNotFoundException, IOException {
        if (temp!=null) {
            WarrantyType it = WarrantyTypeModel.getWarrantyType(temp.getWarrantyTypeId());
            lblWarrantyId.setText(it.getWarrantyTypeId());
            txtWarrantyDuration.setText(it.getWarrantyDuration());
            txtWarrantyCost.setText(it.getWarrantyCost());
            initWarrantyDtlList(it);
        }

    }

    private void initWarrantyDtlList(WarrantyType it) throws SQLException, ClassNotFoundException, IOException {
        warrantyDtlListView.getItems().removeAll(warrantyDtlList);
        warrantyDtlList.clear();
        warrantyDtlHM.clear();
        warrantyDtlHM = it.getWarrantyDtlHM();
        for (Map.Entry<String, String> entry : warrantyDtlHM.entrySet()) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/listview/WarrantyDtlListViewComponent.fxml"));
            Button root1 = (Button) fxmlLoader.load();
            WarrantyDtlListViewComponentController batch = ((WarrantyDtlListViewComponentController) fxmlLoader.getController());
            batch.setData(this, entry.getKey(), entry.getValue(), txtEnterWarrantyDtlTopic, txtEnterWarrantyDtl);
            warrantyDtlList.add(root1);
            warrantyListControllers.add(batch);
        }
        warrantyDtlListView.getItems().addAll(warrantyDtlList);
    }

    @FXML
    void txtEnterItemDtlOnKeyPressed(KeyEvent event) {

    }

    @FXML
    void txtEnterItemDtlTopicOnMouseClick(MouseEvent event) {

    }

    @FXML
    void txtEnterWarrantyDtlTopicOnAction(ActionEvent event) {
        txtEnterWarrantyDtl.requestFocus();

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
    void txtWarrantyCostOnAction(ActionEvent event) {
        txtEnterWarrantyDtlTopic.requestFocus();

    }

    @FXML
    void txtWarrantyCostOnKeyPressed(KeyEvent event) {

    }

    @FXML
    void txtWarrantyDurationOnAction(ActionEvent event) {
        txtWarrantyCost.requestFocus();

    }

    @FXML
    void txtWarrantyDurationOnKeyPressed(KeyEvent event) {

    }

    @FXML
    void warrantyDtlListViewOnMouseClick(MouseEvent event) {

    }

}
