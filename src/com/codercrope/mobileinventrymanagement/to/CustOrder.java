package com.codercrope.mobileinventrymanagement.to;

import java.util.HashMap;

public class CustOrder {
    private String orderId;
    private String paymentTypeId;
    private String employeeId;
    private String dateTime;
    private String custPaymentStats;
    private String custOrderDtl;

    public CustOrder(String orderId, String paymentTypeId, String employeeId, String dateTime, String custPaymentStats, String custOrderDtl) {
        this.orderId = orderId;
        this.paymentTypeId = paymentTypeId;
        this.employeeId = employeeId;
        this.dateTime = dateTime;
        this.custPaymentStats = custPaymentStats;
        this.custOrderDtl = custOrderDtl;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(String paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
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

    public String getCustPaymentStats() {
        return custPaymentStats;
    }

    public void setCustPaymentStats(String custPaymentStats) {
        this.custPaymentStats = custPaymentStats;
    }

    public String getCustOrderDtl() {
        return custOrderDtl;
    }

    public void setCustOrderDtl(String custOrderDtl) {
        this.custOrderDtl = custOrderDtl;
    }
}
