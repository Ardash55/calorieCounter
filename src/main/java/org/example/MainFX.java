package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainFX extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("JavaFX работает");
        Scene scene = new Scene(label, 400, 200);

        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
