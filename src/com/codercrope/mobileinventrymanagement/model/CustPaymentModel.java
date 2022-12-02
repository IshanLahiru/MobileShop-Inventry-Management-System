package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.to.CustPayment;
import com.codercrope.mobileinventrymanagement.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustPaymentModel {
    public static boolean save(CustPayment custPayment) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO cust_payment VALUES(? ,? ,? ,?)";
        return CrudUtil.execute(sql,
                custPayment.getCustPaymentId(),
                custPayment.getOrderId(),
                custPayment.getEmployeeId(),
                custPayment.getPayment()
        );
    }

    public static String getNextPaymentId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT payment_id FROM payment ORDER BY payment_id DESC LIMIT 1";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
            return generateNextItemId(result.getString(1));
        }
        return "P0001";
    }
    private static String generateNextItemId(String currentItemId) {
        if (currentItemId != null) {
            String[] split = currentItemId.split("P0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            String str = String.format("%04d", id);
            return "P0" + str;
        }
        return "-1";


    }
}
