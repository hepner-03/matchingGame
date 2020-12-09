module dusome {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens dusome to javafx.fxml;
    exports dusome;
}