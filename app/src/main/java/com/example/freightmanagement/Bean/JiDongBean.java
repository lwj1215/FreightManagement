package com.example.freightmanagement.Bean;

import java.util.List;

public class JiDongBean {


    /**
     * data : {"ret":[{"location":{"top":169,"left":-29,"width":312,"height":249},"word_name":"owner","word":"","probability":{"average":0.554591,"min":0.415492,"variance":0.023525}},{"location":{"top":-135,"left":-2567,"width":189,"height":91},"word_name":"车架号","word":""},{"location":{"top":337,"left":-82,"width":195,"height":67},"word_name":"登记编号","word":""},{"location":{"top":-220,"left":-3489,"width":99,"height":31},"word_name":"驾驶室载客","word":""},{"probability":{"average":0.554591,"min":0.415492,"variance":0.023525},"location":{"top":-124,"left":-2696,"width":118,"height":17},"word_name":"燃料种类","word":"车"},{"location":{"top":-139,"left":-2636,"width":122,"height":61},"word_name":"发动机号","word":""},{"location":{"top":-115,"left":-2376,"width":244,"height":122},"word_name":"车辆类型","word":""},{"location":{"top":-117,"left":-3371,"width":136,"height":43},"word_name":"使用性质","word":""},{"location":{"top":-158,"left":-2840,"width":238,"height":117},"word_name":"制造厂名称","word":""},{"location":{"top":20,"left":-2516,"width":161,"height":76},"word_name":"排量功率","word":""},{"location":{"top":-86,"left":-3063,"width":142,"height":44},"word_name":"高","word":""},{"probability":{"average":0.998796,"min":0.995769,"variance":2.0E-6},"location":{"top":-91,"left":-2485,"width":188,"height":56},"word_name":"车辆型号","word":"注册登记"},{"probability":{"average":0.79419,"min":0.505241,"variance":0.030262},"location":{"top":-102,"left":-3289,"width":126,"height":23},"word_name":"准牵引总质量","word":"4"},{"location":{"top":-48,"left":-3333,"width":180,"height":54},"word_name":"发证日期","word":""},{"probability":{"average":0.864137,"min":0.606472,"variance":0.025481},"location":{"top":192,"left":-148,"width":124,"height":21},"word_name":"登记机关","word":"登"},{"probability":{"average":0.85313,"min":0.53081,"variance":0.03639},"location":{"top":-2,"left":-2726,"width":126,"height":21},"word_name":"轮胎数","word":"色"},{"location":{"top":237,"left":-166,"width":193,"height":57},"word_name":"登记日期","word":""},{"location":{"top":-136,"left":-3129,"width":155,"height":44},"word_name":"宽","word":""},{"location":{"top":58,"left":-2145,"width":160,"height":61},"word_name":"车辆品牌","word":""},{"location":{"top":-184,"left":-3172,"width":124,"height":41},"word_name":"长","word":""}],"templateSign":"bb46a6619810e8240a80560b0c77068f","templateName":"机动车登记证书","scores":1,"isStructured":true,"logId":"159877144649831","templateMatchDegree":0.8636535611892339,"clockwiseAngle":283.52}
     * error_code : 0
     * error_msg :
     * log_id : 159877144649831
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
         * ret : [{"location":{"top":169,"left":-29,"width":312,"height":249},"word_name":"owner","word":""},{"location":{"top":-135,"left":-2567,"width":189,"height":91},"word_name":"车架号","word":""},{"location":{"top":337,"left":-82,"width":195,"height":67},"word_name":"登记编号","word":""},{"location":{"top":-220,"left":-3489,"width":99,"height":31},"word_name":"驾驶室载客","word":""},{"probability":{"average":0.554591,"min":0.415492,"variance":0.023525},"location":{"top":-124,"left":-2696,"width":118,"height":17},"word_name":"燃料种类","word":"车"},{"location":{"top":-139,"left":-2636,"width":122,"height":61},"word_name":"发动机号","word":""},{"location":{"top":-115,"left":-2376,"width":244,"height":122},"word_name":"车辆类型","word":""},{"location":{"top":-117,"left":-3371,"width":136,"height":43},"word_name":"使用性质","word":""},{"location":{"top":-158,"left":-2840,"width":238,"height":117},"word_name":"制造厂名称","word":""},{"location":{"top":20,"left":-2516,"width":161,"height":76},"word_name":"排量功率","word":""},{"location":{"top":-86,"left":-3063,"width":142,"height":44},"word_name":"高","word":""},{"probability":{"average":0.998796,"min":0.995769,"variance":2.0E-6},"location":{"top":-91,"left":-2485,"width":188,"height":56},"word_name":"车辆型号","word":"注册登记"},{"probability":{"average":0.79419,"min":0.505241,"variance":0.030262},"location":{"top":-102,"left":-3289,"width":126,"height":23},"word_name":"准牵引总质量","word":"4"},{"location":{"top":-48,"left":-3333,"width":180,"height":54},"word_name":"发证日期","word":""},{"probability":{"average":0.864137,"min":0.606472,"variance":0.025481},"location":{"top":192,"left":-148,"width":124,"height":21},"word_name":"登记机关","word":"登"},{"probability":{"average":0.85313,"min":0.53081,"variance":0.03639},"location":{"top":-2,"left":-2726,"width":126,"height":21},"word_name":"轮胎数","word":"色"},{"location":{"top":237,"left":-166,"width":193,"height":57},"word_name":"登记日期","word":""},{"location":{"top":-136,"left":-3129,"width":155,"height":44},"word_name":"宽","word":""},{"location":{"top":58,"left":-2145,"width":160,"height":61},"word_name":"车辆品牌","word":""},{"location":{"top":-184,"left":-3172,"width":124,"height":41},"word_name":"长","word":""}]
         * templateSign : bb46a6619810e8240a80560b0c77068f
         * templateName : 机动车登记证书
         * scores : 1
         * isStructured : true
         * logId : 159877144649831
         * templateMatchDegree : 0.8636535611892339
         * clockwiseAngle : 283.52
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
             * location : {"top":169,"left":-29,"width":312,"height":249}
             * word_name : owner
             * word :
             * probability : {"average":0.554591,"min":0.415492,"variance":0.023525}
             */

            private LocationBean location;
            private String word_name;
            private String word;
            private ProbabilityBean probability;

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

            public ProbabilityBean getProbability() {
                return probability;
            }

            public void setProbability(ProbabilityBean probability) {
                this.probability = probability;
            }

            public static class LocationBean {
                /**
                 * top : 169
                 * left : -29
                 * width : 312
                 * height : 249
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

            public static class ProbabilityBean {
                /**
                 * average : 0.554591
                 * min : 0.415492
                 * variance : 0.023525
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
        }
    }
}
