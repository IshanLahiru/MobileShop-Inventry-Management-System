package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.to.Payment;
import com.codercrope.mobileinventrymanagement.util.CrudUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentModel
{
    public static String getPaymentAmount(String paymentId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT payment_amount FROM payment WHERE payment_id = ?";
        ResultSet result = CrudUtil.execute(sql, paymentId);
        while(result.next()) {
            return result.getString(1);
        }
        return "";
    }

    public static Payment getPayment(String paymentId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM payment WHERE payment_id = ?";
        ResultSet result = CrudUtil.execute(sql, paymentId);
        while(result.next()) {
             return new Payment(result.getString(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4)
             );
        }
        return null;
    }
    public static String getNextPaymentId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT payment_id FROM payment ORDER BY payment_id DESC LIMIT 1";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
            return generateNextItemId(result.getString(1));
        }
        return "I00001";
    }

    private static String generateNextItemId(String currentItemId) {
        if (currentItemId != null) {
            String[] split = currentItemId.split("P0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            String str = String.format("%04d", id);
            return "P0" + str;
        }
        return "P00001";


    }

    public static boolean save(String paymentId, String employeeId, String paymentAmount, String dateTime) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO payment VALUES(?, ? ,? ,?)";
        return CrudUtil.execute(sql,paymentId,employeeId,paymentAmount,dateTime);
    }

    public static boolean remove(String paymentId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM payment WHERE payment_id = ?";
        return CrudUtil.execute(sql,paymentId);
    }

    public static boolean update(String paymentId, String employeeId, String valueOf, String dateTime) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE payment SET employee_id = ?, payment_amount = ?, payment_date_time = ? WHERE payment_id = ? ";
        return CrudUtil.execute(sql,employeeId,valueOf,dateTime,paymentId);
    }
}
