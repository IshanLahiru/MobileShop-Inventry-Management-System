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
        System.out.println(result.getFetchSize());

        if (result.next()) {
            warranty = new Warranty(
                    result.getString(1),
                    WarrantyTypeModel.getWarrantyType(result.getString(2))
            );
        }
        return warranty;
    }
}
