package com.codercrope.mobileinventrymanagement.to;

public class Employee {
    private String employeeId;
    private String administrativeDtlId;
    private String fullName;
    private String birthday;
    private String address;
    private String pwd;
    private String email;
    private String employeeDtl;

    public Employee(Employee emp){

    }
    public Employee(String employeeId, String administrativeDtlId, String fullName, String birthday, String address, String pwd, String email, String employeeDtl) {
        this.employeeId = employeeId;
        this.administrativeDtlId = administrativeDtlId;
        this.fullName = fullName;
        this.birthday = birthday;
        this.address = address;
        this.pwd = pwd;
        this.email = email;
        this.employeeDtl = employeeDtl;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getAdministrativeDtlId() {
        return this.administrativeDtlId;
    }

    public void setAdministrativeDtlId(String administrativeDtlId) {
        this.administrativeDtlId = administrativeDtlId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeDtl() {
        return employeeDtl;
    }

    public void setEmployeeDtl(String employeeDtl) {
        this.employeeDtl = employeeDtl;
    }
}
