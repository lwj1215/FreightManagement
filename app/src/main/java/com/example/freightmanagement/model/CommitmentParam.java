package com.example.freightmanagement.model;

import java.util.Date;

public class CommitmentParam {

    private Integer driverId;

    private String endTime;

    private String commitmentUrl;

    private Integer carId;


    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getCommitmentUrl() {
        return commitmentUrl;
    }

    public void setCommitmentUrl(String commitmentUrl) {
        this.commitmentUrl = commitmentUrl;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }
}
