package core;

import java.util.Comparator;

public class EditedDateComparator implements Comparator<Note>{

    @Override
    public int compare(Note note1, Note note2) {
        return note1.getEditedDate().compareTo(note2.getEditedDate());
    }
  
}
