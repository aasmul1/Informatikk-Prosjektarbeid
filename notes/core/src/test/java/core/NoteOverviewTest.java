package core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NoteOverviewTest {

    private NoteOverview noteOverview;
    private List<Note> list = new ArrayList<Note>();
    private Note note2;
    private Note dateNote;
    LocalDate editedDate = LocalDate.parse("2023-10-06");
    LocalDate createdDate = LocalDate.parse("2023-10-05");
    // Note("Title", "Chores i have to do", createdDate, editedDate);
    //     this.note2 = new Note("Title2", "Here i want to test");

    @BeforeEach
    void setUp() {
      Note note = new Note("Title", "Chores i have to do", createdDate, editedDate);
      Note note2 = new Note("Title", "Chores i have to do");
      list.add(note);
      list.add(note2);
      this.noteOverview = new NoteOverview(list);
        
        
    }

    @Test
    public void testConstructor(){
        assertEquals(list, noteOverview.getNotes());
         
    }
    

    
    //delete
    //add
    //delete int
    //get notes
    //sortbycreated
    //sortbyedited
    //sortbytitle
}
