module notes.ui {
    requires com.fasterxml.jackson.databind;
    requires notes.core;
    requires javafx.controls;
    requires javafx.fxml;

    opens ui to javafx.graphics, javafx.fxml;
}
