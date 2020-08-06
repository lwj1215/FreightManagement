package com.example.freightmanagement.enums;

/**
 * Created by Administrator on 2020/8/6.
 */

public enum  RoleTypeEnum {

    COMPANY(0,"企业"),
    CAR_OWNER(1,"车主"),
    DRIVER(2,"驾驶员"),
    UN_REGIST(3,"未注册");
    private Integer value;

    private String name;

    RoleTypeEnum(int value,String name){
        this.value = value;
        this.name = name;
    }

    public static RoleTypeEnum find(int timeType) {
        RoleTypeEnum[] values = RoleTypeEnum.values();
        for (RoleTypeEnum value : values) {
            if (value.getValue().equals(timeType)){
                return value;
            }
        }
        return null;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
