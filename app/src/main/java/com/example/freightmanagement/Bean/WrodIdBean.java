package com.example.freightmanagement.Bean;

public class WrodIdBean {

    /**
     * code : 0
     * message : 成功
     * data : {"id":5,"driverCertificateId":1,"workCertificateId":1,"isActive":1,"createTime":1596784024000,"updateTime":1596784024000,"name":null,"pass":"123456","tel":"18141919315","certificateDriverBo":{"id":1,"name":"孙勇","sex":"1","country":"中国","isActive":1,"createTime":1596608578000,"updateTime":1596872200000,"address":"北京","birthday":"1989-08-10 15:12","receiveDate":null,"classs":null,"startTime":null,"term":null,"fileNumber":"123456","note":"驾驶证信息","picUrl":null},"certificateIDBo":{"id":1,"name":"蜀黍","six":"0","nation":"中国","birthDay":"2020-08-26 18:18","address":"山东","isActive":1,"createTime":1596607560000,"updateTime":1596881924000,"picUrl":null,"picUrl2":null,"file":null,"file2":null,"idno":"3718356965412358521"},"certificateWorkBo":{"id":1,"name":"孙玉勇","sex":"1","birthday":"2020-08-12 15:24","nationality":"中国","address":"北京","grantNo":"566233","classs":null,"isActive":1,"createTime":1596609097000,"updateTime":1596871505000,"picUrl":null,"category":null,"firstTime":null,"validityStartTime":null,"validityEndTime":null,"fileNumber":null},"idcertificateId":1}
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
         * id : 5
         * driverCertificateId : 1
         * workCertificateId : 1
         * isActive : 1
         * createTime : 1596784024000
         * updateTime : 1596784024000
         * name : null
         * pass : 123456
         * tel : 18141919315
         * certificateDriverBo : {"id":1,"name":"孙勇","sex":"1","country":"中国","isActive":1,"createTime":1596608578000,"updateTime":1596872200000,"address":"北京","birthday":"1989-08-10 15:12","receiveDate":null,"classs":null,"startTime":null,"term":null,"fileNumber":"123456","note":"驾驶证信息","picUrl":null}
         * certificateIDBo : {"id":1,"name":"蜀黍","six":"0","nation":"中国","birthDay":"2020-08-26 18:18","address":"山东","isActive":1,"createTime":1596607560000,"updateTime":1596881924000,"picUrl":null,"picUrl2":null,"file":null,"file2":null,"idno":"3718356965412358521"}
         * certificateWorkBo : {"id":1,"name":"孙玉勇","sex":"1","birthday":"2020-08-12 15:24","nationality":"中国","address":"北京","grantNo":"566233","classs":null,"isActive":1,"createTime":1596609097000,"updateTime":1596871505000,"picUrl":null,"category":null,"firstTime":null,"validityStartTime":null,"validityEndTime":null,"fileNumber":null}
         * idcertificateId : 1
         */

        private int id;
        private int driverCertificateId;
        private int workCertificateId;
        private int isActive;
        private long createTime;
        private long updateTime;
        private Object name;
        private String pass;
        private String tel;
        private CertificateDriverBoBean certificateDriverBo;
        private CertificateIDBoBean certificateIDBo;
        private CertificateWorkBoBean certificateWorkBo;
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

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
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

        public int getIdcertificateId() {
            return idcertificateId;
        }

        public void setIdcertificateId(int idcertificateId) {
            this.idcertificateId = idcertificateId;
        }

        public static class CertificateDriverBoBean {
            /**
             * id : 1
             * name : 孙勇
             * sex : 1
             * country : 中国
             * isActive : 1
             * createTime : 1596608578000
             * updateTime : 1596872200000
             * address : 北京
             * birthday : 1989-08-10 15:12
             * receiveDate : null
             * classs : null
             * startTime : null
             * term : null
             * fileNumber : 123456
             * note : 驾驶证信息
             * picUrl : null
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
            private Object receiveDate;
            private Object classs;
            private Object startTime;
            private Object term;
            private String fileNumber;
            private String note;
            private String picUrl;
            private String picUrl2;

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

            public Object getReceiveDate() {
                return receiveDate;
            }

            public void setReceiveDate(Object receiveDate) {
                this.receiveDate = receiveDate;
            }

            public Object getClasss() {
                return classs;
            }

            public void setClasss(Object classs) {
                this.classs = classs;
            }

            public Object getStartTime() {
                return startTime;
            }

            public void setStartTime(Object startTime) {
                this.startTime = startTime;
            }

            public Object getTerm() {
                return term;
            }

            public void setTerm(Object term) {
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

            public String getPicUrl2() {
                return picUrl2;
            }

            public void setPicUrl2(String picUrl2) {
                this.picUrl2 = picUrl2;
            }
        }

        public static class CertificateIDBoBean {
            /**
             * id : 1
             * name : 蜀黍
             * six : 0
             * nation : 中国
             * birthDay : 2020-08-26 18:18
             * address : 山东
             * isActive : 1
             * createTime : 1596607560000
             * updateTime : 1596881924000
             * picUrl : null
             * picUrl2 : null
             * file : null
             * file2 : null
             * idno : 3718356965412358521
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
            private String file;
            private String file2;
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

            public String getFile() {
                return file;
            }

            public void setFile(String file) {
                this.file = file;
            }

            public String getFile2() {
                return file2;
            }

            public void setFile2(String file2) {
                this.file2 = file2;
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
             * id : 1
             * name : 孙玉勇
             * sex : 1
             * birthday : 2020-08-12 15:24
             * nationality : 中国
             * address : 北京
             * grantNo : 566233
             * classs : null
             * isActive : 1
             * createTime : 1596609097000
             * updateTime : 1596871505000
             * picUrl : null
             * category : null
             * firstTime : null
             * validityStartTime : null
             * validityEndTime : null
             * fileNumber : null
             */

            private int id;
            private String name;
            private String sex;
            private String birthday;
            private String nationality;
            private String address;
            private String grantNo;
            private Object classs;
            private int isActive;
            private long createTime;
            private long updateTime;
            private String picUrl;
            private Object category;
            private String firstTime;
            private String validityStartTime;
            private String validityEndTime;
            private String fileNumber;

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

            public Object getClasss() {
                return classs;
            }

            public void setClasss(Object classs) {
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

            public Object getCategory() {
                return category;
            }

            public void setCategory(Object category) {
                this.category = category;
            }

            public String getFirstTime() {
                return firstTime;
            }

            public void setFirstTime(String firstTime) {
                this.firstTime = firstTime;
            }

            public String getValidityStartTime() {
                return validityStartTime;
            }

            public void setValidityStartTime(String validityStartTime) {
                this.validityStartTime = validityStartTime;
            }

            public String getValidityEndTime() {
                return validityEndTime;
            }

            public void setValidityEndTime(String validityEndTime) {
                this.validityEndTime = validityEndTime;
            }

            public String getFileNumber() {
                return fileNumber;
            }

            public void setFileNumber(String fileNumber) {
                this.fileNumber = fileNumber;
            }
        }
    }
}
