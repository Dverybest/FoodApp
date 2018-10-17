package com.dverybest.fun;

/**
 * Created by BEN on 01/10/2018.
 */

public class Popular {
    int footImageURL;
    String foodName;

    public Popular(int footImageURL, String foodName) {
        this.footImageURL = footImageURL;
        this.foodName = foodName;
    }

    public int getFootImageURL() {
        return footImageURL;
    }

    public void setFootImageURL(int footImageURL) {
        this.footImageURL = footImageURL;
}

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
