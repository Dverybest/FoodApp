package com.dverybest.fun;

import java.io.Serializable;

/**
 * Created by BEN on 01/10/2018.
 */

public class Food extends Popular implements Serializable {

    String description;
    double price;

    public Food(int footImageURL, String foodName, String description, double price) {
        super(footImageURL, foodName);
        this.description = description;
        this.price = price;
    }

    public Food(int footImageURL, String foodName) {
        super(footImageURL, foodName);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
