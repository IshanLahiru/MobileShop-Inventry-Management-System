package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.to.Item;
import com.codercrope.mobileinventrymanagement.to.Warranty;
import com.codercrope.mobileinventrymanagement.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WarrantyModel {
    public static Warranty getWarranty(String warrantyId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM warranty where warranty_id = ?";
        ResultSet result = CrudUtil.execute(sql , warrantyId);
        Warranty warranty = null;
        //System.out.println(result.getFetchSize());

        if (result.next()) {
            warranty = new Warranty(
                    result.getString(1),
                    WarrantyTypeModel.getWarrantyType(result.getString(2))
            );
        }
        return warranty;
    }

    public static String getWarrantyId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT warranty_id FROM warranty ORDER BY warranty_id DESC LIMIT 1";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
            return generateNextItemId(result.getString(1));
        }
        return generateNextItemId(result.getString(null));
    }
    private static String generateNextItemId(String currentItemId) {
        if (currentItemId != null) {
            String[] split = currentItemId.split("WI0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            String str = String.format("%04d", id);
            return "WI0" + str;
        }
        return "-1";


    }

    public static boolean save(Warranty warranty) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO warranty VALUES(?, ?)";
        return CrudUtil.execute(sql, warranty.getWarrantyId(),warranty.getWarrantyTypeId());
    }

    public static boolean save(String warrantyId, String warrantTypeId) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO warranty VALUES(?, ?)";
        return CrudUtil.execute(sql, warrantyId, warrantTypeId);
    }

    public static boolean update(String warrantyId, String warrantTypeId) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE warranty SET warranty_type_id = ? WHERE warranty_id = ?";
        return CrudUtil.execute(sql, warrantTypeId ,warrantyId );
    }
}
