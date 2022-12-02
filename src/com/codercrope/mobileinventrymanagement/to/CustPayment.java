package com.codercrope.mobileinventrymanagement.to;

public class CustPayment {
    private String custPaymentId;
    private String orderId;
    private String employeeId;
    private double payment;

    public CustPayment(String custPaymentId, String orderId, String employeeId, double payment) {
        this.custPaymentId = custPaymentId;
        this.orderId = orderId;
        this.employeeId = employeeId;
        this.payment = payment;
    }

    public String getCustPaymentId() {
        return custPaymentId;
    }

    public void setCustPaymentId(String custPaymentId) {
        this.custPaymentId = custPaymentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }
}
