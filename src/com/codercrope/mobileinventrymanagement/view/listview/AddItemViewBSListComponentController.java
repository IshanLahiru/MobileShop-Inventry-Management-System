package com.codercrope.mobileinventrymanagement.view.listview;

import com.codercrope.mobileinventrymanagement.to.Batch;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddItemViewBSListComponentController {
    public Label lblBatchId;
    public TextField txtNoOfItems;
    public Batch batch;
    public String item;

    public void add(Batch batch,String item) {
        this.batch = batch;
        lblBatchId.setText(batch.getBatchId());
    }

    public String getNoOfItems() {
        if (this.txtNoOfItems.equals(""))return "0";
        return this.txtNoOfItems.getText();
    }
    public String getBatchId(){
        return lblBatchId.getText();
    }
    public String getItem(){
        return this.item;
    }
}
