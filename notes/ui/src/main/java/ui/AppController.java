package ui;

import java.io.IOException;
// import java.net.URL;
// import java.util.ResourceBundle;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import core.Note;
import core.NoteListener;
import core.NoteOverview;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import json.NotesPersistence;


public class AppController implements Initializable, NoteListener{

    private Note note; 
    private NotesPersistence notesPersistence = new NotesPersistence();
    NoteOverview noteOverview = notesPersistence.readNoteOverview();
    

    @FXML
    private AnchorPane noteoverviewpane; 

    @FXML
    private ListView<String> NoteListView; 

    @FXML
    private Button NewNoteButton;

    @FXML
    private Button DeleteNoteButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startScene();
    }

    public void startScene(){
        NoteListView.getItems().clear();
            if(notesPersistence.readNoteOverview() != null){
        NoteListView.getItems().addAll(searchList(notesPersistence.readNoteOverview().getNotes()));
        }

    }

    @FXML
    public void newNote(ActionEvent event) throws IOException {  
        sendToNoteScene();
    }

    @FXML public void listViewMouseClick(MouseEvent arg0) {
        String note = NoteListView.getSelectionModel().getSelectedItem();
        getNote(note);
    }

    public void getNote(String listViewNote){
        String title = listViewNote.substring(0, listViewNote.indexOf('\n'));
        Note matchedNote = null;
        for (Note existingNote : noteOverview.getNotes()) {
            if(existingNote.getTitle().equals(title)){
                matchedNote = existingNote;
            }
        }
        if(matchedNote != null){
            this.note = matchedNote;
        }
        else{
            this.note = null;
        }
    }

    @FXML
    public void deleteNote(ActionEvent event) throws IOException {
        if(this.note == null){
            this.handleWrongInput("Choose a note you want to delete");
            return;
        }
        deleteNote(note);
    }

    public void deleteNote(Note note){
        noteOverview.deleteNote(note);
        noteOverview = notesPersistence.readNoteOverview();
    }

    public void updateinfo(Note note){
        noteOverview = notesPersistence.readNoteOverview();
        try {
            noteOverview.addNote(note);
        } catch (IllegalArgumentException e) {
            this.handleWrongInput("Fill inn all fields");
            return;
        }

        notesPersistence.writeNoteOverview(noteOverview);

       startScene();
    }


        private List<String> searchList(List<Note> list){
        List<String> notes = new ArrayList<String>();
        
        for (Note note : list) {
            String title = note.getTitle().toUpperCase();
            String text = note.getText();

            notes.add(title+"\n\n"+text+"\n\n");
        }
        
        return notes;
    }
    

    public void sendToNoteScene() throws IOException{

        Stage currentStage = (Stage) noteoverviewpane.getScene().getWindow();

        //FXMLLoader loader = new FXMLLoader(getClass().getResource("NoteController.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/Note.fxml"));
        Parent root = loader.load();

        //AppController appController = loader.getController();
        //skal vi sende noe informasjon 

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Create note stage");
        stage.show();

        currentStage.close();    
    }


    

    public void sendToNoteEditingScene(Note note) throws IOException{

        Stage currentStage = (Stage) noteoverviewpane.getScene().getWindow();

        //FXMLLoader loader = new FXMLLoader(getClass().getResource("NoteController.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/NoteEdit.fxml"));
        Parent root = loader.load();

        NoteEditController noteEditController = loader.getController();
        noteEditController.updateinfo(note);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Note edit stage");
        stage.show();

        currentStage.close();    
    }

    @Override
    public void noteChanged(Collection<NoteListener> listeners, Note note) {
        updateinfo(note);
       
    }

    public void handleWrongInput(String message){
        Alert alert = new Alert(AlertType.WARNING, message);
        alert.show();
    }

}
