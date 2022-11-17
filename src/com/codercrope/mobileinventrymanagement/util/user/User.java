package com.codercrope.mobileinventrymanagement.util.user;

import com.codercrope.mobileinventrymanagement.to.Employee;

public class User {
    private static Employee user;

    User(Employee user){
        this.user = user;
    }

    public static void initUser() {
    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }
    public Employee initUser(Employee user){
        if (this.user==null){
            setUser(user);
        }
        return this.user;
    }
}
