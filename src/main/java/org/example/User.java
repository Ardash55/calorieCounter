package org.example;
import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

import java.util.Scanner;

public class User implements Serializable {
    private transient FileManager fileManager = new FileManager();
    private transient Scanner sc = new Scanner(System.in);
    private int age;
    private int weight;
    private int height;
    private String sex;
    private String goal;
    private double activity;
    private double calorieNorm;

    public void initTransient() {
        this.fileManager = new FileManager();
        this.sc = new Scanner(System.in);
    }

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

    public void setAge() {
        System.out.println("Введите ваш возраст");
        int newAge = sc.nextInt();
        this.age = newAge;
        System.out.println("Твой возраст " + this.age + " лет");
        this.setCalorieNorm();
        fileManager.saveUser();
    }

    public void setWeight() {
        System.out.println("Введите ваш вес");
        int newWeight = sc.nextInt();
        this.weight = newWeight;
        System.out.println("Твой вес " + this.weight + " кг");
        this.setCalorieNorm();
        fileManager.saveUser();
    }

    public void setHeight() {
        System.out.println("Введите ваш рост");
        int newHeight = sc.nextInt();
        this.height = newHeight;
        System.out.println("Твой рост " + this.height + " см");
        this.setCalorieNorm();
        fileManager.saveUser();
    }

    public void setSex() {
        System.out.println("Введите ваш пол");
        System.out.println("1. Мужской");
        System.out.println("2. Женский");
        int choice = sc.nextInt();
        String newSex = "";
        if (choice == 1) {
            newSex = "male";
        } else if(choice == 2) {
            newSex = "female";
        }
        this.sex = newSex;
        this.setCalorieNorm();
        fileManager.saveUser();
    }

    public void setGoal() {
        System.out.println("Выберите цель");
        System.out.println("1. Похудеть");
        System.out.println("2. Поддерживать вес");
        System.out.println("3. Набрать вес");
        int choice = sc.nextInt();
        String goal = "";
        if(choice == 1) {
            goal = "loseWeight";
        } else if(choice == 2) {
            goal = "maintainWeight";
        } else if(choice == 3) {
            goal = "gainWeight";
        }
        this.goal = goal;
        this.setCalorieNorm();
        fileManager.saveUser();
    }

    public void setActivity() {
        System.out.println("Выберите уровень активности");
        System.out.println("1. Сидячий образ жизни");
        System.out.println("2. Низкий уровень активности");
        System.out.println("3. Умеренная активность");
        System.out.println("4. Высокая активность");
        System.out.println("5. Очень высокая активность");
        int activityChoise = sc.nextInt();
        double activity = 0;
        if(activityChoise == 1) {
            activity = 1.2;
        } else if(activityChoise == 2) {
            activity = 1.375;
        } else if (activityChoise == 3) {
            activity = 1.55;
        } else if (activityChoise == 4) {
            activity = 1.725;
        } else if (activityChoise == 5) {
            activity = 1.9;
        }
        this.activity = activity;
        this.setCalorieNorm();
        fileManager.saveUser();
    }

    public void setCalorieNorm() {
        double calorieNorm;
        if (this.getSex().equals("male")) {
            calorieNorm = (((10 * this.getWeight()) + (6.25 * this.getHeight()) - (5 * this.getAge()) + 5) * this.getActivity());
            this.calorieNorm = calorieNorm;
            if (this.getGoal().equals("loseWeight")) {
                this.calorieNorm = (this.getCalorieNorm() - (this.getCalorieNorm() * 0.15));
            } else if (this.getGoal().equals("gainWeight")) {
                this.calorieNorm = (this.getCalorieNorm() + (this.getCalorieNorm() * 0.15));
            }
        } else if (this.getSex().equals("female")) {
            calorieNorm = (((10 * this.getWeight()) + (6.25 * this.getHeight()) - (5 * this.getAge()) + - 161) * this.getActivity());
            this.calorieNorm = calorieNorm;
            if (this.getGoal().equals("loseWeight")) {
                this.calorieNorm = (this.getCalorieNorm() - (this.getCalorieNorm() * 0.15));
            } else if (this.getGoal().equals("gainWeight")) {
                this.calorieNorm = (this.getCalorieNorm() + (this.getCalorieNorm() * 0.15));
            }
        }
        fileManager.saveUser();
    }
}