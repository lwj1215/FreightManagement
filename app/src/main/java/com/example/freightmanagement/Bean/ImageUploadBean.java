package com.example.freightmanagement.Bean;

/**
 * Created by songdechuan on 2020/8/14.
 */

public class ImageUploadBean {

    /**
     * code : 0
     * message : 上传成功
     * data : 1e8d3bd6-8a9b-4336-b161-5a5329f80249_jpg
     * type : 1
     * token : 2ojd68KkJQKJHEVx2TbBXz3yl7fNb+dY
     */

    private int code;
    private String message;
    private String data;
    private String type;
    private String token;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
