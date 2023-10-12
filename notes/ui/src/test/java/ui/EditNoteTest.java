package ui;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.matcher.base.NodeMatchers;
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
    // public void testEditNote() throws IOException {
 
    //     clickOn("#noteInputTitle").write("Title");
    //     clickOn("#noteInputText").write("Text");
    //     clickOn("#saveNoteButton");
        
    //     verifyThat("Save Note", isVisible());


    //     // verifyThat("#newNoteInputTitle", "Title");
    //     // clickOn("newNoteInputTitle").write("Title");
    //     // clickOn("newNoteInputText").write("Text");
    // }



}