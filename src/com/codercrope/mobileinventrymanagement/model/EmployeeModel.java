package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.to.AdministrativeDtl;
import com.codercrope.mobileinventrymanagement.to.Employee;
import com.codercrope.mobileinventrymanagement.to.Payment;
import com.codercrope.mobileinventrymanagement.to.UserEPVal;
import com.codercrope.mobileinventrymanagement.util.CrudUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Objects;

public class EmployeeModel {

    public static UserEPVal checkUnamePwd(String email) throws SQLException, ClassNotFoundException {
        String sql = "SELECT email,pwd FROM employee WHERE email = ?";
        ResultSet result = CrudUtil.execute(sql, email);

        if (result.next()) {
            //System.out.println(result.getString(1));
            //System.out.println(result.getString(2));
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
        ResultSet result = CrudUtil.execute(sql, email, pwd);
        Employee admin = null;
        if (result.next()) {
            //System.out.println(result.getString(2));
            admin = new Employee(
                    result.getString(1),
                    new AdministrativeDtl(AdministrativeDtlModel.getModel(result.getString(2))),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getString(7),
                    result.getString(8)
            );
        }
        return admin;
    }

    public static ObservableList<String> getEmployeeIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT employee_id FROM employee";
        ResultSet result = CrudUtil.execute(sql);
        //System.out.println("result set size is = "+result.getFetchSize());
        ObservableList<String> data = FXCollections.observableArrayList();
        while (result.next()) {
            data.add(result.getString(1)
            );
        }
        //System.out.println(items.size());
        return data;

    }

    public static Employee getEmployee(String employeeId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM employee WHERE employee_id = ?";
        ResultSet result = CrudUtil.execute(sql, employeeId);
        while(result.next()) {
            return new Employee(
                    result.getString(1),
                    AdministrativeDtlModel.getModel(result.getString(2)),
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

    public static ArrayList<Employee> getEmployees() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM employee";
        ResultSet result = CrudUtil.execute(sql);
        ArrayList<Employee> users = new ArrayList();
        while (result.next()){
            //System.out.println(result.getString(2));
            users.add(new Employee(
                    result.getString(1),
                    new AdministrativeDtl(AdministrativeDtlModel.getModel(result.getString(2))),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getString(7),
                    result.getString(8)
            ));
        }

        return users;
    }

    public static String getNextEmployeeID() throws SQLException, ClassNotFoundException {
        String sql = "SELECT employee_id FROM employee ORDER BY employee_id DESC LIMIT 1";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
            return generateNextItemId(result.getString(1));
        }
        return "E0001";
    }

    private static String generateNextItemId(String currentItemId) {
        if (currentItemId != null) {
            String[] split = currentItemId.split("E0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            String str = String.format("%03d", id);
            return "E0" + str;
        }
        return "E0001";
    }
}
