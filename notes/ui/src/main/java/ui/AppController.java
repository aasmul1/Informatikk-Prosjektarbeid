package ui;

import java.io.IOException;
// import java.net.URL;
// import java.util.ResourceBundle;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import core.Note;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import json.NotesPersistence;


public class AppController implements Initializable{

    private Note note; 
    private NotesPersistence notesPersistence = new NotesPersistence();
    

    @FXML
    private AnchorPane noteoverviewpane; 

    @FXML
    private ListView<String> NoteListView; 

    @FXML
    private Button NewNoteButton;


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

    public void updateinfo2(Note note){
        NoteOverview noteOverview = notesPersistence.readNoteOverview();
        noteOverview.addNote(note);
        notesPersistence.writeNoteOverview(noteOverview);

        startScene();
    }

    

    public void updateinfo(Note note){
        NoteOverview noteOverview = notesPersistence.readNoteOverview();
                    try {
            noteOverview.addNote(note);
        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(AlertType.WARNING, e.getMessage());
            alert.show();
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
}
