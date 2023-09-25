package ui;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;

import core.Note;

/**
 * TestFX App test
 */
public class AppTest extends ApplicationTest {

    private AppController controller;
    private Parent root;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("App.fxml"));
        root = fxmlLoader.load();
        controller = fxmlLoader.getController();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public Parent getRootNode() {
        return root;
    }

    private void click(String... labels) {
        for (String label: labels) {
            clickOn(LabeledMatchers.hasText(label));
        }
    }

    private ListView<String> getNoteView() {
        return (ListView<String>) getRootNode().lookup("#operandsView");
    }

    private ObservableList<String> getNotes() {
        return getNoteView().getItems();

    }
}
