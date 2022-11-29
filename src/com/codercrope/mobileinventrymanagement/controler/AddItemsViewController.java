package com.codercrope.mobileinventrymanagement.controler;

import com.codercrope.mobileinventrymanagement.controler.subwindows.ItemMoreDetailViewController;
import com.codercrope.mobileinventrymanagement.controler.tmlist.MainItemTM;
import com.codercrope.mobileinventrymanagement.model.*;
import com.codercrope.mobileinventrymanagement.to.*;
import com.codercrope.mobileinventrymanagement.util.ItemPriceGenerator;
import com.codercrope.mobileinventrymanagement.view.listview.AddItemViewBSListComponentController;
import com.codercrope.mobileinventrymanagement.view.listview.AddItemViewDtlTileListViewCompController;
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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddItemsViewController {


    public Button btnAddWarranty;
    public SplitMenuButton warrantyTypeSelector;
    public Label lblBatchDtls;
    public Button AddBatchId;
    public Button btnAddOnlineOrder;
    public Label lblItemPrice1;
    public ListView batchDtlListView;
    public ListView itemDtlComponentLW;
    public Button btnUpdateDtl;
    public Label lblBatchDtls1;

    public ArrayList<Button> batchListViewdtl = new ArrayList<>();
    public Button btnAddDtl;
    public Button btnDeleteDtl;

    public ArrayList<AddItemViewBSListComponentController> batchList = new ArrayList<AddItemViewBSListComponentController>();
    public ArrayList<Button> batchListView = new ArrayList<>();
    public ArrayList<AddItemViewDtlTileListViewCompController> batchListDtl = new ArrayList<AddItemViewDtlTileListViewCompController>();
    HashMap<String, String> hm = new HashMap<>();
    HashMap<String, String> tempArrayForlist = new HashMap<>();
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
    private TableColumn<MainItemTM, Integer> tblItemOnStock;
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

    public void initialize() throws SQLException, ClassNotFoundException, IOException {
        tblItemId.setCellValueFactory(new PropertyValueFactory<MainItemTM, String>("ItemId"));
        tblWorrantyId.setCellValueFactory(new PropertyValueFactory<MainItemTM, String>("WorrantyId"));
        tblItemName.setCellValueFactory(new PropertyValueFactory<MainItemTM, String>("ItemName"));
        tblAddedDateTime.setCellValueFactory(new PropertyValueFactory<MainItemTM, String>("AddedDateTime"));
        tblStockPrice.setCellValueFactory(new PropertyValueFactory<MainItemTM, Double>("StockPrice"));
        tblItemOnStock.setCellValueFactory(new PropertyValueFactory<MainItemTM, Integer>("ItemsOnStock"));
        tblMoreDtl.setCellValueFactory(new PropertyValueFactory<MainItemTM, Button>("MoreDtl"));
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);

        setData();
        lblItemId.setText(ItemModel.getItemId());
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
        txtEnterItemDtl.setWrapText(true);


    }

    @FXML
    public void ItemDtlComponentOnMouseClicked(MouseEvent event) {

    }

    @FXML
    public void btnAddOrderOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = dtf.format(now);
        System.out.println(dateTime);
        System.out.println(warrantyTypeSelector.getText());
        for (AddItemViewBSListComponentController b : batchList) {
            hm.put(b.getBatchId(), b.getNoOfItems());
        }
        boolean sta = AddItemModel.save(new AddItem(lblWarrantyId.getText(), warrantyTypeSelector.getText(), lblItemId.getText(), txtItemName.getText(), dateTime, Double.parseDouble(txtItemPrice.getText()), Integer.parseInt(txtItemProfitPercentage.getText()), AddItemModel.getItemDtlJson(tempArrayForlist), hm));
        if (sta) {
            setData();
            lblItemId.setText(ItemModel.getItemId());
            lblWarrantyId.setText(WarrantyModel.getWarrantyId());
            new Alert(Alert.AlertType.INFORMATION, "Item Added successfully").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Error: not added! try again").show();
        }
        /*try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean warranty = WarrantyModel.save(new Warranty(lblWarrantyId.getText(),WarrantyTypeModel.getWarrantyType(warrantyTypeSelector.getText())));
            boolean item =ItemModel.save(new Item(lblItemId.getText(),WarrantyModel.getWarranty(lblWarrantyId.getText()),txtItemName.getText(),dateTime,Double.parseDouble(txtItemPrice.getText()),10,"",0));
            if (!warranty&&item){
                DBConnection.getInstance().getConnection().rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }*/

    }

    @FXML
    void btnDeleteOrderOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = dtf.format(now);
        System.out.println(dateTime);
        System.out.println(warrantyTypeSelector.getText());
        for (AddItemViewBSListComponentController b : batchList) {
            hm.put(b.getBatchId(), b.getNoOfItems());
        }
        boolean sta = AddItemModel.delete(new AddItem(lblWarrantyId.getText(), warrantyTypeSelector.getText(), lblItemId.getText(), txtItemName.getText(), dateTime, Double.parseDouble(txtItemPrice.getText()), Integer.parseInt(txtItemProfitPercentage.getText()), AddItemModel.getItemDtlJson(tempArrayForlist), hm));
        if (sta) {
            setData();
            lblItemId.setText(ItemModel.getItemId());
            lblWarrantyId.setText(WarrantyModel.getWarrantyId());
            new Alert(Alert.AlertType.INFORMATION, "Item deleted successfully").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Error: not deleted! try again").show();
        }

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOrderOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = dtf.format(now);
        System.out.println(dateTime);
        System.out.println(warrantyTypeSelector.getText());
        for (AddItemViewBSListComponentController b : batchList) {
            hm.put(b.getBatchId(), b.getNoOfItems());
        }
        boolean sta = AddItemModel.Update(new AddItem(lblWarrantyId.getText(), warrantyTypeSelector.getText(), lblItemId.getText(), txtItemName.getText(), dateTime, Double.parseDouble(txtItemPrice.getText()), Integer.parseInt(txtItemProfitPercentage.getText()), AddItemModel.getItemDtlJson(tempArrayForlist), hm));
        if (sta) {
            setData();
            lblItemId.setText(ItemModel.getItemId());
            lblWarrantyId.setText(WarrantyModel.getWarrantyId());
            new Alert(Alert.AlertType.INFORMATION, "Item updated successfully").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Error: not updated! try again").show();
        }

    }

    @FXML
    void tblMouseClickedOnAction(MouseEvent event) throws SQLException, ClassNotFoundException, IOException {
        btnDelete.setDisable(false);
        btnUpdate.setDisable(false);
        btnAdd.setDisable(true);
        if (event.getButton() == MouseButton.PRIMARY) {
            //if (tblItemView.getSelectionModel().getSelectedItem() != null) {
            MainItemTM temp = tblItemView.getSelectionModel().getSelectedItem();
            txtEnterItemDtlTopic.setEditable(true);
            initData(temp);
            btnUpdateDtl.setDisable(true);
            btnAddDtl.setDisable(false);
            btnDeleteDtl.setDisable(true);
        } else if (event.getButton() == MouseButton.SECONDARY) {
            //System.out.println("rightClicked on the table");
            txtEnterItemDtlTopic.setEditable(true);
            txtEnterItemDtlTopic.setText("");
            txtEnterItemDtl.setText("");
            initialize();
            btnUpdateDtl.setDisable(true);
            btnAddDtl.setDisable(false);
            btnDeleteDtl.setDisable(true);
        }

    }

    private void initData(MainItemTM temp) throws SQLException, ClassNotFoundException, IOException {
        Item it = ItemModel.gatItem(temp.getItemId());
        lblItemId.setText(it.getItemId());
        lblWarrantyId.setText(it.getWarrentyId().getWarrantyId());
        txtItemName.setText(it.getItemName());
        txtItemProfitPercentage.setText(String.valueOf(it.getProfitPercentage()));
        warrantyTypeSelector.setText(it.getWarrentyId().getWarrantyTypeId().getWarrantyTypeId());
        txtItemPrice.setText(ItemPriceGenerator.getItemPrice(it.getItemId()));
        initBatchDtlList(it);

    }

    private void initBatchDtlList(Item it) throws SQLException, ClassNotFoundException, IOException {
        batchDtlListView.getItems().removeAll(batchListView);
        itemDtlComponentLW.getItems().removeAll(batchListViewdtl);
        batchList.clear();
        batchListView.clear();
        batchListDtl.clear();
        batchListViewdtl.clear();
        if (it != null) {
            ArrayList<BatchHasItem> batches = BatchHasItemModel.getBatches(it.getItemId());
            /*batchDtlListView.getItems().removeAll(batchListView);
            batchList.clear();
            batchListView.clear();*/
            for (BatchHasItem b : batches) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/listview/AddItemViewBSListComponent.fxml"));
                Button root1 = (Button) fxmlLoader.load();
                AddItemViewBSListComponentController batch = ((AddItemViewBSListComponentController) fxmlLoader.getController());
                batch.addData(b);
                batchListView.add(root1);
                batchList.add(batch);
            }
            batchDtlListView.getItems().addAll(batchListView);
            tempArrayForlist = it.getItemDtlHM();
            if (tempArrayForlist != null) {
                for (Map.Entry<String, String> entry : tempArrayForlist.entrySet()) {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/listview/AddItemViewDtlTileListViewComp.fxml"));
                    Button root1 = (Button) fxmlLoader.load();
                    AddItemViewDtlTileListViewCompController batch = ((AddItemViewDtlTileListViewCompController) fxmlLoader.getController());
                    batch.setData(this, entry.getKey(), entry.getValue(), txtEnterItemDtlTopic, txtEnterItemDtl);
                    batchListViewdtl.add(root1);
                    batchListDtl.add(batch);
                }
                itemDtlComponentLW.getItems().addAll(batchListViewdtl);
            }
        } else {
            btnAdd.setDisable(false);
            txtItemName.setText("");
            txtItemProfitPercentage.setText("");
            txtItemPrice.setText("");
            ArrayList<Batch> batches = BatchModel.getBatches();
            for (Batch b : batches) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/listview/AddItemViewBSListComponent.fxml"));
                Button root1 = (Button) fxmlLoader.load();
                AddItemViewBSListComponentController batch = ((AddItemViewBSListComponentController) fxmlLoader.getController());
                batch.add(b, lblItemId.getText());
                batchListView.add(root1);
                batchList.add(batch);
                batchDtlListView.getItems().removeAll(batchListView);
                batchDtlListView.getItems().addAll(batchListView);
            }

        }
    }

    @FXML
    void txtEnterItemDtlOnKeyPressed(KeyEvent event) {

    }

    @FXML
    void txtEnterItemDtlTopicOnAction(ActionEvent event) {

    }

    @FXML
    void txtItemNAmeOnAction(ActionEvent event) {
        txtItemProfitPercentage.requestFocus();

    }

    @FXML
    void txtItemPriceOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        btnAddOrderOnAction(event);
    }

    @FXML
    void txtItemProfitPercentageOnAction(ActionEvent event) {
        warrantyTypeSelector.requestFocus();

    }

    @FXML
    public void warrantyTypeSelectorOnAction(ActionEvent actionEvent) {
        //WarrantyModel.save(new Warranty(lblWarrantyId.getText(),WarrantyTypeModel.getWarrantyType(warrantyTypeSelector.getText())));
        txtItemPrice.requestFocus();
    }

    @FXML
    private void btnAddWarrantymouseClickEvent(MouseEvent event) {

    }

    public void setData() throws SQLException, ClassNotFoundException {
        ArrayList<Item> items = ItemModel.getItems();
        /*for (Item ob : items) {
            System.out.println(ob.getItemDtlHM());//to check the hash map object
            System.out.println("json is passed");
        }*/
        ObservableList<MainItemTM> cust = FXCollections.observableArrayList();
        for (Item ob : items) {
            Button tem = new Button("  More Details  ");
            MainItemTM temp = new MainItemTM(ob, ob.getItemId(),
                    ob.getWarrentyId().getWarrantyId(),
                    ob.getItemName(),
                    ob.getItemAddedDateTime(),
                    ob.getItemPriceStock(),
                    BatchHasItemModel.getItemCount(ob.getItemId()),
                    tem
            );
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


    public void btnAddBatchIdOnAction(ActionEvent actionEvent) {
    }

    public void btnAddOnlineOrderOnAction(ActionEvent actionEvent) {
    }

    public void btnAddOnlineOrderOnMouseClickEvent(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/subwindows/AddOnlineOrderView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        //((ItemMoreDetailViewController) fxmlLoader.getController()).getObject(item.getOb());
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void btnUpdateDtlOnClickEvt(MouseEvent mouseEvent) throws IOException {
        tempArrayForlist.remove(txtEnterItemDtlTopic.getText());
        tempArrayForlist.put(txtEnterItemDtlTopic.getText(), txtEnterItemDtl.getText());
        txtEnterItemDtlTopic.setText("");
        txtEnterItemDtl.setText("");
        setDataToDtlTmList();
    }

    public void btnDeleteDtlOnAction(ActionEvent actionEvent) throws IOException {
        tempArrayForlist.remove(txtEnterItemDtlTopic.getText());
        txtEnterItemDtlTopic.setText("");
        txtEnterItemDtl.setText("");
        setDataToDtlTmList();
    }

    public void btnAddDtlOnAction(ActionEvent actionEvent) throws IOException {
        tempArrayForlist.put(txtEnterItemDtlTopic.getText(), txtEnterItemDtl.getText());
        txtEnterItemDtlTopic.setText("");
        txtEnterItemDtl.setText("");
        setDataToDtlTmList();
    }

    private void setDataToDtlTmList() throws IOException {
        itemDtlComponentLW.getItems().clear();
        batchListViewdtl.clear();
        batchListDtl.clear();
        for (Map.Entry<String, String> entry : tempArrayForlist.entrySet()) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/listview/AddItemViewDtlTileListViewComp.fxml"));
            Button root1 = (Button) fxmlLoader.load();
            AddItemViewDtlTileListViewCompController batch = ((AddItemViewDtlTileListViewCompController) fxmlLoader.getController());
            batch.setData(this, entry.getKey(), entry.getValue(), txtEnterItemDtlTopic, txtEnterItemDtl);
            batchListViewdtl.add(root1);
            batchListDtl.add(batch);
        }
        itemDtlComponentLW.getItems().addAll(batchListViewdtl);
    }

    public void btnUpdateDtlOnAction(ActionEvent actionEvent) throws IOException {
        tempArrayForlist.put(txtEnterItemDtlTopic.getText(), txtEnterItemDtl.getText());
        txtEnterItemDtlTopic.setText("");
        txtEnterItemDtl.setText("");
        if (txtEnterItemDtlTopic.isEditable()) {
            for (Map.Entry<String, String> entry : tempArrayForlist.entrySet()) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/listview/AddItemViewDtlTileListViewComp.fxml"));
                Button root1 = (Button) fxmlLoader.load();
                AddItemViewDtlTileListViewCompController batch = ((AddItemViewDtlTileListViewCompController) fxmlLoader.getController());
                batch.setData(this, entry.getKey(), entry.getValue(), txtEnterItemDtlTopic, txtEnterItemDtl);
                batchListViewdtl.add(root1);
                batchListDtl.add(batch);
            }
            itemDtlComponentLW.getItems().addAll(batchListViewdtl);
        }
    }

    public void txtEnterItemDtlTopicOnMouseClick(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            txtEnterItemDtlTopic.setEditable(true);
            btnAddDtl.setDisable(true);
            btnUpdateDtl.setDisable(false);
            btnDeleteDtl.setDisable(true);
        }
    }

    public void btnAddWarrantyOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/subwindows/AddWarrantyTypeView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        //((ItemMoreDetailViewController) fxmlLoader.getController()).getObject(item.getOb());
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void btnAddBatchIdMouseClickEvent(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/subwindows/AddBatchView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        //((ItemMoreDetailViewController) fxmlLoader.getController()).getObject(item.getOb());
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
