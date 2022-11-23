package com.codercrope.mobileinventrymanagement.controler.subwindows;

import com.codercrope.mobileinventrymanagement.to.Item;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ItemMoreDetailViewController {
    @FXML
    private Label lblItemId;

    @FXML
    private Label lblWarrentyId;

    @FXML
    private Label lblItemName1;

    @FXML
    private Label lblAddedDateTime;

    @FXML
    private Label lblItemPrice;

    @FXML
    private Label lblProfitPercentage;

    @FXML
    private Label lblItemName;

    @FXML
    private TextField addItemDtlTitle;

    @FXML
    private ListView<?> ItemBatchDtl;

    private Item ob;

    public void initialize(){
        //this.lblItemName.setText();
    }

    public void getObject(Item ob) {
        this.ob = ob;
        lblItemName.setText(this.ob.getItemName());
        lblItemId.setText(this.ob.getItemId());
        lblWarrentyId.setText(this.ob.getWarrentyId().getWarrantyId());
        lblItemName1.setText(this.ob.getItemName());
        lblAddedDateTime.setText(this.ob.getItemAddedDateTime());
        lblItemPrice.setText(String.valueOf(this.ob.getItemPriceStock()));
        lblProfitPercentage.setText(String.valueOf(this.ob.getProfitPercentage())+"%");


    }
}
