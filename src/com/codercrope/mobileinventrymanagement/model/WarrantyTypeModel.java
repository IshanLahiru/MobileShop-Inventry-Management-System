package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.to.Item;
import com.codercrope.mobileinventrymanagement.to.WarrantyType;
import com.codercrope.mobileinventrymanagement.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WarrantyTypeModel {

    public static WarrantyType getWarrantyType(String warrantyTypeId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM warranty where warranty_id = ?";
        ResultSet result = CrudUtil.execute(sql,warrantyTypeId);
        System.out.println(result.getFetchSize());
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
}
