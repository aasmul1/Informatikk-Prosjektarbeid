package ui;

import java.io.IOException;

import core.Note;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NoteController{

    @FXML
    private AnchorPane notepane; 

    @FXML
    private TextField newNoteInputTitle; 

    @FXML
    private Button addNewNote;

    @FXML
    private TextArea newNoteInputText;


    @FXML
    public void initialize(){
        
    }

    @FXML
    public void newNote(ActionEvent event) throws IOException {  
        String title = newNoteInputTitle.getText();
        String noteText = newNoteInputText.getText();

        if (title.isEmpty() || noteText.isEmpty()) {
            this.handleWrongInput("Feil input, fyll alle felt med rikitg input");
            return;
        }
        //skriv til fil
        sendToAppScene();
    }

    public void handleWrongInput(String message){
        Alert alert = new Alert(AlertType.WARNING, message);
        alert.show();
    }

    public void sendToAppScene() throws IOException{

        Stage currentStage = (Stage) notepane.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AppController.fxml"));
        Parent root = loader.load();

        //AppController appController = loader.getController();
        //skal vi sende noe informasjon?

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("NoteBook Overview");
        stage.show();

        currentStage.close();    
    }


}