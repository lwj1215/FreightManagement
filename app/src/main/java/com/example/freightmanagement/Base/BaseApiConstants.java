package com.example.freightmanagement.Base;


/**
 * @Deprecated 用来存放项目中所有的接口url
 * @author: ztc
 * 2019/8/12
 * @describe:
 */
public class BaseApiConstants {


    /**
     * 验证码
     * 参数：username，userpass
     */
    public static final String API_SMS_CODE = "/cccc/register/getMessageCode/";
    /**
     * 账号登录
     * 参数：username，userpass
     */
    public static final String API_LOGIN = "/cccc/login";

    /**
     * 账号注册
     * 参数：username，password
     */

    public static final String API_REGISTER = "/cccc/register";

    /**
     * 找回密码
     */
    public static final String API_RETRIEVE_PWD = "/cccc/register/retrieve";
    /**
     * 获取驾驶员信息
     */
    public static final String API_DRIVERINFORMATION = "/driver/getID/";


}
