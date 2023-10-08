package core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class NoteOverview implements NoteListener {
    private List<Note> notes = new ArrayList<Note>();
    private Collection<NoteOverviewListener> listeners = new ArrayList<>();


    public NoteOverview(List<Note> notes) {
        this.notes = notes;
    }

    public NoteOverview() {
    }

    public void addListener(NoteOverviewListener noteOverviewListener) {
        listeners.add(noteOverviewListener);    
    }

    public void removeListener(NoteOverviewListener noteOverviewListener) {
        listeners.remove(noteOverviewListener);
    }

    public void addNote(Note note) {
        if (note == null) return;
        if (notes.stream().anyMatch(x -> x.getTitle().equals(note.getTitle()))) {
            throw new IllegalArgumentException("Note with that title already exist");
        }
        note.addNoteListener(this);
        notes.add(note);
        fireNoteOverviewChanged();
    }

    /**
     * 
     * @param note
     */
    public void deleteNote(Note note) {
        if (!notes.contains(note)) throw new IllegalArgumentException();
        notes.remove(note);
        fireNoteOverviewChanged();
    }

    public void deleteNote(int index) {
        if (notes.size()-1 < index) throw new IllegalArgumentException(); 
        notes.remove(index);
        fireNoteOverviewChanged();
    }

    public List<Note> getNotes() {
        return new ArrayList<Note>(this.notes);
    }

    public Iterator<Note> notesIterator() {
        return this.notes.iterator();
    }

    public void sortNotesByCreatedDate() {
        notes.sort(new CreatedDateComparator().reversed());
        fireNoteOverviewChanged();
    }

    public void sortNotesByLastEditedDate() {
        notes.sort(new EditedDateComparator().reversed());
        fireNoteOverviewChanged();
    }

    public void sortNotesByTitle() {
        notes.sort(new TitleComparator());
        fireNoteOverviewChanged();
    }

    public static void main(String[] args) {
        
    }

    public void fireNoteOverviewChanged() {
        for (NoteOverviewListener noteOverviewListener: listeners) {
            noteOverviewListener.noteOverviewChanged();
        }
    }

    @Override
    public void noteChanged() {
        fireNoteOverviewChanged();
    }
}
