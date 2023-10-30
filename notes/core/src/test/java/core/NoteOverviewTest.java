package core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class NoteOverviewTest {

    private NoteOverviewListener listener1;
    private NoteOverviewListener listener2;
    private NoteOverview noteOverview;
    private List<Note> list = new ArrayList<Note>();
    LocalDate editedDate = LocalDate.parse("2023-10-06");
    LocalDate createdDate = LocalDate.parse("2023-10-05");
    Note noteStart = new Note("ATitle", "Chores i have to do", createdDate, editedDate);
    Note noteStart2 = new Note("BTitle2", "Chores i have to do");
    private Note note1;
    private Note note2;

    @BeforeEach
    void setUp() {
      
      
      list.add(noteStart);
      list.add(noteStart2);
      listener1 = new NoteOverviewListener() {
        @Override
        public void noteOverviewChanged() {
            // Listener 1 implementation, if needed
        }
    };
    listener2 = new NoteOverviewListener() {
        @Override
        public void noteOverviewChanged() {
            // Listener 2 implementation, if needed
        }
    };

      note1 = new Note("Note 1", "Text 1");
      note2 = new Note("Note 2", "Text 2");
      
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
      Note note = new Note("Title3", "Content");
      noteOverview.addNote(note);
      noteOverview.deleteNote(note);
      assertFalse(noteOverview.getNotes().contains(note));

      // Test deleting a null note
      assertThrows(IllegalArgumentException.class, () -> noteOverview.deleteNote(null));

      // Test deleting a non-existing note
      Note nonExistingNote = new Note("Non-Existing Title", "Non-Existing Content");
      assertThrows(IllegalArgumentException.class, () -> noteOverview.deleteNote(nonExistingNote));

      Note note1 = new Note("Title 1", "Content 1");
      Note note2 = new Note("Title 2", "Content 2");
      noteOverview.addNote(note1);
      noteOverview.addNote(note2);

      noteOverview.deleteNote(0);
      assertFalse(noteOverview.getNotes().contains(note));
      assertTrue(noteOverview.getNotes().contains(note1));


      // Test deleting an invalid index (out of bounds)
      assertThrows(IllegalArgumentException.class, () -> noteOverview.deleteNote(3));

      

  
    }

    @Test
    public void testSort(){
        noteOverview.sortNotesByCreatedDate();
        assertEquals(this.noteStart2, noteOverview.getNotes().get(0));
        Note note = new Note("CTitleee", "TExt", LocalDate.parse("2023-10-05"), LocalDate.parse("2023-10-07"));
        noteOverview.addNote(note);
        noteOverview.sortNotesByLastEditedDate();
        assertEquals(note, noteOverview.getNotes().get(1));
        assertEquals(this.noteStart2, noteOverview.getNotes().get(0));
        noteOverview.sortNotesByTitle();
        assertEquals(note, noteOverview.getNotes().get(2));
        assertEquals(this.noteStart, noteOverview.getNotes().get(0));

    }

    @Test
    public void testAddListener() {
        // Test adding a listener
        noteOverview.addListener(listener1);
        Assertions.assertTrue(noteOverview.getNoteListeners().contains(listener1));
    }

    @Test
    public void testRemoveListener() {
        // Test removing a listener
        noteOverview.addListener(listener1);
        noteOverview.removeListener(listener1);
        Assertions.assertFalse(noteOverview.getNoteListeners().contains(listener1));
    }
 
    @Test
    public void testNotesIterator() {
        // Test iterating over notes
        noteOverview.deleteNote(0);
        noteOverview.deleteNote(0);
        noteOverview.addNote(note1);
        noteOverview.addNote(note2);
        Iterator<Note> iterator = noteOverview.notesIterator();
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(note1, iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(note2, iterator.next());
        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    public void testNoteChanged() {
        // Test firing the note overview changed event
        List<NoteOverviewListener> listeners = noteOverview.getNoteListeners();
        listeners.add(listener1);
        listeners.add(listener2);

        noteOverview.noteChanged();
        // You can add assertions here if you have specific requirements for the listeners.
    }
    

}
