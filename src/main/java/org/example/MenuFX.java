package org.example;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MenuFX {
    private VBox root;
    public static User user;
    public static Days days;
    private double freeCalories;
    public static ThisDay thisDay;
    FileManager fileManager = new FileManager();

    public MenuFX() {
        root = new VBox();
        User loaded = fileManager.loadUser();
        Days loadedDays = fileManager.loadDays();

        if (loadedDays != null) {
            days = loadedDays;
        } else {
            days = new Days();
        }

        if (loaded != null) {
            user = loaded;
        }

        user.initTransient();
        days.initTransient();
        thisDay = days.getToday();
        thisDay.initTransient();
        double totalEatenCalories = thisDay.getTotalEatenCalories();

        freeCalories = user.getCalorieNorm() - thisDay.getTotalEatenCalories();

        Label calorieNormUI = new Label("Норма калорий " + user.getCalorieNorm());
        Label eatenCalorieUI = new Label("Съедено " + thisDay.getTotalEatenCalories() + " калорий");
        Label freeCaloriesUI = new Label("Осталось калорий " + freeCalories);

        Button userButton = new Button("Пользователь");
        Button todayButton = new Button("Сегодня");
        Button showDayLog = new Button("Показать историю дней");

        VBox textMenu = new VBox();
        textMenu.getChildren().addAll(calorieNormUI, eatenCalorieUI, freeCaloriesUI);

        VBox menuButton = new VBox();
        menuButton.getChildren().addAll(userButton, todayButton, showDayLog);

        root.getChildren().addAll(textMenu, menuButton);
    }

    public Parent getRoot() {
        return root;
    }
}