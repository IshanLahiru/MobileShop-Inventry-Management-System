package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.to.AdministrativeDtl;
import com.codercrope.mobileinventrymanagement.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

        while (result.next()) {
            return new AdministrativeDtl(
                    result.getString(1),
                    result.getString(2)
            );
        }
        return null;
    }

    public static ArrayList<String> getAdministrativeDtlSts() throws SQLException, ClassNotFoundException {
        String sql = "SELECT administrative_stats FROM administrative_dtl";
        ResultSet result = CrudUtil.execute(sql);
        ArrayList<String> ar = new ArrayList<>();

        while (result.next()) {
             ar.add(result.getString(1)
             );
        }
        return ar;
    }

    public static AdministrativeDtl getAdministrativeDtlId(String text) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM administrative_dtl WHERE administrative_stats = ?";
        ResultSet result = CrudUtil.execute(sql,text);
        if (result.next()) {
            return new AdministrativeDtl(
                    result.getString(1),
                    result.getString(2)
            );
        }
        return null;
    }
}
