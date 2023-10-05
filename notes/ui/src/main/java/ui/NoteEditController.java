package ui;

import java.io.IOException;
import java.time.LocalDate;

import core.Note;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NoteEditController{

    private Note note; 

    @FXML
    private AnchorPane noteeditpane; 

    @FXML
    private TextField noteInputTitle; 

    @FXML
    private Button saveNoteButton;

    @FXML
    private TextArea noteInputText;

    @FXML
    public void initialize(){   
    }

    public void updateinfo(Note note){
        this.note = note;  
        setText(note);

    }

    public void setText(Note note){
        String titel = note.getTitle();
        String text = note.getText();

        noteInputTitle.setText(titel);
        noteInputText.setText(text);

    }

    @FXML
    public void saveNote(ActionEvent event) throws IOException {  
        String title = noteInputTitle.getText();
        String noteText = noteInputText.getText();

        LocalDate createdDate = note.getCreatedDate();
        LocalDate editedDate = LocalDate.now();

        if (title.isEmpty() || noteText.isEmpty()) { //if the text or title is removed, an alert shows
            handleWrongInput("Du kan ikke slette titel eller tekst");
        }
         
        String oldTitle = note.getTitle();
        String oldText = note.getText(); 

        //check if note not is changed
        if(oldTitle.equals(title) && oldText.equals(noteText)) {
            sendToAppScene(new Note(oldTitle, oldText, createdDate, createdDate));
            return;
        }

        //if note is edited, creates a new Note object and sends it to AppController
        Note editedNote = new Note(title, noteText, createdDate, editedDate);
        sendToAppScene(editedNote);
    }

    public void handleWrongInput(String message){
        Alert alert = new Alert(AlertType.WARNING, message);
        alert.show();
    }

    public void sendToAppScene(Note editnote) throws IOException{

        Stage currentStage = (Stage) noteeditpane.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/App.fxml"));
        Parent root = loader.load();

        AppController appController = loader.getController();
        appController.updateinfo(editnote);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("NoteBook Overview");
        stage.show();

        currentStage.close();    
    } 
}