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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.example.javaaudiobook.DBConnection.DBHandler;

public class LoginController implements Initializable {

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        handler = new DBHandler();
    }

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button login;


    @FXML
    public void loginAction(ActionEvent e) throws ClassNotFoundException {
        // Retrive data
        connection = handler.getconnection();

        String ql = "SELECT * from users WHERE username=? and password=?";

        try {
            pst = connection.prepareStatement(ql);
            pst.setString(1, username.getText());
            pst.setString(2, password.getText());
            ResultSet rs = pst.executeQuery();

            int count = 0;

            while (rs.next()){
                count = count + 1;
            }
            if(count==1){
                login.getScene().getWindow().hide();
                Stage home = new Stage();
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/views/HomePage.fxml"));
                    Scene scene = new Scene(root);
                    home.setScene(scene);
                    home.setTitle("Home Audio Book");
                    Image image = new Image(String.valueOf(getClass().getResource("/img/icon.png")));
                    home.getIcons().add(image);
                    home.show();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Username or Password is not correct!");
                alert.show();

            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        finally {
            try {
                connection.close();
            }catch (SQLException except){
                except.printStackTrace();
            }
        }



    }

    @FXML
    public void signupAction(ActionEvent e) throws IOException {
        login.getScene().getWindow().hide();
        Stage signup = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/views/SignUp.fxml"));
        Scene scene = new Scene(root);
        signup.setScene(scene);
        signup.setTitle("Sign Up Audiobook");
        Image image = new Image(String.valueOf(getClass().getResource("/img/icon.png")));
        signup.getIcons().add(image);
        signup.show();
        signup.setResizable(false);

    }

}
