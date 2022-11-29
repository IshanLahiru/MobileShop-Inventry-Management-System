package com.codercrope.mobileinventrymanagement.controler.tmlist;

import com.codercrope.mobileinventrymanagement.to.AdministrativeDtl;
import com.codercrope.mobileinventrymanagement.to.Employee;
import javafx.scene.control.Button;

public class EmployeeTM {
    private Employee ob;
    private String employeeId;
    private String administrativeSts;
    private String fullName;
    private String email;
    private Button Dtl;

    public EmployeeTM(Employee ob, String employeeId, String administrativeSts, String fullName, String email, Button dtl) {
        this.ob = ob;
        this.employeeId = employeeId;
        this.administrativeSts = administrativeSts;
        this.fullName = fullName;
        this.email = email;
        Dtl = dtl;
    }

    public Employee getOb() {
        return ob;
    }

    public void setOb(Employee ob) {
        this.ob = ob;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getAdministrativeSts() {
        return administrativeSts;
    }

    public void setAdministrativeSts(String administrativeSts) {
        this.administrativeSts = administrativeSts;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Button getDtl() {
        return Dtl;
    }

    public void setDtl(Button dtl) {
        Dtl = dtl;
    }
}
