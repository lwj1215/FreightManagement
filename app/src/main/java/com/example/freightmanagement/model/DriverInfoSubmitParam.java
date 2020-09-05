package com.example.freightmanagement.model;

import java.io.Serializable;

/**
 * Created by songdechuan on 2020/8/13.
 */

public class DriverInfoSubmitParam implements Serializable {
    private String id;
    private String sealUrl;
    private String signature;

    public String getSealUrl() {
        return sealUrl;
    }

    public void setSealUrl(String sealUrl) {
        this.sealUrl = sealUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String name;

    private String tel;

    private int enterpriseId;

    private Integer carId;

    private CertificateWorkParam certificateWorkBo;

    private CertificateDriverParam certificateDriverBo;

    private IDCardParam certificateIDBo;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public CertificateWorkParam getCertificateWorkBo() {
        return certificateWorkBo;
    }

    public void setCertificateWorkBo(CertificateWorkParam certificateWorkBo) {
        this.certificateWorkBo = certificateWorkBo;
    }

    public CertificateDriverParam getCertificateDriverBo() {
        return certificateDriverBo;
    }

    public void setCertificateDriverBo(CertificateDriverParam certificateDriverBo) {
        this.certificateDriverBo = certificateDriverBo;
    }

    public IDCardParam getCertificateIDBo() {
        return certificateIDBo;
    }

    public void setCertificateIDBo(IDCardParam certificateIDBo) {
        this.certificateIDBo = certificateIDBo;
    }
}
