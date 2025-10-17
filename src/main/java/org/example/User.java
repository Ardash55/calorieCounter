package org.example;

public class User {
    private int age;
    private int weight;
    private int height;
    private String sex;
    private String goal;
    private double activity;
    private double calorieNorm;

    User (int age, int weight, int height, String sex, String goal, double activity, double calorieNorm) {
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.goal = goal;
        this.activity = activity;
        this.calorieNorm = calorieNorm;
    }

    int getAge() {
        return this.age;
    }

    int getWeight() {
        return this.weight;
    }

    int getHeight() {
        return this.height;
    }

    String getSex() {
        return this.sex;
    }

    String getGoal() {
        return this.goal;
    }

    double getActivity() {
        return this.activity;
    }

    double getCalorieNorm() {
        return this.calorieNorm;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public void setWeight(int newWeight) {
        this.weight = newWeight;
    }

    public void setHeight(int newHeight) {
        this.height = newHeight;
    }

    public void setSex(String newSex) {
        this.sex = newSex;
    }

    public void setGoal(String newGoal) {
        this.goal = newGoal;
    }

    public void setActivity(double newActivity) {
        this.activity = newActivity;
    }

    public void setCalorieNorm(double newNorm) {
        this.calorieNorm = newNorm;
    }
}