package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.to.Batch;
import com.codercrope.mobileinventrymanagement.util.CrudUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

        while (result.next()) {
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

    public static String getNextBatchId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT batch_id FROM batch ORDER BY batch_id DESC LIMIT 1";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
            return generateNextBatchId(result.getString(1));
        }
        return "B00001";
    }
    private static String generateNextBatchId(String currentItemId) {
        if (currentItemId != null) {
            String[] split = currentItemId.split("B0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            String str = String.format("%04d", id);
            return "B0" + str;
        }
        return "-1";
    }

    public static ObservableList<String> getBatchIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT batch_id FROM batch";
        ResultSet result = CrudUtil.execute(sql);
        //System.out.println("result set size is = "+result.getFetchSize());
        ObservableList<String> data = FXCollections.observableArrayList();
        while (result.next()) {
            data.add(result.getString(1)
            );
        }
        //System.out.println(items.size());
        return data;
    }

    public static boolean save(String batchId, String batchDtl, String dateTime, Double dollarRate) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO batch VALUES(?, ? ,? ,?)";
        return CrudUtil.execute(sql,batchId,batchDtl,dateTime,String.valueOf(dollarRate));
    }

    public static boolean update(String batchId, String batchDtl, String dateTime, double dollerRate) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE batch SET batch_dtl = ? , date_time = ? , doller_rate = ?  WHERE batch_id = ?";
        return CrudUtil.execute(sql,batchDtl,dateTime,String.valueOf(dollerRate),batchId);
    }

    public static boolean delete(String batchId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM batch WHERE batch_id = ?";
        return CrudUtil.execute(sql,batchId);
    }
}
