package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

    private NoteOverview noteOverview = new NoteOverview();
    private User user;

    @BeforeEach
    public void setUp(){
        user = new User("Username", "Password123", noteOverview);
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
}
