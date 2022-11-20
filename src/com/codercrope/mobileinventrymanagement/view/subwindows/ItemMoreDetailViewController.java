package com.codercrope.mobileinventrymanagement.view.subwindows;

import com.codercrope.mobileinventrymanagement.to.Item;
import javafx.scene.control.Label;

public class ItemMoreDetailViewController {
    public Label lblItemName;
    private Item ob;

    public void initialize(){
        //this.lblItemName.setText();
    }

    public void getObject(Item ob) {
        this.ob = ob;
        lblItemName.setText(this.ob.getItemName());
    }
}
