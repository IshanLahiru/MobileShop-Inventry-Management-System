package com.codercrope.mobileinventrymanagement.controler.tmlist;

import javafx.scene.control.Button;

public class MainBillingItemTM {
    private String itemId;
    private String itemName;
    private String hahah;
    private double itemPriceStock;
    private Button tem;

    public MainBillingItemTM(String itemId, String itemName, String hahah, double itemPriceStock, Button tem) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.hahah = hahah;
        this.itemPriceStock = itemPriceStock;
        this.tem = tem;
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

    public String getHahah() {
        return hahah;
    }

    public void setHahah(String hahah) {
        this.hahah = hahah;
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
