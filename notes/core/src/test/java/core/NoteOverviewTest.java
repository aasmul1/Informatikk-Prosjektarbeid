package core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NoteOverviewTest {

    
    private NoteOverview noteOverview;
    private List<Note> list = new ArrayList<Note>();
    LocalDate editedDate = LocalDate.parse("2023-10-06");
    LocalDate createdDate = LocalDate.parse("2023-10-05");
    // Note("Title", "Chores i have to do", createdDate, editedDate);
    //     this.note2 = new Note("Title2", "Here i want to test");

    @BeforeEach
    void setUp() {
      Note noteStart = new Note("Title", "Chores i have to do", createdDate, editedDate);
      Note noteStart2 = new Note("Title2", "Chores i have to do");
      list.add(noteStart);
      list.add(noteStart2);
      this.noteOverview = new NoteOverview(list);
        
        
    }

    @Test
    public void testConstructor(){
        assertEquals(list, noteOverview.getNotes());
         
    }

    @Test
    public void testAdd(){
        Note note = new Note("Title3", "Content");
        noteOverview.addNote(note);
        assertTrue(noteOverview.getNotes().contains(note));

        // Test adding a null note
        noteOverview.addNote(null);
        assertTrue(noteOverview.getNotes().size() == 3);

        // Test adding a note with an existing title
        Note note1 = new Note("Title4", "Content1");
        Note note2 = new Note("Title4", "Content2");
        noteOverview.addNote(note1);
        assertThrows(IllegalArgumentException.class, () -> noteOverview.addNote(note2));
        assertTrue(noteOverview.getNotes().contains(note1));
        assertFalse(noteOverview.getNotes().contains(note2));

        // Test adding a note listener
        // Note note3 = new Note("Another Title", "Another Content");
        // noteOverview.addNoteListener(new NoteListener());
        // noteOverview.addNote(note3);
        // assertTrue(note3.getNoteListeners().contains(noteOverview));
    }

    @Test
    public void testDelete(){

    }

    @Test
    public void testSort(){

    }
    

    
    //delete
    //add
    //delete int
    //get notes
    //sortbycreated
    //sortbyedited
    //sortbytitle
}
