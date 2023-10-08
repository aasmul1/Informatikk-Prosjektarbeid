package ui;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.*;
import org.testfx.api.FxRobot;

/**
 * TestFX App test
 */
public class AppTest extends ApplicationTest {

    private AppController controller;
    private Parent root;

    // @BeforeAll
    // public static void headless() {
    //     if (Boolean.valueOf(System.getProperty("gitlab-ci", "false"))) {
    //         System.setProperty("prism.verbose", "true"); // optional
    //         System.setProperty("java.awt.headless", "true");
    //         System.setProperty("testfx.robot", "glass");
    //         System.setProperty("testfx.headless", "true");
    //         System.setProperty("glass.platform", "Monocle");
    //         System.setProperty("monocle.platform", "Headless");
    //         System.setProperty("prism.order", "sw");
    //         System.setProperty("prism.text", "t2k");
    //         System.setProperty("testfx.setup.timeout", "2500");
    //     }
    // }



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
    public void testOpenNewNoteScene() {
        
        String label = "New Note";
        click(label);
        
        

        // Wait for the "Note.fxml" scene to appear (you may need to adjust the delay)
        sleep(1000); // Adjust the delay as needed

        // Verify that an element in the "Note.fxml" scene is displayed (use a unique element ID)
        verifyThat("Save Note", isVisible());

        // Optionally, you can verify that elements from the "App.fxml" scene are no longer visible
        verifyThat("New Note", isInvisible());
        // Assertions.assertEquals(operand, operand, "Wrong value at #" + " of operand stack");
        

    }

    @Test
    public void testNewNote() throws IOException {
        // FxRobot robot = new FxRobot();
        String label = "New Note";
        click(label);
        sleep(1000); // Adjust the delay as needed
        // Load the "Note.fxml" file
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("Note.fxml"));
        
        Parent noteRoot = fxmlLoader.load();
        // You may need to initialize a controller for the "Note.fxml" file if necessary
        // NoteController noteController = fxmlLoader.getController();
        
        // Set the "Note.fxml" root as the current scene's root
        root.getScene().setRoot(noteRoot);
        write("hei");
        moveTo("newNoteInputText").moveBy(0, 100);
        clickOn("newNoteInputText");
        write("yoo");

        // click("title");
        
        // Optionally, you can verify that elements from the "App.fxml" scene are no longer visible
        // verifyThat("New Note", isInvisible());
        // robot.clickOn("newNoteInputTitle").write("Hei");
        // Now, you can interact with elements from the "Note.fxml" file and perform your tests
        // For example:
        // verifyThat("Save Note", isVisible());
        
        

    }
    
}
//         // Verify that an element in the "Note.fxml" scene is displayed (use a unique element ID)
//         verifyThat("#noteElement", isVisible());

//         // Optionally, you can verify that elements from the "App.fxml" scene are no longer visible
//         verifyThat("#appElement", isInvisible());
//         // Assertions.assertEquals(operand, operand, "Wrong value at #" + " of operand stack");
//     }
//     @Test
//     public void testClicksOperand2() {
//         String label = "#EditNoteButton";
//         click(label);
//         // Assertions.assertEquals(operand, operand, "Wrong value at #" + " of operand stack");
//     }
//     @Test
//     public void testClicksOperand3() {
//         String label = "#DeleteNoteButton";
//         click(label);
//         // Assertions.assertEquals(operand, operand, "Wrong value at #" + " of operand stack");
//     }

//     private void checkView(String operand) {
//         Assertions.assertEquals(operand, operand, "Wrong value at #" + " of operand stack");
//     }

//     private void testNoteView() {
        
//     }


//     public Parent getRootNode() {
//         return root;
//     }
// }
