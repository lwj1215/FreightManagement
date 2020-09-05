package com.example.freightmanagement.Bean;

public class CarInfoBean {


    /**
     * code : 0
     * message : 成功
     * data : {"id":6,"drivingCertificateId":1,"tel":"","transportCertificateId":1,"registrationCertificateId":1,"isActive":1,"createTime":1599290343000,"updateTime":1599290343000,"adminId":13,"enterpriseId":2,"isPass":1,"carOnwerId":0,"certificateDrivingBo":{"id":1,"plateNo":"鲁QW205挂","wchicheType":"重型集装箱半挂车","owner":"","address":"","useCharacter":"非营运","model":"丰田牌Z1V9402TJZA","engineNo":"","registrationDate":"20140411","issueDate":"20161109","fileNo":"3","passengersCount":0,"allWeight":"3","curbWeight":"","approvedWeight":"3","outline":"","tractionWeight":"","note":"","chechRecord":"","isActive":1,"updateTime":1599290342000,"createTime":1599290342000,"picUrl":"https://aicc.ctags.cn/cccc/file/download/5260538a-2bf3-4562-a809-08b62eb93344.jpg","carId":0,"vin":""},"certificateIDBo":null,"certificateTransportBo":{"id":1,"name":"3","address":"","plateNo":"3","licence":"","type":"","weight":"","size":"","scope":"3","grantDate":"2020-09-05","isActive":1,"createTime":1599290343000,"updateTime":1599290343000,"picUrl":"https://aicc.ctags.cn/cccc/file/download/2a09e4d7-43ff-4a45-a7e3-1bf4cde7dc7d.jpg","carId":0},"certificateRegistrationBo":{"id":1,"owner":"述县通达物流有限公司/组织机构代码证书/5343835-","grantName":"","grantNo":"","carType":"半挂牵车C","carBrand":"3","carModel":"A42623E8","carColor":"","carNo":"3","carImportType":"","engineNo":"3","engineType":"","fuelType":"柴油","power":"mLk7","displacement":"mLk7","maker":"解放青岛汽车有限公司前后","turnType":"","tireDistanceAhead":"","tireDistanceHinder":"","tireCount":"3","tireSpecs":"","springsCount":"","wheelbase":"","axlesCount":"","outline":"","inline":"","allWeight":"","curbWeight":"","approvedWeight":"","tractionWeight":"","passengersCount":"1","useNature":"货运","carGetType":"","productionDate":"","issueDate":"2020-09-05","isActive":1,"createTime":1599290342000,"updateTime":1599290342000,"picUrl":"https://aicc.ctags.cn/cccc/file/download/ff8f9082-731f-4202-a9be-c2fe7794e2a6.jpg","carId":0},"enterpriseBo":null,"idcertificateId":0}
     * type : 3
     * token : zgwx+VnqVEshXvVWzQ2EC2BofS4yKQ10
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
         * id : 6
         * drivingCertificateId : 1
         * tel :
         * transportCertificateId : 1
         * registrationCertificateId : 1
         * isActive : 1
         * createTime : 1599290343000
         * updateTime : 1599290343000
         * adminId : 13
         * enterpriseId : 2
         * isPass : 1
         * carOnwerId : 0
         * certificateDrivingBo : {"id":1,"plateNo":"鲁QW205挂","wchicheType":"重型集装箱半挂车","owner":"","address":"","useCharacter":"非营运","model":"丰田牌Z1V9402TJZA","engineNo":"","registrationDate":"20140411","issueDate":"20161109","fileNo":"3","passengersCount":0,"allWeight":"3","curbWeight":"","approvedWeight":"3","outline":"","tractionWeight":"","note":"","chechRecord":"","isActive":1,"updateTime":1599290342000,"createTime":1599290342000,"picUrl":"https://aicc.ctags.cn/cccc/file/download/5260538a-2bf3-4562-a809-08b62eb93344.jpg","carId":0,"vin":""}
         * certificateIDBo : null
         * certificateTransportBo : {"id":1,"name":"3","address":"","plateNo":"3","licence":"","type":"","weight":"","size":"","scope":"3","grantDate":"2020-09-05","isActive":1,"createTime":1599290343000,"updateTime":1599290343000,"picUrl":"https://aicc.ctags.cn/cccc/file/download/2a09e4d7-43ff-4a45-a7e3-1bf4cde7dc7d.jpg","carId":0}
         * certificateRegistrationBo : {"id":1,"owner":"述县通达物流有限公司/组织机构代码证书/5343835-","grantName":"","grantNo":"","carType":"半挂牵车C","carBrand":"3","carModel":"A42623E8","carColor":"","carNo":"3","carImportType":"","engineNo":"3","engineType":"","fuelType":"柴油","power":"mLk7","displacement":"mLk7","maker":"解放青岛汽车有限公司前后","turnType":"","tireDistanceAhead":"","tireDistanceHinder":"","tireCount":"3","tireSpecs":"","springsCount":"","wheelbase":"","axlesCount":"","outline":"","inline":"","allWeight":"","curbWeight":"","approvedWeight":"","tractionWeight":"","passengersCount":"1","useNature":"货运","carGetType":"","productionDate":"","issueDate":"2020-09-05","isActive":1,"createTime":1599290342000,"updateTime":1599290342000,"picUrl":"https://aicc.ctags.cn/cccc/file/download/ff8f9082-731f-4202-a9be-c2fe7794e2a6.jpg","carId":0}
         * enterpriseBo : null
         * idcertificateId : 0
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
        private Object certificateIDBo;
        private CertificateTransportBoBean certificateTransportBo;
        private CertificateRegistrationBoBean certificateRegistrationBo;
        private Object enterpriseBo;
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

        public Object getCertificateIDBo() {
            return certificateIDBo;
        }

        public void setCertificateIDBo(Object certificateIDBo) {
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

        public Object getEnterpriseBo() {
            return enterpriseBo;
        }

        public void setEnterpriseBo(Object enterpriseBo) {
            this.enterpriseBo = enterpriseBo;
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
             * plateNo : 鲁QW205挂
             * wchicheType : 重型集装箱半挂车
             * owner :
             * address :
             * useCharacter : 非营运
             * model : 丰田牌Z1V9402TJZA
             * engineNo :
             * registrationDate : 20140411
             * issueDate : 20161109
             * fileNo : 3
             * passengersCount : 0
             * allWeight : 3
             * curbWeight :
             * approvedWeight : 3
             * outline :
             * tractionWeight :
             * note :
             * chechRecord :
             * isActive : 1
             * updateTime : 1599290342000
             * createTime : 1599290342000
             * picUrl : https://aicc.ctags.cn/cccc/file/download/5260538a-2bf3-4562-a809-08b62eb93344.jpg
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

        public static class CertificateTransportBoBean {
            /**
             * id : 1
             * name : 3
             * address :
             * plateNo : 3
             * licence :
             * type :
             * weight :
             * size :
             * scope : 3
             * grantDate : 2020-09-05
             * isActive : 1
             * createTime : 1599290343000
             * updateTime : 1599290343000
             * picUrl : https://aicc.ctags.cn/cccc/file/download/2a09e4d7-43ff-4a45-a7e3-1bf4cde7dc7d.jpg
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

        public static class CertificateRegistrationBoBean {
            /**
             * id : 1
             * owner : 述县通达物流有限公司/组织机构代码证书/5343835-
             * grantName :
             * grantNo :
             * carType : 半挂牵车C
             * carBrand : 3
             * carModel : A42623E8
             * carColor :
             * carNo : 3
             * carImportType :
             * engineNo : 3
             * engineType :
             * fuelType : 柴油
             * power : mLk7
             * displacement : mLk7
             * maker : 解放青岛汽车有限公司前后
             * turnType :
             * tireDistanceAhead :
             * tireDistanceHinder :
             * tireCount : 3
             * tireSpecs :
             * springsCount :
             * wheelbase :
             * axlesCount :
             * outline :
             * inline :
             * allWeight :
             * curbWeight :
             * approvedWeight :
             * tractionWeight :
             * passengersCount : 1
             * useNature : 货运
             * carGetType :
             * productionDate :
             * issueDate : 2020-09-05
             * isActive : 1
             * createTime : 1599290342000
             * updateTime : 1599290342000
             * picUrl : https://aicc.ctags.cn/cccc/file/download/ff8f9082-731f-4202-a9be-c2fe7794e2a6.jpg
             * carId : 0
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
