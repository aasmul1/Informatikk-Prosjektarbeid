package ui.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationTest;

import core.Note;
import core.NoteOverview;
import core.User;
import dataaccess.LocalNotesAccess;
import dataaccess.NotesAccess;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import ui.App;

public class LoginControllerTest extends ApplicationTest {

    private TextField usernameField;
    private TextField passwordField;
    private Button logInButton;
    private NotesAccess dataAccess = new LocalNotesAccess();
    private TextArea errorMessage;
    private FxRobot robot = new FxRobot();

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

    /**
     * Initializes the user interface elements before each test method.
     */
    @BeforeEach
    public void initFields() {
        usernameField = lookup("#usernameInput").query();
        passwordField = lookup("#passwordInput").query();
        logInButton = lookup("#loginButton").query();
        errorMessage = lookup("#errorMessage").query();
    }

    @Test
    public void testUIComponentsExist() {
        assertNotNull(usernameField);
        assertNotNull(passwordField);
        assertNotNull(errorMessage);
    }

    @Test
    public void testCreateUserButton() {
        // Check if the button can be clicked
        robot.clickOn("#createUserButton");

        assertTrue(usernameField.getText().isEmpty());
        assertTrue(passwordField.getText().isEmpty());
    }

    @Test
    public void testLoginButtonFunctionality() throws IOException {
        // Username and Password fields are empty
        assertTrue(usernameField.getText().isEmpty());
        assertTrue(passwordField.getText().isEmpty());

        createTestUser();

        // Type into the Username and Password fields and press the Login button
        robot.clickOn(usernameField).write("testUser");
        robot.clickOn(passwordField).write("testUserPassword1");
        robot.clickOn("#loginButton");

        assertTrue(errorMessage.getText().isEmpty());

        //teste om overganger funker? 
    }

    private void createTestUser() throws IOException {
        try {
            NoteOverview noteOverview = new NoteOverview(); 

            User user = new User("testUser",
             "testUserPassword1", noteOverview);

            // Note note1 = new Note("TestUser title", "TestUser text"); 
            // Note note2 = new Note("TestUse 2", "TestUser text 2"); 

            // noteOverview.addNote(note1);
            // noteOverview.addNote(note2);

            dataAccess.createUser(user);
        } catch (Exception e) {
            e.getMessage();
        }

    }

}

