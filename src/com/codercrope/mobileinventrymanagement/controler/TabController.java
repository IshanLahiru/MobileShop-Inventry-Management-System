package com.codercrope.mobileinventrymanagement.controler;

import com.codercrope.mobileinventrymanagement.model.TabModel;
import javafx.scene.control.Tab;

import java.util.ArrayList;

public class TabController {
    public static ArrayList<TabModel> tabs = new ArrayList();

    public static TabModel addTab(TabModel tab) {
        TabModel tb = null;
        for( TabModel model : tabs ) {
            if(tab.equals(model.getTheTabId())) {
                tb = model;
            }
            tabs.add(tab);
            tb = tab;
        }
        return tb;
    }
    public TabModel returnTab(TabModel tab){
        return tab;
    }
}
