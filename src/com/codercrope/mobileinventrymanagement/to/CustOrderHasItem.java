package com.codercrope.mobileinventrymanagement.to;

public class CustOrderHasItem {
    private String orderId;
    private String itemId;
    private double qty;
    private double itemPrice;

    public CustOrderHasItem(String orderId, String itemId, double qty, double itemPrice) {
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

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
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
