package com.example.freightmanagement.Bean;

import java.util.List;

public class VerAddBean {

    /**
     * checkDateTime : 1596691836492
     * completeBos : [{"chechDataId":1,"reslut":"其他的时候填","state":1},{"chechDataId":2,"reslut":"其他的时候填","state":0}]
     * driverId : 1
     * type : 1
     */

    private long checkDateTime;
    private int driverId;
    private int type;
    private List<CompleteBosBean> completeBos;

    public long getCheckDateTime() {
        return checkDateTime;
    }

    public void setCheckDateTime(long checkDateTime) {
        this.checkDateTime = checkDateTime;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<CompleteBosBean> getCompleteBos() {
        return completeBos;
    }

    public void setCompleteBos(List<CompleteBosBean> completeBos) {
        this.completeBos = completeBos;
    }

    public static class CompleteBosBean {
        /**
         * chechDataId : 1
         * reslut : 其他的时候填
         * state : 1
         */

        private int chechDataId;
        private String reslut;
        private int state;

        public int getChechDataId() {
            return chechDataId;
        }

        public void setChechDataId(int chechDataId) {
            this.chechDataId = chechDataId;
        }

        public String getReslut() {
            return reslut;
        }

        public void setReslut(String reslut) {
            this.reslut = reslut;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }
    }
}
