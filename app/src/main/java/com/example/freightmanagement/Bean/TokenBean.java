package com.example.freightmanagement.Bean;

public class TokenBean {

    /**
     * code : 0
     * message : 登录成功
     * data : {"loginState":1,"token":"44EjD8O78lEQyjMrjZLTxfPhJ/DKvgSB","tokenName":"adminId","user":{"id":2,"driverCertificateId":1,"workCertificateId":1,"isActive":1,"createTime":1596607489000,"updateTime":1596607489000,"name":null,"pass":null,"tel":"13111111111","idcertificateId":1}}
     */

    private int code;
    private String message;
    private DataBean data;

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

    public static class DataBean {
        /**
         * loginState : 1
         * token : 44EjD8O78lEQyjMrjZLTxfPhJ/DKvgSB
         * tokenName : adminId
         * user : {"id":2,"driverCertificateId":1,"workCertificateId":1,"isActive":1,"createTime":1596607489000,"updateTime":1596607489000,"name":null,"pass":null,"tel":"13111111111","idcertificateId":1}
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
             * id : 2
             * driverCertificateId : 1
             * workCertificateId : 1
             * isActive : 1
             * createTime : 1596607489000
             * updateTime : 1596607489000
             * name : null
             * pass : null
             * tel : 13111111111
             * idcertificateId : 1
             */

            private int id;
            private int driverCertificateId;
            private int workCertificateId;
            private int isActive;
            private long createTime;
            private long updateTime;
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
}
