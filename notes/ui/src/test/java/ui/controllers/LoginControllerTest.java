package ui.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import dataaccess.LocalNotesAccess;
import dataaccess.NotesAccess;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ui.App;

public class LoginControllerTest extends ApplicationTest {

    private TextField usernameField;
    private TextField passwordField;
    private Button logInButton;
    private NotesAccess dataAccess = new LocalNotesAccess();
    private TextArea errorMessage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(App.class.getResource("Login.fxml"));

        LoginController controller = new LoginController();
        fxmlLoader.setController(controller);

        controller.setDataAccess(dataAccess);
    
        final Parent parent = fxmlLoader.load();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    @BeforeEach
    public void initFields() {
        usernameField = lookup("#usernameInput").query();
        passwordField = lookup("#passwordInput").query();
        logInButton = lookup("#loginButton").query();
        errorMessage = lookup("#errorMessage").query();
    }

    
}
