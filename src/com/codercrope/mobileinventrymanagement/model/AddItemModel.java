package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.db.DBConnection;
import com.codercrope.mobileinventrymanagement.to.AddItem;
import com.codercrope.mobileinventrymanagement.to.BatchHasItem;
import com.codercrope.mobileinventrymanagement.to.Item;
import com.codercrope.mobileinventrymanagement.to.Warranty;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class AddItemModel {
    public static boolean save(AddItem item) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean warrantyTable = WarrantyModel.save(item.getWarrantyId(),item.getWarrantTypeId());
            boolean itemTable = ItemModel.save(item.getItemId(),item.getWarrantyId(),item.getItemName(),item.getItemAddedDateTime(),item.getItePriceStock(),item.getProfitPercentage(),item.getItemDtl());
            ArrayList<Boolean> ar = new ArrayList();
            for (Map.Entry<String, String> entry : item.getBatchHasItem().entrySet()) {
                ar.add(BatchHasItemModel.save(entry.getKey(),item.getItemId(),entry.getValue()));
            }
            boolean batchHasItem = true;
            for (boolean b : ar){
                batchHasItem = (batchHasItem & b);
            }
                if (warrantyTable && itemTable && batchHasItem) {
                        DBConnection.getInstance().getConnection().commit();
                        return true;
                }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }
}
