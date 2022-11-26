package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.db.DBConnection;
import com.codercrope.mobileinventrymanagement.to.Item;
import com.codercrope.mobileinventrymanagement.to.Warranty;

import java.sql.SQLException;
import java.time.LocalDate;

public class AddItemModel {
    public static boolean addItem(Item item, Warranty warranty) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean warr = WarrantyModel.save(warranty);
            if (warr) {
                boolean isItemAdded = ItemModel.save(item);
                if (isItemAdded) {
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
}
