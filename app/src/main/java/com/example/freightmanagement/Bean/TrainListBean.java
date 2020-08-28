package com.example.freightmanagement.Bean;

import java.util.List;

public class TrainListBean {


    /**
     * code : 0
     * message : 成功
     * data : [{"id":5,"type":1,"content":"http://aicc.ctags.cn/cccc/file/download/010fd16b-051d-4cdf-b573-63ee62286040.html","isActive":1,"createTime":1597306144000,"updateTime":1597306144000,"file":null},{"id":12,"type":1,"content":"http://aicc.ctags.cn/cccc/file/download/5b2f5357-2ff2-4195-8866-f5bc4cec5455.txt","isActive":1,"createTime":1597329986000,"updateTime":1597329986000,"file":null},{"id":19,"type":2,"content":"http://aicc.ctags.cn/cccc/file/download/086ad680-6422-4deb-89d3-32302eef437.txt","isActive":1,"createTime":1597330315000,"updateTime":1597330315000,"file":null},{"id":26,"type":1,"content":"http://aicc.ctags.cn/cccc/file/download/d8b34fc6-78e0-4e14-8c1a-07ea0b72fc0c.sql","isActive":1,"createTime":1597330341000,"updateTime":1597330341000,"file":null},{"id":33,"type":1,"content":"http://aicc.ctags.cn/cccc/file/download/1eb26f5b-8475-4ad4-acc3-d1f2539cdc27.txt","isActive":1,"createTime":1597330383000,"updateTime":1597330383000,"file":null},{"id":40,"type":1,"content":"http://aicc.ctags.cn/cccc/file/download/ed2a4a13-34c7-4eaa-a37f-aae83c11f2cf.txt","isActive":1,"createTime":1597332124000,"updateTime":1597332124000,"file":null},{"id":47,"type":2,"content":"http://aicc.ctags.cn/cccc/file/download/998a7124-9613-494b-be07-1a8317462ee1.jpg","isActive":1,"createTime":1598521969000,"updateTime":1598521969000,"file":null}]
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
         * id : 5
         * type : 1
         * content : http://aicc.ctags.cn/cccc/file/download/010fd16b-051d-4cdf-b573-63ee62286040.html
         * isActive : 1
         * createTime : 1597306144000
         * updateTime : 1597306144000
         * file : null
         */

        private int id;
        private int type;
        private String content;
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

        public Object getFile() {
            return file;
        }

        public void setFile(Object file) {
            this.file = file;
        }
    }
}
