package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.to.AdministrativeDtl;
import com.codercrope.mobileinventrymanagement.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministrativeDtlModel {
    /*public static AdministrativeDtl getUser(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM employee WHERE administrative_dtl_id = ? ";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {
            return new AdministrativeDtl(
                    result.getString(1),
                    result.getString(2)
            );
        }
        return null;
    }*/

    public static AdministrativeDtl getModel(String string) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM administrative_dtl WHERE administrative_dtl_id = ? ";
        ResultSet result = CrudUtil.execute(sql, string);
        AdministrativeDtl admin = null;

        while (result.next()) {
            admin = new AdministrativeDtl(
                    result.getString(1),
                    result.getString(2)
            );
        }
        return admin;
    }
}
