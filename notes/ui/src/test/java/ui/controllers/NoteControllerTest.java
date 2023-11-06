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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.App;

public class NoteControllerTest extends ApplicationTest{

    private TextArea newNoteInputText;
    private TextField newNoteInputTitle;
    private NotesAccess dataAccess = new LocalNotesAccess();
    private Text errorMessage;
    private FxRobot robot = new FxRobot();

    @Override
    public void start(Stage stage) throws IOException {
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
    }

    @Test
    public void testUIComponentsExist() {
        assertNotNull(newNoteInputText);
        assertNotNull(newNoteInputTitle);
        assertNotNull(errorMessage);
    }

}
