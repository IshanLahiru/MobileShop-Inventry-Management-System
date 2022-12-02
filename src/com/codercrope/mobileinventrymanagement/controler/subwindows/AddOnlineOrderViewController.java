package com.codercrope.mobileinventrymanagement.controler.subwindows;

import com.codercrope.mobileinventrymanagement.controler.tmlist.OnlineOrderTM;
import com.codercrope.mobileinventrymanagement.model.*;
import com.codercrope.mobileinventrymanagement.to.OnlineOrder;
import com.codercrope.mobileinventrymanagement.to.OnlineOrderStr;
import com.codercrope.mobileinventrymanagement.controler.listview.OnlineOrderLinksListViewComponentController;
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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    private Label lblOrderId;

    @FXML
    private ChoiceBox<String> employIdComboBox;

    @FXML
    private ChoiceBox<String> batchIdComboBox;

    @FXML
    private TextField txtPaymentAmount;

    @FXML
    private TextField txtEnterOrderLinkTitle;

    @FXML
    private TextArea txtEnterOrderLink;

    @FXML
    private Label LblItemName11;

    @FXML
    public Button btnAddLink;

    @FXML
    public Button btnUpdateLink;

    @FXML
    public Button btnDeleteLink;

    @FXML
    private Label LblItemName111;

    @FXML
    private ListView<Button> orderLinkDtlView;

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

    public ArrayList<OnlineOrderLinksListViewComponentController> onlineLinkListControllers = new ArrayList<OnlineOrderLinksListViewComponentController>();
    public ArrayList<Button> onlineOrderLink = new ArrayList<>();
    public HashMap<String, String> onlineOrderLinkHM = new HashMap<>();
    private OnlineOrderTM selectedOrder;


    public void initialize() throws SQLException, ClassNotFoundException, IOException {
        tblOrderId.setCellValueFactory(new PropertyValueFactory<OnlineOrderTM, String>("orderId"));
        tblBatchId.setCellValueFactory(new PropertyValueFactory<OnlineOrderTM, String>("batchId"));
        tblPaymentId.setCellValueFactory(new PropertyValueFactory<OnlineOrderTM, String>("paymentId"));
        tblEmployeeId.setCellValueFactory(new PropertyValueFactory<OnlineOrderTM, String>("employeeId"));
        tblDateTime.setCellValueFactory(new PropertyValueFactory<OnlineOrderTM, String>("dateTime"));
        tblMoreDetails.setCellValueFactory(new PropertyValueFactory<OnlineOrderTM, Button>("button"));

        lblOrderId.setText(OnlineOrderModel.getNextOnlineOrderId());
        //lblBatchId.setText(BatchModel.getNextBatchId());

        ObservableList<String> empIds = EmployeeModel.getEmployeeIds();
        employIdComboBox.setItems(empIds);
        employIdComboBox.getSelectionModel().selectFirst();

        employIdComboBox.requestFocus();

        ObservableList<String> batchIds = BatchModel.getBatchIds();
        batchIdComboBox.setItems(batchIds);
        batchIdComboBox.getSelectionModel().selectFirst();
        setData();

        btnUpdateLink.setDisable(true);
        btnDeleteLink.setDisable(true);
        btnAddLink.setDisable(false);

        btnAdd.setDisable(false);
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);

        txtPaymentAmount.setText("");
        txtEnterOrderLinkTitle.setText("");
        txtEnterOrderLink.setText("");

        orderLinkDtlView.getItems().removeAll(onlineOrderLink);
        onlineLinkListControllers.clear();
        onlineOrderLink.clear();
        onlineOrderLinkHM.clear();


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
                    ob.getPaymentId().getPaymentId(),
                    ob.getEmployeeId().getEmployeeId(),
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
    public void tblOnlineOrderOnMouseClicked(MouseEvent mouseEvent) throws SQLException, IOException, ClassNotFoundException {
        btnDelete.setDisable(false);
        btnUpdate.setDisable(false);
        btnAdd.setDisable(true);
        if (mouseEvent.getButton() == MouseButton.PRIMARY) {
            //if (tblItemView.getSelectionModel().getSelectedItem() != null) {
            orderLinkDtlView.getItems().removeAll(onlineOrderLink);
            onlineLinkListControllers.clear();
            onlineOrderLink.clear();
            onlineOrderLinkHM.clear();
            OnlineOrderTM temp = tblOnlineOrder.getSelectionModel().getSelectedItem();
            txtEnterOrderLinkTitle.setEditable(true);
            initData(temp);
            btnUpdateLink.setDisable(true);
            btnAddLink.setDisable(false);
            btnDeleteLink.setDisable(true);
            btnAdd.setDisable(true);
            btnDelete.setDisable(false);
            btnUpdate.setDisable(false);
            txtEnterOrderLinkTitle.setText("");
            txtEnterOrderLink.setText("");
            this.selectedOrder = tblOnlineOrder.getSelectionModel().getSelectedItem();
        } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            //System.out.println("rightClicked on the table");
            txtEnterOrderLinkTitle.setEditable(true);
            txtEnterOrderLink.setText("");
            txtEnterOrderLinkTitle.setText("");
            initialize();
        }
    }
    private void initData(OnlineOrderTM temp) throws SQLException, ClassNotFoundException, IOException {
        if (temp!=null) {
            OnlineOrder it = temp.getOb();
            lblOrderId.setText(it.getOrderId());
            /*ObservableList<String> empIds = EmployeeModel.getEmployeeIds();
            employIdComboBox.setItems(empIds);
            employIdComboBox.getSelectionModel().selectFirst();*/
            employIdComboBox.getSelectionModel().select(temp.getEmployeeId());
            batchIdComboBox.getSelectionModel().select(temp.getBatchId());
            txtPaymentAmount.setText(PaymentModel.getPaymentAmount(it.getPaymentId().getPaymentId()));
            initOrderLinkList(it);
        }

    }
    private void initOrderLinkList(OnlineOrder it) throws SQLException, ClassNotFoundException, IOException {
        orderLinkDtlView.getItems().removeAll(onlineOrderLink);
        onlineLinkListControllers.clear();
        onlineOrderLink.clear();
        onlineOrderLinkHM.clear();
        onlineOrderLinkHM = it.getOnlineOrdersLinksHM();
        for (Map.Entry<String, String> entry : onlineOrderLinkHM.entrySet()) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/listview/OnlineOrderLinksListViewComponent.fxml"));
            Button root1 = (Button) fxmlLoader.load();
            OnlineOrderLinksListViewComponentController batch = ((OnlineOrderLinksListViewComponentController) fxmlLoader.getController());
            batch.setData(this, entry.getKey(), entry.getValue(), txtEnterOrderLinkTitle, txtEnterOrderLink);
            onlineOrderLink.add(root1);
            onlineLinkListControllers.add(batch);
        }
        orderLinkDtlView.getItems().addAll(onlineOrderLink);
    }


    @FXML
    void btnAddLinkOnAction(ActionEvent event) throws IOException {
        onlineOrderLinkHM.put(txtEnterOrderLinkTitle.getText(), txtEnterOrderLink.getText());
        txtEnterOrderLinkTitle.setText("");
        txtEnterOrderLink.setText("");
        setDataToDtlTmList();

    }
    private void setDataToDtlTmList() throws IOException {
        orderLinkDtlView.getItems().removeAll(onlineOrderLink);
        onlineOrderLink.clear();
        for (Map.Entry<String, String> entry : onlineOrderLinkHM.entrySet()) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/listview/OnlineOrderLinksListViewComponent.fxml"));
            Button root1 = (Button) fxmlLoader.load();
            OnlineOrderLinksListViewComponentController batch = ((OnlineOrderLinksListViewComponentController) fxmlLoader.getController());
            batch.setData(this, entry.getKey(), entry.getValue(), txtEnterOrderLinkTitle, txtEnterOrderLink);
            onlineOrderLink.add(root1);
            onlineLinkListControllers.add(batch);
        }
        orderLinkDtlView.getItems().addAll(onlineOrderLink);
    }

    @FXML
    void btnDeleteLinkOnAction(ActionEvent event) throws IOException {
        onlineOrderLinkHM.put(txtEnterOrderLinkTitle.getText(), txtEnterOrderLink.getText());
        txtEnterOrderLinkTitle.setText("");
        txtEnterOrderLink.setText("");
        setDataToDtlTmList();

    }

    @FXML
    void btnAddOrderOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = dtf.format(now);
        System.out.println(dateTime);
        /*System.out.println(warrantyTypeSelector.getText());*/
        /*for (WarrantyDtlListViewComponentController b : warrantyListControllers) {
            warrantyDtlHM.put(b.getId(), b.getContent());
        }*/
        onlineOrderLinkHM.clear();
        for (OnlineOrderLinksListViewComponentController b : onlineLinkListControllers) {
            onlineOrderLinkHM.put(b.getId(), b.getContent());
        }
        System.out.println(batchIdComboBox.getSelectionModel().getSelectedItem());
        boolean sta = AddOnlineOrderModel.save(new OnlineOrderStr(
                lblOrderId.getText(),
                batchIdComboBox.getSelectionModel().getSelectedItem(),
                PaymentModel.getNextPaymentId(),
                employIdComboBox.getSelectionModel().getSelectedItem(),
                dateTime,
                Double.parseDouble(txtPaymentAmount.getText()),
                OnlineOrder.getOnlineOrdersLinksJson(onlineOrderLinkHM)
        ));
        if (sta) {
            initialize();
            new Alert(Alert.AlertType.INFORMATION, "Item Added successfully").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Error: not added! try again").show();
        }


    }

    @FXML
    void btnUpdateOrderOnAction(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = dtf.format(now);
        System.out.println(dateTime);
        //System.out.println(warrantyTypeSelector.getText());
        /*for (WarrantyDtlListViewComponentController b : warrantyListControllers) {
            warrantyDtlHM.put(b.getId(), b.getContent());
        }*/
        boolean sta = AddOnlineOrderModel.update(new OnlineOrderStr(
                lblOrderId.getText(),
                batchIdComboBox.getSelectionModel().getSelectedItem(),
                selectedOrder.getPaymentId(),
                employIdComboBox.getSelectionModel().getSelectedItem(),
                dateTime,
                Double.parseDouble(txtPaymentAmount.getText()),
                OnlineOrder.getOnlineOrdersLinksJson(onlineOrderLinkHM)
        ));
        if (sta) {
            initialize();
            new Alert(Alert.AlertType.INFORMATION, "Item Updated successfully").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Error: not updated! try again").show();
        }

    }

    @FXML
    void btnDeleteOrderOnAction(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = dtf.format(now);
        System.out.println(dateTime);
        /*System.out.println(warrantyTypeSelector.getText());*/
        for (OnlineOrderLinksListViewComponentController b : onlineLinkListControllers) {
            onlineOrderLinkHM.put(b.getId(), b.getContent());
        }
        boolean sta = AddOnlineOrderModel.remove(new OnlineOrderStr(
                lblOrderId.getText(),
                batchIdComboBox.getSelectionModel().getSelectedItem(),
                selectedOrder.getPaymentId(),
                employIdComboBox.getSelectionModel().getSelectedItem(),
                dateTime,
                Double.parseDouble(txtPaymentAmount.getText()),
                OnlineOrder.getOnlineOrdersLinksJson(onlineOrderLinkHM)
        ));
        if (sta) {
            initialize();
            new Alert(Alert.AlertType.INFORMATION, "Item deleted successfully").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Error: not deleted! try again").show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateDtlOnClickEvt(MouseEvent event) {

    }

    @FXML
    void btnUpdateLinkOnAction(ActionEvent event) throws IOException {
        onlineOrderLinkHM.remove(txtEnterOrderLinkTitle.getText());
        txtEnterOrderLinkTitle.setText("");
        txtEnterOrderLink.setText("");
        setDataToDtlTmList();
    }


    @FXML
    void txtEnterItemDtlOnKeyPressed(KeyEvent event) {

    }

    @FXML
    void txtEnterItemDtlTopicOnMouseClick(MouseEvent event) {

    }

    @FXML
    void txtEnterOrderLinkOnAction(MouseEvent event) {

    }

    @FXML
    void txtEnterOrderLinkTitleOnAction(ActionEvent event) {

    }

    @FXML
    void txtEnterWarrantyDtlTopicOnKeyPressed(KeyEvent event) {

    }

    @FXML
    void txtPaymentAmountOnAction(ActionEvent event) {

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
