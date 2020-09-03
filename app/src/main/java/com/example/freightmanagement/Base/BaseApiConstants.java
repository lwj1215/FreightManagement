package com.example.freightmanagement.Base;


/**
 * @Deprecated 用来存放项目中所有的接口url
 * @author: ztc
 * 2019/8/12
 * @describe:
 */
public class BaseApiConstants {

    /**
     * 图片上传后的BASE_URL
     */
    public static final String IMAGE_BASE_URL = "https://aicc.ctags.cn/cccc/file/download/";

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
    public static final String API_DRIVERINFORMATION = "/cccc/driver/getID/";

    public static final String API_WROKID = "/cccc/examination/getExaminationDriverDatas/";
    /**
     * 获取答题结果记录
     */
    public static final String API_ANSWER_RESULT_LIST = "/cccc/examination/getExaminationDriverDatas/";
    /**
     * 获取驾驶员信息
     */
    public static final String API_PEIXUNJIEGUO = "/cccc/driver/getDirver";

    /**
     * 获取训练题目
     */
    public static final String API_XUNLIANTIMU = "/cccc/examination/getExaminationDatas";


    public static final String API_TRAINING = "/cccc/train/getTrainDatas";
    /**
     * 上传图片
     */
    public static final String API_IMAGE_UPLOAD = "/cccc/file/upload";

    /**
     * chezhu注册
     */
    public static final String API_CAR_OWNER_REGISTER = "/cccc/carOwner/addOwner";

    /**
     * 驾驶员注册
     */
    public static final String API_DRIVER_REGISTER = "/cccc/driver/addDirver";

    /**
     * 企业注册
     */
    public static final String API_COMPANY_REGISTER = "/cccc/enterprise/addEnterprise";

    /**
     * 获取车俩检测项
     */
    public static final String API_JIANCEXIANG = "/cccc/check/getCheckDatas";

    /**
     * 提交车俩检测项
     */
    public static final String API_ADDJIANCEXIANG = "/cccc/check/submit";
    /**
     * 提交车俩维修记录
     */
    public static final String API_ADDWEIXIU = "/cccc/repair/addrepair";
    /**
     * 提交车俩保养记录
     */
    public static final String API_ADDBAOYANG = "/cccc/maintain/addMaintain";

    /**
     * 查看车俩检测列表
     */
    public static final String API_CHEJIANCE = "/cccc/check/getCheckHistorys/";
    /**
     * 查看保养记录
     */
    public static final String API_CHEBAOYANG = "/cccc/maintain/getMaintainList/";
    /**
     * 查看维修记录
     */
    public static final String API_CHEWEIXIU = "/cccc/repair/getrepairList/";
    /**
     * 提交培训
     */
    public static final String API_TIJIAOWENJUAN = "/cccc/examination/submit";
    /**
     * 驾驶员车辆信息
     */
    public static final String API_CLXINXI = "/cccc/driver/getDirver/";
    /**
     * 选择车辆
     */
    public static final String API_XUANZECHELIANG = "/cccc/carOwner/getPassedCar";

    /**
     * 提交合同
     */
    public static final String API_ADD_CONTRACT = "/cccc/letter/addContract";
    /**
     * 驾驶员列表
     */
    public static final String API_DRIVER_LIST = "/cccc/manager/driver/getDriverList";

    /**
     * 删除或者更改车辆
     */
    public static final String API_CAR_DEL = "/cccc/carOwner/editOwner";
    /**
     * 新增车辆
     */
    public static final String API_CAR_ADD = "/cccc/carOwner/addOwner";

    /**
     * 获取合同状态
     */
    public static final String API_CONTRACT_GET = "/cccc/letter/getContract/";
    /**
     * 获取企业信息
     */
    public static final String API_QIYEXINXI_GET = "/cccc/enterprise/getEenterprise";
    /**
     * 获取车主信息
     */
    public static final String API_CHEZHU_GET = "/cccc/carOwner/getOwner";
    /**
     * 获取车主信息
     */
    public static final String API_TRAIN_GET = "/cccc/train/complete/";

}
