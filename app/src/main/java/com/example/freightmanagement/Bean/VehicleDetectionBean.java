package com.example.freightmanagement.Bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VehicleDetectionBean {

    /**
     * code : 0
     * message : 成功
     * data : {"1":[{"id":5,"item":"转向","isActive":1,"createTime":null,"updateTime":null},{"id":12,"item":"制动","isActive":1,"createTime":null,"updateTime":null},{"id":19,"item":"灯光","isActive":1,"createTime":null,"updateTime":null},{"id":26,"item":"刮水器","isActive":1,"createTime":null,"updateTime":null},{"id":33,"item":"轮胎","isActive":1,"createTime":null,"updateTime":null}],"2":[{"id":5,"item":"转向","isActive":1,"createTime":null,"updateTime":null},{"id":12,"item":"制动","isActive":1,"createTime":null,"updateTime":null},{"id":19,"item":"灯光","isActive":1,"createTime":null,"updateTime":null},{"id":26,"item":"刮水器","isActive":1,"createTime":null,"updateTime":null},{"id":33,"item":"轮胎","isActive":1,"createTime":null,"updateTime":null}],"3":[{"id":5,"item":"转向","isActive":1,"createTime":null,"updateTime":null},{"id":12,"item":"制动","isActive":1,"createTime":null,"updateTime":null},{"id":19,"item":"灯光","isActive":1,"createTime":null,"updateTime":null},{"id":26,"item":"刮水器","isActive":1,"createTime":null,"updateTime":null},{"id":33,"item":"轮胎","isActive":1,"createTime":null,"updateTime":null}]}
     * type : 1
     * token : zgGyZA534qmhrZ/+Q+jH1T3yl7fNb+dY
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
        @SerializedName("1")
        private List<Type1Bean> type1;
        @SerializedName("2")
        private List<Type2Bean> type2;
        @SerializedName("3")
        private List<Type3Bean> type3;

        public List<Type1Bean> getType1() {
            return type1;
        }

        public void setType1(List<Type1Bean> type1) {
            this.type1 = type1;
        }

        public List<Type2Bean> getType2() {
            return type2;
        }

        public void setType2(List<Type2Bean> type2) {
            this.type2 = type2;
        }

        public List<Type3Bean> getType3() {
            return type3;
        }

        public void setType3(List<Type3Bean> type3) {
            this.type3 = type3;
        }

        public static class Type1Bean {
            /**
             * id : 5
             * item : 转向
             * isActive : 1
             * createTime : null
             * updateTime : null
             */

            private int id;
            private String item;
            private int isActive;
            private Object createTime;
            private Object updateTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getItem() {
                return item;
            }

            public void setItem(String item) {
                this.item = item;
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
        }

        public static class Type2Bean {
            /**
             * id : 5
             * item : 转向
             * isActive : 1
             * createTime : null
             * updateTime : null
             */

            private int id;
            private String item;
            private int isActive;
            private Object createTime;
            private Object updateTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getItem() {
                return item;
            }

            public void setItem(String item) {
                this.item = item;
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
        }

        public static class Type3Bean {
            /**
             * id : 5
             * item : 转向
             * isActive : 1
             * createTime : null
             * updateTime : null
             */

            private int id;
            private String item;
            private int isActive;
            private Object createTime;
            private Object updateTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getItem() {
                return item;
            }

            public void setItem(String item) {
                this.item = item;
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
        }
    }
}
