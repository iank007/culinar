package com.example.bojansolution.culinar.model;

/**
 * Created by bojan solution on 04/02/2018.
 */

public class PackagePopulation {

    private int packageId;
    private String packageName;

    public PackagePopulation(int packageId, String packageName) {
        this.packageId = packageId;
        this.packageName = packageName;
    }

    public int getPackageId() { return packageId; }
    public String getPackageName() { return  packageName; }
}
