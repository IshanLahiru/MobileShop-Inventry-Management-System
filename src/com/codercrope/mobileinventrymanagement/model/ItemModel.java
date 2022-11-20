package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.to.Item;
import com.codercrope.mobileinventrymanagement.to.UserEPVal;
import com.codercrope.mobileinventrymanagement.util.CrudUtil;
import com.codercrope.mobileinventrymanagement.util.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemModel {
    public static ArrayList<Item> getItems() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM item";
        ResultSet result = CrudUtil.execute(sql);
        System.out.println("result set size is = "+result.getFetchSize());
        ArrayList<Item> items = new ArrayList<>();

        if (result.next()) {
             items.add(new Item(
                     result.getString(1),
                     WarrantyModel.getWarranty(result.getString(2)),
                     result.getString(3),
                     result.getString(4),
                     Double.parseDouble(result.getString(5)),
                     Integer.parseInt(result.getString(6)),
                     result.getString(7)
             ));
        }
        System.out.println(items.size());
        return items;
    }

    public static ArrayList<Item> getSearchedItems(String text) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM item where item_name like ? or item_id like ?";
        ResultSet result = CrudUtil.execute(sql,text,text);
        ArrayList<Item> items = new ArrayList<>();
        System.out.println("result set size is = "+result.getFetchSize());
        System.out.println(User.emp.getAdministrativeDtlId().getAdministrativeStats());

        if (result.next()) {
            items.add(new Item(
                    result.getString(1),
                    WarrantyModel.getWarranty(result.getString(2)),
                    result.getString(3),
                    result.getString(4),
                    Double.parseDouble(result.getString(5)),
                    Integer.parseInt(result.getString(6)),
                    result.getString(7)
            ));
        }
        System.out.println(items.size());
        return items;
    }
}
