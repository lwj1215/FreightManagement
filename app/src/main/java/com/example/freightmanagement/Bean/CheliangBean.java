package com.example.freightmanagement.Bean;

import java.util.List;

public class CheliangBean {


    /**
     * code : 0
     * message : 成功
     * data : {"id":383,"driverCertificateId":411,"workCertificateId":390,"isActive":1,"createTime":1599053922000,"updateTime":1599053922000,"tel":"13693155706","adminId":299,"enterpriseId":0,"signUrl":"","carId":82,"certificateDriverBo":{"id":411,"name":"","sex":"","country":"","isActive":1,"createTime":1599053922000,"updateTime":1599053922000,"address":"","birthday":"","receiveDate":"","classs":"C1","startTime":"2050年10月14日","term":"","fileNumber":"41062219960321201X","note":"","picUrl":"https://aicc.ctags.cn/cccc/file/download/ce64d582-829c-44fa-909d-03ee337273c5.jpg","driverId":0},"certificateIDBo":{"id":516,"name":"宋德川","six":"","nation":"","birthDay":"","address":"","isActive":1,"createTime":1599053922000,"updateTime":1599053922000,"picUrl":"https://aicc.ctags.cn/cccc/file/download/c97bd398-ad2d-471b-9317-590fc75adab6.jpg","picUrl2":"https://aicc.ctags.cn/cccc/file/download/72f348dd-cd4b-44a1-8906-c9eb798a1c7a.jpg","driverId":0,"carId":0,"carOwnerId":0,"idno":"41062219960321201X"},"certificateWorkBo":{"id":390,"name":"","sex":"","birthday":"","nationality":"","address":"","grantNo":"3200251969160415","classs":"","isActive":1,"createTime":1599053922000,"updateTime":1599053922000,"picUrl":"https://aicc.ctags.cn/cccc/file/download/c3f080f3-1f9a-4358-866c-5ebd0477df2a.jpg","category":"","firstTime":null,"validityStartTime":null,"validityEndTime":null,"fileNumber":"","driverId":0},"carBo":{"id":82,"drivingCertificateId":47,"tel":"15311871589","transportCertificateId":33,"registrationCertificateId":0,"isActive":1,"createTime":1598869939000,"updateTime":1598869939000,"adminId":1,"enterpriseId":1,"isPass":1,"carOnwerId":1,"certificateDrivingBo":{"id":47,"plateNo":"1102003003666","wchicheType":"","owner":"钱镠","address":"","useCharacter":"运货8","model":"","engineNo":"100030","registrationDate":"","issueDate":"","fileNo":"","passengersCount":1000,"allWeight":"","curbWeight":"","approvedWeight":"","outline":"","tractionWeight":"","note":"","chechRecord":"","isActive":1,"updateTime":1598871780000,"createTime":1598871780000,"picUrl":"http://aicc.ctags.cn/cccc/file/download/78c522b1-9404-4545-ad39-ec06dfb49b23.png","carId":0,"vin":""},"certificateIDBo":{"id":355,"name":"测试4","six":"1","nation":"中国","birthDay":"2020-10-26","address":"北京市朝阳区","isActive":1,"createTime":1598870205000,"updateTime":1598871717000,"picUrl":"http://aicc.ctags.cn/cccc/file/download/5e9f9af5-2dec-4543-9980-c7fc039b4610.png","picUrl2":"","driverId":0,"carId":0,"carOwnerId":0,"idno":"1102003003666"},"certificateTransportBo":{"id":33,"name":"北京时尚呢供应","address":"海淀西北旺11","plateNo":"运输证10259685222122666传","licence":"","type":"货车12","weight":"1000吨2","size":"2000*233*9652","scope":"全国2","grantDate":"2020-06-1211","isActive":1,"createTime":1598869964000,"updateTime":1598870005000,"picUrl":"http://aicc.ctags.cn/cccc/file/download/dab6139b-40ec-4723-85e2-3268e32d3087.png","carId":0},"certificateRegistrationBo":null,"idcertificateId":355},"trainDriverDataBos":[],"idcertificateId":516}
     * type : 1
     * token : vAqc75ku04FaXdj5NVF/o2O0X5OKGGQA
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
         * id : 383
         * driverCertificateId : 411
         * workCertificateId : 390
         * isActive : 1
         * createTime : 1599053922000
         * updateTime : 1599053922000
         * tel : 13693155706
         * adminId : 299
         * enterpriseId : 0
         * signUrl :
         * carId : 82
         * certificateDriverBo : {"id":411,"name":"","sex":"","country":"","isActive":1,"createTime":1599053922000,"updateTime":1599053922000,"address":"","birthday":"","receiveDate":"","classs":"C1","startTime":"2050年10月14日","term":"","fileNumber":"41062219960321201X","note":"","picUrl":"https://aicc.ctags.cn/cccc/file/download/ce64d582-829c-44fa-909d-03ee337273c5.jpg","driverId":0}
         * certificateIDBo : {"id":516,"name":"宋德川","six":"","nation":"","birthDay":"","address":"","isActive":1,"createTime":1599053922000,"updateTime":1599053922000,"picUrl":"https://aicc.ctags.cn/cccc/file/download/c97bd398-ad2d-471b-9317-590fc75adab6.jpg","picUrl2":"https://aicc.ctags.cn/cccc/file/download/72f348dd-cd4b-44a1-8906-c9eb798a1c7a.jpg","driverId":0,"carId":0,"carOwnerId":0,"idno":"41062219960321201X"}
         * certificateWorkBo : {"id":390,"name":"","sex":"","birthday":"","nationality":"","address":"","grantNo":"3200251969160415","classs":"","isActive":1,"createTime":1599053922000,"updateTime":1599053922000,"picUrl":"https://aicc.ctags.cn/cccc/file/download/c3f080f3-1f9a-4358-866c-5ebd0477df2a.jpg","category":"","firstTime":null,"validityStartTime":null,"validityEndTime":null,"fileNumber":"","driverId":0}
         * carBo : {"id":82,"drivingCertificateId":47,"tel":"15311871589","transportCertificateId":33,"registrationCertificateId":0,"isActive":1,"createTime":1598869939000,"updateTime":1598869939000,"adminId":1,"enterpriseId":1,"isPass":1,"carOnwerId":1,"certificateDrivingBo":{"id":47,"plateNo":"1102003003666","wchicheType":"","owner":"钱镠","address":"","useCharacter":"运货8","model":"","engineNo":"100030","registrationDate":"","issueDate":"","fileNo":"","passengersCount":1000,"allWeight":"","curbWeight":"","approvedWeight":"","outline":"","tractionWeight":"","note":"","chechRecord":"","isActive":1,"updateTime":1598871780000,"createTime":1598871780000,"picUrl":"http://aicc.ctags.cn/cccc/file/download/78c522b1-9404-4545-ad39-ec06dfb49b23.png","carId":0,"vin":""},"certificateIDBo":{"id":355,"name":"测试4","six":"1","nation":"中国","birthDay":"2020-10-26","address":"北京市朝阳区","isActive":1,"createTime":1598870205000,"updateTime":1598871717000,"picUrl":"http://aicc.ctags.cn/cccc/file/download/5e9f9af5-2dec-4543-9980-c7fc039b4610.png","picUrl2":"","driverId":0,"carId":0,"carOwnerId":0,"idno":"1102003003666"},"certificateTransportBo":{"id":33,"name":"北京时尚呢供应","address":"海淀西北旺11","plateNo":"运输证10259685222122666传","licence":"","type":"货车12","weight":"1000吨2","size":"2000*233*9652","scope":"全国2","grantDate":"2020-06-1211","isActive":1,"createTime":1598869964000,"updateTime":1598870005000,"picUrl":"http://aicc.ctags.cn/cccc/file/download/dab6139b-40ec-4723-85e2-3268e32d3087.png","carId":0},"certificateRegistrationBo":null,"idcertificateId":355}
         * trainDriverDataBos : []
         * idcertificateId : 516
         */

        private int id;
        private int driverCertificateId;
        private int workCertificateId;
        private int isActive;
        private long createTime;
        private long updateTime;
        private String tel;
        private int adminId;
        private int enterpriseId;
        private String signUrl;
        private int carId;
        private CertificateDriverBoBean certificateDriverBo;
        private CertificateIDBoBean certificateIDBo;
        private CertificateWorkBoBean certificateWorkBo;
        private CarBoBean carBo;
        private int idcertificateId;
        private List<?> trainDriverDataBos;

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

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public int getAdminId() {
            return adminId;
        }

        public void setAdminId(int adminId) {
            this.adminId = adminId;
        }

        public int getEnterpriseId() {
            return enterpriseId;
        }

        public void setEnterpriseId(int enterpriseId) {
            this.enterpriseId = enterpriseId;
        }

        public String getSignUrl() {
            return signUrl;
        }

        public void setSignUrl(String signUrl) {
            this.signUrl = signUrl;
        }

        public int getCarId() {
            return carId;
        }

        public void setCarId(int carId) {
            this.carId = carId;
        }

        public CertificateDriverBoBean getCertificateDriverBo() {
            return certificateDriverBo;
        }

        public void setCertificateDriverBo(CertificateDriverBoBean certificateDriverBo) {
            this.certificateDriverBo = certificateDriverBo;
        }

        public CertificateIDBoBean getCertificateIDBo() {
            return certificateIDBo;
        }

        public void setCertificateIDBo(CertificateIDBoBean certificateIDBo) {
            this.certificateIDBo = certificateIDBo;
        }

        public CertificateWorkBoBean getCertificateWorkBo() {
            return certificateWorkBo;
        }

        public void setCertificateWorkBo(CertificateWorkBoBean certificateWorkBo) {
            this.certificateWorkBo = certificateWorkBo;
        }

        public CarBoBean getCarBo() {
            return carBo;
        }

        public void setCarBo(CarBoBean carBo) {
            this.carBo = carBo;
        }

        public int getIdcertificateId() {
            return idcertificateId;
        }

        public void setIdcertificateId(int idcertificateId) {
            this.idcertificateId = idcertificateId;
        }

        public List<?> getTrainDriverDataBos() {
            return trainDriverDataBos;
        }

        public void setTrainDriverDataBos(List<?> trainDriverDataBos) {
            this.trainDriverDataBos = trainDriverDataBos;
        }

        public static class CertificateDriverBoBean {
            /**
             * id : 411
             * name :
             * sex :
             * country :
             * isActive : 1
             * createTime : 1599053922000
             * updateTime : 1599053922000
             * address :
             * birthday :
             * receiveDate :
             * classs : C1
             * startTime : 2050年10月14日
             * term :
             * fileNumber : 41062219960321201X
             * note :
             * picUrl : https://aicc.ctags.cn/cccc/file/download/ce64d582-829c-44fa-909d-03ee337273c5.jpg
             * driverId : 0
             */

            private int id;
            private String name;
            private String sex;
            private String country;
            private int isActive;
            private long createTime;
            private long updateTime;
            private String address;
            private String birthday;
            private String receiveDate;
            private String classs;
            private String startTime;
            private String term;
            private String fileNumber;
            private String note;
            private String picUrl;
            private int driverId;

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

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
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

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getReceiveDate() {
                return receiveDate;
            }

            public void setReceiveDate(String receiveDate) {
                this.receiveDate = receiveDate;
            }

            public String getClasss() {
                return classs;
            }

            public void setClasss(String classs) {
                this.classs = classs;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public String getTerm() {
                return term;
            }

            public void setTerm(String term) {
                this.term = term;
            }

            public String getFileNumber() {
                return fileNumber;
            }

            public void setFileNumber(String fileNumber) {
                this.fileNumber = fileNumber;
            }

            public String getNote() {
                return note;
            }

            public void setNote(String note) {
                this.note = note;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public int getDriverId() {
                return driverId;
            }

            public void setDriverId(int driverId) {
                this.driverId = driverId;
            }
        }

        public static class CertificateIDBoBean {
            /**
             * id : 516
             * name : 宋德川
             * six :
             * nation :
             * birthDay :
             * address :
             * isActive : 1
             * createTime : 1599053922000
             * updateTime : 1599053922000
             * picUrl : https://aicc.ctags.cn/cccc/file/download/c97bd398-ad2d-471b-9317-590fc75adab6.jpg
             * picUrl2 : https://aicc.ctags.cn/cccc/file/download/72f348dd-cd4b-44a1-8906-c9eb798a1c7a.jpg
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

        public static class CertificateWorkBoBean {
            /**
             * id : 390
             * name :
             * sex :
             * birthday :
             * nationality :
             * address :
             * grantNo : 3200251969160415
             * classs :
             * isActive : 1
             * createTime : 1599053922000
             * updateTime : 1599053922000
             * picUrl : https://aicc.ctags.cn/cccc/file/download/c3f080f3-1f9a-4358-866c-5ebd0477df2a.jpg
             * category :
             * firstTime : null
             * validityStartTime : null
             * validityEndTime : null
             * fileNumber :
             * driverId : 0
             */

            private int id;
            private String name;
            private String sex;
            private String birthday;
            private String nationality;
            private String address;
            private String grantNo;
            private String classs;
            private int isActive;
            private long createTime;
            private long updateTime;
            private String picUrl;
            private String category;
            private Object firstTime;
            private Object validityStartTime;
            private Object validityEndTime;
            private String fileNumber;
            private int driverId;

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

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getNationality() {
                return nationality;
            }

            public void setNationality(String nationality) {
                this.nationality = nationality;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getGrantNo() {
                return grantNo;
            }

            public void setGrantNo(String grantNo) {
                this.grantNo = grantNo;
            }

            public String getClasss() {
                return classs;
            }

            public void setClasss(String classs) {
                this.classs = classs;
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

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public Object getFirstTime() {
                return firstTime;
            }

            public void setFirstTime(Object firstTime) {
                this.firstTime = firstTime;
            }

            public Object getValidityStartTime() {
                return validityStartTime;
            }

            public void setValidityStartTime(Object validityStartTime) {
                this.validityStartTime = validityStartTime;
            }

            public Object getValidityEndTime() {
                return validityEndTime;
            }

            public void setValidityEndTime(Object validityEndTime) {
                this.validityEndTime = validityEndTime;
            }

            public String getFileNumber() {
                return fileNumber;
            }

            public void setFileNumber(String fileNumber) {
                this.fileNumber = fileNumber;
            }

            public int getDriverId() {
                return driverId;
            }

            public void setDriverId(int driverId) {
                this.driverId = driverId;
            }
        }

        public static class CarBoBean {
            /**
             * id : 82
             * drivingCertificateId : 47
             * tel : 15311871589
             * transportCertificateId : 33
             * registrationCertificateId : 0
             * isActive : 1
             * createTime : 1598869939000
             * updateTime : 1598869939000
             * adminId : 1
             * enterpriseId : 1
             * isPass : 1
             * carOnwerId : 1
             * certificateDrivingBo : {"id":47,"plateNo":"1102003003666","wchicheType":"","owner":"钱镠","address":"","useCharacter":"运货8","model":"","engineNo":"100030","registrationDate":"","issueDate":"","fileNo":"","passengersCount":1000,"allWeight":"","curbWeight":"","approvedWeight":"","outline":"","tractionWeight":"","note":"","chechRecord":"","isActive":1,"updateTime":1598871780000,"createTime":1598871780000,"picUrl":"http://aicc.ctags.cn/cccc/file/download/78c522b1-9404-4545-ad39-ec06dfb49b23.png","carId":0,"vin":""}
             * certificateIDBo : {"id":355,"name":"测试4","six":"1","nation":"中国","birthDay":"2020-10-26","address":"北京市朝阳区","isActive":1,"createTime":1598870205000,"updateTime":1598871717000,"picUrl":"http://aicc.ctags.cn/cccc/file/download/5e9f9af5-2dec-4543-9980-c7fc039b4610.png","picUrl2":"","driverId":0,"carId":0,"carOwnerId":0,"idno":"1102003003666"}
             * certificateTransportBo : {"id":33,"name":"北京时尚呢供应","address":"海淀西北旺11","plateNo":"运输证10259685222122666传","licence":"","type":"货车12","weight":"1000吨2","size":"2000*233*9652","scope":"全国2","grantDate":"2020-06-1211","isActive":1,"createTime":1598869964000,"updateTime":1598870005000,"picUrl":"http://aicc.ctags.cn/cccc/file/download/dab6139b-40ec-4723-85e2-3268e32d3087.png","carId":0}
             * certificateRegistrationBo : null
             * idcertificateId : 355
             */

            private int id;
            private int drivingCertificateId;
            private String tel;
            private int transportCertificateId;
            private int registrationCertificateId;
            private int isActive;
            private long createTime;
            private long updateTime;
            private int adminId;
            private int enterpriseId;
            private int isPass;
            private int carOnwerId;
            private CertificateDrivingBoBean certificateDrivingBo;
            private CertificateIDBoBeanX certificateIDBo;
            private CertificateTransportBoBean certificateTransportBo;
            private Object certificateRegistrationBo;
            private int idcertificateId;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getDrivingCertificateId() {
                return drivingCertificateId;
            }

            public void setDrivingCertificateId(int drivingCertificateId) {
                this.drivingCertificateId = drivingCertificateId;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public int getTransportCertificateId() {
                return transportCertificateId;
            }

            public void setTransportCertificateId(int transportCertificateId) {
                this.transportCertificateId = transportCertificateId;
            }

            public int getRegistrationCertificateId() {
                return registrationCertificateId;
            }

            public void setRegistrationCertificateId(int registrationCertificateId) {
                this.registrationCertificateId = registrationCertificateId;
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

            public int getEnterpriseId() {
                return enterpriseId;
            }

            public void setEnterpriseId(int enterpriseId) {
                this.enterpriseId = enterpriseId;
            }

            public int getIsPass() {
                return isPass;
            }

            public void setIsPass(int isPass) {
                this.isPass = isPass;
            }

            public int getCarOnwerId() {
                return carOnwerId;
            }

            public void setCarOnwerId(int carOnwerId) {
                this.carOnwerId = carOnwerId;
            }

            public CertificateDrivingBoBean getCertificateDrivingBo() {
                return certificateDrivingBo;
            }

            public void setCertificateDrivingBo(CertificateDrivingBoBean certificateDrivingBo) {
                this.certificateDrivingBo = certificateDrivingBo;
            }

            public CertificateIDBoBeanX getCertificateIDBo() {
                return certificateIDBo;
            }

            public void setCertificateIDBo(CertificateIDBoBeanX certificateIDBo) {
                this.certificateIDBo = certificateIDBo;
            }

            public CertificateTransportBoBean getCertificateTransportBo() {
                return certificateTransportBo;
            }

            public void setCertificateTransportBo(CertificateTransportBoBean certificateTransportBo) {
                this.certificateTransportBo = certificateTransportBo;
            }

            public Object getCertificateRegistrationBo() {
                return certificateRegistrationBo;
            }

            public void setCertificateRegistrationBo(Object certificateRegistrationBo) {
                this.certificateRegistrationBo = certificateRegistrationBo;
            }

            public int getIdcertificateId() {
                return idcertificateId;
            }

            public void setIdcertificateId(int idcertificateId) {
                this.idcertificateId = idcertificateId;
            }

            public static class CertificateDrivingBoBean {
                /**
                 * id : 47
                 * plateNo : 1102003003666
                 * wchicheType :
                 * owner : 钱镠
                 * address :
                 * useCharacter : 运货8
                 * model :
                 * engineNo : 100030
                 * registrationDate :
                 * issueDate :
                 * fileNo :
                 * passengersCount : 1000
                 * allWeight :
                 * curbWeight :
                 * approvedWeight :
                 * outline :
                 * tractionWeight :
                 * note :
                 * chechRecord :
                 * isActive : 1
                 * updateTime : 1598871780000
                 * createTime : 1598871780000
                 * picUrl : http://aicc.ctags.cn/cccc/file/download/78c522b1-9404-4545-ad39-ec06dfb49b23.png
                 * carId : 0
                 * vin :
                 */

                private int id;
                private String plateNo;
                private String wchicheType;
                private String owner;
                private String address;
                private String useCharacter;
                private String model;
                private String engineNo;
                private String registrationDate;
                private String issueDate;
                private String fileNo;
                private int passengersCount;
                private String allWeight;
                private String curbWeight;
                private String approvedWeight;
                private String outline;
                private String tractionWeight;
                private String note;
                private String chechRecord;
                private int isActive;
                private long updateTime;
                private long createTime;
                private String picUrl;
                private int carId;
                private String vin;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getPlateNo() {
                    return plateNo;
                }

                public void setPlateNo(String plateNo) {
                    this.plateNo = plateNo;
                }

                public String getWchicheType() {
                    return wchicheType;
                }

                public void setWchicheType(String wchicheType) {
                    this.wchicheType = wchicheType;
                }

                public String getOwner() {
                    return owner;
                }

                public void setOwner(String owner) {
                    this.owner = owner;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getUseCharacter() {
                    return useCharacter;
                }

                public void setUseCharacter(String useCharacter) {
                    this.useCharacter = useCharacter;
                }

                public String getModel() {
                    return model;
                }

                public void setModel(String model) {
                    this.model = model;
                }

                public String getEngineNo() {
                    return engineNo;
                }

                public void setEngineNo(String engineNo) {
                    this.engineNo = engineNo;
                }

                public String getRegistrationDate() {
                    return registrationDate;
                }

                public void setRegistrationDate(String registrationDate) {
                    this.registrationDate = registrationDate;
                }

                public String getIssueDate() {
                    return issueDate;
                }

                public void setIssueDate(String issueDate) {
                    this.issueDate = issueDate;
                }

                public String getFileNo() {
                    return fileNo;
                }

                public void setFileNo(String fileNo) {
                    this.fileNo = fileNo;
                }

                public int getPassengersCount() {
                    return passengersCount;
                }

                public void setPassengersCount(int passengersCount) {
                    this.passengersCount = passengersCount;
                }

                public String getAllWeight() {
                    return allWeight;
                }

                public void setAllWeight(String allWeight) {
                    this.allWeight = allWeight;
                }

                public String getCurbWeight() {
                    return curbWeight;
                }

                public void setCurbWeight(String curbWeight) {
                    this.curbWeight = curbWeight;
                }

                public String getApprovedWeight() {
                    return approvedWeight;
                }

                public void setApprovedWeight(String approvedWeight) {
                    this.approvedWeight = approvedWeight;
                }

                public String getOutline() {
                    return outline;
                }

                public void setOutline(String outline) {
                    this.outline = outline;
                }

                public String getTractionWeight() {
                    return tractionWeight;
                }

                public void setTractionWeight(String tractionWeight) {
                    this.tractionWeight = tractionWeight;
                }

                public String getNote() {
                    return note;
                }

                public void setNote(String note) {
                    this.note = note;
                }

                public String getChechRecord() {
                    return chechRecord;
                }

                public void setChechRecord(String chechRecord) {
                    this.chechRecord = chechRecord;
                }

                public int getIsActive() {
                    return isActive;
                }

                public void setIsActive(int isActive) {
                    this.isActive = isActive;
                }

                public long getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(long updateTime) {
                    this.updateTime = updateTime;
                }

                public long getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(long createTime) {
                    this.createTime = createTime;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public int getCarId() {
                    return carId;
                }

                public void setCarId(int carId) {
                    this.carId = carId;
                }

                public String getVin() {
                    return vin;
                }

                public void setVin(String vin) {
                    this.vin = vin;
                }
            }

            public static class CertificateIDBoBeanX {
                /**
                 * id : 355
                 * name : 测试4
                 * six : 1
                 * nation : 中国
                 * birthDay : 2020-10-26
                 * address : 北京市朝阳区
                 * isActive : 1
                 * createTime : 1598870205000
                 * updateTime : 1598871717000
                 * picUrl : http://aicc.ctags.cn/cccc/file/download/5e9f9af5-2dec-4543-9980-c7fc039b4610.png
                 * picUrl2 :
                 * driverId : 0
                 * carId : 0
                 * carOwnerId : 0
                 * idno : 1102003003666
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

            public static class CertificateTransportBoBean {
                /**
                 * id : 33
                 * name : 北京时尚呢供应
                 * address : 海淀西北旺11
                 * plateNo : 运输证10259685222122666传
                 * licence :
                 * type : 货车12
                 * weight : 1000吨2
                 * size : 2000*233*9652
                 * scope : 全国2
                 * grantDate : 2020-06-1211
                 * isActive : 1
                 * createTime : 1598869964000
                 * updateTime : 1598870005000
                 * picUrl : http://aicc.ctags.cn/cccc/file/download/dab6139b-40ec-4723-85e2-3268e32d3087.png
                 * carId : 0
                 */

                private int id;
                private String name;
                private String address;
                private String plateNo;
                private String licence;
                private String type;
                private String weight;
                private String size;
                private String scope;
                private String grantDate;
                private int isActive;
                private long createTime;
                private long updateTime;
                private String picUrl;
                private int carId;

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

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getPlateNo() {
                    return plateNo;
                }

                public void setPlateNo(String plateNo) {
                    this.plateNo = plateNo;
                }

                public String getLicence() {
                    return licence;
                }

                public void setLicence(String licence) {
                    this.licence = licence;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getWeight() {
                    return weight;
                }

                public void setWeight(String weight) {
                    this.weight = weight;
                }

                public String getSize() {
                    return size;
                }

                public void setSize(String size) {
                    this.size = size;
                }

                public String getScope() {
                    return scope;
                }

                public void setScope(String scope) {
                    this.scope = scope;
                }

                public String getGrantDate() {
                    return grantDate;
                }

                public void setGrantDate(String grantDate) {
                    this.grantDate = grantDate;
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

                public int getCarId() {
                    return carId;
                }

                public void setCarId(int carId) {
                    this.carId = carId;
                }
            }
        }
    }
}
