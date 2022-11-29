package com.codercrope.mobileinventrymanagement.controler.listview;

import com.codercrope.mobileinventrymanagement.controler.BillingViewController;
import com.codercrope.mobileinventrymanagement.controler.tmlist.MainBillingItemTM;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

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
    public int indexInArraylistItem;

    public void addItem(int size, MainBillingItemTM itemtm, BillingViewController billingViewController){
        this.billItem = itemtm;
        this.billingViewController = billingViewController;
        lblIndex.setText(String.valueOf(size));
        lblQty.setText(String.valueOf(itemtm.getItemQty()));
        lblPrice.setText(String.valueOf(itemtm.getItemPriceStock()));
        lblItemName.setText(itemtm.getOb().getItemName());
        lblItemName.setWrapText(true);
        //billingViewController.item.get().lblQty.getText())
        for(int i = 0 ; i<billingViewController.item.size();i++){
            if(itemtm.getItemId().equals(billingViewController.item.get(i).getItemId())){
                indexInArraylistItem = i;
            }
        }
    }

    public void btnPlusClickEvent(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        lblQty.setText(String.valueOf(Integer.parseInt(lblQty.getText())+1));
        billingViewController.item.get(indexInArraylistItem).setStock(billingViewController.item.get(indexInArraylistItem).getStock()-1);
        //billItem.getOb().setItemPriceStock(billItem.getOb().getProfitPercentage()-1);
        billingViewController.setData();
        //System.out.println("clicked +");
    }

    public void btnMinusClickEvt(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        lblQty.setText(String.valueOf(Integer.parseInt(lblQty.getText())-1));
        billingViewController.item.get(indexInArraylistItem).setStock(billingViewController.item.get(indexInArraylistItem).getStock()+1);
        //billItem.getOb().setItemPriceStock(billItem.getOb().getProfitPercentage()+1);
        billingViewController.setData();
    }

    public void removeItemLwOnAction(MouseEvent mouseEvent) {
    }
}
