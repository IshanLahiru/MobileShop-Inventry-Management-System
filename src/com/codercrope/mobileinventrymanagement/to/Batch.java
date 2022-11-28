package com.codercrope.mobileinventrymanagement.to;

public class Batch {
    private String batchId;
    private String batchDtl;
    private String dateTime;
    private double dollerRate;

    public Batch(String batchId, String batchDtl, String dateTime, double dollerRate) {
        this.batchId = batchId;
        this.batchDtl = batchDtl;
        this.dateTime = dateTime;
        this.dollerRate = dollerRate;
    }

    public double getDollerRate() {
        return dollerRate;
    }

    public void setDollerRate(double dollerRate) {
        this.dollerRate = dollerRate;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getBatchDtl() {
        return batchDtl;
    }

    public void setBatchDtl(String batchDtl) {
        this.batchDtl = batchDtl;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
