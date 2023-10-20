package ui;

import core.Note;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class CustomListCell extends ListCell<Note>{
	private HBox content;
	private Text title = new Text();
	private Text text = new Text();
	private Text date = new Text();

    public CustomListCell() {
        super();
        VBox vBox = new VBox(title, text);
        HBox hBox = new HBox(date);
        
        content = new HBox(vBox, hBox);
        content.setSpacing(10);
        

        // Set alignment for the child HBoxes
        HBox.setHgrow(vBox, Priority.ALWAYS); // Makes vBox take as much space as possible on the left
        HBox.setHgrow(hBox, Priority.NEVER);
    }

	@Override
        protected void updateItem(Note note, boolean empty) {
            super.updateItem(note, empty);
            if (note != null && !empty) { // <== test for null item and empty parameter
                title.setText(note.getTitle());
                text.setText(String.format("%s", note.getText()));
                title.setFont(Font.font("Arial", FontWeight.BOLD, 13));
				date.setText(String.format("%s", note.getCreatedDate()));
                title.setWrappingWidth(300); // Set the maximum width for title text
                text.setWrappingWidth(300);
                setGraphic(content);
            } else {
                setGraphic(null);
            }
        }
}
