package org.example;
import java.util.Scanner;
import java.util.ArrayList;

public class CalorieApp {
    static User user = new User(0, 0, 0, "", "", 0, 0);
    static Meals breakfast = new Meals("Завтрак", 0);
    static Meals lunch = new Meals("Обед", 0);
    static Meals dinner = new Meals("Ужин", 0);
    static double totalEatenCalories;
    static double freeCalories;
    public static void start() {
        while (true) {
            freeCalories = user.getCalorieNorm() - totalEatenCalories;
            Scanner sc = new Scanner(System.in);
            System.out.println("Съеденно калорий - " + totalEatenCalories);
            System.out.println("Осталось калорий - " + freeCalories);
            System.out.println("Выберите действие");
            System.out.println("1. Зарегистрироватья");
            System.out.println("2. Расчетать мою норму калорий");
            System.out.println("3. Добавить прием пищи");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> createUser();
                case 2 -> calculateCalorieIntake();
                case 3 -> eat();
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
        System.out.println(user.getSex() + " " +  user.getAge() + " " + user.getHeight() + " " + user.getGoal() + " " + user.getWeight() + " " +user.getActivity());
    }

    public static void calculateCalorieIntake() {
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

    public static void eat() {
        Scanner sc = new Scanner(System.in);
        while (true)
            try {
                System.out.println("Выберите прием пищи");
                System.out.println("1. Завтрак");
                System.out.println("2. Обед");
                System.out.println("3. Ужин");
                int mealChoise = sc.nextInt();
                switch (mealChoise) {
                    case 1 -> addFoodToMeal(breakfast);
                    case 2 -> addFoodToMeal(lunch);
                    case 3 -> addFoodToMeal(dinner);
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

    public static void addFoodToMeal(Meals meal) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название блюда:");
        String mealName = sc.nextLine();
        System.out.println("Введите количество калорий:");
        while (true) {
            try {
                int mealCalories = sc.nextInt();
                FoodTime newFoodTime = new FoodTime(mealName, mealCalories);
                meal.addFood(newFoodTime);
                totalEatenCalories += mealCalories;

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

}