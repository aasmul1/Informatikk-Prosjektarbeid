package ui.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationTest;

import dataaccess.LocalNotesAccess;
import dataaccess.NotesAccess;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ui.App;

public class CreateUserControllerTest extends ApplicationTest{

    private TextField usernameField;
    private TextField passwordField;
    private Button createUserButton;
    private NotesAccess dataAccess = new LocalNotesAccess();
    private FxRobot robot = new FxRobot();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(App.class.getResource("CreateUser.fxml"));

        CreateUserController controller = new CreateUserController();
        fxmlLoader.setController(controller);

        controller.setDataAccess(dataAccess);
    
        final Parent parent = fxmlLoader.load();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    /**
     * Initializes the user interface elements before each test method.
     */
    @BeforeEach
    public void initFields() {
        usernameField = lookup("#createUsernameInput").query();
        passwordField = lookup("#createPasswordInput").query();
        createUserButton = lookup("#createUserButton").query();
    }
        @Test
    public void testUIComponentsExist() {
        assertNotNull(usernameField);
        assertNotNull(passwordField);
    }
    
}
