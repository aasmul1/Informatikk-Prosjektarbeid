package ui;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.service.query.NodeQuery;
import org.testfx.matcher.base.NodeMatchers;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EditNoteTest extends ApplicationTest {

    private AppController controller;
    private Parent root;
    
    
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("NoteEdit.fxml"));
        root = fxmlLoader.load();
        controller = fxmlLoader.getController();
        fxmlLoader.setController(controller);
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void click(String label) {
        clickOn(LabeledMatchers.hasText(label));
    }

    // @Test
    // public void testEditNote() {
 
    //     click("Title");
    //     write("");
    //     click("#saveNoteButton");
    //     sleep(500); // Delay
    //     verifyThat("Warning", isVisible());
    //     click("OK");
    //     sleep(500);
    //     NodeQuery query = lookup("Warning"); // Looks up "Warning"
    //     assertTrue(query.queryAll().isEmpty());
        
        
    // }



}