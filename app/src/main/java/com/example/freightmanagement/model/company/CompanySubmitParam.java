package com.example.freightmanagement.model.company;

import com.example.freightmanagement.model.IDCardParam;

/**
 * Created by songdechuan on 2020/8/18.
 */

public class CompanySubmitParam {
    private IDCardParam idBo;
    private CertificateTransport certificateOperationBo;
    private CertificateBusiness certificateBusinessBo;

    public IDCardParam getIdBo() {
        return idBo;
    }

    public void setIdBo(IDCardParam idBo) {
        this.idBo = idBo;
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
