package core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class NoteOverview implements NoteListener {
    private List<Note> notes = new ArrayList<Note>();
    private Collection<NoteOverviewListener> listeners = new ArrayList<>();

    /**
     * Constructs a new NoteOverview with the specified list of notes
     * @param notes the list of Note objects to be associated with this overview
     */
    public NoteOverview(List<Note> notes) {
        this.notes = notes;
    }

    /**
     * Constructs a new, empty NoteOverview
     */
    public NoteOverview() {
    }

    /**
     * Registers the specified NoteOverviewListener with this object.
     * @param noteOverviewListener the NoteOverviewListener to be registered
     */
    public void addListener(NoteOverviewListener noteOverviewListener) {
        listeners.add(noteOverviewListener);    
    }

    /**
     * Removes the specified NoteOverviewListener with this object
     * @param noteOverviewListener the NoteOverviewListener to be registred
     */
    public void removeListener(NoteOverviewListener noteOverviewListener) {
        listeners.remove(noteOverviewListener);
    }

    /**
     * Adds the specified Note to the internal collection of notes
     * @param note the Note to be added
     * @throws IllegalArgumentException if a note with the same title already exists in the collection
     */
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
     * Removes the specified Note from the internal collection of notes
     * @param note the Note to be removed
     * @throws IllegalArgumentException if the specified note is not found in the collection
     */
    public void deleteNote(Note note) {
        if (!notes.contains(note)) throw new IllegalArgumentException();
        notes.remove(note);
        fireNoteOverviewChanged();
    }

    /**
     * Removes the note at a specified position in the internal collection of notes
     * @param index the position of the Note to be removed
     * @throws IllegalArgumentException if the index is out of range
     */
    public void deleteNote(int index) {
        if (notes.size()-1 < index) throw new IllegalArgumentException(); 
        notes.remove(index);
        fireNoteOverviewChanged();
    }

    /**
     * Retrieves a copy of the current list of notes
     * @return a new list containing all the notes from the internal collection
     */
    public List<Note> getNotes() {
        return new ArrayList<Note>(this.notes);
    }

    /**
     * Provides an iterator over the list of notes
     * @return an iterator over the notes in the internal collection
     */
    public Iterator<Note> notesIterator() {
        return this.notes.iterator();
    }

    /**
     * Sorts the internal list of notes by their created date in descending order.
     */
    public void sortNotesByCreatedDate() {
        notes.sort(new CreatedDateComparator().reversed());
        fireNoteOverviewChanged();
    }

    /**
     * Sorts the internal list of notes by their last edited date in descending order.
     */
    public void sortNotesByLastEditedDate() {
        notes.sort(new EditedDateComparator().reversed());
        fireNoteOverviewChanged();
    }

    /**
     * Sorts the internal list of notes alphabetically by their title.
     */
    public void sortNotesByTitle() {
        notes.sort(new TitleComparator());
        fireNoteOverviewChanged();
    }

    /**
     * Notifies all registered NoteOverviewListeners of a change in the note overview
     */
    public void fireNoteOverviewChanged() {
        for (NoteOverviewListener noteOverviewListener: listeners) {
            noteOverviewListener.noteOverviewChanged();
        }
    }

    /**
     * Handles the event when a note has changed.
     */
    @Override
    public void noteChanged() {
        fireNoteOverviewChanged();
    }

}
