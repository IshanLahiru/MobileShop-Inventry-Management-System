package com.codercrope.mobileinventrymanagement.to;

public class BatchHasItem {
    private Batch batchId;
    private Item itemId;
    private int itemqty;

    public BatchHasItem(Batch batchId, Item itemId, int itemqty) {
        this.batchId = batchId;
        this.itemId = itemId;
        this.itemqty = itemqty;
    }

    public Batch getBatchId() {
        return batchId;
    }

    public void setBatchId(Batch batchId) {
        this.batchId = batchId;
    }

    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }

    public int getItemqty() {
        return itemqty;
    }

    public void setItemqty(int itemqty) {
        this.itemqty = itemqty;
    }
}
