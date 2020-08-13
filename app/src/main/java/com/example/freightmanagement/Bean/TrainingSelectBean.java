package com.example.freightmanagement.Bean;

import java.util.List;

public class TrainingSelectBean {

    /**
     * code : 0
     * message : 成功
     * data : [{"id":12,"type":2,"content":"1+1等于2","isActive":1,"createTime":1597305869000,"updateTime":1597305869000,"options":"A:正确,B:错误","rightKey":null,"file":null,"index":1,"optionsMap":{"A":"正确","B":"错误"}},{"id":5,"type":1,"content":"1加1等于几","isActive":1,"createTime":1597305798000,"updateTime":1597305798000,"options":"A:2,B:3","rightKey":null,"file":null,"index":2,"optionsMap":{"A":"2","B":"3"}}]
     * type : 1
     * token : 2ojd68KkJQKJHEVx2TbBXz3yl7fNb+dY
     */

    private int code;
    private String message;
    private String type;
    private String token;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 12
         * type : 2
         * content : 1+1等于2
         * isActive : 1
         * createTime : 1597305869000
         * updateTime : 1597305869000
         * options : A:正确,B:错误
         * rightKey : null
         * file : null
         * index : 1
         * optionsMap : {"A":"正确","B":"错误"}
         */

        private int id;
        private int type;
        private String content;
        private int isActive;
        private long createTime;
        private long updateTime;
        private String options;
        private Object rightKey;
        private Object file;
        private int index;
        private OptionsMapBean optionsMap;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
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

        public String getOptions() {
            return options;
        }

        public void setOptions(String options) {
            this.options = options;
        }

        public Object getRightKey() {
            return rightKey;
        }

        public void setRightKey(Object rightKey) {
            this.rightKey = rightKey;
        }

        public Object getFile() {
            return file;
        }

        public void setFile(Object file) {
            this.file = file;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public OptionsMapBean getOptionsMap() {
            return optionsMap;
        }

        public void setOptionsMap(OptionsMapBean optionsMap) {
            this.optionsMap = optionsMap;
        }

        public static class OptionsMapBean {
            /**
             * A : 正确
             * B : 错误
             */

            private String A;
            private String B;

            public String getA() {
                return A;
            }

            public void setA(String A) {
                this.A = A;
            }

            public String getB() {
                return B;
            }

            public void setB(String B) {
                this.B = B;
            }
        }
    }
}
