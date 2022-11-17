package com.codercrope.mobileinventrymanagement.to;

public class UserEPVal {
    private String Email;
    private String pwd;

    public UserEPVal(String email, String pwd) {
        Email = email;
        this.pwd = pwd;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
