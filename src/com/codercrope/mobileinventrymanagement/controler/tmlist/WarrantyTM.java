package com.codercrope.mobileinventrymanagement.controler.tmlist;

import com.codercrope.mobileinventrymanagement.to.WarrantyType;
import javafx.scene.control.Button;

public class WarrantyTM {
    private WarrantyType ob;
    private String warrantyTypeId;
    private String warrantyDuration;
    private String warrantyCost;
    private String warrantyTypeDtl;
    private Button btn;

    public WarrantyTM(WarrantyType ob, String warrantyTypeId, String warrantyDuration, String warrantyCost, String warrantyTypeDtl, Button btn) {
        this.ob = ob;
        this.warrantyTypeId = warrantyTypeId;
        this.warrantyDuration = warrantyDuration;
        this.warrantyCost = warrantyCost;
        this.warrantyTypeDtl = warrantyTypeDtl;
        this.btn = btn;
    }

    public WarrantyType getOb() {
        return ob;
    }

    public void setOb(WarrantyType ob) {
        this.ob = ob;
    }

    public String getWarrantyTypeId() {
        return warrantyTypeId;
    }

    public void setWarrantyTypeId(String warrantyTypeId) {
        this.warrantyTypeId = warrantyTypeId;
    }

    public String getWarrantyDuration() {
        return warrantyDuration;
    }

    public void setWarrantyDuration(String warrantyDuration) {
        this.warrantyDuration = warrantyDuration;
    }

    public String getWarrantyCost() {
        return warrantyCost;
    }

    public void setWarrantyCost(String warrantyCost) {
        this.warrantyCost = warrantyCost;
    }

    public String getWarrantyTypeDtl() {
        return warrantyTypeDtl;
    }

    public void setWarrantyTypeDtl(String warrantyTypeDtl) {
        this.warrantyTypeDtl = warrantyTypeDtl;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
