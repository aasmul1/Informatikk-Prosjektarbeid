package ui.controllers;

import java.io.IOException;

import org.testfx.framework.junit5.ApplicationTest;

import dataaccess.LocalNotesAccess;
import dataaccess.NotesAccess;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.App;

public class AppControllerTest extends ApplicationTest{

    private Button deleteButton;
    private Button editButton;
    private Button newNoteButton;
    private ListView<String> listView;
    private Text errorMessage;

    private NotesAccess dataAccess = new LocalNotesAccess();
    
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(App.class.getResource("App.fxml"));

        LoginController controller = new LoginController();
        fxmlLoader.setController(controller);

        controller.setDataAccess(dataAccess);

        final Parent parent = fxmlLoader.load();
        stage.setScene(new Scene(parent));
        stage.show();
    }
}
