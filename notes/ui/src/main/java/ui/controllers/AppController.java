package ui.controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javafx.util.Callback;
import core.Note;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import ui.CustomListCell;

public class AppController extends AbstractController {

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
    @FXML
    private Text errorMessage;

    /**
     * Constructor for the AppController when in test mode.
     *
     * @param isTestMode Indicates whether the application is in test mode.
     */
    public AppController() {
    }

    /**
     * Initializes the main scene, including loading notes and setting up listeners
     */
    public void startScene() {
        NoteListView.getItems().clear();
        NoteListView.getItems().addAll(dataAccess.getUserNoteOverview().getNotes());
        NoteListView.setCellFactory(new Callback<ListView<Note>, ListCell<Note>>() {
            @Override
            public ListCell<Note> call(ListView<Note> listView) {
                return new CustomListCell();
            }
        });
        sortComboBox.getItems().addAll(sortList);

    }

    @FXML
    public void newNote(ActionEvent event) throws IOException {
        setScene(Controllers.NOTE, event, dataAccess);

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
        try {
            dataAccess.deleteNote(selectedNoteIndex);
            updateView();
        } catch (IllegalArgumentException e) {
            errorMessage.setText(e.getMessage());
        }
    }

    /**
     * Edits a selected note by deleting it and sending it to the note editing
     * scene.
     * 
     * @param event the ActionEvent triggered by the "Edit" button click.
     * @throws IOException if an error occurs during the transition to the note
     *                     editing scene.
     */
    @FXML
    public void editNote(ActionEvent event) throws IOException {
        int selectedNoteIndex = NoteListView.getSelectionModel().getSelectedIndex();
        try {
            dataAccess.setSelectedIndex(selectedNoteIndex);
            setScene(Controllers.NOTE_EDIT, event, getDataAccess());
        } catch (IllegalArgumentException e) {
            errorMessage.setText(e.getMessage());
        }
    }

    /**
     * Sorts the NoteOverview using the selected sorting algorithm.
     */
    @FXML
    public void sortNoteOverview() {
        String sort = sortComboBox.getValue();
        if (sort.equals(null))
            return;
        if (sort.equals(sortList.get(0))) { // "Created date"
            dataAccess.sortNotesByCreatedDate();
        } else if (sort.equals(sortList.get(1))) { // "Last edited date"
            dataAccess.sortNotesByLastEditedDate();
        } else if (sort.equals(sortList.get(2))) { // "Title (A-Z)"
            dataAccess.sortNotesByTitle();
        }
        updateView();
    }



    public void updateView() {
        NoteListView.getItems().clear();
        NoteListView.getItems().addAll(dataAccess.getUserNoteOverview().getNotes());
        NoteListView.setCellFactory(new Callback<ListView<Note>, ListCell<Note>>() {
            @Override
            public ListCell<Note> call(ListView<Note> listView) {
                return new CustomListCell();
            }
        });
        errorMessage.setText("");
    }
}
