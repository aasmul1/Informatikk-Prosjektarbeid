package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.matcher.control.TextInputControlMatchers;
import org.testfx.service.query.NodeQuery;

import static org.testfx.matcher.base.NodeMatchers.*;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.*;


/**
 * TestFX Note test
 */
public class NoteTest extends ApplicationTest {

    private NoteController controller;
    private Parent root;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("Note.fxml"));
        root = fxmlLoader.load();
        controller = fxmlLoader.getController();
        stage.setScene(new Scene(root));
        stage.show();
    }

    // @Test
    // public void testController_initial() {
    //   assertNotNull(this.controller);
    // }
  
    private void click(String label) {
        clickOn(LabeledMatchers.hasText(label));
    }

    @Test
    public void testNewNote() throws IOException {
 
        clickOn("#newNoteInputTitle").write("Title");
        clickOn("#newNoteInputText").write("Text");

        verifyThat("Title", isVisible());
        verifyThat("Text", isVisible());
        clickOn("#saveNoteButton");
        sleep(3000);
        verifyThat("Edit", isVisible());
        
    }  
}

