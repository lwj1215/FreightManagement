package com.example.freightmanagement.Utils;

/**
 * @author ztc
 * @date 2019/8/5
 */
public interface PrefConstants {
    //用户数据,退出应该清空
    String PREF_USER_DATA_TABLE = "userInfo";
    //非用户数据,退出不应该清空
    String PREF_NON_USER_DATA_TABLE = "permanentPreservation";

    //************************************用户数据**************************************************

    //当前使用者是否登录 TODO: 注意（false代表未登录 true代表已登录）
    String ISLOGIN = "isLogin";
    //用户token
    String TOKEN = "token";

    //司机id
    String DRIVERID = "DriverId";
    //登录时的用户名
    String NICKNAME = "nickname";
    //登录时的用户Id
    String USERID = "userId";
    //登录时的用户Id
    String ADMINID = "adminId";
    //wrokId
    String WROKID = "wrokId";
    //身份证id
    String IDCORDID = "idcordId";
   //身份type
    String TYPE = "type";


    //用户登录密码
    String PASSWORD = "pwd";
    //登录时的用户名
    String ADCODE = "com.app.adCode";
    //用户第三方登录ID
    String THIRDID = "thirdId";
    //用户第三方登录
    String THIRDSOURCE = "thirdSource";
    //三方登录类型
    String THIRDTYPE = "thirdType";
    //微信第三方绑定id
    String UNIONID = "unionid";
    //用户性别
    String GENDER = "gender";
    //用户出生日期
    String BIRTHDATE = "birthDate";
    //1、用户手机号
    String MOBILE = "mobile";
    //用户头像
    String PHOTOMIDDLE = "photomiddle";
    //用户地址
    String ADDRESS = "address";
    //是否第三方登录
    String ISTHIRDLOGIN = "isThirdLogin";
}