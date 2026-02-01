package org.example;
//mvn clean compile exec:java -Dexec.mainClass=org.example.MainFX
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainFX extends Application {

    @Override
    public void start(Stage stage) {
        MenuFX menuFX = new MenuFX();
        Scene scene = new Scene(menuFX.getRoot(), 800, 600);
        stage.setScene(scene);
        stage.setTitle("чисто тест");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
