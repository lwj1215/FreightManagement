package com.example.freightmanagement.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.freightmanagement.Base.BaseApplication;

public abstract class PrefUtilsData {


    /**
     * 适用于退出登录清除用户数据
     */
    public static void userClear() {
        SP.userClear();
    }

    public static String getToken() {
        return SP.getString(PrefConstants.TOKEN, "");
    }

    public static void setToken(String token) {
        SP.putString(PrefConstants.TOKEN, token);
    }

    public static String getDriverId() {
        return SP.getString(PrefConstants.DRIVERID, "");
    }

    public static void setDriverId(String user) {
        SP.putString(PrefConstants.DRIVERID, user);
    }

    public static String getWorkId() {
        return SP.getString(PrefConstants.WROKID, "");
    }

    public static void setWorkId(String user) {
        SP.putString(PrefConstants.WROKID, user);
    }

    public static String getIdCordId() {
        return SP.getString(PrefConstants.IDCORDID, "");
    }

    public static void setIdCordId(String user) {
        SP.putString(PrefConstants.IDCORDID, user);
    }

    public static String getNickName() {
        return SP.getString(PrefConstants.NICKNAME, "");
    }

    public static void setNickName(String user) {
        SP.putString(PrefConstants.NICKNAME, user);
    }

    public static String getUserId() {
        return SP.getString(PrefConstants.USERID, "");
    }

    public static void setUserId(String user) {
        SP.putString(PrefConstants.USERID, user);
    }


    public static String getPwd() {
        return SP.getString(PrefConstants.PASSWORD, "");
    }

    public static void setPwd(String pwd) {
        SP.putString(PrefConstants.PASSWORD, pwd);
    }

    public static String getAdCode() {
        return SP.getString(PrefConstants.ADCODE, "");
    }

    public static void setAdCode(String user) {
        SP.putString(PrefConstants.ADCODE, user);
    }

    public static String getThirdId() {
        return SP.getString(PrefConstants.THIRDID, "");
    }

    public static void setThirdId(String thirdId) {
        SP.putString(PrefConstants.THIRDID, thirdId);
    }

    public static String getThirdSource() {
        return SP.getString(PrefConstants.THIRDSOURCE, "");
    }

    public static void setThirdSource(String thirdSource) {
        SP.putString(PrefConstants.THIRDSOURCE, thirdSource);
    }

    public static String getThirdType() {
        return SP.getString(PrefConstants.THIRDTYPE, "");
    }

    public static void setThirdType(String thirdType) {
        SP.putString(PrefConstants.THIRDTYPE, thirdType);
    }

    public static void putUnionid(String unionid) {
        SP.putString(PrefConstants.UNIONID, unionid);
    }

    public static String getUnionid() {
        return SP.getString(PrefConstants.UNIONID, "");
    }

    public static void putIsThirdLogin(boolean isThirdLogin) {
        SP.putBoolean(PrefConstants.ISTHIRDLOGIN, isThirdLogin);
    }

    public static boolean getIsThirdLogin() {
        return SP.getBoolean(PrefConstants.ISTHIRDLOGIN, false);
    }


    public static boolean getIsLogin() {
        return SP.getBoolean(PrefConstants.ISLOGIN, false);
    }

    public static void setIsLogin(boolean isLogin) {
        SP.putBoolean(PrefConstants.ISLOGIN, isLogin);
    }

    public static String getGender() {
        return SP.getString(PrefConstants.GENDER, "");
    }

    public static void setGender(String gender) {
        SP.putString(PrefConstants.GENDER, gender);
    }

    public static String getBirthDate() {
        return SP.getString(PrefConstants.BIRTHDATE, "");
    }

    public static void setBirthDate(String birthDate) {
        SP.putString(PrefConstants.BIRTHDATE, birthDate);
    }

    public static String getMobile() {
        return SP.getString(PrefConstants.MOBILE, "");
    }

    public static void setMobile(String mobile) {
        SP.putString(PrefConstants.MOBILE, mobile);
    }

    public static String getPhotoMiddle() {
        return SP.getString(PrefConstants.PHOTOMIDDLE, "");
    }

    public static void setPhotoMiddle(String photoMiddle) {
        SP.putString(PrefConstants.PHOTOMIDDLE, photoMiddle);
    }

    public static String getAddress() {
        return SP.getString(PrefConstants.ADDRESS, "");
    }

    public static void setAddress(String address) {
        SP.putString(PrefConstants.ADDRESS, address);
    }


    protected static class SP {
        //非用户的数据,用户退出不清空
        private static SharedPreferences sUserSharedPreferences;

        private static SharedPreferences getSharedPreferences() {
            if (sUserSharedPreferences == null) {
                sUserSharedPreferences = BaseApplication.getApp().getSharedPreferences(PrefConstants.PREF_USER_DATA_TABLE, Context.MODE_PRIVATE);
            }
            return sUserSharedPreferences;
        }

        public static void putBoolean(String key, boolean value) {
            getSharedPreferences().edit().putBoolean(key, value).apply();
        }

        public static boolean getBoolean(String key, boolean defValue) {
            return getSharedPreferences().getBoolean(key, defValue);
        }

        public static void putInt(String key, int value) {
            getSharedPreferences().edit().putInt(key, value).apply();
        }

        public static int getInt(String key, int defValue) {
            return getSharedPreferences().getInt(key, defValue);
        }

        public static void putFloat(String key, float value) {
            getSharedPreferences().edit().putFloat(key, value).apply();
        }

        public static float getFloat(String key, float defValue) {
            return getSharedPreferences().getFloat(key, defValue);
        }

        public static void putString(String key, String value) {
            getSharedPreferences().edit().putString(key, value).apply();
        }

        public static String getString(String key, String defValue) {
            return getSharedPreferences().getString(key, defValue);
        }

        public static void userClear() {
            sUserSharedPreferences.edit().clear().apply();
        }
    }

}
