package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class AppController {



    @FXML
    private ListView<String> NoteListView; 

    @FXML
    private Label NewNoteButton;

    public AppController() {
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NoteListView.getItems().clear();
        NoteListView.getItems().addAll(searchList(file.load(), search.getText().toLowerCase()));
    }

    @FXML
    public void newNote(ActionEvent event) throws IOException {  
        

                
    }
}
