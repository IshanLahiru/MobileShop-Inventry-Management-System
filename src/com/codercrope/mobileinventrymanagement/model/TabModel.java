package com.codercrope.mobileinventrymanagement.model;

import javafx.scene.control.Tab;

public class TabModel extends Tab {
    private String theTabId;

    public TabModel(String text){
        theTabId = text;

    }

    public String getTheTabId() {
        return theTabId;
    }

    public void setTheTabId(String theTabId) {
        this.theTabId = theTabId;
    }
}
