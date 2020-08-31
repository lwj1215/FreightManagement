package com.example.freightmanagement.Bean;

import java.util.List;

public class WorkBean {


    /**
     * data : {"ret":[{"probability":{"average":0.971485,"min":0.870618,"variance":0.002549},"location":{"top":45,"left":67,"width":28,"height":16},"word_name":"userName","word":"陈建成"},{"probability":{"average":0.951729,"min":0.21822,"variance":0.01367},"location":{"top":189,"left":92,"width":91,"height":17},"word_name":"certificateNum","word":"320023106912260415"},{"probability":{"average":0.907343,"min":0.810212,"variance":0.00405},"location":{"top":276,"left":111,"width":22,"height":11},"word_name":"validPeriod","word":"2022"},{"probability":{"average":0.893176,"min":0.56087,"variance":0.01682},"location":{"top":240,"left":67,"width":125,"height":16},"word_name":"sendTime","word":"2010年04月09日20104181"}],"templateSign":"be14fc9fd2d9a508fc95a3f8fbbe37d9","templateName":"从业资格证","scores":1,"isStructured":true,"logId":"159872174056314","templateMatchDegree":0.9918086709620506,"clockwiseAngle":1.28}
     * error_code : 0
     * error_msg :
     * log_id : 159872174056314
     */

    private DataBean data;
    private int error_code;
    private String error_msg;
    private String log_id;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public String getLog_id() {
        return log_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    public static class DataBean {
        /**
         * ret : [{"probability":{"average":0.971485,"min":0.870618,"variance":0.002549},"location":{"top":45,"left":67,"width":28,"height":16},"word_name":"userName","word":"陈建成"},{"probability":{"average":0.951729,"min":0.21822,"variance":0.01367},"location":{"top":189,"left":92,"width":91,"height":17},"word_name":"certificateNum","word":"320023106912260415"},{"probability":{"average":0.907343,"min":0.810212,"variance":0.00405},"location":{"top":276,"left":111,"width":22,"height":11},"word_name":"validPeriod","word":"2022"},{"probability":{"average":0.893176,"min":0.56087,"variance":0.01682},"location":{"top":240,"left":67,"width":125,"height":16},"word_name":"sendTime","word":"2010年04月09日20104181"}]
         * templateSign : be14fc9fd2d9a508fc95a3f8fbbe37d9
         * templateName : 从业资格证
         * scores : 1
         * isStructured : true
         * logId : 159872174056314
         * templateMatchDegree : 0.9918086709620506
         * clockwiseAngle : 1.28
         */

        private String templateSign;
        private String templateName;
        private int scores;
        private boolean isStructured;
        private String logId;
        private double templateMatchDegree;
        private double clockwiseAngle;
        private List<RetBean> ret;

        public String getTemplateSign() {
            return templateSign;
        }

        public void setTemplateSign(String templateSign) {
            this.templateSign = templateSign;
        }

        public String getTemplateName() {
            return templateName;
        }

        public void setTemplateName(String templateName) {
            this.templateName = templateName;
        }

        public int getScores() {
            return scores;
        }

        public void setScores(int scores) {
            this.scores = scores;
        }

        public boolean isIsStructured() {
            return isStructured;
        }

        public void setIsStructured(boolean isStructured) {
            this.isStructured = isStructured;
        }

        public String getLogId() {
            return logId;
        }

        public void setLogId(String logId) {
            this.logId = logId;
        }

        public double getTemplateMatchDegree() {
            return templateMatchDegree;
        }

        public void setTemplateMatchDegree(double templateMatchDegree) {
            this.templateMatchDegree = templateMatchDegree;
        }

        public double getClockwiseAngle() {
            return clockwiseAngle;
        }

        public void setClockwiseAngle(double clockwiseAngle) {
            this.clockwiseAngle = clockwiseAngle;
        }

        public List<RetBean> getRet() {
            return ret;
        }

        public void setRet(List<RetBean> ret) {
            this.ret = ret;
        }

        public static class RetBean {
            /**
             * probability : {"average":0.971485,"min":0.870618,"variance":0.002549}
             * location : {"top":45,"left":67,"width":28,"height":16}
             * word_name : userName
             * word : 陈建成
             */

            private ProbabilityBean probability;
            private LocationBean location;
            private String word_name;
            private String word;

            public ProbabilityBean getProbability() {
                return probability;
            }

            public void setProbability(ProbabilityBean probability) {
                this.probability = probability;
            }

            public LocationBean getLocation() {
                return location;
            }

            public void setLocation(LocationBean location) {
                this.location = location;
            }

            public String getWord_name() {
                return word_name;
            }

            public void setWord_name(String word_name) {
                this.word_name = word_name;
            }

            public String getWord() {
                return word;
            }

            public void setWord(String word) {
                this.word = word;
            }

            public static class ProbabilityBean {
                /**
                 * average : 0.971485
                 * min : 0.870618
                 * variance : 0.002549
                 */

                private double average;
                private double min;
                private double variance;

                public double getAverage() {
                    return average;
                }

                public void setAverage(double average) {
                    this.average = average;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }

                public double getVariance() {
                    return variance;
                }

                public void setVariance(double variance) {
                    this.variance = variance;
                }
            }

            public static class LocationBean {
                /**
                 * top : 45
                 * left : 67
                 * width : 28
                 * height : 16
                 */

                private int top;
                private int left;
                private int width;
                private int height;

                public int getTop() {
                    return top;
                }

                public void setTop(int top) {
                    this.top = top;
                }

                public int getLeft() {
                    return left;
                }

                public void setLeft(int left) {
                    this.left = left;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }
            }
        }
    }
}
