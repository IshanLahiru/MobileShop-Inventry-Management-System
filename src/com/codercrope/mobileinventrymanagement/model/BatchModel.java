package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.to.Batch;
import com.codercrope.mobileinventrymanagement.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BatchModel {
    public static ArrayList<Batch> getBatches() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM batch";
        ResultSet result = CrudUtil.execute(sql);
        //System.out.println("result set size is = "+result.getFetchSize());
        ArrayList<Batch> batches = new ArrayList<>();

        while (result.next()) {
            batches.add(new Batch(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    Double.parseDouble(result.getString(4))
            ));
        }
        //System.out.println(items.size());
        return batches;
    }

    public static Batch getBatch(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM batch Where batch_id = ?";
        ResultSet result = CrudUtil.execute(sql,id);
        //System.out.println("result set size is = "+result.getFetchSize());
        ArrayList<Batch> batches = new ArrayList<>();

        if (result.next()) {
            return new Batch(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    Double.parseDouble(result.getString(4))
            );
        }
        //System.out.println(items.size());
        return null;
    }
}
