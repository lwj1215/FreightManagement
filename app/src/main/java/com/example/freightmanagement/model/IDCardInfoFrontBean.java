package com.example.freightmanagement.model;

/**
 * Created by Administrator on 2020/8/9.
 */

public class IDCardInfoFrontBean {

    /**
     * address : {"location":{"height":78,"left":238,"top":368,"width":359},"words":"河南省淇县高村镇花庄未六路13号"}
     * birthday : {"location":{"height":28,"left":240,"top":296,"width":240},"words":"19960321"}
     * direction : 0
     * ethnic : {"location":{"height":27,"left":413,"top":231,"width":23},"words":"汉"}
     * gender : {"location":{"height":28,"left":243,"top":233,"width":22},"words":"男"}
     * idCardSide : front
     * idNumber : {"location":{"height":34,"left":376,"top":545,"width":480},"words":"41062219960321201X"}
     * imageStatus : normal
     * name : {"location":{"height":35,"left":242,"top":158,"width":109},"words":"宋德川"}
     * riskType :
     * wordsResultNumber : 6
     * jsonRes : {"direction": 0, "log_id": 3911265521396470185, "words_result_num": 6, "words_result": {"住址": {"location": {"width": 359, "top": 368, "left": 238, "height": 78}, "words": "河南省淇县高村镇花庄未六路13号"}, "出生": {"location": {"width": 240, "top": 296, "left": 240, "height": 28}, "words": "19960321"}, "姓名": {"location": {"width": 109, "top": 158, "left": 242, "height": 35}, "words": "宋德川"}, "公民身份号码": {"location": {"width": 480, "top": 545, "left": 376, "height": 34}, "words": "41062219960321201X"}, "性别": {"location": {"width": 22, "top": 233, "left": 243, "height": 28}, "words": "男"}, "民族": {"location": {"width": 23, "top": 231, "left": 413, "height": 27}, "words": "汉"}}, "image_status": "normal", "idcard_number_type": 1}
     * logId : 3911265521396470185
     */

    private AddressBean address;
    private BirthdayBean birthday;
    private int direction;
    private EthnicBean ethnic;
    private GenderBean gender;
    private String idCardSide;
    private IdNumberBean idNumber;
    private String imageStatus;
    private NameBean name;
    private String riskType;
    private int wordsResultNumber;
    private String jsonRes;
    private long logId;

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

    public BirthdayBean getBirthday() {
        return birthday;
    }

    public void setBirthday(BirthdayBean birthday) {
        this.birthday = birthday;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public EthnicBean getEthnic() {
        return ethnic;
    }

    public void setEthnic(EthnicBean ethnic) {
        this.ethnic = ethnic;
    }

    public GenderBean getGender() {
        return gender;
    }

    public void setGender(GenderBean gender) {
        this.gender = gender;
    }

    public String getIdCardSide() {
        return idCardSide;
    }

    public void setIdCardSide(String idCardSide) {
        this.idCardSide = idCardSide;
    }

    public IdNumberBean getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(IdNumberBean idNumber) {
        this.idNumber = idNumber;
    }

    public String getImageStatus() {
        return imageStatus;
    }

    public void setImageStatus(String imageStatus) {
        this.imageStatus = imageStatus;
    }

    public NameBean getName() {
        return name;
    }

    public void setName(NameBean name) {
        this.name = name;
    }

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    public int getWordsResultNumber() {
        return wordsResultNumber;
    }

    public void setWordsResultNumber(int wordsResultNumber) {
        this.wordsResultNumber = wordsResultNumber;
    }

    public String getJsonRes() {
        return jsonRes;
    }

    public void setJsonRes(String jsonRes) {
        this.jsonRes = jsonRes;
    }

    public long getLogId() {
        return logId;
    }

    public void setLogId(long logId) {
        this.logId = logId;
    }

    public static class AddressBean {
        /**
         * location : {"height":78,"left":238,"top":368,"width":359}
         * words : 河南省淇县高村镇花庄未六路13号
         */

        private LocationBean location;
        private String words;

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }

        public static class LocationBean {
            /**
             * height : 78
             * left : 238
             * top : 368
             * width : 359
             */

            private int height;
            private int left;
            private int top;
            private int width;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getLeft() {
                return left;
            }

            public void setLeft(int left) {
                this.left = left;
            }

            public int getTop() {
                return top;
            }

            public void setTop(int top) {
                this.top = top;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }
        }
    }

    public static class BirthdayBean {
        /**
         * location : {"height":28,"left":240,"top":296,"width":240}
         * words : 19960321
         */

        private LocationBeanX location;
        private String words;

        public LocationBeanX getLocation() {
            return location;
        }

        public void setLocation(LocationBeanX location) {
            this.location = location;
        }

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }

        public static class LocationBeanX {
            /**
             * height : 28
             * left : 240
             * top : 296
             * width : 240
             */

            private int height;
            private int left;
            private int top;
            private int width;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getLeft() {
                return left;
            }

            public void setLeft(int left) {
                this.left = left;
            }

            public int getTop() {
                return top;
            }

            public void setTop(int top) {
                this.top = top;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }
        }
    }

    public static class EthnicBean {
        /**
         * location : {"height":27,"left":413,"top":231,"width":23}
         * words : 汉
         */

        private LocationBeanXX location;
        private String words;

        public LocationBeanXX getLocation() {
            return location;
        }

        public void setLocation(LocationBeanXX location) {
            this.location = location;
        }

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }

        public static class LocationBeanXX {
            /**
             * height : 27
             * left : 413
             * top : 231
             * width : 23
             */

            private int height;
            private int left;
            private int top;
            private int width;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getLeft() {
                return left;
            }

            public void setLeft(int left) {
                this.left = left;
            }

            public int getTop() {
                return top;
            }

            public void setTop(int top) {
                this.top = top;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }
        }
    }

    public static class GenderBean {
        /**
         * location : {"height":28,"left":243,"top":233,"width":22}
         * words : 男
         */

        private LocationBeanXXX location;
        private String words;

        public LocationBeanXXX getLocation() {
            return location;
        }

        public void setLocation(LocationBeanXXX location) {
            this.location = location;
        }

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }

        public static class LocationBeanXXX {
            /**
             * height : 28
             * left : 243
             * top : 233
             * width : 22
             */

            private int height;
            private int left;
            private int top;
            private int width;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getLeft() {
                return left;
            }

            public void setLeft(int left) {
                this.left = left;
            }

            public int getTop() {
                return top;
            }

            public void setTop(int top) {
                this.top = top;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }
        }
    }

    public static class IdNumberBean {
        /**
         * location : {"height":34,"left":376,"top":545,"width":480}
         * words : 41062219960321201X
         */

        private LocationBeanXXXX location;
        private String words;

        public LocationBeanXXXX getLocation() {
            return location;
        }

        public void setLocation(LocationBeanXXXX location) {
            this.location = location;
        }

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }

        public static class LocationBeanXXXX {
            /**
             * height : 34
             * left : 376
             * top : 545
             * width : 480
             */

            private int height;
            private int left;
            private int top;
            private int width;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getLeft() {
                return left;
            }

            public void setLeft(int left) {
                this.left = left;
            }

            public int getTop() {
                return top;
            }

            public void setTop(int top) {
                this.top = top;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }
        }
    }

    public static class NameBean {
        /**
         * location : {"height":35,"left":242,"top":158,"width":109}
         * words : 宋德川
         */

        private LocationBeanXXXXX location;
        private String words;

        public LocationBeanXXXXX getLocation() {
            return location;
        }

        public void setLocation(LocationBeanXXXXX location) {
            this.location = location;
        }

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }

        public static class LocationBeanXXXXX {
            /**
             * height : 35
             * left : 242
             * top : 158
             * width : 109
             */

            private int height;
            private int left;
            private int top;
            private int width;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getLeft() {
                return left;
            }

            public void setLeft(int left) {
                this.left = left;
            }

            public int getTop() {
                return top;
            }

            public void setTop(int top) {
                this.top = top;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }
        }
    }
}
