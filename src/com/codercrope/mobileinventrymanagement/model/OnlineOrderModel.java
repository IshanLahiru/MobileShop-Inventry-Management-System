package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.to.Item;
import com.codercrope.mobileinventrymanagement.to.OnlineOrder;
import com.codercrope.mobileinventrymanagement.to.Payment;
import com.codercrope.mobileinventrymanagement.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OnlineOrderModel {
    public static ArrayList<OnlineOrder> getOnlineOrders() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM online_orders";
        ResultSet result = CrudUtil.execute(sql);
        //System.out.println("result set size is = "+result.getFetchSize());
        ArrayList<OnlineOrder> orders = new ArrayList<>();

        while (result.next()) {
            orders.add(new OnlineOrder(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6)
            ));


        }
        //System.out.println(items.size());
        return orders;
    }

    public static String getNextOnlineOrderId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT order_id FROM online_orders ORDER BY order_id DESC LIMIT 1";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
            return generateNextBatchId(result.getString(1));
        }
        return "OO00001";
    }
    private static String generateNextBatchId(String currentItemId) {
        if (currentItemId != null) {
            String[] split = currentItemId.split("OO0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            String str = String.format("%04d", id);
            return "OO0" + str;
        }
        return "-1";
    }

    public static Object getOnlineOrder(String text) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM payment WHERE payment_id = ?";
        ResultSet result = CrudUtil.execute(sql, text);
        while(result.next()) {
            return new Payment(result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
            );
        }
        return null;
    }

    public static boolean save(String orderId, String batchId, String paymentId, String employeeId, String dateTime, String onlineOrdersLinks) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO online_orders VALUES(?, ? ,? ,? ,? ,?)";
        return CrudUtil.execute(sql,orderId,batchId,paymentId,employeeId,dateTime,onlineOrdersLinks);
    }

    public static boolean update(String orderId, String batchId, String paymentId, String employeeId, String dateTime, String onlineOrdersLinks) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE online_orders SET batch_id = ? , payment_id = ? , employee_id = ? , date_time = ? , online_orders_links = ?  WHERE order_id = ? ";
        return CrudUtil.execute(sql,batchId,paymentId,employeeId,dateTime,onlineOrdersLinks,orderId);
    }

    public static boolean delete(String orderId, String batchId, String paymentId, String employeeId, String dateTime, String onlineOrdersLinks) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM online_orders WHERE order_id = ? ";
        return CrudUtil.execute(sql,orderId);
    }
}
