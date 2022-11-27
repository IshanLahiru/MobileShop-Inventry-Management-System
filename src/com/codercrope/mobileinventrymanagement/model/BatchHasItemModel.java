package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.to.Item;
import com.codercrope.mobileinventrymanagement.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BatchHasItemModel {
    public static int getItemCount(String itemId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT SUM(item_qty) FROM batch_has_item WHERE item_id = ? ";
        ResultSet result = CrudUtil.execute(sql,itemId);
        if (result.next()) {
            return Integer.parseInt(result.getString(1));
        }
        //System.out.println(items.size());
        return -1;
    }

    public static boolean save(String batchId, String itemId, String itemQty) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO batch_has_item VALUES(?, ? ,?)";
        return CrudUtil.execute(sql,batchId,itemId,itemQty);

    }
}
