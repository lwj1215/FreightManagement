package com.example.freightmanagement.model;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class AccountParam {

    private String name;//可不传
    private String pass;
    private String tel;
    private String msCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMsCode() {
        return msCode;
    }

    public void setMsCode(String msCode) {
        this.msCode = msCode;
    }
}
