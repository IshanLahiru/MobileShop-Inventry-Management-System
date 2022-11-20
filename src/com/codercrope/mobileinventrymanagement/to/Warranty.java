package com.codercrope.mobileinventrymanagement.to;

import java.util.HashMap;

public class Warranty {
    private String warrantyId;
    private WarrantyType warrantyTypeId;

    public Warranty(String warrantyId, WarrantyType warrantyTypeId) {
        this.warrantyId = warrantyId;
        this.warrantyTypeId = warrantyTypeId;
    }

    public String getWarrantyId() {
        return warrantyId;
    }

    public void setWarrantyId(String warrantyId) {
        this.warrantyId = warrantyId;
    }

    public WarrantyType getWarrantyTypeId() {
        return warrantyTypeId;
    }

    public void setWarrantyTypeId(WarrantyType warrantyTypeId) {
        this.warrantyTypeId = warrantyTypeId;
    }
}
