package com.codercrope.mobileinventrymanagement.to;

import java.util.HashMap;

public class WarrantyType {
    private String warrantyTypeId;
    private String warrantyDuration;
    private String warrantyCost;
    private String warrantyTypeDtl;

    public WarrantyType(String warrantyTypeId, String warrantyDuration, String warrantyCost, String warrantyTypeDtl) {
        this.warrantyTypeId = warrantyTypeId;
        this.warrantyDuration = warrantyDuration;
        this.warrantyCost = warrantyCost;
        this.warrantyTypeDtl = warrantyTypeDtl;
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
}
