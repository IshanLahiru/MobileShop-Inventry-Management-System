package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.to.Item;
import com.codercrope.mobileinventrymanagement.to.UserEPVal;
import com.codercrope.mobileinventrymanagement.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemModel {
    public static ArrayList<Item> getItems() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM item";
        ResultSet result = CrudUtil.execute(sql);
        ArrayList<Item> items = new ArrayList<>();

        if (result.next()) {
             items.add(new Item(
                     result.getString(1),
                     result.getString(2),
                     result.getString(3),
                     result.getString(4),
                     Double.parseDouble(result.getString(5)),
                     Integer.parseInt(result.getString(6)),
                     result.getString(7)
                     ));
        }
        return items;
    }
}
