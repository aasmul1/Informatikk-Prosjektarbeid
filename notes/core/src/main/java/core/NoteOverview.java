package core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NoteOverview {
    private List<Note> notes = new ArrayList<Note>();

    public NoteOverview(List<Note> notes) {
        this.notes = notes;
    }

    public NoteOverview() {
    }

    public void addNote(Note note) {
        if (note == null) return;
        if (notes.stream().anyMatch(x -> x.getTitle().equals(note.getTitle()))) {
            throw new IllegalArgumentException("Note with that title already exist");
        }
        notes.add(note);
    }

    /**
     * 
     * @param note
     */
    public void deleteNote(Note note) {
        if (!notes.contains(note)) throw new IllegalArgumentException();
        notes.remove(note);
    }

    public void deleteNote(int index) {
        if (notes.size()-1 < index) throw new IllegalArgumentException(); 
        notes.remove(index);
    }

    public List<Note> getNotes() {
        return this.notes;
    }

    public Iterator<Note> notesIterator() {
        return this.notes.iterator();
    }

    public void sortNotesByCreatedDate() {
        notes.sort(new CreatedDateComparator());
    }

    public void sortNotesByLastEditedDate() {
        notes.sort(new EditedDateComparator());
    }

    public void sortNotesByTitle() {
        notes.sort(new TitleComparator());
    }

    public static void main(String[] args) {
        
    }
}
