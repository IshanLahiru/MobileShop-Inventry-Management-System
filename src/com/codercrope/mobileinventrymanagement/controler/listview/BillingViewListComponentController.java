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
    public Label lblIndex;
    public MainBillingItemTM billItem;
    public BillingViewController billingViewController;

    public void addItem(int size, MainBillingItemTM item, BillingViewController billingViewController){
        this.billItem = item;
        this.billingViewController = billingViewController;
        lblIndex.setText(String.valueOf(size));
        lblQty.setText(String.valueOf(item.getItemQty()));
        lblPrice.setText(String.valueOf(item.getItemPriceStock()));
        lblItemName.setText(item.getOb().getItemName());
        lblItemName.setWrapText(true);
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
