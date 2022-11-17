package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.to.Employee;
import com.codercrope.mobileinventrymanagement.to.UserEPVal;
import com.codercrope.mobileinventrymanagement.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class EmployeeModel {

    public static UserEPVal checkUnamePwd(String email) throws SQLException, ClassNotFoundException {
        String sql = "SELECT email,pwd FROM employee WHERE email = ?";
        ResultSet result = CrudUtil.execute(sql, email);

        if (result.next()) {
            System.out.println(result.getString(1));
            System.out.println(result.getString(2));
            return new UserEPVal(
                    result.getString(1),
                    result.getString(2)
            );
        }
        return null;
    }



    public static UserEPVal getPwd(String email) throws SQLException, ClassNotFoundException {
        String sql = "SELECT email,pwd FROM employee WHERE email = ?";
        ResultSet result = CrudUtil.execute(sql, email);

        if (result.next()) {
            //System.out.println(result.getString(1));
           // System.out.println(result.getString(2));
            return new UserEPVal(
                    result.getString(1),
                    result.getString(2)
            );
        }
        return null;
    }

    public static Employee getUser(String email, String pwd) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM employee WHERE email = ? AND pwd = ?";
        ResultSet result = CrudUtil.execute(sql, email , pwd);

        if (result.next()) {
            return new Employee(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getString(7),
                    result.getString(8)
            );
        }
        return null;
    }
}
