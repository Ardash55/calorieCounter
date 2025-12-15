package org.example;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Scanner;

public class ThisDay implements Serializable  {
    private transient Scanner sc = new Scanner(System.in);
    private LocalDate today;
    private Meals breakfast;
    private Meals lunch;
    private Meals dinner;
    private double totalEatenCalories;
    private ArrayList<FoodTime> foodTimes;

    ThisDay() {
        this.today = LocalDate.now();
        this.breakfast = new Meals("Завтрак", 0);
        this.lunch = new Meals("Обед", 0);
        this.dinner = new Meals("Ужин", 0);
        this.totalEatenCalories = 0;;
        this.foodTimes = new ArrayList<>();
    }

    double getTotalEatenCalories() {
        return totalEatenCalories;
    }

    void eat() {
        while (true)
            try {
                System.out.println("Выберите прием пищи");
                System.out.println("1. Завтрак");
                System.out.println("2. Обед");
                System.out.println("3. Ужин");
                int mealChoise = sc.nextInt();
                switch (mealChoise) {
                    case 1 -> addFoodToMeal(this.breakfast);
                    case 2 -> addFoodToMeal(this.lunch);
                    case 3 -> addFoodToMeal(this.dinner);
                }

                if(mealChoise != 1 && mealChoise != 2 && mealChoise != 3) {
                    System.out.println("Выберите один из трех приемов пищи");
                    continue;
                }

                break;
            } catch (Exception e) {
                System.out.println("Введите число");
                sc.nextLine();
            }
    }

    void addFoodToMeal(Meals meal) {
        System.out.println("Введите название блюда:");
        sc.nextLine();
        String mealName = sc.nextLine();
        System.out.println("Введите количество калорий:");
        while (true) {
            try {
                int mealCalories = sc.nextInt();
                FoodTime newFoodTime = new FoodTime(mealName, mealCalories);
                meal.addFood(newFoodTime);
                this.totalEatenCalories += mealCalories;

                if(mealCalories <= 0) {
                    System.out.println("Калорий должно быть больше нуля");
                    continue;
                }

                break;
            } catch (Exception e) {
                System.out.println("Введите числом количество калорий");
                sc.nextLine();
            }
        }
    }

    void showBreakfast() {
        breakfast.showFoodtimes();
    }

    void showLunch() {
        lunch.showFoodtimes();
    }

    void showDinner() {
        dinner.showFoodtimes();
    }

    LocalDate getToday() {
        return this.today;
    }
 }