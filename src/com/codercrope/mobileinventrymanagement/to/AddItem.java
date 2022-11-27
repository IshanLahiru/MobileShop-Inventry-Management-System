package com.codercrope.mobileinventrymanagement.to;

import java.util.HashMap;

public class AddItem {
    private String warrantyId;
    private String warrantTypeId;
    private String itemId;
    private String itemName;
    private String itemAddedDateTime;
    private Double itePriceStock;
    private int profitPercentage;
    private String ItemDtl;
    private HashMap<String, String> batchHasItem;

    public AddItem(String warrantyId, String warrantTypeId, String itemId, String itemName, String itemAddedDateTime, Double itePriceStock, int profitPercentage, String itemDtl, HashMap<String, String> batchHasItem) {
        this.warrantyId = warrantyId;
        this.warrantTypeId = warrantTypeId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemAddedDateTime = itemAddedDateTime;
        this.itePriceStock = itePriceStock;
        this.profitPercentage = profitPercentage;
        ItemDtl = itemDtl;
        this.batchHasItem = batchHasItem;
    }

    public String getWarrantyId() {
        return warrantyId;
    }

    public void setWarrantyId(String warrantyId) {
        this.warrantyId = warrantyId;
    }

    public String getWarrantTypeId() {
        return warrantTypeId;
    }

    public void setWarrantTypeId(String warrantTypeId) {
        this.warrantTypeId = warrantTypeId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemAddedDateTime() {
        return itemAddedDateTime;
    }

    public void setItemAddedDateTime(String itemAddedDateTime) {
        this.itemAddedDateTime = itemAddedDateTime;
    }

    public Double getItePriceStock() {
        return itePriceStock;
    }

    public void setItePriceStock(Double itePriceStock) {
        this.itePriceStock = itePriceStock;
    }

    public int getProfitPercentage() {
        return profitPercentage;
    }

    public void setProfitPercentage(int profitPercentage) {
        this.profitPercentage = profitPercentage;
    }

    public String getItemDtl() {
        return ItemDtl;
    }

    public void setItemDtl(String itemDtl) {
        ItemDtl = itemDtl;
    }

    public HashMap<String, String> getBatchHasItem() {
        return batchHasItem;
    }

    public void setBatchHasItem(HashMap<String, String> batchHasItem) {
        this.batchHasItem = batchHasItem;
    }
}
