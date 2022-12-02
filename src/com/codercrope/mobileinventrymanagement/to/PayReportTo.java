package com.codercrope.mobileinventrymanagement.to;

public class PayReportTo {
    private String id;
    private String name;
    private String qty;
    private String pricePerUnit;
    private String price;

    public PayReportTo(String id, String name, String qty, String pricePerUnit, String price) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.pricePerUnit = pricePerUnit;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(String pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
