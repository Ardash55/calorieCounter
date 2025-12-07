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
        int newAge;
        while (true) {
            try {
                System.out.println("Введите ваш возраст");
                newAge = sc.nextInt();
                this.age = newAge;

                if (newAge <= 0) {
                    System.out.println("Возраст должен быть больше нуля");
                    continue;
                }
                fileManager.saveUser();
                this.setCalorieNorm();
                break;
            } catch (Exception e) {
                System.out.println("Возраст должен быть числом");
                sc.nextLine();
            }
        }
    }

    public void setWeight() {

        while (true) {
            int newWeight;
            try {
                System.out.println("Введите ваш вес");
                newWeight = sc.nextInt();
                this.weight = newWeight;

                if (newWeight <= 0) {
                    System.out.println("Вес должен быть больше нуля");
                    continue;
                }
                fileManager.saveUser();
                this.setCalorieNorm();
                break;
            } catch (Exception e) {
                System.out.println("Вес должен быть числом");
                sc.nextLine();
            }
        }
    }

    public void setHeight() {
        while (true) {
            int newHeight;
            try {
                System.out.println("Введите ваш рост");
                newHeight = sc.nextInt();
                this.height = newHeight;

                if (newHeight <= 0) {
                    System.out.println("Рост должен быть больше нуля");
                    continue;
                }
                fileManager.saveUser();
                this.setCalorieNorm();
                break;
            } catch (Exception e) {
                System.out.println("Вес должен быть числом");
                sc.nextLine();
            }
        }
    }

    public void setSex() {
        while (true) {
            int sexChoice;
            try {
                System.out.println("Выберите ваш пол");
                System.out.println("1. Мужской");
                System.out.println("2. Женский");
                sexChoice = sc.nextInt();
                if (sexChoice == 1) {
                    sex = "male";
                } else if (sexChoice == 2) {
                    sex = "female";
                }

                if (sexChoice != 1 && sexChoice != 2) {
                    System.out.println("Выберите из двух имеющихся опций");
                    continue;
                }
                fileManager.saveUser();
                this.setCalorieNorm();
                break;
            } catch (Exception e) {
                System.out.println("Введите число");
                sc.nextLine();
            }
        }
    }

    public void setGoal() {
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
                fileManager.saveUser();
                this.setCalorieNorm();
                break;
            } catch (Exception e) {
                System.out.println("Введите число");
                sc.nextLine();
            }
        }
    }

    public void setActivity() {
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
                fileManager.saveUser();
                this.setCalorieNorm();
                break;
            } catch (Exception e) {
                System.out.println("Введите число");
                sc.nextLine();
            }
        }
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