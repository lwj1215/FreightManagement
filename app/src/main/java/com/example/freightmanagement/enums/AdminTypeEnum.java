package com.example.freightmanagement.enums;

/**
 * Created by songdechuan on 2020/8/10.
 */

public enum  AdminTypeEnum {

    DRIVER(1,"驾驶员","1"),
    CAR_OWNER(2,"车主","2"),
    COMPANY(3,"企业","3");

    private Integer code;

    private String msg;

    private String value;

    AdminTypeEnum(int code, String msg,String value){
        this.code = code;
        this.msg = msg;
        this.value = value;
    }

    public static AdminTypeEnum find(int timeType) {
        AdminTypeEnum[] values = AdminTypeEnum.values();
        for (AdminTypeEnum value : values) {
            if (value.getCode().equals(timeType)){
                return value;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
