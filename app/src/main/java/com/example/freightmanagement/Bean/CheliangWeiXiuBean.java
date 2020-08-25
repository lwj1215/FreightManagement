package com.example.freightmanagement.Bean;

import java.util.List;

public class CheliangWeiXiuBean {

    /**
     * code : 0
     * message : 成功
     * data : [{"id":5,"mileage":null,"servicer":"爹呵呵呵","content":"滴滴滴飞","partMaker":"爹呵呵","time":"婆婆婆婆","picUrl":"/storage/emulated/0/DCIM/Screenshots/Screenshot_2020-08-23-16-42-23-70.png","billPicUrl":"名爹","isActive":1,"createTime":1598342102000,"updateTime":1598342102000,"carOwnerId":null,"driverId":1},{"id":12,"mileage":null,"servicer":"爹呵呵呵","content":"滴滴滴飞","partMaker":"爹呵呵","time":"婆婆婆婆","picUrl":"/storage/emulated/0/DCIM/Screenshots/Screenshot_2020-08-23-16-42-23-70.png","billPicUrl":"名爹","isActive":1,"createTime":1598342106000,"updateTime":1598342106000,"carOwnerId":null,"driverId":1},{"id":19,"mileage":null,"servicer":"爹呵呵呵","content":"滴滴滴飞","partMaker":"爹呵呵","time":"婆婆婆婆","picUrl":"/storage/emulated/0/DCIM/Screenshots/Screenshot_2020-08-23-16-42-23-70.png","billPicUrl":"名爹","isActive":1,"createTime":1598342107000,"updateTime":1598342107000,"carOwnerId":null,"driverId":1},{"id":26,"mileage":null,"servicer":"爹呵呵呵","content":"滴滴滴飞","partMaker":"爹呵呵","time":"婆婆婆婆","picUrl":"/storage/emulated/0/DCIM/Screenshots/Screenshot_2020-08-23-16-42-23-70.png","billPicUrl":"名爹","isActive":1,"createTime":1598342108000,"updateTime":1598342108000,"carOwnerId":null,"driverId":1},{"id":33,"mileage":null,"servicer":"爹呵呵呵","content":"滴滴滴飞","partMaker":"爹呵呵","time":"婆婆婆婆","picUrl":"/storage/emulated/0/DCIM/Screenshots/Screenshot_2020-08-23-16-42-23-70.png","billPicUrl":"名爹","isActive":1,"createTime":1598342108000,"updateTime":1598342108000,"carOwnerId":null,"driverId":1},{"id":40,"mileage":null,"servicer":"爹呵呵呵","content":"滴滴滴飞","partMaker":"爹呵呵","time":"婆婆婆婆","picUrl":"/storage/emulated/0/DCIM/Screenshots/Screenshot_2020-08-23-16-42-23-70.png","billPicUrl":"名爹","isActive":1,"createTime":1598342108000,"updateTime":1598342108000,"carOwnerId":null,"driverId":1},{"id":47,"mileage":null,"servicer":"爹呵呵呵","content":"滴滴滴飞","partMaker":"爹呵呵","time":"婆婆婆婆","picUrl":"/storage/emulated/0/DCIM/Screenshots/Screenshot_2020-08-23-16-42-23-70.png","billPicUrl":"名爹","isActive":1,"createTime":1598342109000,"updateTime":1598342109000,"carOwnerId":null,"driverId":1},{"id":54,"mileage":null,"servicer":"爹呵呵呵","content":"滴滴滴飞","partMaker":"爹呵呵","time":"婆婆婆婆","picUrl":"/storage/emulated/0/DCIM/Screenshots/Screenshot_2020-08-23-16-42-23-70.png","billPicUrl":"名爹","isActive":1,"createTime":1598342128000,"updateTime":1598342128000,"carOwnerId":null,"driverId":1}]
     * type : 3
     * token : cGAe9Yhs62HKLRyZkJtxzX0VLBvvk3q8
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
         * id : 5
         * mileage : null
         * servicer : 爹呵呵呵
         * content : 滴滴滴飞
         * partMaker : 爹呵呵
         * time : 婆婆婆婆
         * picUrl : /storage/emulated/0/DCIM/Screenshots/Screenshot_2020-08-23-16-42-23-70.png
         * billPicUrl : 名爹
         * isActive : 1
         * createTime : 1598342102000
         * updateTime : 1598342102000
         * carOwnerId : null
         * driverId : 1
         */

        private int id;
        private Object mileage;
        private String servicer;
        private String content;
        private String partMaker;
        private String time;
        private String picUrl;
        private String billPicUrl;
        private int isActive;
        private long createTime;
        private long updateTime;
        private Object carOwnerId;
        private int driverId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getMileage() {
            return mileage;
        }

        public void setMileage(Object mileage) {
            this.mileage = mileage;
        }

        public String getServicer() {
            return servicer;
        }

        public void setServicer(String servicer) {
            this.servicer = servicer;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPartMaker() {
            return partMaker;
        }

        public void setPartMaker(String partMaker) {
            this.partMaker = partMaker;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getBillPicUrl() {
            return billPicUrl;
        }

        public void setBillPicUrl(String billPicUrl) {
            this.billPicUrl = billPicUrl;
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

        public Object getCarOwnerId() {
            return carOwnerId;
        }

        public void setCarOwnerId(Object carOwnerId) {
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
