package com.example.bojansolution.culinar.model;

/**
 * Created by bojan solution on 17/12/2017.
 */

public class StorePopulation {
    private String storeId;
    private String storeName;
    private String openClosedStatus;

    public StorePopulation(String storeId, String storeName, String openClosedStatus) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.openClosedStatus = openClosedStatus;
    }

    public String getStoreId() {
        return storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getOpenClosedStatus() {
        return openClosedStatus;
    }
}
