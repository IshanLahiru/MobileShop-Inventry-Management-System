package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.to.Item;
import com.codercrope.mobileinventrymanagement.to.OnlineOrder;
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
}
