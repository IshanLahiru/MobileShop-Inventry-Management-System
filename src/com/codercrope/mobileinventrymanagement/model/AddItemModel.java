package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.db.DBConnection;
import com.codercrope.mobileinventrymanagement.to.AddItem;
import com.codercrope.mobileinventrymanagement.to.BatchHasItem;
import com.codercrope.mobileinventrymanagement.to.Item;
import com.codercrope.mobileinventrymanagement.to.Warranty;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
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
                if (warrantyTable & itemTable & batchHasItem) {
                        DBConnection.getInstance().getConnection().commit();
                        return true;
                }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }

    public static boolean Update(AddItem item) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean warrantyTable = WarrantyModel.update(item.getWarrantyId(),item.getWarrantTypeId());
            boolean itemTable = ItemModel.update(item.getItemId(),item.getWarrantyId(),item.getItemName(),item.getItemAddedDateTime(),item.getItePriceStock(),item.getProfitPercentage(),item.getItemDtl());
            ArrayList<Boolean> ar = new ArrayList();
            for (Map.Entry<String, String> entry : item.getBatchHasItem().entrySet()) {
                ar.add(BatchHasItemModel.update(entry.getKey(),item.getItemId(),entry.getValue()));
            }
            boolean batchHasItem = true;
            for (boolean b : ar){
                batchHasItem = (batchHasItem & b);
            }
            if (warrantyTable & itemTable & batchHasItem) {
                DBConnection.getInstance().getConnection().commit();
                return true;
            }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }

    }

    public static String getItemDtlJson (HashMap<String, String> hm) {
        return new Gson().toJson(hm);
    }

    public static boolean delete(AddItem item) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean batchHasItem = BatchHasItemModel.delete(item.getItemId());
            boolean itemTable = ItemModel.delete(item.getItemId());
            boolean warrantyTable = WarrantyModel.delete(item.getWarrantyId());
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
