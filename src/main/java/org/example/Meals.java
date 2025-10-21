package org.example;
import java.util.ArrayList;
import java.util.List;

public class Meals {
    private String name;
    private int calories;
    private List<FoodTime> foodTimes;

    Meals(String name, int calories) {
        this.name = name;
        this.calories = calories;
        this.foodTimes = new ArrayList<>();
    }

    String getName() {
        return this.name;
    }

    int getCalories() {
        return this.calories;
    }

    public void addFood(FoodTime foodTime) {
        this.foodTimes.add(foodTime);
        this.calories = this.calories + foodTime.getCalorie();
    }
}
