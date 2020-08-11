package com.example.freightmanagement.Bean;

import java.util.List;

public class DriverInformationBean {


    /**
     * code : 0
     * message : 成功
     * data : {"id":2,"dirverId":1,"score":null,"isPass":0,"isActive":1,"createTime":1596622919000,"updateTime":1596622919000,"driverDataBos":[{"id":1,"driverId":1,"examinationDataId":1,"isRight":0,"answer":"answer","isActive":1,"createTime":1596622919000,"updateTime":1596622919000,"examinationDriverScoreId":2,"examinationDataBo":{"id":1,"type":2,"content":"1+2+3+4","isActive":1,"createTime":1596427338000,"updateTime":1597041280000,"options":"111111","rightKey":"的"}}]}
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
         * id : 2
         * dirverId : 1
         * score : null
         * isPass : 0
         * isActive : 1
         * createTime : 1596622919000
         * updateTime : 1596622919000
         * driverDataBos : [{"id":1,"driverId":1,"examinationDataId":1,"isRight":0,"answer":"answer","isActive":1,"createTime":1596622919000,"updateTime":1596622919000,"examinationDriverScoreId":2,"examinationDataBo":{"id":1,"type":2,"content":"1+2+3+4","isActive":1,"createTime":1596427338000,"updateTime":1597041280000,"options":"111111","rightKey":"的"}}]
         */

        private int id;
        private int dirverId;
        private String score;
        private int isPass;
        private int isActive;
        private long createTime;
        private long updateTime;
        private List<DriverDataBosBean> driverDataBos;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getDirverId() {
            return dirverId;
        }

        public void setDirverId(int dirverId) {
            this.dirverId = dirverId;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public int getIsPass() {
            return isPass;
        }

        public void setIsPass(int isPass) {
            this.isPass = isPass;
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

        public List<DriverDataBosBean> getDriverDataBos() {
            return driverDataBos;
        }

        public void setDriverDataBos(List<DriverDataBosBean> driverDataBos) {
            this.driverDataBos = driverDataBos;
        }

        public static class DriverDataBosBean {
            /**
             * id : 1
             * driverId : 1
             * examinationDataId : 1
             * isRight : 0
             * answer : answer
             * isActive : 1
             * createTime : 1596622919000
             * updateTime : 1596622919000
             * examinationDriverScoreId : 2
             * examinationDataBo : {"id":1,"type":2,"content":"1+2+3+4","isActive":1,"createTime":1596427338000,"updateTime":1597041280000,"options":"111111","rightKey":"的"}
             */

            private int id;
            private int driverId;
            private int examinationDataId;
            private int isRight;
            private String answer;
            private int isActive;
            private long createTime;
            private long updateTime;
            private int examinationDriverScoreId;
            private ExaminationDataBoBean examinationDataBo;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getDriverId() {
                return driverId;
            }

            public void setDriverId(int driverId) {
                this.driverId = driverId;
            }

            public int getExaminationDataId() {
                return examinationDataId;
            }

            public void setExaminationDataId(int examinationDataId) {
                this.examinationDataId = examinationDataId;
            }

            public int getIsRight() {
                return isRight;
            }

            public void setIsRight(int isRight) {
                this.isRight = isRight;
            }

            public String getAnswer() {
                return answer;
            }

            public void setAnswer(String answer) {
                this.answer = answer;
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

            public int getExaminationDriverScoreId() {
                return examinationDriverScoreId;
            }

            public void setExaminationDriverScoreId(int examinationDriverScoreId) {
                this.examinationDriverScoreId = examinationDriverScoreId;
            }

            public ExaminationDataBoBean getExaminationDataBo() {
                return examinationDataBo;
            }

            public void setExaminationDataBo(ExaminationDataBoBean examinationDataBo) {
                this.examinationDataBo = examinationDataBo;
            }

            public static class ExaminationDataBoBean {
                /**
                 * id : 1
                 * type : 2
                 * content : 1+2+3+4
                 * isActive : 1
                 * createTime : 1596427338000
                 * updateTime : 1597041280000
                 * options : 111111
                 * rightKey : 的
                 */

                private int id;
                private int type;
                private String content;
                private int isActive;
                private long createTime;
                private long updateTime;
                private String options;
                private String rightKey;

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

                public String getRightKey() {
                    return rightKey;
                }

                public void setRightKey(String rightKey) {
                    this.rightKey = rightKey;
                }
            }
        }
    }
}
