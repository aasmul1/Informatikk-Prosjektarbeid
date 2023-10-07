package core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

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
        this.title = title;
        this.text = text;
        this.created = LocalDate.now();
        this.edited = LocalDate.now();
    }

    /**
     * LocalDate format: year-month-day
     * Example: 2023-09-25
     * @param title
     * @param text
     * @param created local date when the Note was created
     * @param edited local date when the Note was last edited
     */
    public Note(String title, String text, LocalDate created, LocalDate edited) {
        this.title = title;
        this.text = text;
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

    public void setText(String text) {
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

    public void setEditedDate() {
        this.edited = LocalDate.now();
        fireNoteChanged(listeners);
    } 

    public void addNoteListener(NoteListener listener){
        if(!listeners.contains(listener)){
            listeners.add(listener);
        }
    }

    public void removeNoteListener(NoteListener listener){
        if(listeners.contains(listener)){
            listeners.remove(listener);
        }
    }

    public void fireNoteChanged(Collection<NoteListener> listeners){
        for (NoteListener listener : listeners) {
            listener.noteChanged();
        }
    }

    public static void main(String[] args) {

    }

    
}
