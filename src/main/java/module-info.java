module com.example.javaaudiobook {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires java.sql;

    opens com.example.javaaudiobook to javafx.fxml;
    exports com.example.javaaudiobook;
    exports com.example.javaaudiobook.controllers;
    opens com.example.javaaudiobook.controllers to javafx.fxml;
}