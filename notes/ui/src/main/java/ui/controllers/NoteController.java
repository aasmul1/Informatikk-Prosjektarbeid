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

public class NoteController extends AbstractController {

    @FXML
    private AnchorPane notepane;

    @FXML
    private TextField newNoteInputTitle;

    @FXML
    private Button addNewNote;

    @FXML
    private TextArea newNoteInputText;

    /**
     * Method to handle the creation of a new note when the "Save Note" button is
     * clicked.
     *
     * @param event the ActionEvent triggered by the "Save Note" button click.
     * @throws IOException
     */
    @FXML
    public void newNote(ActionEvent event) throws IOException {
        String title = newNoteInputTitle.getText();
        String noteText = newNoteInputText.getText();

        if (title.isEmpty() || noteText.isEmpty()) {
            this.handleWrongInput("Feil input, fyll alle felt med rikitg input");
            return;
        }
        Note newnote = new Note(title, noteText);

        dataAccess.addNote(newnote);

        setScene(Controllers.NOTEOVERVIEW, event, dataAccess);
    }

    /**
     * Method for displaying a warning message in the form of an Alert.
     *
     * @param message to display in the warning.
     */
    public void handleWrongInput(String message) {
        Alert alert = new Alert(AlertType.WARNING, message);
        alert.show();
    }
}