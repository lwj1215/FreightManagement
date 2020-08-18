package com.example.freightmanagement.model.company;


import java.util.Date;

/**
 * Created by songdechuan on 2020/8/18.
 */

public class CertificateTransport {
    //证件号
    private String grantNo;
    //有效期
    private String validityDate;
    //业户名称
    private String owner;
    //地址
    private String address;
    //经济性质
    private String nature;
    //经营范围
    private String scope;

    private String picUrl;

    public String getGrantNo() {
        return grantNo;
    }

    public void setGrantNo(String grantNo) {
        this.grantNo = grantNo;
    }

    public String getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(String validityDate) {
        this.validityDate = validityDate;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
