package com.example.javaaudiobook.controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FantasyBooksController implements Initializable {



    @FXML
    private Button hpsecond;

    @FXML
    private Button lotrfirst;

    @FXML
    private Button hpthird;

    @FXML
    private Button backbutton;

    @FXML
    private Button gotfirst;

    @FXML
    private Button hpfirst;

    @FXML
    void hpfirstbook(ActionEvent event) {

    }

    @FXML
    void hpsecondbook(ActionEvent event) {

    }

    @FXML
    void hpthirdbook(ActionEvent event) {

    }

    @FXML
    void gotfirstbook(ActionEvent event) {

    }

    @FXML
    void lotrfirstbook(ActionEvent event) {

    }


    @FXML
    public void backAction(ActionEvent e){
        backbutton.getScene().getWindow().hide();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
