package com.example.freightmanagement.model;

public class ResponsibilityParam {

    private Integer driverId;

    private String responsibilityUrl;


    private Integer carId;

    private String endTime;


    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getResponsibilityUrl() {
        return responsibilityUrl;
    }

    public void setResponsibilityUrl(String responsibilityUrl) {
        this.responsibilityUrl = responsibilityUrl;
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
