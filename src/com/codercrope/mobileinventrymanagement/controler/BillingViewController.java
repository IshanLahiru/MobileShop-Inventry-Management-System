package com.codercrope.mobileinventrymanagement.controler;

import com.codercrope.mobileinventrymanagement.controler.listview.BillingViewListComponentController;
import com.codercrope.mobileinventrymanagement.controler.subwindows.ItemMoreDetailViewController;
import com.codercrope.mobileinventrymanagement.controler.tmlist.MainBillingItemTM;
import com.codercrope.mobileinventrymanagement.controler.tmlist.MainBillingListViewTm;
import com.codercrope.mobileinventrymanagement.model.*;
import com.codercrope.mobileinventrymanagement.to.AddItem;
import com.codercrope.mobileinventrymanagement.to.Item;
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

public class BillingViewController {

    public TableColumn tblItemPrice1;
    public Label lblTotalPB;
    public Label lblTotal;
    public Label lblTotal1;
    public Label lblDiscount;
    @FXML
    private GridPane pane1;

    @FXML
    private Label lblItemId;

    @FXML
    private Button btnMoreDetails;

    @FXML
    private Label lblItemName;

    @FXML
    private Label lblItemPrice;

    @FXML
    private Label lblOnStock;

    @FXML
    private Button btnAdd;

    @FXML
    private TextField txtSearch;

    @FXML
    public TextField txtQty;

    @FXML
    private TableView<MainBillingItemTM> tblBillingView;

    @FXML
    private TableColumn<MainBillingItemTM, String> tblItemId;

    @FXML
    private TableColumn<MainBillingItemTM, String> tblItemName;

    @FXML
    private TableColumn<MainBillingItemTM, String> tblItemPrice;

    @FXML
    private TableColumn<MainBillingItemTM, Double> tblOnStock;

    @FXML
    private TableColumn<MainBillingItemTM, Button> tblMoreDtl;

    @FXML
    private ListView<Button> listViewBilling;

    @FXML
    private Button btnPay;


    public ObservableList<MainBillingItemTM> cust = FXCollections.observableArrayList();
    public ArrayList<Button> items = new ArrayList<>();
    public ArrayList<BillingViewListComponentController> lwItemControllerDb =new ArrayList<>();
    public ArrayList<Item> item = new ArrayList();
    public MainBillingItemTM selectedItem;
    public HashMap<Item,Integer> order = new HashMap<>();

    public void initLabels(){
        lblItemId.setText(item.get(0).getItemId());
        lblItemName.setText(item.get(0).getItemName());
        lblOnStock.setText(String.valueOf(item.get(0).getStock()));
        lblItemPrice.setText(String.valueOf(item.get(0).getItemPriceStock()));
        btnMoreDetails.setOnMouseClicked(e -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/subwindows/ItemMoreDetailView.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                ((ItemMoreDetailViewController) fxmlLoader.getController()).getObject(item.get(0));
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
    public void initLabels(Item item){
        lblItemId.setText(item.getItemId());
        lblItemName.setText(item.getItemName());
        lblOnStock.setText(String.valueOf(item.getStock()));
        lblItemPrice.setText(String.valueOf(item.getItemPriceStock()));
        btnMoreDetails.setOnMouseClicked(e -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/subwindows/ItemMoreDetailView.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                ((ItemMoreDetailViewController) fxmlLoader.getController()).getObject(item);
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
    public void initLabels(MainBillingItemTM item){
        lblItemId.setText(item.getItemId());
        lblItemName.setText(item.getItemName());
        lblOnStock.setText(String.valueOf(item.getItemQty()));
        lblItemPrice.setText(String.valueOf(item.getItemPriceStock()));
        btnMoreDetails.setOnMouseClicked(e -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/subwindows/ItemMoreDetailView.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                ((ItemMoreDetailViewController) fxmlLoader.getController()).getObject(item.getOb());
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }



    public void initialize() throws SQLException, ClassNotFoundException {
        tblItemId.setCellValueFactory(new PropertyValueFactory<MainBillingItemTM, String>("itemId"));
        tblItemName.setCellValueFactory(new PropertyValueFactory<MainBillingItemTM, String>("itemName"));
        tblItemPrice.setCellValueFactory(new PropertyValueFactory<MainBillingItemTM, String>("itemPriceStock"));
        tblOnStock.setCellValueFactory(new PropertyValueFactory<MainBillingItemTM, Double>("itemQty"));
        tblMoreDtl.setCellValueFactory(new PropertyValueFactory<MainBillingItemTM, Button>("tem"));

        item = ItemModel.getItems();
        setData();
        initLabels();
        /*lblItemId.setText(item.get(0).getItemId());
        lblItemName.setText(item.get(0).getItemName());
        lblOnStock.setText(String.valueOf(item.get(0).getStock()));
        lblItemPrice.setText(String.valueOf(item.get(0).getItemPriceStock()));
        btnMoreDetails.setOnMouseClicked(e -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/subwindows/ItemMoreDetailView.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                ((ItemMoreDetailViewController) fxmlLoader.getController()).getObject(item.get(0));
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });*/
    }

    @FXML
    void listViewBillingClickEvt(MouseEvent event) {

    }

    public void setRow(Item item) throws SQLException, ClassNotFoundException {
        Button tem = new Button("  More Details  ");
        MainBillingItemTM temp = new MainBillingItemTM(
                item,
                item.getItemId(),
                item.getItemName(),
                item.getStock(),
                PriceModel.getItemPrice(item.getItemId(),
                        item.getItemPriceStock(),
                        item.getProfitPercentage()),
                tem
        );
        tem.setOnAction(e -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/subwindows/ItemMoreDetailView.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                ((ItemMoreDetailViewController) fxmlLoader.getController()).getObject(item);
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        cust.add(temp);
    }
    public void setData() throws SQLException, ClassNotFoundException {
        tblBillingView.getItems().clear();
        cust.clear();
        //ArrayList<Item> items = ItemModel.getItems();
        for (Item ob : item) {
            setRow(ob);
        }
        this.selectedItem = cust.get(0);
        tblBillingView.setItems(cust);

    }
    public void setTxtSearchData(ArrayList<Item> item) throws SQLException, ClassNotFoundException {
        //ObservableList<MainBillingItemTM> cust = FXCollections.observableArrayList();
        tblBillingView.getItems().clear();
        for (Item ob : item) {
            Button tem = new Button("  More Details  ");
            MainBillingItemTM temp = new MainBillingItemTM(ob, ob.getItemId(), ob.getItemName(), ob.getStock(), ob.getItemPriceStock(), tem);
            tem.setOnMouseClicked(e -> {
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
            this.selectedItem = temp;
            initLabels();
            /*lblItemId.setText(item.get(0).getItemId());
            lblItemName.setText(item.get(0).getItemName());
            lblMoreInfo.setText(item.get(0).getItemDtl());
            lblOnStock.setText(String.valueOf(item.get(0).getItemPriceStock()));
            btnMoreDetails.setOnMouseClicked(e -> {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/subwindows/ItemMoreDetailView.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    ((ItemMoreDetailViewController) fxmlLoader.getController()).getObject(temp.getOb());
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });*/
        }
        this.selectedItem = cust.get(0);
        tblBillingView.setItems(cust);
    }
    public void txtSearchOnAction(ActionEvent actionEvent) {
    }

    public void txtSearchKeyRelesedOnAction(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
            tblBillingView.getItems().clear();
            /*//ArrayList<Item> items = ItemModel.getSearchedItems(("%" + txtSearch.getText() + "%"));
            ArrayList<Item> items = new ArrayList();
            for(int i=0; i<item.size(); i++){
                if (item.get(i).getItemName().contains(txtSearch.getText()) | item.get(i).getItemId().contains(txtSearch.getText())){
                    items.add(item.get(i));
                }
            }
            setTxtSearchData(items);*/
        cust.clear();
        for (Item ob : item) {
            if (ob.getItemName().contains(txtSearch.getText()) || ob.getItemId().contains(txtSearch.getText())){
                setRow(ob);
            }
        }
        this.selectedItem = cust.get(0);
        tblBillingView.setItems(cust);
    }

    public void txtSearchKeyPressedOnAction(KeyEvent keyEvent) {
        System.out.println(keyEvent.getCode());
        if (keyEvent.getCode().isArrowKey()){
            tblBillingView.requestFocus();
            tblBillingView.getSelectionModel().select(0);
            tblBillingView.getFocusModel().focus(0);
        }else if(keyEvent.getCode().isWhitespaceKey()){
            txtQty.requestFocus();
        }
    }

    public void tblViewOnKeyPressedEvt(KeyEvent keyEvent) {
        if (keyEvent.getCode().isWhitespaceKey()) {
            if(tblBillingView.getSelectionModel().getSelectedItem()!=null) {
                MainBillingItemTM temp = (MainBillingItemTM) tblBillingView.getSelectionModel().getSelectedItem();
                this.selectedItem = temp;
                //System.out.println(selectedItem.getOb().getItemDtlHM().get("ishan"));
                initLabels(temp);
                /*lblItemId.setText(temp.getItemId());
                lblItemName.setText(temp.getItemName());
                lblMoreInfo.setText(temp.getHahah());
                lblOnStock.setText(String.valueOf(temp.getItemPriceStock()));
                btnMoreDetails.setOnMouseClicked(e -> {
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/subwindows/ItemMoreDetailView.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        ((ItemMoreDetailViewController) fxmlLoader.getController()).getObject(temp.getOb());
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root1));
                        stage.show();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });*/
                txtQty.requestFocus();

            /*txtCustId.setText(temp.getCustId());
            txtCustName.setText(temp.getCustName());
            txtCustAddress.setText(temp.getCustAddress());
            txtCustSallery.setText(String.valueOf(temp.getSalary()));*/
            }
        } /*else if (event.getButton() == MouseButton.SECONDARY) {
            System.out.println("rightClicked on the table");
        }*/
    }

    @FXML
    void tblBillingViewMouseClickEvent(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            if(tblBillingView.getSelectionModel().getSelectedItem()!=null) {
                MainBillingItemTM temp = (MainBillingItemTM) tblBillingView.getSelectionModel().getSelectedItem();
                this.selectedItem = temp;
                //System.out.println("the selected item id is : "+temp.getItemId());
                txtQty.requestFocus();
                initLabels(temp);
                /*lblItemId.setText(temp.getItemId());
                lblItemName.setText(temp.getItemName());
                lblItemPrice.setText(String.valueOf(temp.getItemPriceStock()));
                lblOnStock.setText(String.valueOf(temp.getQty()));
                btnMoreDetails.setOnMouseClicked(e -> {
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/subwindows/ItemMoreDetailView.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        ((ItemMoreDetailViewController) fxmlLoader.getController()).getObject(temp.getOb());
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root1));
                        stage.show();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });*/


            /*txtCustId.setText(temp.getCustId());
            txtCustName.setText(temp.getCustName());
            txtCustAddress.setText(temp.getCustAddress());
            txtCustSallery.setText(String.valueOf(temp.getSalary()));*/
            }
        } else if (event.getButton() == MouseButton.SECONDARY) {
            System.out.println("rightClicked on the table");
        }

    }

    public void lblQtyOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        this.selectedItem.setItemQty(Integer.parseInt(txtQty.getText()));
        boolean exists =false;
        int index = -1;
        for(int i = 0 ; i<lwItemControllerDb.size();i++){
            if(this.selectedItem.getOb().getItemId().equals(lwItemControllerDb.get(i).billItem.getItemId())){
                index = i;
                exists = true;
            }
        }
        if(exists){
            lwItemControllerDb.get(index).lblQty.setText(String.valueOf((Integer.parseInt(txtQty.getText()))+(Integer.parseInt(lwItemControllerDb.get(index).lblQty.getText()))));
            int locationOnItemAr = lwItemControllerDb.get(index).indexInArraylistItem;
            int qtyInLw = Integer.parseInt(lwItemControllerDb.get(index).lblQty.getText());
            item.get(locationOnItemAr).setStock(item.get(locationOnItemAr).getStock()- Integer.parseInt(txtQty.getText()));
            initTotals();
            setData();
            listViewBilling.getItems().removeAll(items);
            listViewBilling.getItems().addAll(items);
            txtQty.setText("");
            txtSearch.requestFocus();
            initPayBtn();
            /*item.set(locationOnItemAr,item.get(locationOnItemAr).getStock());
            item.get(lwItemControllerDb.get(index).indexInArraylistItem).setStock(
                    (
                            (item.get(lwItemControllerDb.get(index).indexInArraylistItem).getStock())-(Integer.parseInt(lwItemControllerDb.get(index).lblQty.getText()))
                    )
            );*/
        }else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/listview/BillingViewListComponent.fxml"));
            Button root1 = (Button) fxmlLoader.load();
            BillingViewListComponentController controller = (BillingViewListComponentController) fxmlLoader.getController();
            controller.addItem(root1,lwItemControllerDb.size() + 1, this.selectedItem, this);
            lwItemControllerDb.add(controller);
            listViewBilling.getItems().removeAll(items);
            items.add(root1);
            listViewBilling.getItems().addAll(items);
            int qtyInLw = Integer.parseInt(lwItemControllerDb.get(lwItemControllerDb.size()-1).lblQty.getText());
            item.get(lwItemControllerDb.size() - 1).setStock(item.get(lwItemControllerDb.size() - 1).getStock()- (Integer.parseInt(txtQty.getText())));
            initTotals();
            setData();
            txtQty.setText("");
            txtSearch.requestFocus();
            initPayBtn();
        }
    }
    public void initLv(){
        listViewBilling.getItems().removeAll(items);
        listViewBilling.getItems().clear();
        listViewBilling.getItems().addAll(items);
    }

    public void initTotals() {
        int total = 0;

        lblTotal1.setText(String.valueOf(total));
    }

    public void btnAddOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        this.selectedItem.setItemQty(Integer.parseInt(txtQty.getText()));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/listview/BillingViewListComponent.fxml"));
        Button root1 = (Button) fxmlLoader.load();
        new MainBillingListViewTm(this.selectedItem.getOb(),this.selectedItem.getItemId(),
                this.selectedItem.getItemName(),this.selectedItem.getItemQty(),
                this.selectedItem.getItemPriceStock(),items.size());
        ((BillingViewListComponentController) fxmlLoader.getController()).addItem(root1, lwItemControllerDb.size(), this.selectedItem,this);
        setData();
        items.add(root1);
        listViewBilling.getItems().removeAll(items);
        listViewBilling.getItems().addAll(items);
        txtSearch.requestFocus();
    }

    public void initPayBtn() {
        /*lblTotal1.setText(String.valueOf(Double.parseDouble(lblTotal1.getText())+(price)));
        lblTotal1.setText(String.valueOf(Double.parseDouble(lblTotal1.getText())+(price)));
        lblTotal1.setText(String.valueOf(Double.parseDouble(lblTotal1.getText())+(price)));*/
        /*lblTotalPB.setText(String.valueOf(
                (Double.parseDouble
                        (lblTotalPB.getText()))+(price)));
        lblTotal.setText(String.valueOf(
                (Double.parseDouble
                        (lblTotal.getText()))+(price)));
        lblTotal1.setText(String.valueOf(
                (Double.parseDouble
                        (lblTotal1.getText()))+(price)));*/
        double total = 0;
        for (BillingViewListComponentController c : lwItemControllerDb) {
            total += c.getPrice();
        }
        System.out.println("the total is going to be : " + total);

        lblTotalPB.setText(String.valueOf(String.format("%.2f",total)));
        lblTotal.setText(String.valueOf(String.format("%.2f",total)));
        lblTotal1.setText(String.valueOf(String.format("%.2f",total)));
    }

    public void btnPayOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = dtf.format(now);
        //System.out.println(dateTime);
        //System.out.println(warrantyTypeSelector.getText());
        /*for (AddItemViewBSListComponentController b : batchList) {
            hm.put(b.getBatchId(), b.getNoOfItems());
        }*/
        boolean sta = AddOrderModel.save(item,order,CustPAymentTypeModel.getType(),dateTime,"payment stats","{}");
        if (sta) {
            setData();
            //lblItemId.setText(ItemModel.getItemId());
            //lblWarrantyId.setText(WarrantyModel.getWarrantyId());
            new Alert(Alert.AlertType.INFORMATION, "Item Added successfully").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Error: not added! try again").show();
        }
    }
}
