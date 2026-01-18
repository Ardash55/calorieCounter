package org.example;
//mvn clean compile exec:java -Dexec.mainClass=org.example.MainFX
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainFX extends Application {
    public static User user;
    public static Days days;
    private double freeCalories;
    public static ThisDay thisDay;
    FileManager fileManager = new FileManager();

    @Override
    public void start(Stage stage) {
        User loaded = fileManager.loadUser();
        Days loadedDays = fileManager.loadDays();

        if (loadedDays != null) {
            days = loadedDays;
        }

        thisDay = days.getToday();

        if (loaded != null) {
            user = loaded;
        }

        user.initTransient();
        days.initTransient();
        thisDay.initTransient();


        Label calorieNormUI = new Label("Норма калорий " + user.getCalorieNorm());
        Label eatenCalorieUI = new Label("Съедено " + thisDay.getTotalEatenCalories() + " калорий");

        VBox root = new VBox();
        root.getChildren().addAll(calorieNormUI, eatenCalorieUI);

        Scene scene = new Scene(root, 400, 200);

        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
