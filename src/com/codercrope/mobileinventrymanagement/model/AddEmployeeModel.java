package com.codercrope.mobileinventrymanagement.model;

import com.codercrope.mobileinventrymanagement.to.Employee;
import com.google.gson.Gson;

import java.util.HashMap;

public class AddEmployeeModel {

    public static String getEmployeeDtlJson(HashMap<String, String> hm) {
        return new Gson().toJson(hm);
    }

    public static boolean update(Employee employee) {
        return true;
    }

    public static boolean delete(Employee employee) {
        return true;
    }

    public static boolean add(Employee employee) {
        return true;
    }
}
