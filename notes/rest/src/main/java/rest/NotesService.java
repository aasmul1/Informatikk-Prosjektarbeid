package rest;

import java.util.List;

import org.springframework.stereotype.Service;

import core.Note;
import core.NoteOverview;

@Service
public class NotesService {

    private NoteOverview noteOverview;

    public void addNote(Note note) {
        noteOverview.addNote(note);
    }

    public List<Note> getAllNotes() {
        return noteOverview.getNotes();
    }


    
}
