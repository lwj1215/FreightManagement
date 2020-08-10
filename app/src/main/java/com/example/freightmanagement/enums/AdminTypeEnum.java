package com.example.freightmanagement.enums;

/**
 * Created by songdechuan on 2020/8/10.
 */

public enum  AdminTypeEnum {

    DRIVER(1,"驾驶员"),
    CAR_OWNER(2,"车主"),
    COMPANY(3,"企业");

    private Integer code;

    private String msg;

    AdminTypeEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static ResponseCodeEnum find(int timeType) {
        ResponseCodeEnum[] values = ResponseCodeEnum.values();
        for (ResponseCodeEnum value : values) {
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
}
