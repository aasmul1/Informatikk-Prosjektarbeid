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

public class NoteController extends AbstractController {

  @FXML
  private AnchorPane notepane;

  @FXML
  private TextField newNoteInputTitle;

  @FXML
  private Button saveNoteButton;

  @FXML
  private TextArea newNoteInputText;

  @FXML
  private Text errorMessage;

  /**
   * Method to handle the creation of a new note when the "Save Note" button is clicked.
   *
   * @param event the ActionEvent triggered by the "Save Note" button click.
   * @throws IOException
   */
  @FXML
  public void newNote(ActionEvent event) throws IOException {
    String title = newNoteInputTitle.getText();
    String noteText = newNoteInputText.getText();
    try {
      Note newnote = new Note(title, noteText);

      dataAccess.addNote(newnote);

      setScene(Controllers.NOTEOVERVIEW, event, dataAccess);
    } catch (IllegalArgumentException e) {
      errorMessage.setText(e.getMessage());
    }


  }

}
