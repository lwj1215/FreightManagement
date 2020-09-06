package com.example.freightmanagement.model.company;

import com.example.freightmanagement.model.IDCardParam;

/**
 * Created by songdechuan on 2020/8/18.
 */

public class CompanySubmitParam {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
    private String signature;
    private String sealUrl;


    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSealUrl() {
        return sealUrl;
    }

    public void setSealUrl(String sealUrl) {
        this.sealUrl = sealUrl;
    }

    private IDCardParam certificateIDBo;
    private CertificateTransport certificateOperationBo;
    private CertificateBusiness certificateBusinessBo;

    public IDCardParam getCertificateIDBo() {
        return certificateIDBo;
    }

    public void setCertificateIDBo(IDCardParam certificateIDBo) {
        this.certificateIDBo = certificateIDBo;
    }

    public CertificateTransport getCertificateOperationBo() {
        return certificateOperationBo;
    }

    public void setCertificateOperationBo(CertificateTransport certificateOperationBo) {
        this.certificateOperationBo = certificateOperationBo;
    }

    public CertificateBusiness getCertificateBusinessBo() {
        return certificateBusinessBo;
    }

    public void setCertificateBusinessBo(CertificateBusiness certificateBusinessBo) {
        this.certificateBusinessBo = certificateBusinessBo;
    }
}
