package org.example;
import java.util.Scanner;
//import java.util.ArrayList;
//import java.io.FileOutputStream;
//import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

public class CalorieApp {
    public static User user = new User(0, 0, 0, "", "", 0, 0);
    public static Days days = new Days();
    ThisDay thisDay = days.getToday();
    private double freeCalories;
    FileManager fileManager = new FileManager();

    public void start() {
        User loaded = fileManager.loadUser();
        Days loadedDays = fileManager.loadDays();
        if (loaded != null) {
            user = loaded;
        }

        if (loadedDays != null) {
            days = loadedDays;
        }



        user.initTransient();

        while (true) {
            menu();
        }
    }

    public void menu() {
        freeCalories = user.getCalorieNorm() - thisDay.getTotalEatenCalories();
        Scanner sc = new Scanner(System.in);

        System.out.println("Норма калорий - " + user.getCalorieNorm());
        System.out.println("Съеденно калорий - " + thisDay.getTotalEatenCalories());
        System.out.println("Осталось калорий - " + freeCalories);
        System.out.println("");
        System.out.println("1. Пользователь");
        System.out.println("2. Сегодня");
        System.out.println("0. Выход");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> userMenu();
            case 2 -> todayMenu();
            case 0 -> exit();
        }
    }

    public void exit() {
        System.out.println("До встречи");
        System.exit(0);
    }

    public void userMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Изменить мои данные");
        System.out.println("2. Показать мои данные");
        System.out.println("0. Назад");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> changeMyDate();
            case 2 -> showMyDate();
            case 0 -> menu();
        }
    }

    public void todayMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Добавить прием пищи");
        System.out.println("2. Посмотреть список съеденного на завтрак");
        System.out.println("3. Посмотреть список съеденного на обед");
        System.out.println("4. Посмотреть список съеденного на ужин");
        System.out.println("0. Назад");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> thisDay.eat();
            case 2 -> thisDay.showBreakfast();
            case 3 -> thisDay.showLunch();
            case 4 -> thisDay.showDinner();
            case 0 -> menu();
        }
        fileManager.saveDays();
    }

    public void changeMyDate() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Что вы хотите изменить?");
        System.out.println("1. Возраст");
        System.out.println("2. Вес");
        System.out.println("3. Рост");
        System.out.println("4. Пол");
        System.out.println("5. Цель");
        System.out.println("6. Уровень активности");
        System.out.println("0. Назад");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> user.setAge();
            case 2 -> user.setWeight();
            case 3 -> user.setHeight();
            case 4 -> user.setSex();
            case 5 -> user.setGoal();
            case 6 -> user.setActivity();
            case 0 -> userMenu();
        }
    }

    public void showMyDate() {
        System.out.println("Ваш возраст - " + user.getAge());
        System.out.println("Ваш вес - " + user.getWeight());
        System.out.println("Ваш рост - " + user.getHeight());
        System.out.println("Ваш пол - " + user.getSex());
        System.out.println("Ваша цель - " + user.getGoal());
        System.out.println("Ваш уровень активности - " + user.getActivity());
    }
}