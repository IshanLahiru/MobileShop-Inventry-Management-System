package com.codercrope.mobileinventrymanagement.to;

import com.google.gson.Gson;

import java.util.HashMap;

public class AddWarrantyType {
    private String warrantyTypeId;
    private String warrantyDuration;
    private String warrantyCost;
    private HashMap<String,String> warrantyTypeDtl;

    public AddWarrantyType(String warrantyTypeId, String warrantyDuration, String warrantyCost, HashMap<String, String> warrantyTypeDtl) {
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

    public HashMap<String, String> getWarrantyTypeDtlHm() {
        return warrantyTypeDtl;
    }

    public void setWarrantyTypeDtl(HashMap<String, String> warrantyTypeDtl) {
        this.warrantyTypeDtl = warrantyTypeDtl;
    }
    public static String getWarrantyTypeDtlJson(HashMap<String, String> hm) {
        return new Gson().toJson(hm);
    }
}
