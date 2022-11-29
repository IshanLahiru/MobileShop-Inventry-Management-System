package com.codercrope.mobileinventrymanagement.to;

public class Payment {
    private String paymentId;
    private String employeeId;
    private String paymentAmount;
    private String paymentDateTime;

    public Payment(String paymentId, String employeeId, String paymentAmount, String paymentDateTime) {
        this.paymentId = paymentId;
        this.employeeId = employeeId;
        this.paymentAmount = paymentAmount;
        this.paymentDateTime = paymentDateTime;
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

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentDateTime() {
        return paymentDateTime;
    }

    public void setPaymentDateTime(String paymentDateTime) {
        this.paymentDateTime = paymentDateTime;
    }
}
