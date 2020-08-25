package com.example.freightmanagement.Bean;

import java.util.List;

public class CheliangByBean {

    /**
     * code : 0
     * message : 成功
     * data : [{"id":1,"mileage":1,"content":"1","time":1596816000000,"picUrl":"1","isActive":1,"createTime":1596816000000,"updateTime":1596816000000,"carOwnerId":1,"driverId":1}]
     * type : 3
     * token : Vpe8mWImwoqDj5gNupv+zn0VLBvvk3q8
     */

    private int code;
    private String message;
    private String type;
    private String token;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * mileage : 1.0
         * content : 1
         * time : 1596816000000
         * picUrl : 1
         * isActive : 1
         * createTime : 1596816000000
         * updateTime : 1596816000000
         * carOwnerId : 1
         * driverId : 1
         */

        private int id;
        private double mileage;
        private String content;
        private long time;
        private String picUrl;
        private int isActive;
        private long createTime;
        private long updateTime;
        private int carOwnerId;
        private int driverId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getMileage() {
            return mileage;
        }

        public void setMileage(double mileage) {
            this.mileage = mileage;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public int getIsActive() {
            return isActive;
        }

        public void setIsActive(int isActive) {
            this.isActive = isActive;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public int getCarOwnerId() {
            return carOwnerId;
        }

        public void setCarOwnerId(int carOwnerId) {
            this.carOwnerId = carOwnerId;
        }

        public int getDriverId() {
            return driverId;
        }

        public void setDriverId(int driverId) {
            this.driverId = driverId;
        }
    }
}
