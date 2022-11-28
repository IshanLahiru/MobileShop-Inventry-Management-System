package com.codercrope.mobileinventrymanagement.controler.tmlist;

import com.codercrope.mobileinventrymanagement.to.Item;
import com.codercrope.mobileinventrymanagement.to.Warranty;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainItemTM {
    private Item ob;
    private String ItemId;
    private String WorrantyId;
    private String ItemName;
    private String AddedDateTime;
    private double StockPrice;
    private int ItemsOnStock;
    private Button MoreDtl;

    public MainItemTM(Item ob, String itemId, String worrantyId, String itemName, String addedDateTime, double stockPrice, int itemsOnStock, Button moreDtl) {
        this.ob = ob;
        ItemId = itemId;
        WorrantyId = worrantyId;
        ItemName = itemName;
        AddedDateTime = addedDateTime;
        StockPrice = stockPrice;
        ItemsOnStock = itemsOnStock;
        MoreDtl = moreDtl;
    }

    public Item getOb() {
        return ob;
    }

    public void setOb(Item ob) {
        this.ob = ob;
    }

    public String getItemId() {
        return ItemId;
    }

    public void setItemId(String itemId) {
        ItemId = itemId;
    }

    public String getWorrantyId() {
        return WorrantyId;
    }

    public void setWorrantyId(String worrantyId) {
        WorrantyId = worrantyId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getAddedDateTime() {
        return AddedDateTime;
    }

    public void setAddedDateTime(String addedDateTime) {
        AddedDateTime = addedDateTime;
    }

    public double getStockPrice() {
        return StockPrice;
    }

    public void setStockPrice(double stockPrice) {
        StockPrice = stockPrice;
    }

    public Button getMoreDtl() {
        return MoreDtl;
    }

    public void setMoreDtl(Button moreDtl) {
        MoreDtl = moreDtl;
    }

    public int getItemsOnStock() {
        return ItemsOnStock;
    }

    public void setItemsOnStock(int itemsOnStock) {
        ItemsOnStock = itemsOnStock;
    }
}
