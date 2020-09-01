package com.example.freightmanagement.Bean;

public class QiYeBean {

    /**
     * code : 0
     * message : 成功
     * data : {"id":5,"name":"","legalPerson":"","signature":"","sealUrl":"","isActive":1,"createTime":null,"updateTime":null,"certificateBusinessId":33,"certificateOperationId":19,"pass":"","tel":"","adminId":131,"certificateIDBo":{"id":418,"name":"张天成","six":"","nation":"","birthDay":"","address":"","isActive":1,"createTime":1598932614000,"updateTime":1598932614000,"picUrl":"https://aicc.ctags.cn/cccc/file/download/8e3849de-b557-4400-8fdf-e6f284600b6a.jpg","picUrl2":"https://aicc.ctags.cn/cccc/file/download/cf70a752-29ae-4661-9b61-e460482dfa30.jpg","driverId":0,"carId":0,"idno":""},"certificateOperationBo":{"id":19,"grantNo":"54646434343616166119191","validityDate":"2050年10月14日","owner":"","address":"","nature":"","scope":"","isActive":1,"updateTime":1598932614000,"createTime":1598932614000,"picUrl":"https://aicc.ctags.cn/cccc/file/download/30634e9b-aa9d-4710-8cd5-1619fe2c8963.jpg","file":null},"certificateBusinessBo":{"id":33,"picUrl":"https://aicc.ctags.cn/cccc/file/download/17443b51-f438-4317-9d7c-b892c80fd4c9.jpg","name":"档正N该正前看限公度","capital":"","type":"","establishmentDate":"无","legalPerson":"张天成","term":"","scope":"r:usin会t注nnH,分有关自北百方可产台营票功!a慢物4,说知台由运验生加挡涉翻得目g式1。","address":"","registrationAuthority":"山名纪造市然疼区梦知道的木喜仔ai164物x如an7-1","isActive":1,"createTime":1598932614000,"updateTime":1598932614000,"file":null},"idcertificateId":418}
     * type : 3
     * token : 2xwSZk8t8/Om2S2MrxBH1xTrjPUTa60g
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
         * id : 5
         * name :
         * legalPerson :
         * signature :
         * sealUrl :
         * isActive : 1
         * createTime : null
         * updateTime : null
         * certificateBusinessId : 33
         * certificateOperationId : 19
         * pass :
         * tel :
         * adminId : 131
         * certificateIDBo : {"id":418,"name":"张天成","six":"","nation":"","birthDay":"","address":"","isActive":1,"createTime":1598932614000,"updateTime":1598932614000,"picUrl":"https://aicc.ctags.cn/cccc/file/download/8e3849de-b557-4400-8fdf-e6f284600b6a.jpg","picUrl2":"https://aicc.ctags.cn/cccc/file/download/cf70a752-29ae-4661-9b61-e460482dfa30.jpg","driverId":0,"carId":0,"idno":""}
         * certificateOperationBo : {"id":19,"grantNo":"54646434343616166119191","validityDate":"2050年10月14日","owner":"","address":"","nature":"","scope":"","isActive":1,"updateTime":1598932614000,"createTime":1598932614000,"picUrl":"https://aicc.ctags.cn/cccc/file/download/30634e9b-aa9d-4710-8cd5-1619fe2c8963.jpg","file":null}
         * certificateBusinessBo : {"id":33,"picUrl":"https://aicc.ctags.cn/cccc/file/download/17443b51-f438-4317-9d7c-b892c80fd4c9.jpg","name":"档正N该正前看限公度","capital":"","type":"","establishmentDate":"无","legalPerson":"张天成","term":"","scope":"r:usin会t注nnH,分有关自北百方可产台营票功!a慢物4,说知台由运验生加挡涉翻得目g式1。","address":"","registrationAuthority":"山名纪造市然疼区梦知道的木喜仔ai164物x如an7-1","isActive":1,"createTime":1598932614000,"updateTime":1598932614000,"file":null}
         * idcertificateId : 418
         */

        private int id;
        private String name;
        private String legalPerson;
        private String signature;
        private String sealUrl;
        private int isActive;
        private Object createTime;
        private Object updateTime;
        private int certificateBusinessId;
        private int certificateOperationId;
        private String pass;
        private String tel;
        private int adminId;
        private CertificateIDBoBean certificateIDBo;
        private CertificateOperationBoBean certificateOperationBo;
        private CertificateBusinessBoBean certificateBusinessBo;
        private int idcertificateId;

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

        public String getLegalPerson() {
            return legalPerson;
        }

        public void setLegalPerson(String legalPerson) {
            this.legalPerson = legalPerson;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getSealUrl() {
            return sealUrl;
        }

        public void setSealUrl(String sealUrl) {
            this.sealUrl = sealUrl;
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

        public int getCertificateBusinessId() {
            return certificateBusinessId;
        }

        public void setCertificateBusinessId(int certificateBusinessId) {
            this.certificateBusinessId = certificateBusinessId;
        }

        public int getCertificateOperationId() {
            return certificateOperationId;
        }

        public void setCertificateOperationId(int certificateOperationId) {
            this.certificateOperationId = certificateOperationId;
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

        public CertificateOperationBoBean getCertificateOperationBo() {
            return certificateOperationBo;
        }

        public void setCertificateOperationBo(CertificateOperationBoBean certificateOperationBo) {
            this.certificateOperationBo = certificateOperationBo;
        }

        public CertificateBusinessBoBean getCertificateBusinessBo() {
            return certificateBusinessBo;
        }

        public void setCertificateBusinessBo(CertificateBusinessBoBean certificateBusinessBo) {
            this.certificateBusinessBo = certificateBusinessBo;
        }

        public int getIdcertificateId() {
            return idcertificateId;
        }

        public void setIdcertificateId(int idcertificateId) {
            this.idcertificateId = idcertificateId;
        }

        public static class CertificateIDBoBean {
            /**
             * id : 418
             * name : 张天成
             * six :
             * nation :
             * birthDay :
             * address :
             * isActive : 1
             * createTime : 1598932614000
             * updateTime : 1598932614000
             * picUrl : https://aicc.ctags.cn/cccc/file/download/8e3849de-b557-4400-8fdf-e6f284600b6a.jpg
             * picUrl2 : https://aicc.ctags.cn/cccc/file/download/cf70a752-29ae-4661-9b61-e460482dfa30.jpg
             * driverId : 0
             * carId : 0
             * idno :
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

            public String getIdno() {
                return idno;
            }

            public void setIdno(String idno) {
                this.idno = idno;
            }
        }

        public static class CertificateOperationBoBean {
            /**
             * id : 19
             * grantNo : 54646434343616166119191
             * validityDate : 2050年10月14日
             * owner :
             * address :
             * nature :
             * scope :
             * isActive : 1
             * updateTime : 1598932614000
             * createTime : 1598932614000
             * picUrl : https://aicc.ctags.cn/cccc/file/download/30634e9b-aa9d-4710-8cd5-1619fe2c8963.jpg
             * file : null
             */

            private int id;
            private String grantNo;
            private String validityDate;
            private String owner;
            private String address;
            private String nature;
            private String scope;
            private int isActive;
            private long updateTime;
            private long createTime;
            private String picUrl;
            private Object file;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getGrantNo() {
                return grantNo;
            }

            public void setGrantNo(String grantNo) {
                this.grantNo = grantNo;
            }

            public String getValidityDate() {
                return validityDate;
            }

            public void setValidityDate(String validityDate) {
                this.validityDate = validityDate;
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

            public String getNature() {
                return nature;
            }

            public void setNature(String nature) {
                this.nature = nature;
            }

            public String getScope() {
                return scope;
            }

            public void setScope(String scope) {
                this.scope = scope;
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

            public Object getFile() {
                return file;
            }

            public void setFile(Object file) {
                this.file = file;
            }
        }

        public static class CertificateBusinessBoBean {
            /**
             * id : 33
             * picUrl : https://aicc.ctags.cn/cccc/file/download/17443b51-f438-4317-9d7c-b892c80fd4c9.jpg
             * name : 档正N该正前看限公度
             * capital :
             * type :
             * establishmentDate : 无
             * legalPerson : 张天成
             * term :
             * scope : r:usin会t注nnH,分有关自北百方可产台营票功!a慢物4,说知台由运验生加挡涉翻得目g式1。
             * address :
             * registrationAuthority : 山名纪造市然疼区梦知道的木喜仔ai164物x如an7-1
             * isActive : 1
             * createTime : 1598932614000
             * updateTime : 1598932614000
             * file : null
             */

            private int id;
            private String picUrl;
            private String name;
            private String capital;
            private String type;
            private String establishmentDate;
            private String legalPerson;
            private String term;
            private String scope;
            private String address;
            private String registrationAuthority;
            private int isActive;
            private long createTime;
            private long updateTime;
            private Object file;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCapital() {
                return capital;
            }

            public void setCapital(String capital) {
                this.capital = capital;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getEstablishmentDate() {
                return establishmentDate;
            }

            public void setEstablishmentDate(String establishmentDate) {
                this.establishmentDate = establishmentDate;
            }

            public String getLegalPerson() {
                return legalPerson;
            }

            public void setLegalPerson(String legalPerson) {
                this.legalPerson = legalPerson;
            }

            public String getTerm() {
                return term;
            }

            public void setTerm(String term) {
                this.term = term;
            }

            public String getScope() {
                return scope;
            }

            public void setScope(String scope) {
                this.scope = scope;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getRegistrationAuthority() {
                return registrationAuthority;
            }

            public void setRegistrationAuthority(String registrationAuthority) {
                this.registrationAuthority = registrationAuthority;
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

            public Object getFile() {
                return file;
            }

            public void setFile(Object file) {
                this.file = file;
            }
        }
    }
}
