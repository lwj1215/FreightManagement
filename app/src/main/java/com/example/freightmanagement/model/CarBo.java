package com.example.freightmanagement.model;

public class CarBo {

    private CertificateDriving certificateDrivingBo;

    private CertificateTransport certificateTransportBo;

    private CertificateRegistration certificateRegistrationBo;

    public CertificateDriving getCertificateDrivingBo() {
        return certificateDrivingBo;
    }

    public void setCertificateDrivingBo(CertificateDriving certificateDrivingBo) {
        this.certificateDrivingBo = certificateDrivingBo;
    }

    public CertificateTransport getCertificateTransportBo() {
        return certificateTransportBo;
    }

    public void setCertificateTransportBo(CertificateTransport certificateTransportBo) {
        this.certificateTransportBo = certificateTransportBo;
    }

    public CertificateRegistration getCertificateRegistrationBo() {
        return certificateRegistrationBo;
    }

    public void setCertificateRegistrationBo(CertificateRegistration certificateRegistrationBo) {
        this.certificateRegistrationBo = certificateRegistrationBo;
    }
}
