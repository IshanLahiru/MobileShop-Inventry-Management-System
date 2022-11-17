package com.codercrope.mobileinventrymanagement.util.user.validation;

import com.codercrope.mobileinventrymanagement.model.EmployeeModel;
import com.codercrope.mobileinventrymanagement.to.Employee;
import com.codercrope.mobileinventrymanagement.to.UserEPVal;
import com.codercrope.mobileinventrymanagement.util.user.User;

import java.sql.SQLException;

public class UserValidation {

    public static boolean initValidation(String email, String pwd) throws SQLException, ClassNotFoundException {
        UserEPVal userEpVal = EmployeeModel.getPwd(email);
        //System.out.println(userEpVal);
        if (userEpVal!=null && userEpVal.getPwd().equals(pwd)){
            //User.initUser();
            return true;
        }
        return false;
    }

    public static Employee getUser(String email, String pwd) throws SQLException, ClassNotFoundException {
        return EmployeeModel.getUser(email, pwd);
    }
}
