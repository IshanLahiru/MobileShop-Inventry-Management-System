package com.codercrope.mobileinventrymanagement.controler.tmlist;

import com.codercrope.mobileinventrymanagement.to.Item;
import javafx.scene.control.Button;

public class MainBillingItemTM {
    private Item ob;
    private String itemId;
    private String itemName;
    private int itemQty;
    private double itemPriceStock;
    private Button tem;

    public int getItemQty() {
        return itemQty;
    }

    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }

    public MainBillingItemTM(Item ob, String itemId, String itemName, int itemQty, double itemPriceStock, Button tem) {
        this.ob = ob;
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemQty = itemQty;
        this.itemPriceStock = itemPriceStock;
        this.tem = tem;
    }

    public Item getOb() {
        return ob;
    }

    public void setOb(Item ob) {
        this.ob = ob;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPriceStock() {
        return itemPriceStock;
    }

    public void setItemPriceStock(double itemPriceStock) {
        this.itemPriceStock = itemPriceStock;
    }

    public Button getTem() {
        return tem;
    }

    public void setTem(Button tem) {
        this.tem = tem;
    }
}
