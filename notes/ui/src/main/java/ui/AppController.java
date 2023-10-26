package ui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;


import javafx.util.Callback;
import core.Accounts;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import json.AccountsPersistence;


public class AppController implements Initializable, NoteOverviewListener{

    private AccountsPersistence accountsPersistence = new AccountsPersistence(new File("src/main/resources/noteOverview.json"));
    
    protected Accounts accounts = accountsPersistence.readAccounts();
    protected NoteOverview noteOverview;

    private List<String> sortList = Arrays.asList("Date created", "Last edited date", "Title (A-Z)");
    
    @FXML
    private AnchorPane noteoverviewpane; 

    @FXML
    private ListView<Note> NoteListView; 

    @FXML
    private Button NewNoteButton;

    @FXML
    private Button DeleteNoteButton;

    @FXML
    private ComboBox<String> sortComboBox;
    
    /**
     * Constructor for the AppController when in test mode.
     *
     * @param isTestMode Indicates whether the application is in test mode.
     */
    public AppController(boolean isTestMode) {
        if (isTestMode) {
            accountsPersistence = new AccountsPersistence(new File("src/main/resources/testOverview.json"));
            System.out.println("New file (test)");
            accounts = accountsPersistence.readAccounts();
            noteOverview = accounts.getUser("username").getNoteOverview();
        }
    }

    public AppController() {  
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startScene();
        sortComboBox.getItems().addAll(sortList);
    }

    /**
     * Initializes the main scene, including loading notes and setting up listeners
     */
    public void startScene(){
        accounts = accountsPersistence.readAccounts();
        noteOverview = accounts.getUser("username").getNoteOverview();
        noteOverview.addListener(this);
        NoteListView.getItems().clear();
        NoteListView.getItems().addAll(noteOverview.getNotes());
        NoteListView.setCellFactory(new Callback<ListView<Note>, ListCell<Note>>() {
            @Override
            public ListCell<Note> call(ListView<Note> listView) {
                return new CustomListCell();
            }
        });
        
    }

    @FXML
    public void newNote(ActionEvent event) throws IOException {  
        sendToNoteScene();
    }

   /**
     * Deletes a selected note.
     * 
     * @param event the ActionEvent triggered by the "Delete" button click.
     * @throws IOException if an error occurs during note deletion
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

    /**
     * Edits a selected note by deleting it and sending it to the note editing scene.
     * 
     * @param event the ActionEvent triggered by the "Edit" button click.
     * @throws IOException if an error occurs during the transition to the note editing scene.
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


    /** 
     * Sorts the NoteOverview using the selected sorting algorithm.
     */
    @FXML
    public void sortNoteOverview(){
        String sort = sortComboBox.getValue();
        if (sort.equals(null)) return;
        if(sort.equals(sortList.get(0))) { //"Created date"
            noteOverview.sortNotesByCreatedDate();
        }
        else if(sort.equals(sortList.get(1))) { //"Last edited date"
            noteOverview.sortNotesByCreatedDate();
        }
        else if(sort.equals(sortList.get(2))) { //"Title (A-Z)"
            noteOverview.sortNotesByTitle();
        }
    }

    /** 
     * Adds a new note to the NoteOverview.
     * 
     * @param note to be added
     */
    public void updateinfo(Note note){
        try {
            noteOverview.addNote(note);
        } catch (IllegalArgumentException e) {
            this.handleWrongInput("Fill inn all fields");
            return;
        }
    }
    
    /**
     * Method for transitioning to the "Create Note" scene by loading the "Note.fxml" file.
     * Closes the current stage and opens a new one for creating a new note.
     * 
     * @throws IOException if there is an issue loading the FXML file.
     */
    public void sendToNoteScene() throws IOException{

        Stage currentStage = (Stage) noteoverviewpane.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/Note.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Create note stage");
        stage.show();

        currentStage.close();    
    }

    /**
     * Method for transitioning to the "Note Editing" scene by loading the "NoteEdit.fxml" file.
     * Closes the current stage, opens new one, and initializes the NoteEditController
     * to edit a selected note.
     * 
     * @param note The selected note to edit.
     * @throws IOException if there is an issue loading the FXML file.
     */
    public void sendToNoteEditingScene(Note note) throws IOException{

        Stage currentStage = (Stage) noteoverviewpane.getScene().getWindow();

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

    /**
     * Method for displaying a warning message in the form of an Alert.
     * 
     * @param message The message to display in the warning.
     */
    public void handleWrongInput(String message){
        Alert alert = new Alert(AlertType.WARNING, message);
        alert.show();
    }
    
    /**
     * Callback method triggered when the NoteOverview is changed. It updates the JSON representation
     * of the NoteOverview and refreshes the scene.
     */
    @Override
    public void noteOverviewChanged() {
        updateJson();
    }

    /**
     * Method for updating the JSON representation of the Note Overview and refreshing the scene.
     */
    public void updateJson() {
        accountsPersistence.writeAccounts(accounts);
        startScene();
    } 
}
