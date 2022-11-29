package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.to.Item;
import com.codercrope.mobileinventrymanagement.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemModel {
    public static ArrayList<Item> getItems() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM item";
        ResultSet result = CrudUtil.execute(sql);
        //System.out.println("result set size is = "+result.getFetchSize());
        ArrayList<Item> items = new ArrayList<>();

        while (result.next()) {
            items.add(new Item(
                    result.getString(1),
                    WarrantyModel.getWarranty(result.getString(2)),
                    result.getString(3),
                    result.getString(4),
                    Double.parseDouble(result.getString(5)),
                    Integer.parseInt(result.getString(6)),
                    result.getString(7),
                    BatchHasItemModel.getItemCount(result.getString(1))));
        }
        //System.out.println(items.size());
        return items;
    }

    public static ArrayList<String> getItemIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT item_id FROM item";
        ResultSet result = CrudUtil.execute(sql);
        //System.out.println("result set size is = "+result.getFetchSize());
        ArrayList<String> items = new ArrayList<>();

        while (result.next()) {
            items.add(result.getString(1));
        }
        //System.out.println(items.size());
        return items;
    }

    public static ArrayList<Item> getSearchedItems(String text) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM item where item_name like ? or item_id like ?";
        ResultSet result = CrudUtil.execute(sql, text, text);
        ArrayList<Item> items = new ArrayList<>();
        //System.out.println("result set size is = "+result.getFetchSize());
        //System.out.println(User.emp.getAdministrativeDtlId().getAdministrativeStats());

        while (result.next()) {
            items.add(new Item(
                    result.getString(1),
                    WarrantyModel.getWarranty(result.getString(2)),
                    result.getString(3),
                    result.getString(4),
                    Double.parseDouble(result.getString(5)),
                    Integer.parseInt(result.getString(6)),
                    result.getString(7),
                    BatchHasItemModel.getItemCount(result.getString(1))));
        }
        //System.out.println(items.size());
        return items;
    }

    public static String getItemId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT item_id FROM item ORDER BY item_id DESC LIMIT 1";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
            return generateNextItemId(result.getString(1));
        }
        return "I00001";
    }

    private static String generateNextItemId(String currentItemId) {
        if (currentItemId != null) {
            String[] split = currentItemId.split("I0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            String str = String.format("%04d", id);
            return "I0" + str;
        }
        return "I00001";


    }

    public static boolean save(Item item) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO item VALUES(?, ? ,? ,? ,? ,? ,?)";
        return CrudUtil.execute(sql, item.getItemId(),
                item.getWarrentyId().getWarrantyId(),
                item.getItemName(),
                item.getItemAddedDateTime(),
                item.getItemPriceStock(),
                item.getProfitPercentage(),
                item.getItemDtl()
        );
    }

    public static String getProfitPercentage(String itemId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT profit_percentage FROM item where item_id = ? ";
        ResultSet result = CrudUtil.execute(sql, itemId);
        if (result.next()) {
            return result.getString(7);
        }
        return null;
    }

    public static Item gatItem(String itemId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM item where item_id = ? ";
        ResultSet result = CrudUtil.execute(sql, itemId);
        if (result.next()) {
            return new Item(
                    result.getString(1),
                    WarrantyModel.getWarranty(result.getString(2)),
                    result.getString(3),
                    result.getString(4),
                    Double.parseDouble(result.getString(5)),
                    Integer.parseInt(result.getString(6)),
                    result.getString(7),
                    BatchHasItemModel.getItemCount(result.getString(1)));
        }
        return null;
    }

    public static boolean save(String itemId, String warrantyId, String itemName, String itemAddedDateTime, Double itePriceStock, int profitPercentage, String itemDtl) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO item VALUES(?, ? ,? ,? ,? ,? ,?)";
        return CrudUtil.execute(sql,
                itemId,
                warrantyId,
                itemName,
                itemAddedDateTime,
                itePriceStock,
                profitPercentage,
                itemDtl
        );
    }

    public static boolean update(String itemId, String warrantyId, String itemName, String itemAddedDateTime, Double itePriceStock, int profitPercentage, String itemDtl) throws SQLException, ClassNotFoundException {
            String sql = "UPDATE item SET warrenty_id = ? , item_name = ? ,item_added_date_time = ? ,ite_price_stock = ? ,profit_percentage = ? ,itm_dtl = ?  WHERE item_id = ?";
            return CrudUtil.execute(sql,
                    warrantyId,
                    itemName,
                    itemAddedDateTime,
                    itePriceStock,
                    profitPercentage,
                    itemDtl,
                    itemId
            );
    }

    public static boolean delete(String itemId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM item WHERE item_id = ?";
        return CrudUtil.execute(sql,itemId);
    }
}
