package com.example.freightmanagement.model;

import com.example.freightmanagement.Base.BaseResponse;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class TrainingListBean extends BaseResponse{

        /**
         * id : 1
         * type : 1
         * content : 1+2
         * createTime : 1596350485000
         * updateTime : 1596350485000
         */

        private int id;
        private int type;
        private String content;
        private long createTime;
        private long updateTime;

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

}
