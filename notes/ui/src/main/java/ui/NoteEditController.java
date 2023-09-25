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

public class NoteEditController{

    private Note note; 

    @FXML
    private AnchorPane noteeditpane; 

    @FXML
    private TextField noteInputTitle; 

    @FXML
    private Button addNewNote;

    @FXML
    private TextArea noteInputText;

    @FXML
    public void initialize(){
        String titel = note.getTitle();
        String text = note.getText();

        noteInputTitle.setText(titel);
        noteInputText.setText(text); 
        
    }

    public void updateinfo(Note note){
        this.note = note;    
    }



    public void sendToAppScene(Note note) throws IOException{

        Stage currentStage = (Stage) noteeditpane.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/App.fxml"));
        Parent root = loader.load();

        AppController appController = loader.getController();
        appController.updateinfo(note);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("NoteBook Overview");
        stage.show();

        currentStage.close();    
    }

    



    
}
