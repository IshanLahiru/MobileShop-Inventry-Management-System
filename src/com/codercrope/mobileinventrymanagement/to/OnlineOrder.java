package com.codercrope.mobileinventrymanagement.to;

import com.codercrope.mobileinventrymanagement.model.EmployeeModel;
import com.codercrope.mobileinventrymanagement.model.PaymentModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.sql.SQLException;
import java.util.HashMap;

public class OnlineOrder {
    private String orderId;
    private String batchId;
    private Payment paymentId;
    private Employee employeeId;
    private String dateTime;
    private String onlineOrdersLinks;

    public OnlineOrder(String orderId, String batchId, String paymentId, String employeeId, String dateTime, String onlineOrdersLinks) throws SQLException, ClassNotFoundException {
        this.orderId = orderId;
        this.batchId = batchId;
        this.paymentId = PaymentModel.getPayment(paymentId);
        this.employeeId = EmployeeModel.getEmployee(employeeId);
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

    public Payment getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Payment paymentId) {
        this.paymentId = paymentId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
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
    public static String getOnlineOrdersLinksJson(HashMap<String, String> hm) {
        return new Gson().toJson(hm);
    }
}
