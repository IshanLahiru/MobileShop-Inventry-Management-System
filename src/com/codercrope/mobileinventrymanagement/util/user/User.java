package com.codercrope.mobileinventrymanagement.util.user;

import com.codercrope.mobileinventrymanagement.to.Employee;

public class User {
    public static String user="admin";

    public static void initUser(Employee usr) {
        String u = usr.getAdministrativeDtlId();
        switch (u){
            case"D001":
                user = "admin";
                break;
            case"D002":
                user = "worker";
                break;
            case "D003":
                user = "technician";
                break;
        }
    }
}
