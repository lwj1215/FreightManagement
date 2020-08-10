package com.example.freightmanagement.model;

/**
 * Created by songdechuan on 2020/8/10.
 */

public class AdminBean {

        /**
         * loginState : 1
         * token : bBymFadZshW/7mYrc+Tjf/wF++M7JReD
         * tokenName : adminId
         * user : {"id":12,"driverCertificateId":0,"workCertificateId":0,"isActive":1,"createTime":null,"updateTime":null,"name":null,"pass":null,"tel":"18888888888","idcertificateId":0}
         */

        private int loginState;
        private String token;
        private String tokenName;
        private UserBean user;

        public int getLoginState() {
            return loginState;
        }

        public void setLoginState(int loginState) {
            this.loginState = loginState;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getTokenName() {
            return tokenName;
        }

        public void setTokenName(String tokenName) {
            this.tokenName = tokenName;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * id : 12
             * driverCertificateId : 0
             * workCertificateId : 0
             * isActive : 1
             * createTime : null
             * updateTime : null
             * name : null
             * pass : null
             * tel : 18888888888
             * idcertificateId : 0
             */

            private int id;
            private int driverCertificateId;
            private int workCertificateId;
            private int isActive;
            private Object createTime;
            private Object updateTime;
            private Object name;
            private Object pass;
            private String tel;
            private int idcertificateId;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getDriverCertificateId() {
                return driverCertificateId;
            }

            public void setDriverCertificateId(int driverCertificateId) {
                this.driverCertificateId = driverCertificateId;
            }

            public int getWorkCertificateId() {
                return workCertificateId;
            }

            public void setWorkCertificateId(int workCertificateId) {
                this.workCertificateId = workCertificateId;
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

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public Object getPass() {
                return pass;
            }

            public void setPass(Object pass) {
                this.pass = pass;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public int getIdcertificateId() {
                return idcertificateId;
            }

            public void setIdcertificateId(int idcertificateId) {
                this.idcertificateId = idcertificateId;
            }
        }

}
