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
}
