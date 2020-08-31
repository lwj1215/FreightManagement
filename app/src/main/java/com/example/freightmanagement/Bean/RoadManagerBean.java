package com.example.freightmanagement.Bean;

import java.util.List;

/**
 * 道路运输经营许可证
 */
public class RoadManagerBean {


    /**
     * data : {"ret":[{"probability":{"average":0.846047,"min":0.150192,"variance":0.045714},"location":{"top":326,"left":158,"width":145,"height":17},"word_name":"date","word":"2023"},{"probability":{"average":0.996323,"min":0.975716,"variance":3.4E-5},"location":{"top":294,"left":182,"width":141,"height":19},"word_name":"number","word":"临字371316290072号"},{"probability":{"average":0.998348,"min":0.995749,"variance":3.0E-6},"location":{"top":133,"left":508,"width":189,"height":37},"word_name":"address","word":"山东省临沂市经济开发区芝麻街道:办事处沂河路116号鲁信物流院内D3-12号"},{"probability":{"average":0.995984,"min":0.97442,"variance":4.7E-5},"location":{"top":99,"left":509,"width":126,"height":17},"word_name":"companyName","word":"临沂兴盛运输有限公司"},{"probability":{"average":0.996092,"min":0.980307,"variance":2.7E-5},"location":{"top":201,"left":517,"width":178,"height":53},"word_name":"range","word":"道路普通货物运输,货物专用运输(集装箱),货物专用运输(冷藏保鲜设备),货物专用运输(罐式容器)"}],"templateSign":"bfa90c13251df75350437d83f41f57d6","templateName":"道路运输经营许可证","scores":1,"isStructured":true,"logId":"159873310791493","templateMatchDegree":0.9912476857100023,"clockwiseAngle":3.8}
     * error_code : 0
     * error_msg :
     * log_id : 159873310791493
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
         * ret : [{"probability":{"average":0.846047,"min":0.150192,"variance":0.045714},"location":{"top":326,"left":158,"width":145,"height":17},"word_name":"date","word":"2023"},{"probability":{"average":0.996323,"min":0.975716,"variance":3.4E-5},"location":{"top":294,"left":182,"width":141,"height":19},"word_name":"number","word":"临字371316290072号"},{"probability":{"average":0.998348,"min":0.995749,"variance":3.0E-6},"location":{"top":133,"left":508,"width":189,"height":37},"word_name":"address","word":"山东省临沂市经济开发区芝麻街道:办事处沂河路116号鲁信物流院内D3-12号"},{"probability":{"average":0.995984,"min":0.97442,"variance":4.7E-5},"location":{"top":99,"left":509,"width":126,"height":17},"word_name":"companyName","word":"临沂兴盛运输有限公司"},{"probability":{"average":0.996092,"min":0.980307,"variance":2.7E-5},"location":{"top":201,"left":517,"width":178,"height":53},"word_name":"range","word":"道路普通货物运输,货物专用运输(集装箱),货物专用运输(冷藏保鲜设备),货物专用运输(罐式容器)"}]
         * templateSign : bfa90c13251df75350437d83f41f57d6
         * templateName : 道路运输经营许可证
         * scores : 1.0
         * isStructured : true
         * logId : 159873310791493
         * templateMatchDegree : 0.9912476857100023
         * clockwiseAngle : 3.8
         */

        private String templateSign;
        private String templateName;
        private double scores;
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

        public double getScores() {
            return scores;
        }

        public void setScores(double scores) {
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
             * probability : {"average":0.846047,"min":0.150192,"variance":0.045714}
             * location : {"top":326,"left":158,"width":145,"height":17}
             * word_name : date
             * word : 2023
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
                 * average : 0.846047
                 * min : 0.150192
                 * variance : 0.045714
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
                 * top : 326
                 * left : 158
                 * width : 145
                 * height : 17
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
