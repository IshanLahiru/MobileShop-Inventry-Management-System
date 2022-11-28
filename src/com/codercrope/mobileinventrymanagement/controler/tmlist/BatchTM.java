package com.codercrope.mobileinventrymanagement.controler.tmlist;

import com.codercrope.mobileinventrymanagement.to.Batch;
import javafx.scene.control.Button;

public class BatchTM {
    private Batch ob;
    private String batchId;
    private String batchDtl;
    private String dateTime;
    private double dollerRate;
    private Button btn;

    public BatchTM(Batch ob, String batchId, String batchDtl, String dateTime, double dollerRate, Button btn) {
        this.ob = ob;
        this.batchId = batchId;
        this.batchDtl = batchDtl;
        this.dateTime = dateTime;
        this.dollerRate = dollerRate;
        this.btn = btn;
    }

    public Batch getOb() {
        return ob;
    }

    public void setOb(Batch ob) {
        this.ob = ob;
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

    public double getDollerRate() {
        return dollerRate;
    }

    public void setDollerRate(double dollerRate) {
        this.dollerRate = dollerRate;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
