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
    public Button root1;

    public void addItem(Button root1, int size, MainBillingItemTM itemtm, BillingViewController billingViewController) {
        this.billItem = itemtm;
        this.root1 = root1;
        this.billingViewController = billingViewController;
        lblIndex.setText(String.valueOf(size));
        lblQty.setText(String.valueOf(itemtm.getItemQty()));
        lblPrice.setText(String.valueOf(itemtm.getItemPriceStock()));
        lblItemName.setText(itemtm.getOb().getItemName());
        lblItemName.setWrapText(true);
        //billingViewController.item.get().lblQty.getText())
        for (int i = 0; i < billingViewController.item.size(); i++) {
            if (itemtm.getItemId().equals(billingViewController.item.get(i).getItemId())) {
                indexInArraylistItem = i;

            }
        }
        initLblPrice();
        //billingViewController.initPayBtn(getPrice());
    }

    public void btnPlusClickEvent(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if ((billItem.getItemQty()) != 0) {
            lblQty.setText(String.valueOf(Integer.parseInt(lblQty.getText()) + 1));
            billingViewController.item.get(indexInArraylistItem).setStock(billingViewController.item.get(indexInArraylistItem).getStock() - 1);
            //billItem.getOb().setItemPriceStock(billItem.getOb().getProfitPercentage()-1);
            billingViewController.setData();
            //System.out.println("clicked +");
            initLblPrice();
            //billingViewController.initPayBtn(getPrice());
            billingViewController.initPayBtn();
        } else {
            billingViewController.lwItemControllerDb.remove(this);
            billingViewController.items.remove(root1);
            billingViewController.initLv();
        }
    }

    public void btnMinusClickEvt(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if ((Integer.parseInt(lblQty.getText())) != 1) {
            lblQty.setText(String.valueOf(Integer.parseInt(lblQty.getText()) - 1));
            billingViewController.item.get(indexInArraylistItem).setStock(billingViewController.item.get(indexInArraylistItem).getStock() + 1);
            //billItem.getOb().setItemPriceStock(billItem.getOb().getProfitPercentage()+1);
            billingViewController.setData();
            initLblPrice();
            // billingViewController.initPayBtn(getPrice());
            billingViewController.initPayBtn();
        } else {
            billingViewController.lwItemControllerDb.remove(this);
            billingViewController.items.remove(root1);
            billingViewController.initLv();
        }
    }

    public void removeItemLwOnAction(MouseEvent mouseEvent) {
    }

    public void initLblPrice() {
        lblPrice.setText(String.valueOf(billItem.getItemPriceStock() * Integer.parseInt(lblQty.getText())));
    }

    public double getPrice() {
        System.out.println("the passing price is : " + Double.parseDouble(lblPrice.getText()));
        return Double.parseDouble(lblPrice.getText());
    }

    public void btnRemoveClickEvent(ActionEvent actionEvent) {
        billItem.setItemQty(Integer.parseInt(this.lblQty.getText()));
        billingViewController.item.get(billingViewController.lwItemControllerDb.size() - 1).setStock(billingViewController.item.get(billingViewController.lwItemControllerDb.size() - 1).getStock()+ (Integer.parseInt(billingViewController.txtQty.getText())));
        billingViewController.lwItemControllerDb.remove(this);
        billingViewController.items.remove(root1);
        billingViewController.initLv();
    }
}
