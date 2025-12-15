package org.example;

import java.io.Serializable;

public class FoodTime implements Serializable {
    private String name;
    private int calorie;

    FoodTime(String name, int calorie) {
        this.name = name;
        this.calorie = calorie;
    }

    String getName() {
        return this.name;
    }

    int getCalorie() {
        return this.calorie;
    }
}
