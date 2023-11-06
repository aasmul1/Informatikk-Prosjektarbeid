import notes.core.NoteOverview;
import notes.core.User;
import notes.core.Accounts;



public class NotesAppIT extends AplicationTest{

    private List<User> testUserList;
    private LoginController loginController; 
    private ObjectMapper objectMapper;
    private NotesAccess dataAccess;
    private NotesConfig config;
  

    @Override
    public void start(Stage stage) throws Exception(){

    }


    @BeforeAll
    public static void setupHeadless() {
        Notes.supportHeadless();
    }

    @BeforeEach
    void generateData() {
        createTestUsers();
    }

    private void createTestUsers() {
        try {
            NoteOverview noteoverview = new NoteOverview();
            NoteOverview noteoverview2 = new NoteOverview();
            User user = new User("Username", "Password123!", noteoverview);
            User user2 = new User("Username2", "Password1", noteoverview2);
            Note note1 = new Note("TestNote 1", "Text");
            user.addNote(note1);
            Note note2 = new Note("TestNote2","Text");
            user2.addNote(note2);
            testUserList.add(user);
            testUserList.add(user2);
            dataAccess.createUser(user);
            dataAccess.createUser(user2);

        } catch (Exception e) {
          System.err.println(e.getMessage());
          fail();
        }
    
      }
}