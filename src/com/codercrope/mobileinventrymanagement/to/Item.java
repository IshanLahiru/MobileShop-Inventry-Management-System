package com.codercrope.mobileinventrymanagement.to;

import java.util.HashMap;

public class Item {
    private String itemId;
    private String warrentyId;
    private String itemName;
    private String itemAddedDateTime;
    private double itemPriceStock;
    private int profitPercentage;
    private String itemDtl;


    public Item(String itemId, String warrentyId,
                String itemName, String itemAddedDateTime,
                double itemPriceStock , int profitPercentage, String itemDtl) {
        this.itemId = itemId;
        this.warrentyId = warrentyId;
        this.itemName = itemName;
        this.itemAddedDateTime = itemAddedDateTime;
        this.itemPriceStock = itemPriceStock;
        this.profitPercentage = profitPercentage;
        this.itemDtl = itemDtl;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getWarrentyId() {
        return warrentyId;
    }

    public void setWarrentyId(String warrentyId) {
        this.warrentyId = warrentyId;
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

    public double getItemPriceStock() {
        return itemPriceStock;
    }

    public void setItemPriceStock(double itemPriceStock) {
        this.itemPriceStock = itemPriceStock;
    }

    public int getProfitPercentage() {
        return profitPercentage;
    }

    public void setProfitPercentage(int profitPercentage) {
        this.profitPercentage = profitPercentage;
    }

    public String getItemDtl() {
        return itemDtl;
    }

    public void setItemDtl(String itemDtl) {
        this.itemDtl = itemDtl;
    }
}
