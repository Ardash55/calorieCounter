package org.example;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.ObjectOutputStream;
//import java.io.FileOutputStream;

public class CalorieApp {
    static User user = new User(0, 0, 0, "", "", 0, 0);
    static ThisDay thisDay = new ThisDay();
    static double freeCalories;
    public static void start() {
        while (true) {
            freeCalories = user.getCalorieNorm() - thisDay.getTotalEatenCalories();
            Scanner sc = new Scanner(System.in);
            System.out.println("Съеденно калорий - " + thisDay.getTotalEatenCalories());
            System.out.println("Осталось калорий - " + freeCalories);
            System.out.println("Выберите действие");
            System.out.println("1. Зарегистрироватья");
            System.out.println("2. Расчетать мою норму калорий");
            System.out.println("3. Добавить прием пищи");
            System.out.println("Вес - " + user.getWeight());
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> createUser();
                case 2 -> calculateCalorieIntake();
                case 3 -> thisDay.eat();
            }
        }
    }

    public static void createUser() {
        Scanner sc = new Scanner(System.in);
        int age = 0;
        int weight = 0;
        int height = 0;
        String sex = "";
        String goal = "";
        double activity = 0;
        while (true) {
            try {
                System.out.println("Введите ваш возраст");
                age = sc.nextInt();

                if (age <= 0) {
                    System.out.println("Возраст должен быть больше нуля");
                    continue;
                }

                break;
            } catch (Exception e) {
                System.out.println("Возраст должен быть числом");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("Введите ваш вес");
                weight = sc.nextInt();

                if (weight <= 0) {
                    System.out.println("Вес должен быть больше нуля");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Вес должен быть числом");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("Введите ваш рост (в см)");
                height = sc.nextInt();

                if(height <= 0) {
                    System.out.println("Рост должен быть больше нуля");
                    continue;
                }

                break;
            } catch (Exception e) {
                System.out.println("Рост должен быть числом");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("Выберите ваш пол");
                System.out.println("1. Мужской");
                System.out.println("2. Женский");
                int sexChoice = sc.nextInt();
                if (sexChoice == 1) {
                    sex = "male";
                } else if(sexChoice == 2) {
                    sex = "female";
                }

                if(sexChoice != 1 && sexChoice != 2) {
                    System.out.println("Выберите из вдух имеющихся опций");
                    continue;
                }

                break;
            } catch (Exception e) {
                System.out.println("Введите число");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("Выберите цель");
                System.out.println("1. Похудеть");
                System.out.println("2. Поддерживать вес");
                System.out.println("3. Набрать вес");
                int goalChoice = sc.nextInt();
                if(goalChoice == 1) {
                    goal = "loseWeight";
                } else if(goalChoice == 2) {
                    goal = "maintainWeight";
                } else if(goalChoice == 3) {
                    goal = "gainWeight";
                }

                if(goalChoice != 1 && goalChoice != 2 && goalChoice != 3) {
                    System.out.println("Выберите цель из этих трех вариантов");
                    continue;
                }

                break;
            } catch (Exception e) {
                System.out.println("Введите число");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("Выберите уровень активности");
                System.out.println("1. Сидячий образ жизни");
                System.out.println("2. Низкий уровень активности");
                System.out.println("3. Умеренная активность");
                System.out.println("4. Высокая активность");
                System.out.println("5. Очень высокая активность");
                int activityChoise = sc.nextInt();
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

                if(activityChoise != 1 && activityChoise != 2 && activityChoise != 3 && activityChoise != 4 && activityChoise != 5) {
                    System.out.println("Выберите один из пяти указанных уровней активности");
                    continue;
                }

                break;
            } catch (Exception e) {
                System.out.println("Введите число");
                sc.nextLine();
            }
        }

        user.setAge(age);
        user.setWeight(weight);
        user.setHeight(height);
        user.setSex(sex);
        user.setGoal(goal);
        user.setActivity(activity);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat"))){
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(user.getSex() + " " +  user.getAge() + " " + user.getHeight() + " " + user.getGoal() + " " + user.getWeight() + " " +user.getActivity());
    }

    public static void calculateCalorieIntake() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
            user = (User) ois.readObject();
            System.out.println("Десериализованный объект: " + user);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        double calorieNorm;
        if (user.getSex().equals("male")) {
            calorieNorm = (((10 * user.getWeight()) + (6.25 * user.getHeight()) - (5 * user.getAge()) + 5) * user.getActivity());
            user.setCalorieNorm(calorieNorm);
            if (user.getGoal().equals("loseWeight")) {
                user.setCalorieNorm(user.getCalorieNorm() - (user.getCalorieNorm() * 0.15));
            } else if (user.getGoal().equals("gainWeight")) {
                user.setCalorieNorm(user.getCalorieNorm() + (user.getCalorieNorm() * 0.15));
            }
        } else if (user.getSex().equals("female")) {
            calorieNorm = (((10 * user.getWeight()) + (6.25 * user.getHeight()) - (5 * user.getAge()) + - 161) * user.getActivity());
            user.setCalorieNorm(calorieNorm);
            if (user.getGoal().equals("loseWeight")) {
                user.setCalorieNorm(user.getCalorieNorm() - (user.getCalorieNorm() * 0.15));
            } else if (user.getGoal().equals("gainWeight")) {
                user.setCalorieNorm(user.getCalorieNorm() + (user.getCalorieNorm() * 0.15));
            }
        }
        System.out.println(user.getCalorieNorm());
    }
}