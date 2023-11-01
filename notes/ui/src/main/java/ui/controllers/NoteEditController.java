package ui.controllers;

import java.io.IOException;

import core.Note;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class NoteEditController extends AbstractController {

    private Note note;

    @FXML
    private AnchorPane noteeditpane;

    @FXML
    private TextField noteInputTitle;

    @FXML
    private Button saveNoteButton, undoChangesButton;

    @FXML
    private TextArea noteInputText;

    /**
     * Sets the current note for editing to the selected note from AppController
     * and updates the text fields in the with the details of the provided note
     * object.
     *
     * @param note the Note object to be edited.
     */
    public void loadEditInfo() {
        this.note = dataAccess.getNoteToEdit();
        setText(note);
    }

    /**
     * Sets the title and text fields of the note editing interface with the
     * details of the provided note object.
     *
     * @param note from which to extract title and text.
     */
    public void setText(Note note) {
        String titel = note.getTitle();
        String text = note.getText();

        noteInputTitle.setText(titel);
        noteInputText.setText(text);
    }

    /**
     * Handles the save action for a edited note, validating and saving changes made
     * to the note.
     *
     * @param event the ActionEvent triggered by the "Save" button click.
     * @throws IOException if an error occurs during scene transition.
     */
    @FXML
    public void saveNote(ActionEvent event) throws IOException {
        String title = noteInputTitle.getText();
        String noteText = noteInputText.getText();

        // LocalDate createdDate = note.getCreatedDate();
        // LocalDate editedDate = LocalDate.now();

        if (title.isEmpty() || noteText.isEmpty()) { // if the text or title is removed, an alert shows
            this.handleWrongInput("Du kan ikke slette titel eller tekst");
            return;
        }

        note.setTitle(title);
        note.setText(noteText);
        note.setEditedDate();

        dataAccess.updateNote();

        setScene(Controllers.NOTEOVERVIEW, event, dataAccess);
    }

    /**
     * Handles the undo action, reverting changes made to the note.
     *
     * @param event the ActionEvent triggered by the "Undo" button click.
     * @throws IOException If an error occurs during scene transition.
     */
    @FXML
    public void undo(ActionEvent event) throws IOException {
        setScene(Controllers.NOTEOVERVIEW, event, dataAccess);
    }

    /**
     * Method for displaying a warning message in the form of an Alert.
     *
     * @param message the message to display in the warning.
     */
    public void handleWrongInput(String message) {
        Alert alert = new Alert(AlertType.WARNING, message);
        alert.show();
    }
}