package com.haotu.javafx;

import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFXDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX Demo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
