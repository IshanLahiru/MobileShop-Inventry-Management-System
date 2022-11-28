package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.util.CrudUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentModel
{
    public static String getPaymentAmount(String paymentId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT payment_amount FROM payment WHERE payment_id = ?";
        ResultSet result = CrudUtil.execute(sql);
        while (result.next()) {
            return result.getString(1);
        }
        return "";
    }
}
