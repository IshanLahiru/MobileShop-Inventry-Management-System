package com.codercrope.mobileinventrymanagement.to;

public class CustOrderHasWarranty {
    private String orderId;
    private String employeeId;
    private String warrantyId;
    private String date_time;

    public CustOrderHasWarranty(String orderId, String employeeId, String warrantyId, String date_time) {
        this.orderId = orderId;
        this.employeeId = employeeId;
        this.warrantyId = warrantyId;
        this.date_time = date_time;
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

    public String getWarrantyId() {
        return warrantyId;
    }

    public void setWarrantyId(String warrantyId) {
        this.warrantyId = warrantyId;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
}
