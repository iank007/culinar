package com.example.bojansolution.culinar.model;

/**
 * Created by bojan solution on 23/12/2017.
 */

public class FoodPopulation {
    private String storeId;
    private String foodId;
    private String foodName;
    private long foodPrice;
    private int foodCount;

    public FoodPopulation(String storeId, String foodId, String foodName, long foodPrice
            , int foodCount) {
        this.storeId = storeId;
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodCount = foodCount;
    }

    public String getStoreId() {
        return storeId;
    }

    public String getFoodId() {
        return foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public long getFoodPrice() {
        return foodPrice;
    }

    public int getFoodCount() {return foodCount;}
}
