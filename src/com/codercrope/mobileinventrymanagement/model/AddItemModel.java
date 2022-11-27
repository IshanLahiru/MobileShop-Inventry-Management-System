package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.db.DBConnection;
import com.codercrope.mobileinventrymanagement.to.AddItem;
import com.codercrope.mobileinventrymanagement.to.Item;
import com.codercrope.mobileinventrymanagement.to.Warranty;

import java.sql.SQLException;
import java.time.LocalDate;

public class AddItemModel {
    public static boolean save(AddItem item) throws SQLException, ClassNotFoundException {
        /*try {
                if (true) {
                        DBConnection.getInstance().getConnection().commit();
                        return true;
                }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }*/
        return true;
    }
}
