package core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NoteTest {
    private Note note;
    private Note note2;
    LocalDate currentDate = LocalDate.now();
    LocalDate createdDate = LocalDate.parse("2023-10-07");

    @BeforeEach
    void setUp() {
        this.note = new Note("Title", "Chores i have to do", createdDate, currentDate);
        this.note2 = new Note("Title2", "Here i want to test");
    }

    @Test
    public void testConstructor(){
        assertEquals("Title", note.getTitle());
        assertEquals("Chores i have to do", note.getText());
        assertEquals(LocalDate.parse("2023-10-07"), note.getCreatedDate());
        assertEquals(LocalDate.now(), note.getEditedDate());
        
    }

    @Test
    public void testConstructor2(){
        assertEquals("Title2", note2.getTitle());
        assertEquals("Here i want to test", note2.getText());
        assertEquals(LocalDate.now(), note2.getCreatedDate());
        assertEquals(LocalDate.now(), note2.getEditedDate());
        
    }
}
