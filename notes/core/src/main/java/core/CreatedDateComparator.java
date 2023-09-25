package core;

import java.util.Comparator;

public class CreatedDateComparator implements Comparator<Note> {

    @Override
    public int compare(Note note1, Note note2) {
        return note1.getCreatedDate().compareTo(note2.getCreatedDate());
    }

}
