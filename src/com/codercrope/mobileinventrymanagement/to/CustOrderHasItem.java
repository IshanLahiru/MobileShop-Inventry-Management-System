package com.codercrope.mobileinventrymanagement.to;

import java.util.HashMap;

public class CustOrderHasItem {
    private String orderId;
    private HashMap<Item, Integer> itemId;
    private double qty;
    private double itemPrice;

    public CustOrderHasItem(String orderId, HashMap<Item, Integer> itemId) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.qty = qty;
        this.itemPrice = itemPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public HashMap<Item, Integer> getItemId() {
        return itemId;
    }

    public void setItemId(HashMap<Item, Integer> itemId) {
        this.itemId = itemId;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
