package com.example.freightmanagement.Bean;

public class CheliangBean {

    /**
     * code : 0
     * message : 成功
     * data : {"id":1,"drivingCertificateId":1,"tel":"1","transportCertificateId":1,"registrationCertificateId":1,"isActive":1,"createTime":null,"updateTime":null,"name":"1","pass":"1","adminId":2,"enterpriseId":1,"isPass":1,"certificateDrivingBo":{"id":1,"plateNo":"行车证1102003003666","wchicheType":"1","owner":"汪凯","address":"1","useCharacter":"运货","model":"1","engineNo":"100030","registrationDate":"1","issueDate":"1","fileNo":"1","passengersCount":122,"allWeight":"1","curbWeight":"1","approvedWeight":"1","outline":"1","tractionWeight":"1","note":"1","chechRecord":"1","isActive":1,"updateTime":1597805951000,"createTime":null,"picUrl":"1","file":null,"vin":"1"},"certificateIDBo":{"id":1,"name":"李思","six":"0","nation":"中国","birthDay":"2020-08-20 10:01","address":"山东","isActive":1,"createTime":null,"updateTime":1597805972000,"picUrl":"1","picUrl2":"1","file":null,"file2":null,"idno":"车主1102003003666"},"certificateTransportBo":{"id":1,"name":"北京时尚呢供应123","address":"海淀西北旺","plateNo":"运输证10259685222122666","licence":"1","type":"货车","weight":"1000吨","size":"2000*233*965","scope":"全国123","grantDate":"2020-06-12","isActive":1,"createTime":1597805868000,"updateTime":1597807654000,"picUrl":"1","file":null},"certificateRegistrationBo":{"id":1,"owner":"张三","grantName":"车辆登记证","grantNo":"登记证110231196811095687","carType":"小车","carBrand":"奔驰","carModel":"WKJOIIO90-200352","carColor":"黑色","carNo":"300255cjh-op0","carImportType":"国产","engineNo":"100030","engineType":"100265","fuelType":"30025","power":"3000","displacement":"2000","maker":"时风集团","turnType":"方向盘","tireDistanceAhead":"12","tireDistanceHinder":"113","tireCount":"4","tireSpecs":"12","springsCount":"12","wheelbase":"50","axlesCount":"4","outline":"100*100*200*300","inline":"600*966*899*7411","allWeight":"1000","curbWeight":"100","approvedWeight":"10000","tractionWeight":"100","passengersCount":"6","useNature":"拉人","carGetType":"买","productionDate":"2020-02-05","issueDate":"2020-05-06","isActive":1,"createTime":null,"updateTime":1597805961000,"picUrl":"1","file":null},"idcertificateId":1}
     * type : 1
     * token : 2ojd68KkJQKJHEVx2TbBXz3yl7fNb+dY
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
         * id : 1
         * drivingCertificateId : 1
         * tel : 1
         * transportCertificateId : 1
         * registrationCertificateId : 1
         * isActive : 1
         * createTime : null
         * updateTime : null
         * name : 1
         * pass : 1
         * adminId : 2
         * enterpriseId : 1
         * isPass : 1
         * certificateDrivingBo : {"id":1,"plateNo":"行车证1102003003666","wchicheType":"1","owner":"汪凯","address":"1","useCharacter":"运货","model":"1","engineNo":"100030","registrationDate":"1","issueDate":"1","fileNo":"1","passengersCount":122,"allWeight":"1","curbWeight":"1","approvedWeight":"1","outline":"1","tractionWeight":"1","note":"1","chechRecord":"1","isActive":1,"updateTime":1597805951000,"createTime":null,"picUrl":"1","file":null,"vin":"1"}
         * certificateIDBo : {"id":1,"name":"李思","six":"0","nation":"中国","birthDay":"2020-08-20 10:01","address":"山东","isActive":1,"createTime":null,"updateTime":1597805972000,"picUrl":"1","picUrl2":"1","file":null,"file2":null,"idno":"车主1102003003666"}
         * certificateTransportBo : {"id":1,"name":"北京时尚呢供应123","address":"海淀西北旺","plateNo":"运输证10259685222122666","licence":"1","type":"货车","weight":"1000吨","size":"2000*233*965","scope":"全国123","grantDate":"2020-06-12","isActive":1,"createTime":1597805868000,"updateTime":1597807654000,"picUrl":"1","file":null}
         * certificateRegistrationBo : {"id":1,"owner":"张三","grantName":"车辆登记证","grantNo":"登记证110231196811095687","carType":"小车","carBrand":"奔驰","carModel":"WKJOIIO90-200352","carColor":"黑色","carNo":"300255cjh-op0","carImportType":"国产","engineNo":"100030","engineType":"100265","fuelType":"30025","power":"3000","displacement":"2000","maker":"时风集团","turnType":"方向盘","tireDistanceAhead":"12","tireDistanceHinder":"113","tireCount":"4","tireSpecs":"12","springsCount":"12","wheelbase":"50","axlesCount":"4","outline":"100*100*200*300","inline":"600*966*899*7411","allWeight":"1000","curbWeight":"100","approvedWeight":"10000","tractionWeight":"100","passengersCount":"6","useNature":"拉人","carGetType":"买","productionDate":"2020-02-05","issueDate":"2020-05-06","isActive":1,"createTime":null,"updateTime":1597805961000,"picUrl":"1","file":null}
         * idcertificateId : 1
         */

        private int id;
        private int drivingCertificateId;
        private String tel;
        private int transportCertificateId;
        private int registrationCertificateId;
        private int isActive;
        private Object createTime;
        private Object updateTime;
        private String name;
        private String pass;
        private int adminId;
        private int enterpriseId;
        private int isPass;
        private CertificateDrivingBoBean certificateDrivingBo;
        private CertificateIDBoBean certificateIDBo;
        private CertificateTransportBoBean certificateTransportBo;
        private CertificateRegistrationBoBean certificateRegistrationBo;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
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

        public CertificateDrivingBoBean getCertificateDrivingBo() {
            return certificateDrivingBo;
        }

        public void setCertificateDrivingBo(CertificateDrivingBoBean certificateDrivingBo) {
            this.certificateDrivingBo = certificateDrivingBo;
        }

        public CertificateIDBoBean getCertificateIDBo() {
            return certificateIDBo;
        }

        public void setCertificateIDBo(CertificateIDBoBean certificateIDBo) {
            this.certificateIDBo = certificateIDBo;
        }

        public CertificateTransportBoBean getCertificateTransportBo() {
            return certificateTransportBo;
        }

        public void setCertificateTransportBo(CertificateTransportBoBean certificateTransportBo) {
            this.certificateTransportBo = certificateTransportBo;
        }

        public CertificateRegistrationBoBean getCertificateRegistrationBo() {
            return certificateRegistrationBo;
        }

        public void setCertificateRegistrationBo(CertificateRegistrationBoBean certificateRegistrationBo) {
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
             * id : 1
             * plateNo : 行车证1102003003666
             * wchicheType : 1
             * owner : 汪凯
             * address : 1
             * useCharacter : 运货
             * model : 1
             * engineNo : 100030
             * registrationDate : 1
             * issueDate : 1
             * fileNo : 1
             * passengersCount : 122
             * allWeight : 1
             * curbWeight : 1
             * approvedWeight : 1
             * outline : 1
             * tractionWeight : 1
             * note : 1
             * chechRecord : 1
             * isActive : 1
             * updateTime : 1597805951000
             * createTime : null
             * picUrl : 1
             * file : null
             * vin : 1
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
            private Object createTime;
            private String picUrl;
            private Object file;
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

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
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

            public String getVin() {
                return vin;
            }

            public void setVin(String vin) {
                this.vin = vin;
            }
        }

        public static class CertificateIDBoBean {
            /**
             * id : 1
             * name : 李思
             * six : 0
             * nation : 中国
             * birthDay : 2020-08-20 10:01
             * address : 山东
             * isActive : 1
             * createTime : null
             * updateTime : 1597805972000
             * picUrl : 1
             * picUrl2 : 1
             * file : null
             * file2 : null
             * idno : 车主1102003003666
             */

            private int id;
            private String name;
            private String six;
            private String nation;
            private String birthDay;
            private String address;
            private int isActive;
            private Object createTime;
            private long updateTime;
            private String picUrl;
            private String picUrl2;
            private Object file;
            private Object file2;
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

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
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

            public Object getFile() {
                return file;
            }

            public void setFile(Object file) {
                this.file = file;
            }

            public Object getFile2() {
                return file2;
            }

            public void setFile2(Object file2) {
                this.file2 = file2;
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
             * id : 1
             * name : 北京时尚呢供应123
             * address : 海淀西北旺
             * plateNo : 运输证10259685222122666
             * licence : 1
             * type : 货车
             * weight : 1000吨
             * size : 2000*233*965
             * scope : 全国123
             * grantDate : 2020-06-12
             * isActive : 1
             * createTime : 1597805868000
             * updateTime : 1597807654000
             * picUrl : 1
             * file : null
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
            private Object file;

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

            public Object getFile() {
                return file;
            }

            public void setFile(Object file) {
                this.file = file;
            }
        }

        public static class CertificateRegistrationBoBean {
            /**
             * id : 1
             * owner : 张三
             * grantName : 车辆登记证
             * grantNo : 登记证110231196811095687
             * carType : 小车
             * carBrand : 奔驰
             * carModel : WKJOIIO90-200352
             * carColor : 黑色
             * carNo : 300255cjh-op0
             * carImportType : 国产
             * engineNo : 100030
             * engineType : 100265
             * fuelType : 30025
             * power : 3000
             * displacement : 2000
             * maker : 时风集团
             * turnType : 方向盘
             * tireDistanceAhead : 12
             * tireDistanceHinder : 113
             * tireCount : 4
             * tireSpecs : 12
             * springsCount : 12
             * wheelbase : 50
             * axlesCount : 4
             * outline : 100*100*200*300
             * inline : 600*966*899*7411
             * allWeight : 1000
             * curbWeight : 100
             * approvedWeight : 10000
             * tractionWeight : 100
             * passengersCount : 6
             * useNature : 拉人
             * carGetType : 买
             * productionDate : 2020-02-05
             * issueDate : 2020-05-06
             * isActive : 1
             * createTime : null
             * updateTime : 1597805961000
             * picUrl : 1
             * file : null
             */

            private int id;
            private String owner;
            private String grantName;
            private String grantNo;
            private String carType;
            private String carBrand;
            private String carModel;
            private String carColor;
            private String carNo;
            private String carImportType;
            private String engineNo;
            private String engineType;
            private String fuelType;
            private String power;
            private String displacement;
            private String maker;
            private String turnType;
            private String tireDistanceAhead;
            private String tireDistanceHinder;
            private String tireCount;
            private String tireSpecs;
            private String springsCount;
            private String wheelbase;
            private String axlesCount;
            private String outline;
            private String inline;
            private String allWeight;
            private String curbWeight;
            private String approvedWeight;
            private String tractionWeight;
            private String passengersCount;
            private String useNature;
            private String carGetType;
            private String productionDate;
            private String issueDate;
            private int isActive;
            private Object createTime;
            private long updateTime;
            private String picUrl;
            private Object file;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getOwner() {
                return owner;
            }

            public void setOwner(String owner) {
                this.owner = owner;
            }

            public String getGrantName() {
                return grantName;
            }

            public void setGrantName(String grantName) {
                this.grantName = grantName;
            }

            public String getGrantNo() {
                return grantNo;
            }

            public void setGrantNo(String grantNo) {
                this.grantNo = grantNo;
            }

            public String getCarType() {
                return carType;
            }

            public void setCarType(String carType) {
                this.carType = carType;
            }

            public String getCarBrand() {
                return carBrand;
            }

            public void setCarBrand(String carBrand) {
                this.carBrand = carBrand;
            }

            public String getCarModel() {
                return carModel;
            }

            public void setCarModel(String carModel) {
                this.carModel = carModel;
            }

            public String getCarColor() {
                return carColor;
            }

            public void setCarColor(String carColor) {
                this.carColor = carColor;
            }

            public String getCarNo() {
                return carNo;
            }

            public void setCarNo(String carNo) {
                this.carNo = carNo;
            }

            public String getCarImportType() {
                return carImportType;
            }

            public void setCarImportType(String carImportType) {
                this.carImportType = carImportType;
            }

            public String getEngineNo() {
                return engineNo;
            }

            public void setEngineNo(String engineNo) {
                this.engineNo = engineNo;
            }

            public String getEngineType() {
                return engineType;
            }

            public void setEngineType(String engineType) {
                this.engineType = engineType;
            }

            public String getFuelType() {
                return fuelType;
            }

            public void setFuelType(String fuelType) {
                this.fuelType = fuelType;
            }

            public String getPower() {
                return power;
            }

            public void setPower(String power) {
                this.power = power;
            }

            public String getDisplacement() {
                return displacement;
            }

            public void setDisplacement(String displacement) {
                this.displacement = displacement;
            }

            public String getMaker() {
                return maker;
            }

            public void setMaker(String maker) {
                this.maker = maker;
            }

            public String getTurnType() {
                return turnType;
            }

            public void setTurnType(String turnType) {
                this.turnType = turnType;
            }

            public String getTireDistanceAhead() {
                return tireDistanceAhead;
            }

            public void setTireDistanceAhead(String tireDistanceAhead) {
                this.tireDistanceAhead = tireDistanceAhead;
            }

            public String getTireDistanceHinder() {
                return tireDistanceHinder;
            }

            public void setTireDistanceHinder(String tireDistanceHinder) {
                this.tireDistanceHinder = tireDistanceHinder;
            }

            public String getTireCount() {
                return tireCount;
            }

            public void setTireCount(String tireCount) {
                this.tireCount = tireCount;
            }

            public String getTireSpecs() {
                return tireSpecs;
            }

            public void setTireSpecs(String tireSpecs) {
                this.tireSpecs = tireSpecs;
            }

            public String getSpringsCount() {
                return springsCount;
            }

            public void setSpringsCount(String springsCount) {
                this.springsCount = springsCount;
            }

            public String getWheelbase() {
                return wheelbase;
            }

            public void setWheelbase(String wheelbase) {
                this.wheelbase = wheelbase;
            }

            public String getAxlesCount() {
                return axlesCount;
            }

            public void setAxlesCount(String axlesCount) {
                this.axlesCount = axlesCount;
            }

            public String getOutline() {
                return outline;
            }

            public void setOutline(String outline) {
                this.outline = outline;
            }

            public String getInline() {
                return inline;
            }

            public void setInline(String inline) {
                this.inline = inline;
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

            public String getTractionWeight() {
                return tractionWeight;
            }

            public void setTractionWeight(String tractionWeight) {
                this.tractionWeight = tractionWeight;
            }

            public String getPassengersCount() {
                return passengersCount;
            }

            public void setPassengersCount(String passengersCount) {
                this.passengersCount = passengersCount;
            }

            public String getUseNature() {
                return useNature;
            }

            public void setUseNature(String useNature) {
                this.useNature = useNature;
            }

            public String getCarGetType() {
                return carGetType;
            }

            public void setCarGetType(String carGetType) {
                this.carGetType = carGetType;
            }

            public String getProductionDate() {
                return productionDate;
            }

            public void setProductionDate(String productionDate) {
                this.productionDate = productionDate;
            }

            public String getIssueDate() {
                return issueDate;
            }

            public void setIssueDate(String issueDate) {
                this.issueDate = issueDate;
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

            public Object getFile() {
                return file;
            }

            public void setFile(Object file) {
                this.file = file;
            }
        }
    }
}
