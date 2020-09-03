package com.example.freightmanagement.Bean;

import java.util.List;

public class CarOwnerBean {


    /**
     * code : 0
     * message : 成功
     * data : {"id":19,"tel":"","isActive":1,"createTime":1599065248000,"updateTime":1599065248000,"adminId":306,"certificateIDBo":{"id":537,"name":"宋德川","six":"","nation":"","birthDay":"","address":"","isActive":1,"createTime":1599065248000,"updateTime":1599065248000,"picUrl":"https://aicc.ctags.cn/cccc/file/download/d59ac3b5-541d-4922-8310-5294b3dcda2b.jpg","picUrl2":"https://aicc.ctags.cn/cccc/file/download/f0c98631-a320-4096-837d-97ed55569ea7.jpg","driverId":0,"carId":0,"carOwnerId":0,"idno":"41062219960321201X"},"carBos":[],"idcertificateId":537}
     * type : 2
     * token : YNUqRX3CpBUlxL86OmTsTRBrL8HOOIKh
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
         * id : 19
         * tel :
         * isActive : 1
         * createTime : 1599065248000
         * updateTime : 1599065248000
         * adminId : 306
         * certificateIDBo : {"id":537,"name":"宋德川","six":"","nation":"","birthDay":"","address":"","isActive":1,"createTime":1599065248000,"updateTime":1599065248000,"picUrl":"https://aicc.ctags.cn/cccc/file/download/d59ac3b5-541d-4922-8310-5294b3dcda2b.jpg","picUrl2":"https://aicc.ctags.cn/cccc/file/download/f0c98631-a320-4096-837d-97ed55569ea7.jpg","driverId":0,"carId":0,"carOwnerId":0,"idno":"41062219960321201X"}
         * carBos : []
         * idcertificateId : 537
         */

        private int id;
        private String tel;
        private int isActive;
        private long createTime;
        private long updateTime;
        private int adminId;
        private CertificateIDBoBean certificateIDBo;
        private int idcertificateId;
        private List<?> carBos;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
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

        public int getAdminId() {
            return adminId;
        }

        public void setAdminId(int adminId) {
            this.adminId = adminId;
        }

        public CertificateIDBoBean getCertificateIDBo() {
            return certificateIDBo;
        }

        public void setCertificateIDBo(CertificateIDBoBean certificateIDBo) {
            this.certificateIDBo = certificateIDBo;
        }

        public int getIdcertificateId() {
            return idcertificateId;
        }

        public void setIdcertificateId(int idcertificateId) {
            this.idcertificateId = idcertificateId;
        }

        public List<?> getCarBos() {
            return carBos;
        }

        public void setCarBos(List<?> carBos) {
            this.carBos = carBos;
        }

        public static class CertificateIDBoBean {
            /**
             * id : 537
             * name : 宋德川
             * six :
             * nation :
             * birthDay :
             * address :
             * isActive : 1
             * createTime : 1599065248000
             * updateTime : 1599065248000
             * picUrl : https://aicc.ctags.cn/cccc/file/download/d59ac3b5-541d-4922-8310-5294b3dcda2b.jpg
             * picUrl2 : https://aicc.ctags.cn/cccc/file/download/f0c98631-a320-4096-837d-97ed55569ea7.jpg
             * driverId : 0
             * carId : 0
             * carOwnerId : 0
             * idno : 41062219960321201X
             */

            private int id;
            private String name;
            private String six;
            private String nation;
            private String birthDay;
            private String address;
            private int isActive;
            private long createTime;
            private long updateTime;
            private String picUrl;
            private String picUrl2;
            private int driverId;
            private int carId;
            private int carOwnerId;
            private String idno;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSix() {
                return six;
            }

            public void setSix(String six) {
                this.six = six;
            }

            public String getNation() {
                return nation;
            }

            public void setNation(String nation) {
                this.nation = nation;
            }

            public String getBirthDay() {
                return birthDay;
            }

            public void setBirthDay(String birthDay) {
                this.birthDay = birthDay;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
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

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public String getPicUrl2() {
                return picUrl2;
            }

            public void setPicUrl2(String picUrl2) {
                this.picUrl2 = picUrl2;
            }

            public int getDriverId() {
                return driverId;
            }

            public void setDriverId(int driverId) {
                this.driverId = driverId;
            }

            public int getCarId() {
                return carId;
            }

            public void setCarId(int carId) {
                this.carId = carId;
            }

            public int getCarOwnerId() {
                return carOwnerId;
            }

            public void setCarOwnerId(int carOwnerId) {
                this.carOwnerId = carOwnerId;
            }

            public String getIdno() {
                return idno;
            }

            public void setIdno(String idno) {
                this.idno = idno;
            }
        }
    }
}
