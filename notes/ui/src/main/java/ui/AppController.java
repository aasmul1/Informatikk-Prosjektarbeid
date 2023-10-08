package ui;

import java.io.IOException;
// import java.net.URL;
// import java.util.ResourceBundle;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import core.Note;
import core.NoteOverview;
import core.NoteOverviewListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import json.NotesPersistence;


public class AppController implements Initializable, NoteOverviewListener{

    private Note note; 
    private NotesPersistence notesPersistence = new NotesPersistence();
    protected NoteOverview noteOverview = notesPersistence.readNoteOverview();
    
    @FXML
    private AnchorPane noteoverviewpane; 

    @FXML
    private ListView<String> NoteListView; 

    @FXML
    private Button NewNoteButton;

    @FXML
    private Button DeleteNoteButton;

    @FXML
    private ComboBox<String> sortComboBox;

    private List<String> sortList = Arrays.asList("Date created", "Last edited date", "Title (A-Z)");

    


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startScene();
        sortComboBox.getItems().addAll(sortList);
    }

    public void startScene(){
        noteOverview = notesPersistence.readNoteOverview();
        noteOverview.addListener(this);
        NoteListView.getItems().clear();
        NoteListView.getItems().addAll(searchList(noteOverview.getNotes()));
    }

    @FXML
    public void newNote(ActionEvent event) throws IOException {  
        sendToNoteScene();
    }

    // @FXML public void listViewMouseClick(MouseEvent arg0) {
    //     try {
    //         String note = NoteListView.getSelectionModel().getSelectedItem();
    //         getNote(note);
    //     } catch (IllegalArgumentException e) {
    //         this.handleWrongInput("No notes to choose");
    //         return;
    //     }
        
        
        
    // }

    // public void getNote(String listViewNote){
    //     String title = listViewNote.substring(0, listViewNote.indexOf('\n')).toLowerCase();
    //     Note matchedNote = null;
    //     for (Note existingNote : noteOverview.getNotes()) {
    //         if(existingNote.getTitle().equals(title)){
    //             matchedNote = existingNote;
    //         }
    //     }
    //     if(matchedNote != null){
    //         this.note = matchedNote;
    //     }
    //     else{
    //         this.note = null;
    //     }
    // }

    /** Method for deleting a Note. 
     * 
     * @param event
     * @throws IOException
     */
    @FXML
    public void deleteNote(ActionEvent event) throws IOException {
        int selectedNoteIndex = NoteListView.getSelectionModel().getSelectedIndex(); 
        if (selectedNoteIndex == -1) {
            handleWrongInput("Choose a note you want to delete");
            return;
        }
        noteOverview.deleteNote(selectedNoteIndex);
    }

    /** Method for editing a Note, deletes note and sends it to NoteEditingScene. 
     * 
     * @param event
     * @throws IOException
     */
    @FXML
    public void editNote(ActionEvent event) throws IOException {
        int selectedNoteIndex = NoteListView.getSelectionModel().getSelectedIndex(); 
        if (selectedNoteIndex == -1) {
            handleWrongInput("Choose a note you want to edit");
            return;
        }
        Note editNote = noteOverview.getNotes().get(selectedNoteIndex);
        noteOverview.deleteNote(selectedNoteIndex);

        sendToNoteEditingScene(editNote);
    }


    @FXML
    public void sortNoteOverview(){
        String sort = sortComboBox.getValue();
        if(sort == null) {
            return;
        }
        if(sort.equals(sortList.get(0))) { //"Created date"
            noteOverview.sortNotesByCreatedDate();
        }
        else if(sort.equals(sortList.get(1))) { //"Last edited date"
            noteOverview.sortNotesByCreatedDate();
        }
        else if(sort.equals(sortList.get(2))) { //"Title (A-Z)"
            noteOverview.sortNotesByCreatedDate();
        }
    }

    /** Method for adding note
     * 
     * @param note
     */
    public void updateinfo(Note note){
        try {
            noteOverview.addNote(note);
        } catch (IllegalArgumentException e) {
            this.handleWrongInput("Fill inn all fields");
            return;
        }
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

    public void handleWrongInput(String message){
        Alert alert = new Alert(AlertType.WARNING, message);
        alert.show();
    }
    
    @Override
    public void noteOverviewChanged() {
        updateJson();
    }

    public void updateJson() {
        notesPersistence.writeNoteOverview(noteOverview);
        startScene();
    }
}
