package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.db.DBConnection;
import com.codercrope.mobileinventrymanagement.to.Batch;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class AddBatchModel {
    public static boolean save(Batch batch) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean batchTable = BatchModel.save(batch.getBatchId(), batch.getBatchDtl(), batch.getDateTime(), batch.getDollerRate());
            if (batchTable) {
                ArrayList<String> itemIds = ItemModel.getItemIds();
                boolean c = true;
                for (String s : itemIds) {
                    c = (c & (BatchHasItemModel.save(batch.getBatchId(), s, "0")));
                }
                if (c) {
                    DBConnection.getInstance().getConnection().commit();
                    return true;
                }
            }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }

    public static boolean remove(Batch batch) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean batchHasItem = BatchHasItemModel.deleteBatch(batch.getBatchId());
            if (batchHasItem) {
                boolean batchTable = BatchModel.delete(batch.getBatchId());
                if (batchTable) {
                    DBConnection.getInstance().getConnection().commit();
                    return true;
                }
            }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }

    public static boolean update(Batch batch) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean batchTable = BatchModel.update(batch.getBatchId(), batch.getBatchDtl(), batch.getDateTime(), batch.getDollerRate());
            if (batchTable) {
                DBConnection.getInstance().getConnection().commit();
                return true;
            }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }
}
