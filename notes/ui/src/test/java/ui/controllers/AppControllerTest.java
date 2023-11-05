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
import core.Note;
import core.NoteOverview;
import core.User;
import dataaccess.LocalNotesAccess;
import dataaccess.NotesAccess;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
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
    private NoteOverview noteoverview = new NoteOverview();
    private User user = new User("Osman", "Password3", noteoverview);
    private Note note = new Note("Tittel", "Text");
    
    
    
    @Override
    public void start(Stage stage) throws IOException {
        user.addNote(note);
        dataAccess.userLogin("Osman", "Password3");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(App.class.getResource("App.fxml"));

        AppController controller = new AppController();
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

         // Load the NewNote scene
        FXMLLoader loader = new FXMLLoader(App.class.getResource("Note.fxml"));
        NoteController noteController = new NoteController();
        loader.setController(noteController);
        AnchorPane expectedPane;
        try {
            expectedPane = loader.load();
        } catch (IOException e) {
            throw new AssertionError("Failed to load Note.fxml", e);
        }

        // Get the current window's root pane
        Window currentWindow = robot.window(0); // the primary window
        Scene currentScene = currentWindow.getScene();
        Parent currentRoot = currentScene.getRoot();
        if (!(currentRoot instanceof AnchorPane)) {
            throw new AssertionError("Expected root to be instance of AnchorPane");
        }
        AnchorPane currentPane = (AnchorPane) currentRoot;

        // Compare children nodes, ensure that the scene transition works as expected
        ObservableList<Node> nodeListCurrentWindow = currentPane.getChildren();
        ObservableList<Node> nodeListExpectedWindow = expectedPane.getChildren();
        for (int i = 0; i < nodeListCurrentWindow.size(); i++) {
            assertEquals(nodeListCurrentWindow.get(i).getId(), nodeListExpectedWindow.get(i).getId());
        }
        robot.clickOn("#newNoteInputTitle").write("New Title");
        robot.clickOn("#newNoteInputText").write("Text two");
        robot.clickOn("#saveNoteButton");
        ListView<String> node2 = lookup("#NoteListView").query();


        // Add an item to the ListView using the controller
        Node node = node2.lookup(".thumb");
        robot.clickOn(node, MouseButton.PRIMARY);
        robot.clickOn("#DeleteNoteButton");
        assertTrue(node2.getItems().isEmpty());
        


    }

    // @Test
    // public void editNote(){
    //     robot.clickOn("#editNoteButton");
    //     assertEquals(Errors.SELECT_NOTE.getMessage(), errorMessage.getText());
    //     robot.clickOn("#NewNoteButton");        
    //     robot.clickOn("#newNoteInputTitle").write("Another Title");
    //     robot.clickOn("#newNoteInputText").write("Text again");
    //     robot.clickOn("#saveNoteButton");

    //     Node node = listView.lookup(".thumb");
    //     robot.clickOn(node, MouseButton.PRIMARY);
    //     robot.clickOn("#editNoteButton");
    //     assertTrue(errorMessage.getText().isEmpty());

    // }

}
