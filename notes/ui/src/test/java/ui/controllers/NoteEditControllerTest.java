package ui.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import core.Note;
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

        loginUserWithSelectedNote();
    }

    public void loginUserWithSelectedNote() throws IOException {

        NoteOverview noteoverview = new NoteOverview();
        User user = new User("User", "Password1", noteoverview);

        if (!dataAccess.readAccounts().containsUser(user)) {
            dataAccess.createUser(user);
        }
        dataAccess.userLogin("User", "Password1");

        // creates Note to edit
        LocalDate editedDate = LocalDate.parse("2023-10-11");
        LocalDate createdDate = LocalDate.parse("2023-10-05");
        Note note = new Note("Selected Note", "Text", createdDate, editedDate);
        dataAccess.addNote(note);

        // Set the note to edit in NoteEditController
        dataAccess.setNoteToEdit(note);
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

        // Load the user's note and set it in the controller
        Note note = dataAccess.getNoteToEdit();

        // clickOn(noteInputTitle).write(note.getTitle());
        // clickOn(noteInputText).write(note.getText());

        interact(() -> noteInputTitle.setText(note.getTitle()));
        interact(() -> noteInputText.setText(note.getText()));
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
