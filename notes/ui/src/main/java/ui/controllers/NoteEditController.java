package ui.controllers;

import java.io.IOException;

import core.Note;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class NoteEditController extends AbstractController {

  private Note oldNote;
  private Note newNote;

  @FXML
  private AnchorPane noteeditpane;

  @FXML
  private TextField noteInputTitle;

  @FXML
  private Button saveNoteButton, undoChangesButton;

  @FXML
  private TextArea noteInputText;

  @FXML
  private Text errorMessage;

  /**
   * Sets the current note for editing to the selected note from AppController and updates the text
   * fields in the with the details of the provided note object.
   *
   * @param note the Note object to be edited.
   */
  public void loadEditInfo() {
    this.oldNote = dataAccess.getNote(dataAccess.getLoggedInUser().getUsername(),
        dataAccess.getSelectedIndex());
    setText(oldNote);
  }

  /**
   * Sets the title and text fields of the note editing interface with the details of the provided
   * note object.
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
   * Handles the save action for a edited note, validating and saving changes made to the note.
   *
   * @param event the ActionEvent triggered by the "Save" button click.
   * @throws IOException if an error occurs during scene transition.
   */
  @FXML
  public void saveNote(ActionEvent event) throws IOException {
    String title = noteInputTitle.getText();
    String noteText = noteInputText.getText();
    this.oldNote = dataAccess.getNote(dataAccess.getLoggedInUser().getUsername(),
        dataAccess.getSelectedIndex());

    try {
      newNote = new Note(title, noteText, oldNote.getCreatedDate(), oldNote.getEditedDate());
      dataAccess.deleteNote(dataAccess.getSelectedIndex());
      dataAccess.addNote(newNote);

      setScene(Controllers.NOTEOVERVIEW, event, dataAccess);
    } catch (IllegalArgumentException e) {
      errorMessage.setText(e.getMessage());
    }



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

}
