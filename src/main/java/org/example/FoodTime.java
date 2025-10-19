package org.example;

public class FoodTime {
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
