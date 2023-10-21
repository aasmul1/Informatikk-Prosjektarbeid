package core;

import java.util.List;

public class User {
    private String username;
    private String password;
    private NoteOverview noteOverview;
    
    public User(String username, String password, NoteOverview noteOverview) {
        this.username = username;
        this.password = password;
        this.noteOverview = new NoteOverview();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        UserValidation.checkValidUsername(username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        UserValidation.checkValidPassword(password);
        this.password = password;
    }

    public List<Note> getNoteOverview() {
        return noteOverview.getNotes();
    }

    public Note getNote(Note note) {
        return getNoteOverview().stream().filter(n -> n.getTitle().equals(note.getTitle()))
                                 .findAny()
                                 .orElse(null); 
    }

    public void addNote(Note note) {
        if(!noteExists(note)) {
            noteOverview.addNote(note);
            //evt observer her
        }
    }

    public boolean noteExists(Note note) {
        for (Note n : noteOverview.getNotes()) {
            if(note.getTitle().equals(n.getTitle())) {
                return true;
            }
        }
        return false;
    }
}
