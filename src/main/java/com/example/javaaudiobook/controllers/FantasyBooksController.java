package com.example.javaaudiobook.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class FantasyBooksController{

    private MediaPlayer mediaPlayer;

    @FXML
    private Button backbutton;


    @FXML
    void hpfirstbook(ActionEvent event) {
        openWindow("C:\\Users\\ilker\\Desktop\\JavaAudioBook\\src\\main\\resources\\audiobooksfiles\\hpfirstbook.mp3",
                "Harry Potter and Sorcerer's Stone","J. K. Rowling");
    }

    @FXML
    void hpsecondbook(ActionEvent event) {
        openWindow("C:\\Users\\ilker\\Desktop\\JavaAudioBook\\src\\main\\resources\\audiobooksfiles\\hpsecondbook.mp3",
                "Harry Potter and Chamber of Secrets ","J. K. Rowling");
    }

    @FXML
    void hpthirdbook(ActionEvent event) {
        openWindow("C:\\Users\\ilker\\Desktop\\JavaAudioBook\\src\\main\\resources\\audiobooksfiles\\hpthirdbook.mp3",
                "Harry Potter and Prisoner of Azkaban","J. K. Rowling");
    }

    @FXML
    void gotfirstbook(ActionEvent event) {
        openWindow("C:\\Users\\ilker\\Desktop\\JavaAudioBook\\src\\main\\resources\\audiobooksfiles\\gotfirstbook.mp3",
                "Game of Thrones","George R.R. Martin");
    }

    @FXML
    void lotrfirstbook(ActionEvent event) {
        openWindow("C:\\Users\\ilker\\Desktop\\JavaAudioBook\\src\\main\\resources\\audiobooksfiles\\lotrfirstbook.mp3",
                "Lord of the Rings","J. R. R. Tolkien");
    }


    @FXML
    public void backAction(ActionEvent e){
        backbutton.getScene().getWindow().hide();
    }


    private void openWindow(String file,String bookName, String author) {
        Stage window = new Stage();
        window.setTitle(bookName);

        //Başlık
        Label label = new Label("Audio Book");
        label.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        //Kitap Başlığı
        Label bookTitleLabel = new Label(bookName);
        bookTitleLabel.setStyle("-fx-font-size: 18px;");
        // Kitap yazarı
        Label bookAuthorLabel = new Label("Author: " + author);


        Button startButton = new Button("Play");
        startButton.setStyle("-fx-font-size: 14px; -fx-pref-width: 80px;");

        Button stopButton = new Button("Stop");
        stopButton.setStyle("-fx-font-size: 14px; -fx-pref-width: 80px;");


        startButton.setOnAction(event -> playAudio(file));
        stopButton.setOnAction(event -> stopAudio());

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label, bookTitleLabel, bookAuthorLabel, startButton, stopButton);

        // Ana sahne
        Scene scene = new Scene(layout, 400, 300);


        window.setScene(scene);
        Image image = new Image(String.valueOf(getClass().getResource("/img/icon.png")));
        window.getIcons().add(image);

        window.show();
    }

    private void playAudio(String file) {
        String audioFile = file;
        Media media = new Media(new File(audioFile).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    private void stopAudio() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

}
