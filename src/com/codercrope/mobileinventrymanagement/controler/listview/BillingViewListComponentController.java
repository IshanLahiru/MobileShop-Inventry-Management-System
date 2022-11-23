package com.codercrope.mobileinventrymanagement.controler.listview;

import com.codercrope.mobileinventrymanagement.controler.BillingViewController;
import com.codercrope.mobileinventrymanagement.controler.tmlist.MainBillingItemTM;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class BillingViewListComponentController {
    public Label lblPrice;
    public Label lblItemName;
    public Label lblQty;
    public Button btnPlus;
    public Button btnMinus;
    public Button btnRemove;
    private MainBillingItemTM billItem;
    private BillingViewController billingViewController;

    public void addItem(MainBillingItemTM item, BillingViewController billingViewController){
        this.billItem = item;
        this.billingViewController = billingViewController;
        //System.out.println(billItem);
        lblQty.setText(String.valueOf(billItem.getItemQty()));
        lblItemName.setText(billItem.getItemName());
        lblPrice.setText(String.valueOf(billItem.getItemPriceStock()));
        billItem.getOb().setItemPriceStock(billItem.getOb().getProfitPercentage()-billItem.getItemQty());
    }

    public void btnPlusClickEvent(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        lblQty.setText(String.valueOf(Integer.parseInt(lblQty.getText())+1));
        billItem.getOb().setItemPriceStock(billItem.getOb().getProfitPercentage()-1);
        billingViewController.setData();
        System.out.println("clicked +");
    }

    public void btnMinusClickEvt(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        lblQty.setText(String.valueOf(Integer.parseInt(lblQty.getText())-1));
        billItem.getOb().setItemPriceStock(billItem.getOb().getProfitPercentage()+1);
        billingViewController.setData();
    }
}
