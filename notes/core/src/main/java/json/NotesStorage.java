package json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import core.Note;
import core.NoteOverview;

public class NotesStorage {
    
    private ObjectMapper mapper;

    public NotesStorage() {
        this.mapper = new ObjectMapper();
    }

    public NoteOverview readNoteOverview() {
        NoteOverview noteOverview;
        try {
            noteOverview = mapper.readValue(new File("notes/core/src/main/java/resources/noteOverview.json"), NoteOverview.class);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return noteOverview;
    }
    public void writeNoteOverview(NoteOverview noteOverview) {
        try {
            mapper.writeValue(new File("notes/core/src/main/java/resources/noteOverview.json"), noteOverview);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NotesStorage notesStorage = new NotesStorage();
        Note note = new Note("title", "text");
        Note note2 = new Note("title2", "text2");
        NoteOverview noteOverview = new NoteOverview();
        noteOverview.addNote(note);
        noteOverview.addNote(note2);
        notesStorage.writeNoteOverview(noteOverview);

    }
}
