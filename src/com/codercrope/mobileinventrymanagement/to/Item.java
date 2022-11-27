package com.codercrope.mobileinventrymanagement.to;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

public class Item {
    private String itemId;
    private Warranty warrentyId;
    private String itemName;
    private String itemAddedDateTime;
    private double itemPriceStock;
    private int profitPercentage;
    private String itemDtl;
    private int stock;


    public Item(String itemId, Warranty warrentyId,
                String itemName, String itemAddedDateTime,
                double itemPriceStock, int profitPercentage, String itemDtl, int stock) {
        this.itemId = itemId;
        this.warrentyId = warrentyId;
        this.itemName = itemName;
        this.itemAddedDateTime = itemAddedDateTime;
        this.itemPriceStock = itemPriceStock;
        this.profitPercentage = profitPercentage;
        this.itemDtl = itemDtl;
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Warranty getWarrentyId() {
        return warrentyId;
    }

    public void setWarrentyId(Warranty warrentyId) {
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

    public HashMap<String, String> getItemDtlHM() {
        HashMap<String, String> mapObj = new Gson().fromJson(
                itemDtl, new TypeToken<HashMap<String, String>>() {}.getType()
        );
        return mapObj;
        /*Map<String, Object> userData = new Gson().fromJson(itemDtl, new TypeToken<HashMap<String, Object>>() {
        }.getType());
        // print all key-value pairs
        System.out.println("key : " + userData.get("Name"));
        System.out.println("Mobile : " + userData.get("Mobile"));
        System.out.println("Designation : " + userData.get("Designation"));
        System.out.println("Pet : " + userData.get("Pet"));
        System.out.println("Address : " + userData.get("Address"));*/
    }

}
