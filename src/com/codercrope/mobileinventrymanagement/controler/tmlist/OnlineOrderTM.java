package com.codercrope.mobileinventrymanagement.controler.tmlist;

import com.codercrope.mobileinventrymanagement.to.OnlineOrder;
import javafx.scene.control.Button;

import java.util.HashMap;

public class OnlineOrderTM {
    private OnlineOrder ob;
    private String orderId;
    private String batchId;
    private String paymentId;
    private String employeeId;
    private String dateTime;
    private String onlineOrderLinks;
    private Button button;

    public OnlineOrderTM(OnlineOrder ob, String orderId, String batchId, String paymentId, String employeeId, String dateTime, String onlineOrderLinks, Button button) {
        this.ob = ob;
        this.orderId = orderId;
        this.batchId = batchId;
        this.paymentId = paymentId;
        this.employeeId = employeeId;
        this.dateTime = dateTime;
        this.onlineOrderLinks = onlineOrderLinks;
        this.button = button;
    }

    public OnlineOrder getOb() {
        return ob;
    }

    public void setOb(OnlineOrder ob) {
        this.ob = ob;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getOnlineOrderLinks() {
        return onlineOrderLinks;
    }

    public void setOnlineOrderLinks(String onlineOrderLinks) {
        this.onlineOrderLinks = onlineOrderLinks;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
