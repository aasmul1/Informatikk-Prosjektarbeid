package ui;

import java.io.IOException;
// import java.net.URL;
// import java.util.ResourceBundle;

import core.Note;
// import core.Note;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AppController {

    private Note note; 


    @FXML
    private AnchorPane noteoverviewpane; 

    @FXML
    private ListView<String> NoteListView; 

    @FXML
    private Button NewNoteButton;


    // @Override
    // public void initialize(URL location, ResourceBundle resources) {
    //     NoteListView.getItems().clear();
    //     NoteListView.getItems().addAll(searchList(file.load(), search.getText().toLowerCase()));
    // }

    @FXML
    public void newNote(ActionEvent event) throws IOException {  
        sendToNoteScene();
    }

    public void sendToNoteScene() throws IOException{

        Stage currentStage = (Stage) noteoverviewpane.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("NoteController.fxml"));
        Parent root = loader.load();

        AppController appController = loader.getController();
        //skal vi sende noe informasjon 

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Create note stage");
        stage.show();

        currentStage.close();    
    }
}
