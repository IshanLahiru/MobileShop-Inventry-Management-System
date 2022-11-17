package com.codercrope.mobileinventrymanagement.util;

import com.codercrope.mobileinventrymanagement.db.DBConnection;
import com.codercrope.mobileinventrymanagement.to.Employee;

public class User {

    private static Employee user;

    private User(Employee emp){
        user=emp;
    }
    public static Employee initUser(Employee emp){
        return (null == user) ? user = new Employee(emp) : user;
    }
    public static void logout(){user=null;}

}
