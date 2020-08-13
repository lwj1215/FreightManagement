package com.example.freightmanagement.Bean;

import java.util.List;

public class TrainingSelectBean {

    /**
     * code : 0
     * message : 成功
     * data : [{"id":1,"type":1,"content":"1+2+3+4","isActive":1,"createTime":1596427338000,"updateTime":1597206408000,"options":"A:1 B:2 C:3 D:10","rightKey":null},{"id":5,"type":2,"content":"奥术大师","isActive":1,"createTime":1597041288000,"updateTime":1597150413000,"options":"正确  不正确","rightKey":null},{"id":2,"type":1,"content":"1+2","isActive":0,"createTime":1596534343000,"updateTime":1597139877000,"options":"11111","rightKey":null}]
     */

    private int code;
    private String message;
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * type : 1
         * content : 1+2+3+4
         * isActive : 1
         * createTime : 1596427338000
         * updateTime : 1597206408000
         * options : A:1 B:2 C:3 D:10
         * rightKey : null
         */

        private int id;
        private int type;
        private String content;
        private int isActive;
        private long createTime;
        private long updateTime;
        private String options;
        private Object rightKey;

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
    }
}
