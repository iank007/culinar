package com.example.bojansolution.culinar.model;

/**
 * Created by bojan solution on 14/02/2018.
 */

public class DriverPopulation {
    private int driverId;
    private String driverName;
    private String driverStatus;

    public DriverPopulation(int driverId, String driverName) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.driverStatus = "available";
    }

    public int getDriverId() {
        return driverId;
    }
    public String getDriverName() {
        return driverName;
    }
}
