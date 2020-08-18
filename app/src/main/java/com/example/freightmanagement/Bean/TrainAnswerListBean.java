package com.example.freightmanagement.Bean;

/**
 * Created by songdechuan on 2020/8/18.
 */

public class TrainAnswerListBean {


    /**
     * code : 0
     * message : 成功
     * data : {"id":0,"dirverId":0,"score":0,"isPass":0,"isActive":0,"createTime":null,"updateTime":null,"driverDataBos":null}
     * type : 3
     * token : z9dEVi4xB4t6F4p4InUC330VLBvvk3q8
     */

    private int code;
    private String message;
    private DataBean data;
    private String type;
    private String token;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
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

    public static class DataBean {
        /**
         * id : 0
         * dirverId : 0
         * score : 0
         * isPass : 0
         * isActive : 0
         * createTime : null
         * updateTime : null
         * driverDataBos : null
         */

        private int id;
        private int dirverId;
        private int score;
        private int isPass;
        private int isActive;
        private Object createTime;
        private Object updateTime;
        private Object driverDataBos;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getDirverId() {
            return dirverId;
        }

        public void setDirverId(int dirverId) {
            this.dirverId = dirverId;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getIsPass() {
            return isPass;
        }

        public void setIsPass(int isPass) {
            this.isPass = isPass;
        }

        public int getIsActive() {
            return isActive;
        }

        public void setIsActive(int isActive) {
            this.isActive = isActive;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getDriverDataBos() {
            return driverDataBos;
        }

        public void setDriverDataBos(Object driverDataBos) {
            this.driverDataBos = driverDataBos;
        }
    }
}
