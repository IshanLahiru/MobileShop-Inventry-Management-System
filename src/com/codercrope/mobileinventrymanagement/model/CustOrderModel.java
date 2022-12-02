package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.to.CustOrder;
import com.codercrope.mobileinventrymanagement.to.CustPaymentType;
import com.codercrope.mobileinventrymanagement.to.Item;
import com.codercrope.mobileinventrymanagement.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustOrderModel {
    public static ArrayList<CustOrder> getItems() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM cust_order";
        ResultSet result = CrudUtil.execute(sql);
        // System.out.println("result set size is = "+result.getFetchSize());
        ArrayList<CustOrder> orders = new ArrayList<>();

        while (result.next()) {
            orders.add(new CustOrder(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6)
            ));
        }
        //System.out.println(orders.size());
        return orders;
    }

    public static String getNewOrderId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT order_id FROM cust_order ORDER BY order_id DESC LIMIT 1";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
            return generateNextItemId(result.getString(1));
        }
        return "CO0001";
    }

    private static String generateNextItemId(String currentItemId) {
        if (currentItemId != null) {
            String[] split = currentItemId.split("CO0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            String str = String.format("%03d", id);
            return "CO0" + str;
        }
        return "CO0001";
    }

    public static boolean save(CustOrder p001){
        return true;
    }
}
