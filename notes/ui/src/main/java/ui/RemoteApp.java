package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controllers.LoginController;

import java.net.URI;

import dataaccess.RemoteNotesAccess;

/**
 * JavaFX App
 */
public class RemoteApp extends Application {

    private NotesConfig notesConfig = new NotesConfig();

    @Override
    public void start(Stage stage) throws Exception {
        URI uri = new URI(notesConfig.getProperty("serverURI"));

        final FXMLLoader loader = new FXMLLoader();

        LoginController controller = new LoginController();
        controller.setDataAccess(new RemoteNotesAccess(uri));
        loader.setController(controller);
        loader.setLocation(App.class.getResource("/ui/Login.fxml"));
        final Parent parent = loader.load();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}