package com.example.freightmanagement.Bean;

import java.util.List;

public class RoadCardBean {


    /**
     * data : {"ret":[{"probability":{"average":0.986042,"min":0.976608,"variance":9.6E-5},"location":{"top":93,"left":98,"width":42,"height":146},"word_name":"business_scope","word":"货物专用运输(藏保鲜设备)"},{"probability":{"average":0.953426,"min":0.512993,"variance":0.012125},"location":{"top":112,"left":334,"width":39,"height":159},"word_name":"number","word":"临字37131600277号"},{"probability":{"average":0.859879,"min":0.546245,"variance":0.026243},"location":{"top":115,"left":227,"width":28,"height":89},"word_name":"vehicle_number","word":"Q37GY(黄2-"},{"probability":{"average":0.960816,"min":0.488073,"variance":0.01525},"location":{"top":107,"left":312,"width":37,"height":150},"word_name":"name","word":"临沂兴盛运输有限公司"},{"probability":{"average":0.874183,"min":0.121328,"variance":0.042327},"location":{"top":109,"left":40,"width":29,"height":147},"word_name":"sendTime","word":"20190013"}],"templateSign":"7687cab0e4a577476de317601f418ef5","templateName":"道路运输证","scores":1,"isStructured":true,"logId":"159877135356183","templateMatchDegree":0.9511822002621521,"clockwiseAngle":270.9}
     * error_code : 0
     * error_msg :
     * log_id : 159877135356183
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
         * ret : [{"probability":{"average":0.986042,"min":0.976608,"variance":9.6E-5},"location":{"top":93,"left":98,"width":42,"height":146},"word_name":"business_scope","word":"货物专用运输(藏保鲜设备)"},{"probability":{"average":0.953426,"min":0.512993,"variance":0.012125},"location":{"top":112,"left":334,"width":39,"height":159},"word_name":"number","word":"临字37131600277号"},{"probability":{"average":0.859879,"min":0.546245,"variance":0.026243},"location":{"top":115,"left":227,"width":28,"height":89},"word_name":"vehicle_number","word":"Q37GY(黄2-"},{"probability":{"average":0.960816,"min":0.488073,"variance":0.01525},"location":{"top":107,"left":312,"width":37,"height":150},"word_name":"name","word":"临沂兴盛运输有限公司"},{"probability":{"average":0.874183,"min":0.121328,"variance":0.042327},"location":{"top":109,"left":40,"width":29,"height":147},"word_name":"sendTime","word":"20190013"}]
         * templateSign : 7687cab0e4a577476de317601f418ef5
         * templateName : 道路运输证
         * scores : 1
         * isStructured : true
         * logId : 159877135356183
         * templateMatchDegree : 0.9511822002621521
         * clockwiseAngle : 270.9
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
             * probability : {"average":0.986042,"min":0.976608,"variance":9.6E-5}
             * location : {"top":93,"left":98,"width":42,"height":146}
             * word_name : business_scope
             * word : 货物专用运输(藏保鲜设备)
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
                 * average : 0.986042
                 * min : 0.976608
                 * variance : 9.6E-5
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
                 * top : 93
                 * left : 98
                 * width : 42
                 * height : 146
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
