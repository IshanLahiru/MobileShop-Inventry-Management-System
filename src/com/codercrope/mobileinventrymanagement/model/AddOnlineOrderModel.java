package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.db.DBConnection;
import com.codercrope.mobileinventrymanagement.to.OnlineOrder;
import com.codercrope.mobileinventrymanagement.to.OnlineOrderStr;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class AddOnlineOrderModel {
    public static boolean save(OnlineOrderStr onlineOrder) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            //System.out.println(onlineOrder.getPaymentId());
            boolean paymentTable = PaymentModel.save(
                    onlineOrder.getPaymentId(),
                    onlineOrder.getEmployeeId().getEmployeeId(),
                    String.valueOf(onlineOrder.getPaymentAmount()),
                    onlineOrder.getDateTime()
            );
            if (paymentTable) {
                //System.out.println("paymentTableUpdateConfermation : "+ paymentTable);
                DBConnection.getInstance().getConnection().commit();
                //DBConnection.getInstance().getConnection().setAutoCommit(true);
                //DBConnection.getInstance().getConnection().setAutoCommit(false);
                boolean OnlineOrderTable = OnlineOrderModel.save(
                        onlineOrder.getOrderId(),
                        onlineOrder.getBatchId(),
                        onlineOrder.getPaymentId(),
                        onlineOrder.getEmployeeId().getEmployeeId(),
                        onlineOrder.getDateTime(),
                        onlineOrder.getOnlineOrdersLinks()
                );
                if (OnlineOrderTable) {
                    DBConnection.getInstance().getConnection().commit();
                    return true;
                }
            }
            DBConnection.getInstance().getConnection().rollback();
            PaymentModel.remove(onlineOrder.getPaymentId());
            return false;
        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }

    public static boolean update(OnlineOrderStr onlineOrder) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            //System.out.println(onlineOrder.getPaymentId());
            boolean paymentTable = PaymentModel.update(
                    onlineOrder.getPaymentId(),
                    onlineOrder.getEmployeeId().getEmployeeId(),
                    String.valueOf(onlineOrder.getPaymentAmount()),
                    onlineOrder.getDateTime()
            );
            System.out.println("the payment id that have issue is " + onlineOrder.getPaymentId());
            System.out.println("paymentTableUpdateConfermation : "+ paymentTable);
            if (paymentTable) {
                System.out.println("paymentTableUpdateConfermation : "+ paymentTable);
                DBConnection.getInstance().getConnection().commit();
                //DBConnection.getInstance().getConnection().setAutoCommit(true);
                //DBConnection.getInstance().getConnection().setAutoCommit(false);
                boolean OnlineOrderTable = OnlineOrderModel.update(
                        onlineOrder.getOrderId(),
                        onlineOrder.getBatchId(),
                        onlineOrder.getPaymentId(),
                        onlineOrder.getEmployeeId().getEmployeeId(),
                        onlineOrder.getDateTime(),
                        onlineOrder.getOnlineOrdersLinks()
                );
                if (OnlineOrderTable) {
                    DBConnection.getInstance().getConnection().commit();
                    return true;
                }
            }
            DBConnection.getInstance().getConnection().rollback();
            PaymentModel.remove(onlineOrder.getPaymentId());
            return false;
        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }

    public static boolean remove(OnlineOrderStr onlineOrder) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean OnlineOrderTable = OnlineOrderModel.delete(
                    onlineOrder.getOrderId(),
                    onlineOrder.getBatchId(),
                    onlineOrder.getPaymentId(),
                    onlineOrder.getEmployeeId().getEmployeeId(),
                    onlineOrder.getDateTime(),
                    onlineOrder.getOnlineOrdersLinks()
            );
            if (OnlineOrderTable) {
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