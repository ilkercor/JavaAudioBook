package com.example.javaaudiobook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/views/LoginMain.fxml"));
            Scene scene = new Scene(root,800,600);
            stage.setScene(scene);
            stage.setTitle("Login Audio Book");
            Image image = new Image(String.valueOf(getClass().getResource("/img/icon.png")));
            stage.getIcons().add(image);
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