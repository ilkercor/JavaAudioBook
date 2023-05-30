package com.example.javaaudiobook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main2 extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/views/HomePage.fxml"));
            Scene scene = new Scene(root,800,600);
            stage.setScene(scene);
            stage.setTitle("Home Audio Book");
            stage.show();
            stage.setResizable(false);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}