package com.codercrope.mobileinventrymanagement.view.subwindows;

import com.codercrope.mobileinventrymanagement.controler.subwindows.ItemMoreDetailViewController;
import com.codercrope.mobileinventrymanagement.controler.tmlist.MainItemTM;
import com.codercrope.mobileinventrymanagement.model.*;
import com.codercrope.mobileinventrymanagement.to.*;
import com.codercrope.mobileinventrymanagement.view.listview.AddItemViewBSListComponentController;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class AddItemsViewController {


    public Button btnAddWarranty;
    public SplitMenuButton warrantyTypeSelector;
    public Label lblBatchDtls;
    public Button AddBatchId;
    public Button btnAddOnlineOrder;
    public Label lblItemPrice1;
    public ListView batchDtlListView;
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

    String warrantyType;

    public ArrayList<AddItemViewBSListComponentController> batchList = new ArrayList<AddItemViewBSListComponentController>();
    public ArrayList<Button> batchListView = new ArrayList<>();
    HashMap<String,String> hm =new HashMap<>();


    public void initialize() throws SQLException, ClassNotFoundException, IOException {
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
        lblWarrantyId.setText(WarrantyModel.getWarrantyId());
        ArrayList<WarrantyType> ar = WarrantyTypeModel.getWarrantyTypes();
        warrantyTypeSelector.getItems().clear();
        for (WarrantyType w : ar){
            MenuItem i = new MenuItem(w.getWarrantyTypeId());
            warrantyTypeSelector.getItems().add(i);
            i.setOnAction(event ->{
                warrantyTypeSelector.setText(w.getWarrantyTypeId());
                //warrantyType = w.getWarrantyTypeId();
            });
        }
        ArrayList<Batch> batches = BatchModel.getBatches();
        for(Batch b : batches){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/listview/AddItemViewBSListComponent.fxml"));
            Button root1 = (Button) fxmlLoader.load();
            AddItemViewBSListComponentController batch =((AddItemViewBSListComponentController) fxmlLoader.getController());
            batch.add(b,lblItemId.getText());
            batchListView.add(root1);
            batchList.add(batch);
            batchDtlListView.getItems().removeAll(batchListView);
            batchDtlListView.getItems().addAll(batchListView);
        }

    }

    @FXML
    public void ItemDtlComponentOnMouseClicked(MouseEvent event) {

    }

    @FXML
    public void btnAddOrderOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = dtf.format(now);
        System.out.println(warrantyTypeSelector.getText());
        for (AddItemViewBSListComponentController b : batchList){
            hm.put(b.getBatchId(),b.getNoOfItems());
        }
        boolean sta = AddItemModel.save(new AddItem(lblWarrantyId.getText(), warrantyTypeSelector.getText(), lblItemId.getText(), txtItemName.getText(), dateTime, lblItemPrice.getText(), lblProfitPercentage.getText(), "null", hm));
        if(sta){
            setData();
            lblItemId.setText(ItemModel.getItemId());
            lblWarrantyId.setText(WarrantyModel.getWarrantyId());
            new Alert(Alert.AlertType.INFORMATION,"Item Added successfully").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Error: not added! try again").show();
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
    public void warrantyTypeSelectorOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        //WarrantyModel.save(new Warranty(lblWarrantyId.getText(),WarrantyTypeModel.getWarrantyType(warrantyTypeSelector.getText())));
        txtItemPrice.requestFocus();
    }

    @FXML
    private void btnAddWarrantymouseClickEvent(ActionEvent event) {

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


    public void btnAddBatchIdOnAction(ActionEvent actionEvent) {
    }

    public void btnAddOnlineOrderOnAction(ActionEvent actionEvent) {
    }

    public void btnAddOnlineOrderOnMouseClickEvent(MouseEvent mouseEvent) {
    }

    public void btnAddBatchIdMouseClickEvent(MouseEvent mouseEvent) {
    }
}
