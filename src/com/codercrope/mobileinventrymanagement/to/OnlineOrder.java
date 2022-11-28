package com.codercrope.mobileinventrymanagement.to;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

public class OnlineOrder {
    private String orderId;
    private String batchId;
    private String paymentId;
    private String employeeId;
    private String dateTime;
    private String onlineOrdersLinks;

    public OnlineOrder(String orderId, String batchId, String paymentId, String employeeId, String dateTime, String onlineOrdersLinks) {
        this.orderId = orderId;
        this.batchId = batchId;
        this.paymentId = paymentId;
        this.employeeId = employeeId;
        this.dateTime = dateTime;
        this.onlineOrdersLinks = onlineOrdersLinks;
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

    public String getOnlineOrdersLinks() {
        return onlineOrdersLinks;
    }

    public void setOnlineOrdersLinks(String onlineOrdersLinks) {
        this.onlineOrdersLinks = onlineOrdersLinks;
    }

    public HashMap<String, String> getOnlineOrdersLinksHM() {
        HashMap<String, String> mapObj = new Gson().fromJson(
                onlineOrdersLinks, new TypeToken<HashMap<String, String>>() {}.getType()
        );
        return mapObj;
    }
}
