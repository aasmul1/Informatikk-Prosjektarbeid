package ui;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import json.NotesPersistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.matcher.control.ListViewMatchers;
import org.testfx.matcher.control.TextMatchers;
import org.testfx.service.query.NodeQuery;

import core.Note;

import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.*;
import org.testfx.api.FxRobot;
import static org.testfx.util.WaitForAsyncUtils.waitForFxEvents;


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
        controller = new AppController(true);
        fxmlLoader.setController(controller);
        stage.setScene(new Scene(root));
        stage.show();
        
    }

    @Test
    public void testController_initial() {
      assertNotNull(this.controller);
    }
  
    private void click(String label) {
        clickOn(LabeledMatchers.hasText(label));
    }

    @Test
    public void checkVisibleButtons() {
        sleep(2000);
        assertFalse(lookup("New Note").queryAll().isEmpty());
        assertFalse(lookup("Edit").queryAll().isEmpty());
        assertFalse(lookup("Delete Note").queryAll().isEmpty());
        assertFalse(lookup("Sort").queryAll().isEmpty());
        assertFalse(lookup("Notes").queryAll().isEmpty());
    }

    @Test
    public void testOpenNewNoteScene() {
        
        String label = "New Note";
        click(label);
        sleep(500); // Delay
        verifyThat("Save Note", isVisible());  
        clickOn("#saveNoteButton");    
        sleep(500); // Delay
        verifyThat("Warning", isVisible());
        click("OK");
        sleep(500);
        NodeQuery query = lookup("Warning"); // Looks up "Warning"
        assertTrue(query.queryAll().isEmpty());
    }

    @Test
    public void testOpenEditNoteSceneWarning(){
        
        String label = "Edit";
        click(label);
        sleep(500); // Delay
        verifyThat("Warning", isVisible());
        click("OK");
        sleep(500);
        NodeQuery query = lookup("Warning"); // Looks up "Warning"
        assertTrue(query.queryAll().isEmpty());
    }

    @Test
    public void testAddNewNote(){

        String label = "New Note";
        click(label);
        sleep(500); // Delay
        verifyThat("Save Note", isVisible());
        
        // clickOn("#newNoteInputTitle").write("Title");
        // clickOn("#newNoteInputText").write("Text");

        // verifyThat("Title", isVisible());
        // verifyThat("Text", isVisible());
        // clickOn("#saveNoteButton");
        // sleep(3000);
        // verifyThat("Edit", isVisible());
    }

    @Test
    public void testChooseNote(){
        ListView<String> node2 = lookup("#NoteListView").query();
        
        // verifyThat("#NoteListView", ListViewMatchers.hasItems(1));
        String label = "New Note";
        click(label);
        sleep(500); // Delay
        verifyThat("Save Note", isVisible());
        
        // clickOn("#newNoteInputTitle").write("New Title");
        // clickOn("#newNoteInputText").write("Text two");

        // verifyThat("New Title", isVisible());
        // verifyThat("Text two", isVisible());
        // clickOn("#saveNoteButton");
        // sleep(3000);
        // verifyThat("Edit", isVisible());

        // waitForFxEvents();

        // // Add an item to the ListView using the controller
        // verifyThat("#NoteListView", ListViewMatchers.hasItems(2));
        // Node node = node2.lookup(".thumb");
        // clickOn(node, MouseButton.PRIMARY);
        
        // sleep(500);
        // click("Edit");
        // sleep(500); // Delay
        // NodeQuery query = lookup("Warning"); // Looks up "Warning"
        // assertTrue(query.queryAll().isEmpty());

        // clickOn("#noteInputTitle").write("Changed Title");
        // clickOn("#noteInputText").write("Changed Text");
        // clickOn("#saveNoteButton");
        // sleep(1000);
        // verifyThat("New Note", isVisible());
        // click("Sort");

    }

    @Test
    public void deleteWithoutNote(){
        String label = "Delete Note";
        click(label);
        sleep(500); // Delay
        verifyThat("Warning", isVisible());
        click("OK");
        sleep(500);
        NodeQuery query = lookup("Warning"); // Looks up "Warning"
        assertTrue(query.queryAll().isEmpty());
    }
}