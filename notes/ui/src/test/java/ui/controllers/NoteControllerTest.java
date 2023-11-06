package ui.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationTest;

import core.NoteOverview;
import core.User;
import dataaccess.LocalNotesAccess;
import dataaccess.NotesAccess;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.App;

public class NoteControllerTest extends ApplicationTest {

    private TextArea newNoteInputText;
    private TextField newNoteInputTitle;
    private NotesAccess dataAccess = new LocalNotesAccess();
    private Text errorMessage;
    private Button saveNoteButton;
    private FxRobot robot = new FxRobot();

    @Override
    public void start(Stage stage) throws IOException {

        loginUser();

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(App.class.getResource("Note.fxml"));

        NoteController controller = new NoteController();
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
        newNoteInputText = lookup("#newNoteInputText").query();
        newNoteInputTitle = lookup("#newNoteInputTitle").query();
        errorMessage = lookup("#errorMessage").query();
        saveNoteButton = lookup("#saveNoteButton").query();
    }

    @Test
    public void testUIComponentsExist() {
        assertNotNull(newNoteInputText);
        assertNotNull(newNoteInputTitle);
        assertNotNull(errorMessage);
        assertNotNull(saveNoteButton);  
    }

    public void loginUser() throws IOException {

        NoteOverview noteoverview = new NoteOverview();
        User user = new User("User", "Password1", noteoverview);

        if (!dataAccess.readAccounts().containsUser(user)) {
            dataAccess.createUser(user);
        }
        dataAccess.userLogin("User", "Password1");
    }

    @Test
    public void testNewNoteEmptyFields() {
        // Click "Save Note" without entering any text
        clickOn(saveNoteButton);

        // Verify: An error message should be displayed
        assertNotNull(errorMessage);

        // Verify: No new notes should be added to the user's note overview
        assertEquals(0, dataAccess.getUserNoteOverview().getNotes().size());
    }

}
