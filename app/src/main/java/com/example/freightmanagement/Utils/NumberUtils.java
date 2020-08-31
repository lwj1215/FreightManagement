package com.example.freightmanagement.Utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 浮点数工具类
 * Created by wangyubing on 2019/4/24.
 */
public class NumberUtils {

    /**
     * 四舍五入
     * @param rate
     * @return
     */
    public static Double doubleScale(Double rate) {
        if (rate == null){
            return null;
        }
        BigDecimal b = new BigDecimal(rate);
        return b.setScale(4, RoundingMode.HALF_UP).doubleValue();
    }



    /**
     * 提供精确的加法运算。
     *
     * @param v1
     *            被加数
     * @param v2
     *            加数
     * @return 两个参数的和
     */

    public static double add(double v1, double v2)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }
}
