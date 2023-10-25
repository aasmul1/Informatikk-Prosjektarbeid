module notes.ui {
    requires com.fasterxml.jackson.databind;
    requires notes.core;
    requires javafx.controls;
    requires javafx.fxml;

    opens ui.controllers to javafx.graphics, javafx.fxml;
    exports ui.controllers;
    exports ui to javafx.graphics;
}
