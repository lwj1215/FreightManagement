package com.example.freightmanagement.Bean;

import java.util.List;

public class WenJuanAnserBean {

    /**
     * dirverId : 1
     * driverDataBos : [{"answer":"answer","driverId":1,"examinationDataId":1}]
     */

    private int dirverId;
    private List<DriverDataBosBean> driverDataBos;

    public int getDirverId() {
        return dirverId;
    }

    public void setDirverId(int dirverId) {
        this.dirverId = dirverId;
    }

    public List<DriverDataBosBean> getDriverDataBos() {
        return driverDataBos;
    }

    public void setDriverDataBos(List<DriverDataBosBean> driverDataBos) {
        this.driverDataBos = driverDataBos;
    }

    public static class DriverDataBosBean {
        /**
         * answer : answer
         * driverId : 1
         * examinationDataId : 1
         */

        private String answer;
        private int driverId;
        private int examinationDataId;

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public int getDriverId() {
            return driverId;
        }

        public void setDriverId(int driverId) {
            this.driverId = driverId;
        }

        public int getExaminationDataId() {
            return examinationDataId;
        }

        public void setExaminationDataId(int examinationDataId) {
            this.examinationDataId = examinationDataId;
        }
    }
}
