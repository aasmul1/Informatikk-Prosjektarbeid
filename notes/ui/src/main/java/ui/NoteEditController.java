package ui;

import java.io.IOException;

import core.Note;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NoteEditController {

    @FXML
    private AnchorPane noteeditpane; 

    @FXML
    private TextField newNoteInputTitle; 

    @FXML
    private Button addNewNote;

    @FXML
    private TextArea newNoteInputText;



    public void sendToAppScene(Note newnote) throws IOException{

        Stage currentStage = (Stage) noteeditpane.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/App.fxml"));
        Parent root = loader.load();

        AppController appController = loader.getController();
        appController.updateinfo(newnote);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("NoteBook Overview");
        stage.show();

        currentStage.close();    
    }


    
}
