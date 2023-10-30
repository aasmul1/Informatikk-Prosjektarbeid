package core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

    private NoteOverview noteOverview;
    private User user;

    @BeforeEach
    public void setUp(){
        noteOverview = new NoteOverview();
        user = new User("Username", "Password123", noteOverview);
    }

    @Test
    public void testConstructors() {
        NoteOverview testOverview = new NoteOverview();
        User smallConstructor = new User("Test", "Test", testOverview);
        assertEquals("Test", smallConstructor.getUsername());
        assertEquals("Test", smallConstructor.getPassword());
        assertEquals(testOverview, smallConstructor.getNoteOverview());
    }

    
    
    @Test
    public void testGetters(){
        Assertions.assertEquals("Username", user.getUsername());
        Assertions.assertEquals("Password123", user.getPassword());
        Assertions.assertEquals(noteOverview, user.getNoteOverview());
        Note note = new Note("Note", "Text");
        noteOverview.addNote(note);
        Assertions.assertEquals(note, user.getNote(note));

    }

    @Test
    public void testSetters(){
        user.setUsername("NewUsername");
        Assertions.assertEquals("NewUsername", user.getUsername());
        user.setPassword("NewPassword123");
        Assertions.assertEquals("NewPassword123", user.getPassword());
        
    }

    @Test
    public void testAddNote() {
        // Test adding a new note to the user's note overview
        Note note = new Note("Note", "Text");
        user.addNote(note);
        Assertions.assertTrue(user.noteExists(note)); // Check if the note exists

        // Test adding the same note again (should not be added twice)
        user.addNote(note);
        Assertions.assertEquals(1, user.getNoteOverview().getNotes().size());
    }

    @Test
    public void testNoteExists() {
        // Test noteExists method when a note exists and when it doesn't
        Note existingNote = new Note("Existing Note", "Text");
        user.addNote(existingNote);
        Assertions.assertTrue(user.noteExists(existingNote));

        Note nonExistingNote = new Note("Non-Existing Note", "Text");
        Assertions.assertFalse(user.noteExists(nonExistingNote));
    }
}
