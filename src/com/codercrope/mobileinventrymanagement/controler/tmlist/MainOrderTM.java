package com.codercrope.mobileinventrymanagement.controler.tmlist;

import com.codercrope.mobileinventrymanagement.to.CustOrder;
import com.codercrope.mobileinventrymanagement.to.Item;
import javafx.scene.control.Button;

public class MainOrderTM {
    private CustOrder ob;
    private String orderId;
    private String paymentType;
    private String employeeId;
    private String dateTime;
    private double custPaymentSts;
    private Button tem;

    public MainOrderTM(CustOrder ob, String orderId, String paymentType, String employeeId, String dateTime, double custPaymentSts, Button tem) {
        this.ob = ob;
        this.orderId = orderId;
        this.paymentType = paymentType;
        this.employeeId = employeeId;
        this.dateTime = dateTime;
        this.custPaymentSts = custPaymentSts;
        this.tem = tem;
    }

    public CustOrder getOb() {
        return ob;
    }

    public void setOb(CustOrder ob) {
        this.ob = ob;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
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

    public double getCustPaymentSts() {
        return custPaymentSts;
    }

    public void setCustPaymentSts(double custPaymentSts) {
        this.custPaymentSts = custPaymentSts;
    }

    public Button getTem() {
        return tem;
    }

    public void setTem(Button tem) {
        this.tem = tem;
    }
}