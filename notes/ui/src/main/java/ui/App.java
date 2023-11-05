package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controllers.LoginController;

import java.io.IOException;

import dataaccess.LocalNotesAccess;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        final FXMLLoader loader = new FXMLLoader();

        LoginController controller = new LoginController();
        controller.setDataAccess(new LocalNotesAccess()); // TODO: remote/local
        loader.setController(controller);
        loader.setLocation(App.class.getResource("/ui/Login.fxml"));
        final Parent parent = loader.load();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    
}