package core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Note {
    private String title;
    private String text;
    private LocalDate created;
    private LocalDate edited;
    private Collection<NoteListener> listeners = new ArrayList<>();

    /**
     * 
     * @param title
     * @param text
     */
    public Note(String title, String text) {
        if(this.title == null) {
            throw new IllegalArgumentException(Errors.EMPTY_TITLE.getMessage());
        }
        this.title = title;
        
        if(this.text == null) {
            throw new IllegalArgumentException(Errors.EMPTY_TEXT.getMessage());
        }
        this.text = text;
        this.created = LocalDate.now();
        this.edited = LocalDate.now();
    }

    /**
     * Constructs a new Note with the specified title, text, creation date, and edited date. 
     * The creation date must not be after the edited date. It it is, an IllegalArgumentExeption
     * will be thrown
     * LocalDate format: year-month-day
     * Example: 2023-09-25
     * @param title title of note
     * @param text text describing the note
     * @param created local date when the Note was created
     * @param edited local date when the Note was last edited
     * @throws IllegalArgumentException if the creation date is after the edited date
     */
    public Note(String title, String text, LocalDate created, LocalDate edited) {
        if(this.title == null) {
            throw new IllegalArgumentException(Errors.EMPTY_TITLE.getMessage());
        }
        this.title = title;

        if(this.text == null) {
            throw new IllegalArgumentException(Errors.EMPTY_TEXT.getMessage());
        }
        this.text = text;

        if(created.isAfter(edited)){
            throw new IllegalArgumentException(Errors.INVALID_CREATE_DATE.getMessage());
        }
        this.created = created;
        this.edited = edited;
    }

    /**
     * 
     * @return the the title of the Note
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title of the Note
     */
    public void setTitle(String title) {
        if(this.title == null) {
            throw new IllegalArgumentException(Errors.EMPTY_TITLE.getMessage());
        }
        this.title = title;
        fireNoteChanged(listeners);
    }

    /**
     * 
     * @return the text in the Note 
     */
    public String getText() {
        return text;
    }

    /**
     * 
     * @param text text in the note
     */
    public void setText(String text) {
        if(this.text == null) {
            throw new IllegalArgumentException(Errors.EMPTY_TEXT.getMessage());
        }
        this.text = text;
        fireNoteChanged(listeners);
    }

    /**
     * 
     * @return when the Note was created
     * 
     */
    public LocalDate getCreatedDate() {
        return created;
    }

    /**
     * 
     * @return when the Note last was edited
     */
    public LocalDate getEditedDate() {
        return edited;
    } 

    /**
     * If note is edited, this method sets edited date to todays date
     */
    public void setEditedDate() {
        this.edited = LocalDate.now();
        fireNoteChanged(listeners);
    } 

    /**
     * Adds a specified NoteListener to this objects list of listeners, if its not already present
     * @param listener to be added
     */
    public void addNoteListener(NoteListener listener){
        if(!listeners.contains(listener)){
            listeners.add(listener);
        }
    }

    /**
     * Removes the specified NoteListener from this objects list of listeners
     * @param listener to be removed
     */
    public void removeNoteListener(NoteListener listener){
        if(listeners.contains(listener)){
            listeners.remove(listener);
        }
    }

    /** 
     * Fire changes in Note to all listeners
     * @param listeners a collection of NoteListeners to be notified 
     */
    public void fireNoteChanged(Collection<NoteListener> listeners){
        for (NoteListener listener : listeners) {
            listener.noteChanged();
        }
    }    

    public List<NoteListener> getNoteListeners(){
        return new ArrayList<NoteListener>(this.listeners);
    }
}