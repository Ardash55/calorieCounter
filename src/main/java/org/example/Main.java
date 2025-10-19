package org.example;
import java.util.Scanner;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   static User user = new User(0, 0, 0, "", "", 0, 0);
   static ArrayList<FoodTime> lunch = new ArrayList<>();
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Выберите действие");
            System.out.println("1. Зарегистрироватья");
            System.out.println("2. Расчетать мою норму калорий");
            System.out.println("3. Добавить прием пищи");
            System.out.println("4. Посмотреть список приемов пищи");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createUser();
                    break;
                case  2:
                    calculateCalorieIntake();
                    break;
                case 3:
                    eat();
                    break;
                case 4:
                    showLunch();
                    break;
            }
        }
//        createUser();
//        calculateCalorieIntake();
    }

     public static void createUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ваш возраст");
        int age = sc.nextInt();
        System.out.println("Введите ваш вес");
        int weight = sc.nextInt();
        System.out.println("Введите ваш рост (в см)");
        int height = sc.nextInt();
        System.out.println("Выберите ваш пол");
        System.out.println("1. Мужской");
        System.out.println("2. Женский");
        int sexChoice = sc.nextInt();
        String sex = "";
        if (sexChoice == 1) {
            sex = "male";
        } else if(sexChoice == 2) {
            sex = "female";
        }
        System.out.println("Выберите цель");
        System.out.println("1. Похудеть");
        System.out.println("2. Поддерживать вес");
        System.out.println("3. Набрать вес");
        int goalChoice = sc.nextInt();
        String goal = "";
        if(goalChoice == 1) {
            goal = "loseWeight";
        } else if(goalChoice == 2) {
            goal = "maintainWeight";
        } else if(goalChoice == 3) {
            goal = "gainWeight";
        }
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

        user.setAge(age);
        user.setWeight(weight);
        user.setHeight(height);
        user.setSex(sex);
        user.setGoal(goal);
        user.setActivity(activity);
        System.out.println(user.getSex() + " " +  user.getAge() + " " + user.getHeight() + " " + user.getGoal() + " " + user.getWeight() + " " +user.getActivity());
    }

    public static void calculateCalorieIntake() {
        double calorieNorm;
        if (user.getSex() == "male") {
             calorieNorm = (((10 * user.getWeight()) + (6.25 * user.getHeight()) - (5 * user.getAge()) + 5) * user.getActivity());
             user.setCalorieNorm(calorieNorm);
             if (user.getGoal() == "loseWeight") {
                 user.setCalorieNorm(user.getCalorieNorm() - (user.getCalorieNorm() * 0.15));
             } else if (user.getGoal() == "gainWeight") {
                 user.setCalorieNorm(user.getCalorieNorm() + (user.getCalorieNorm() * 0.15));
             }
        } else if (user.getSex() == "female") {
             calorieNorm = (((10 * user.getWeight()) + (6.25 * user.getHeight()) - (5 * user.getAge()) + - 161) * user.getActivity());
             user.setCalorieNorm(calorieNorm);
            if (user.getGoal() == "loseWeight") {
                user.setCalorieNorm(user.getCalorieNorm() - (user.getCalorieNorm() * 0.15));
            } else if (user.getGoal() == "gainWeight") {
                user.setCalorieNorm(user.getCalorieNorm() + (user.getCalorieNorm() * 0.15));
            }
        }
        System.out.println(user.getCalorieNorm());
    }

    public static void eat() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название блюда");
        String foodName = sc.nextLine();
        System.out.println("Введите количество съеденых калорий");
        int thisCalories = sc.nextInt();
        FoodTime newFoodTime = new FoodTime(foodName, thisCalories);
        lunch.add(newFoodTime);
    }

    public static void showLunch() {
        for(FoodTime foodTime : lunch) {
            System.out.println(foodTime.getName() + ": " + foodTime.getCalorie() + " калорий");
        }
    }
}