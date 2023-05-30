package com.example.javaaudiobook.controllers;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {

    @FXML
    AnchorPane holderPane;

    AnchorPane home;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createPage();
    }

    private void setNode(Node node){
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    private void createPage() {
        try {
            home = FXMLLoader.load(getClass().getResource("/views/Categories.fxml"));
            setNode(home);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private Button mybooks;

    @FXML
    private Button history;

    @FXML
    private Button homebutton;

    public void homeclick(){
        setNode(home);
    }


    @FXML
    private Button logoutbutton;


    public void logout(){
        logoutbutton.getScene().getWindow().hide();
        Stage login = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/views/LoginMain.fxml"));
            Scene scene = new Scene(root);
            login.setScene(scene);
            Image image = new Image(String.valueOf(getClass().getResource("/img/icon.png")));
            login.getIcons().add(image);
            login.setTitle("Login Audio Book");
            login.show();
            login.setResizable(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
