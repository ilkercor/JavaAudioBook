package com.example.javaaudiobook.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CategoriesController implements Initializable {

    @FXML
    private AnchorPane homeAnchor;



    HomePageController homePage;
    AnchorPane u;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void childrenAction(ActionEvent e){
        try {
            loadFXML("/views/ChildrenBooks.fxml", "Children Audio Books");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void loadFXML(String loc, String title) throws IOException {
        Parent root = FXMLLoader.   load(getClass().getResource(loc));
        Stage stage = new Stage(StageStyle.UNDECORATED);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setX(785);
        stage.setY(250);
        stage.show();
    }

    @FXML
    public void fantasyAction(ActionEvent e){
        try {
            loadFXML("/views/FantasyBooks.fxml", "Fantasy Audio Books");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    @FXML
    public void scienceAction(ActionEvent e){
        try {
            loadFXML("/views/ScienceBooks.fxml", "Science Audio Books");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    @FXML
    public void biographyAction(ActionEvent e){
        try {
            loadFXML("/views/BiographyBooks.fxml", "Biography Audio Books");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


}
