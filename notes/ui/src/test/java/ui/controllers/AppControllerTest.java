package ui.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationTest;


import core.Errors;
import dataaccess.LocalNotesAccess;
import dataaccess.NotesAccess;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.App;

public class AppControllerTest extends ApplicationTest{

    private Button deleteButton;
    private Button editButton;
    private Button newNoteButton;
    private ListView<String> listView;
    private Text errorMessage;
    private ComboBox<String> comboBox;
    
    private FxRobot robot = new FxRobot();
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

    @BeforeEach
    public void initFields() {
        deleteButton = lookup("#DeleteNoteButton").query();
        editButton = lookup("#editNoteButton").query();
        newNoteButton = lookup("#NewNoteButton").query();
        listView = lookup("#NoteListView").query();
        comboBox = lookup("#sortComboBox").query();
        errorMessage = lookup("#errorMessage").query();
    }

    @Test
    public void testUIComponentsExist() {
        assertNotNull(deleteButton);
        assertNotNull(editButton);
        assertNotNull(newNoteButton);
        assertNotNull(listView);
        assertNotNull(comboBox);  
        assertNotNull(errorMessage);  

    }


    @Test
    public void deleteNote(){
        robot.clickOn("#DeleteNoteButton");
        assertEquals(Errors.SELECT_NOTE.getMessage(), errorMessage.getText());
        robot.clickOn("#NewNoteButton");        
        robot.clickOn("#newNoteInputTitle").write("New Title");
        robot.clickOn("#newNoteInputText").write("Text two");
        robot.clickOn("#saveNoteButton");

        Node node = listView.lookup(".thumb");
        robot.clickOn(node, MouseButton.PRIMARY);
        robot.clickOn("#DeleteNoteNutton");
        assertTrue(errorMessage.getText().isEmpty());

    }

    @Test
    public void editNote(){
        robot.clickOn("#editNoteButton");
        assertEquals(Errors.SELECT_NOTE.getMessage(), errorMessage.getText());
        robot.clickOn("#NewNoteButton");        
        robot.clickOn("#newNoteInputTitle").write("Another Title");
        robot.clickOn("#newNoteInputText").write("Text again");
        robot.clickOn("#saveNoteButton");

        Node node = listView.lookup(".thumb");
        robot.clickOn(node, MouseButton.PRIMARY);
        robot.clickOn("#editNoteNutton");
        assertTrue(errorMessage.getText().isEmpty());

    }

}
