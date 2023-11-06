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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.App;

public class NoteEditControllerTest extends ApplicationTest {

    private TextField noteInputTitle;
    private Button saveNoteButton, undoChangesButton;
    private TextArea noteInputText;
    private Text errorMessage;
    private NotesAccess dataAccess = new LocalNotesAccess();

    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(App.class.getResource("NoteEdit.fxml"));

        NoteEditController controller = new NoteEditController();
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
        noteInputTitle = lookup("#noteInputTitle").query();
        noteInputText = lookup("#noteInputText").query();
        errorMessage = lookup("#errorMessage").query();
        saveNoteButton = lookup("#saveNoteButton").query();
        undoChangesButton = lookup("#undoChangesButton").query();
    }

    @Test
    public void testUIComponentsExist() {
        assertNotNull(noteInputTitle);
        assertNotNull(noteInputText);
        assertNotNull(errorMessage);
        assertNotNull(saveNoteButton);
        assertNotNull(undoChangesButton);
    }

}
