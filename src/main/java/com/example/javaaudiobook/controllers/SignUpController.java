package com.example.javaaudiobook.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.example.javaaudiobook.DBConnection.DBHandler;


public class SignUpController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        handler = new DBHandler();
    }

    @FXML
    private PasswordField password;

    @FXML
    private Button login;

    @FXML
    private Button signup;

    @FXML
    private TextField username;

    @FXML
    private RadioButton male;

    @FXML
    private RadioButton female;

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;


    @FXML
    public void signUp(ActionEvent e) throws SQLException {

        // Saving Data
        String insert = "INSERT INTO users(username,password,gender)"+
                        "VALUES (?,?,?)";

        try {
            connection = handler.getconnection();
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

        try {
            pst = connection.prepareStatement(insert);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        try {
            pst.setString(1, username.getText());
            pst.setString(2, password.getText());
            pst.setString(3, getGender());

            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("Registered as "+ username.getText() +" ! You can login now!");
            alert.show();


        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    @FXML
    public void loginAction(ActionEvent e) throws IOException {
        signup.getScene().getWindow().hide();
        Stage login = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/views/LoginMain.fxml"));
        Scene scene = new Scene(root);
        login.setScene(scene);
        login.setTitle("Login Audiobook");
        Image image = new Image(String.valueOf(getClass().getResource("/img/icon.png")));
        login.getIcons().add(image);
        login.show();
        login.setResizable(false);

    }

    public String getGender(){
        String gen = "";
        if(male.isSelected()){
            gen = "Male";
        }else if (female.isSelected()){
            gen = "Female";
        }else {
            gen = "Other";
        }
        return gen;
    }


}
