package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.to.Batch;
import com.codercrope.mobileinventrymanagement.to.BatchHasItem;
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

    public static ArrayList<BatchHasItem> getBatches(String itemId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT batch_id,item_qty FROM batch_has_item where item_id = ?";
        ResultSet result = CrudUtil.execute(sql,itemId);
        //System.out.println("result set size is = "+result.getFetchSize());
        ArrayList<BatchHasItem> batches = new ArrayList<>();

        while (result.next()) {
            batches.add(new BatchHasItem(BatchModel.getBatch(result.getString(1)),ItemModel.gatItem(itemId),
                    Integer.parseInt(result.getString(2))
            ));
        }
        //System.out.println(items.size());
        return batches;
    }

    public static Boolean update(String key, String itemId, String value) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE batch_has_item SET item_qty = ? WHERE batch_id = ? AND item_id = ? ";
        return CrudUtil.execute(sql,value,key,itemId);
    }

    public static boolean delete(String itemId) throws SQLException, ClassNotFoundException {
        String sql = "Delete FROM batch_has_item where item_id = ?";
        return CrudUtil.execute(sql,itemId);
    }
    public static boolean deleteBatch(String batchId) throws SQLException, ClassNotFoundException {
        String sql = "Delete FROM batch_has_item where batch_id = ?";
        return CrudUtil.execute(sql,batchId);
    }
}
