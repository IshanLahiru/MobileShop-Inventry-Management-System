package com.codercrope.mobileinventrymanagement.to;

import java.util.HashMap;

public class CustPaymentType {
    private String custPaymentTypeId;
    private String paymentType;
    private String descreption;
    private String custPaymentDtl;

    public CustPaymentType(String custPaymentTypeId, String paymentType, String descreption, String custPaymentDtl) {
        this.custPaymentTypeId = custPaymentTypeId;
        this.paymentType = paymentType;
        this.descreption = descreption;
        this.custPaymentDtl = custPaymentDtl;
    }

    public CustPaymentType(Object paymentType) {
    }


    public String getCustPaymentTypeId() {
        return custPaymentTypeId;
    }

    public void setCustPaymentTypeId(String custPaymentTypeId) {
        this.custPaymentTypeId = custPaymentTypeId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public String getCustPaymentDtl() {
        return custPaymentDtl;
    }

    public void setCustPaymentDtl(String custPaymentDtl) {
        this.custPaymentDtl = custPaymentDtl;
    }
}
