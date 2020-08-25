package com.example.freightmanagement.Bean;

import java.util.List;

public class CheliangJcBean {

    /**
     * code : 0
     * message : 成功
     * data : [{"id":40,"driverId":1,"note":null,"checkDateTime":1598249797000,"type":0,"isActive":1,"createTime":1598249797000,"updateTime":1598249797000,"completeBos":null},{"id":47,"driverId":1,"note":null,"checkDateTime":1598249802000,"type":0,"isActive":1,"createTime":1598249802000,"updateTime":1598249802000,"completeBos":null},{"id":54,"driverId":1,"note":null,"checkDateTime":1598249802000,"type":0,"isActive":1,"createTime":1598249802000,"updateTime":1598249802000,"completeBos":null}]
     * type : 3
     * token : 6hlM89H0vsv/BIn3Rpij6n0VLBvvk3q8
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
         * id : 40
         * driverId : 1
         * note : null
         * checkDateTime : 1598249797000
         * type : 0
         * isActive : 1
         * createTime : 1598249797000
         * updateTime : 1598249797000
         * completeBos : null
         */

        private int id;
        private int driverId;
        private Object note;
        private long checkDateTime;
        private int type;
        private int isActive;
        private long createTime;
        private long updateTime;
        private Object completeBos;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getDriverId() {
            return driverId;
        }

        public void setDriverId(int driverId) {
            this.driverId = driverId;
        }

        public Object getNote() {
            return note;
        }

        public void setNote(Object note) {
            this.note = note;
        }

        public long getCheckDateTime() {
            return checkDateTime;
        }

        public void setCheckDateTime(long checkDateTime) {
            this.checkDateTime = checkDateTime;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
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

        public Object getCompleteBos() {
            return completeBos;
        }

        public void setCompleteBos(Object completeBos) {
            this.completeBos = completeBos;
        }
    }
}
