package com.codercrope.mobileinventrymanagement.view.listview;

import com.codercrope.mobileinventrymanagement.model.BatchHasItemModel;
import com.codercrope.mobileinventrymanagement.model.BatchModel;
import com.codercrope.mobileinventrymanagement.to.Batch;
import com.codercrope.mobileinventrymanagement.to.BatchHasItem;
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
    public void addData(BatchHasItem it){
        this.lblBatchId.setText(it.getBatchId().getBatchId());
        this.txtNoOfItems.setText(String.valueOf(it.getItemqty()));
    }

    public String getNoOfItems() {
        if (this.txtNoOfItems == null) {
            return "0";
        }
        return this.txtNoOfItems.getText();


    }
    public String getBatchId(){
        return lblBatchId.getText();
    }
    public String getItem(){
        return this.item;
    }
}
