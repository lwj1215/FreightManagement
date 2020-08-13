package com.example.freightmanagement.model;

import java.io.File;

/**
 * Created by songdechuan on 2020/8/13.
 */

public class IDCardParam {

    private File file;
    private File file2;

    private String name;

    private String six;

    private String nation;

    private String birthDay;

    private String address;

    private String IDNo;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile2() {
        return file2;
    }

    public void setFile2(File file2) {
        this.file2 = file2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSix() {
        return six;
    }

    public void setSix(String six) {
        this.six = six;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIDNo() {
        return IDNo;
    }

    public void setIDNo(String IDNo) {
        this.IDNo = IDNo;
    }
}
