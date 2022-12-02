package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.db.DBConnection;
import com.codercrope.mobileinventrymanagement.to.*;
import com.codercrope.mobileinventrymanagement.util.user.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class AddOrderModel {

    public static boolean save(ArrayList<Item> item, HashMap<Item, Integer> order, String type1, String type, String dateTime, String payment_stats, String s) throws SQLException, ClassNotFoundException {
        try {
            String orderId = CustOrderModel.getNewOrderId();
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean custOrder = CustOrderModel.save(new CustOrder(orderId, "P001", (User.emp.getEmployeeId()), dateTime, "100", "{}"));
            if (custOrder) {
                boolean custOrderHasItem = CustOrderHasItemModel.save(new CustOrderHasItem("","",12,12));
                if (custOrderHasItem) {
                    boolean custOrderHasWarranty = CustOrderHasWarrantyModel.save(new CustOrderHasWarranty(CustOrderHasWarrantyModel.getNextWarranty(), User.emp.getEmployeeId(), "", " "));
                    if (custOrderHasWarranty) {
                        boolean custPayment = CustPaymentModel.save(new CustPayment(CustPaymentModel.getNewCustomerPayment(), String orderId, User.emp.getEmployeeId(), Double.parseDouble(s)));
                        if (custPayment) {
                            DBConnection.getInstance().getConnection().commit();
                            return true;
                        }
                    }
                }
            }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        }
        finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }

}
            ////////////////////////

           /* boolean batchTable = BatchModel.save(batch.getBatchId(), batch.getBatchDtl(), batch.getDateTime(), batch.getDollerRate());
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
        */
