package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.to.AddWarrantyType;
import com.codercrope.mobileinventrymanagement.to.Item;
import com.codercrope.mobileinventrymanagement.to.WarrantyType;
import com.codercrope.mobileinventrymanagement.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WarrantyTypeModel {

    public static ArrayList<WarrantyType> getWarrantyTypes() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM warranty_type";
        ResultSet result = CrudUtil.execute(sql);
        //System.out.println(result.getFetchSize());
        ArrayList<WarrantyType> warrantyTypes = new ArrayList<>();

        while (result.next()) {
            warrantyTypes.add(new WarrantyType(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
            ));
        }
        return warrantyTypes;
    }

    public static WarrantyType getWarrantyType(String warrantyTypeId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM warranty_type where warranty_type_id = ?";
        ResultSet result = CrudUtil.execute(sql, warrantyTypeId);
        //System.out.println(result.getFetchSize());
        WarrantyType warrantyType = null;

        if (result.next()) {
            warrantyType = new WarrantyType(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
            );
        }
        return warrantyType;
    }

    public static String getNextWarrantyId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT warranty_type_id FROM warranty_type ORDER BY warranty_type_id DESC LIMIT 1";
        ResultSet result = CrudUtil.execute(sql);
        if (result.next()) {
            return generateNextItemId(result.getString(1));
        }
        return "W00001";
    }

    private static String generateNextItemId(String currentItemId) {
        if (currentItemId != null) {
            String[] split = currentItemId.split("W0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            String str = String.format("%04d", id);
            return "W0" + str;
        }
        return "W00001";
    }

    public static boolean save(AddWarrantyType addWarrantyType) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO warranty_type VALUES(?, ? ,? ,?)";
        return CrudUtil.execute(sql,
                addWarrantyType.getWarrantyTypeId(),
                addWarrantyType.getWarrantyDuration(),
                addWarrantyType.getWarrantyCost(),
                AddWarrantyType.getWarrantyTypeDtlJson(
                        addWarrantyType.getWarrantyTypeDtlHm()
                )
        );

    }

    public static boolean update(AddWarrantyType addWarrantyType) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE warranty_type SET warranty_duration = ? ,warranty_cost = ? ,warranty_type_dtl = ? WHERE warranty_type_id = ? ";
        return CrudUtil.execute(sql,
                addWarrantyType.getWarrantyDuration(),
                addWarrantyType.getWarrantyCost(),
                AddWarrantyType.getWarrantyTypeDtlJson(addWarrantyType.getWarrantyTypeDtlHm()),
                addWarrantyType.getWarrantyTypeId()
        );
    }

    public static boolean delete(String text) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM warranty_type WHERE warranty_type_id = ?";
        return CrudUtil.execute(sql, text);
    }
}
