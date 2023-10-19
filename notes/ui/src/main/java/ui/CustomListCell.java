package ui;

import core.Note;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class CustomListCell extends ListCell<Note>{
	private HBox content;
	private Text title = new Text();
	private Text text = new Text();
	private Text date = new Text();

    public CustomListCell() {
        super();
        VBox vBox = new VBox(title, text);
        content = new HBox(date, vBox);
        content.setSpacing(10);
    }

	@Override
        protected void updateItem(Note note, boolean empty) {
            super.updateItem(note, empty);
            if (note != null && !empty) { // <== test for null item and empty parameter
                title.setText(note.getTitle());
                text.setText(String.format("%s", note.getText()));
				date.setText(String.format("%s",note.getCreatedDate()));
                setGraphic(content);
            } else {
                setGraphic(null);
            }
        }
}
