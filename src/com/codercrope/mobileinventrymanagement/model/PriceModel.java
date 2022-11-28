package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.to.BatchHasItem;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.sql.SQLException;
import java.util.ArrayList;

public class PriceModel {

    public static double getItemPrice(String itemId, double itemPriceStock, int profitPercentage) throws SQLException, ClassNotFoundException {
        ArrayList<BatchHasItem> batches = BatchHasItemModel.getBatches(itemId);
        double averageDollerPrice = 0;
        double total = 0;
        if (batches.size() != 0){
            for (BatchHasItem b : batches){
                averageDollerPrice += b.getBatchId().getDollerRate();
            }
            averageDollerPrice = (averageDollerPrice/batches.size());
        }
        System.out.println(averageDollerPrice);
        total = (itemPriceStock*averageDollerPrice*((100+profitPercentage)/100));
        System.out.println("the total is = " + total);
        double v = Double.parseDouble(String.format("%.2f", total));
        return v;
    }
}
