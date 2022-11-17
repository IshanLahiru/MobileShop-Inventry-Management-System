package com.codercrope.mobileinventrymanagement.util.validation;

import com.codercrope.mobileinventrymanagement.model.EmployeeModel;
import com.codercrope.mobileinventrymanagement.to.Employee;
import com.codercrope.mobileinventrymanagement.to.UserEPVal;

import java.sql.SQLException;

public class UserValidation {

    public static boolean initValidation(String email, String pwd) throws SQLException, ClassNotFoundException {
        UserEPVal userEpVal = EmployeeModel.getPwd(email);
        //System.out.println(userEpVal);
        if (userEpVal!=null && userEpVal.getPwd().equals(pwd)){
            return true;
        }
        return false;
    }

    public static Employee getUser(String email, String pwd) throws SQLException, ClassNotFoundException {
        return EmployeeModel.getUser(email, pwd);
    }
}
