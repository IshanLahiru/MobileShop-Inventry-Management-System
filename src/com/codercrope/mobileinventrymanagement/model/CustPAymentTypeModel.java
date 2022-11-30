package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.to.AdministrativeDtl;
import com.codercrope.mobileinventrymanagement.to.CustPaymentType;
import com.codercrope.mobileinventrymanagement.to.Employee;
import com.codercrope.mobileinventrymanagement.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustPAymentTypeModel {
    public static Object getPaymentType(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM cust_payment_type WHERE  cust_payment_type_id = ?";
        ResultSet result = CrudUtil.execute(sql, id);
        CustPaymentType type = null;
        if (result.next()) {
            System.out.println(result.getString(2));
            type = new CustPaymentType(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
            );
        }
        return type;
    }

    public static String getType() {
        return "P001";
    }
}
