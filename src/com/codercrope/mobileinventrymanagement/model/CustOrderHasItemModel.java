package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.to.CustOrder;
import com.codercrope.mobileinventrymanagement.to.CustOrderHasItem;
import com.codercrope.mobileinventrymanagement.to.Item;
import com.codercrope.mobileinventrymanagement.util.CrudUtil;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CustOrderHasItemModel {
    public static boolean save(String orderId, HashMap<Item, Integer> order) throws SQLException, ClassNotFoundException {
        boolean c = true;
        boolean b = true;
        for (Map.Entry<Item,Integer> entry : order.entrySet()) {
            String sql = "INSERT INTO cust_order_has_item VALUES(?,?,?,?)";
            b = CrudUtil.execute(sql,orderId,
                    entry.getKey().getItemId(),
                    entry.getValue(),
                    (PriceModel.getItemPrice(entry.getKey().getItemId(),entry.getKey().getItemPriceStock(),entry.getKey().getProfitPercentage())));
            c = c & b;
            //paymentAmount+= PriceModel.getItemPrice(entry.getKey().getItemId(),entry.getKey().getItemPriceStock(),entry.getKey().getProfitPercentage())*(entry.getValue());
        }
        return c;
    }
}
