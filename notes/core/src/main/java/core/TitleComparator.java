package core;

import java.util.Comparator;

public class TitleComparator implements Comparator<Note>{

    @Override
    public int compare(Note note1, Note note2) {
        return note1.getTitle().compareTo(note2.getTitle());
    }

}
