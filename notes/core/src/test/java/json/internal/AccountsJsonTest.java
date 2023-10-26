package json.internal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import core.Accounts;
import core.Note;
import core.NoteOverview;
import core.User;

public class AccountsJsonTest {
    private final ObjectMapper objectMapper = new ObjectMapper();
    {
        objectMapper.registerModule(new AccountsModule());
    }

    private void assertEqualsIgnoreWhitespace(final String expected, final String actual) throws Exception {
        assertEquals(expected, actual.replaceAll("\\s+", ""));
}

    @Test
    public void testNoteOverviewSerialization() throws Exception {
        LocalDate localDate = java.time.LocalDate.of(2022, 1, 1);

        final String actualJson = objectMapper
                .writeValueAsString(new NoteOverview(Arrays.asList(new Note("title", "text", localDate, localDate), new Note("title2", "text2", localDate, localDate)) ));
        final String expectedJson =
                "[{\"title\":\"title\",\"text\":\"text\",\"created\":\"2022-01-01\",\"edited\":\"2022-01-01\"},{\"title\":\"title2\",\"text\":\"text2\",\"created\":\"2022-01-01\",\"edited\":\"2022-01-01\"}]";
        assertEqualsIgnoreWhitespace(expectedJson, actualJson);
    }

    @Test
    public void testNoteOverviewDeserialization() throws Exception {
        final String json = 
                "[{\"title\":\"title\",\"text\":\"text\",\"created\":\"2022-01-01\",\"edited\":\"2022-01-01\"},{\"title\":\"title2\",\"text\":\"text2\",\"created\":\"2022-01-01\",\"edited\":\"2022-01-01\"}]";
        final NoteOverview noteOverview = objectMapper.readValue(json, NoteOverview.class);
        assertEquals(2, noteOverview.getNotes().size());
        assertEquals("title", noteOverview.getNotes().get(0).getTitle());
        assertEquals("text", noteOverview.getNotes().get(0).getText());
        assertEquals("title2", noteOverview.getNotes().get(1).getTitle());
        assertEquals("text2", noteOverview.getNotes().get(1).getText());
        assertEquals(LocalDate.of(2022, 1, 1), noteOverview.getNotes().get(0).getCreatedDate());
        assertEquals(LocalDate.of(2022, 1, 1), noteOverview.getNotes().get(0).getEditedDate());

    }

    @Test
    public void testAccountsSerialization() throws Exception {
        final LocalDate localDate = java.time.LocalDate.of(2022, 1, 1);
        final String expectedJson = 
                "[{\"username\":\"username\",\"password\":\"password\",\"noteOverview\":[{\"title\":\"title\",\"text\":\"text\",\"created\":\"2022-01-01\",\"edited\":\"2022-01-01\"}]}]";

        Accounts accounts = new Accounts();
        NoteOverview noteOverview = new NoteOverview();
        Note note = new Note("title", "text", localDate, localDate);
        noteOverview.addNote(note);
        User user = new User("username", "password", noteOverview);
        accounts.addUser(user);

        final String actualJson = objectMapper.writeValueAsString(accounts);
        assertEqualsIgnoreWhitespace(expectedJson, actualJson);


    }

    @Test
    public void testAccountsDeserialization() throws Exception {
        final String json = 
                "[{\"username\":\"username\",\"password\":\"password\",\"noteOverview\":[{\"title\":\"title\",\"text\":\"text\",\"created\":\"2022-01-01\",\"edited\":\"2022-01-01\"}]}]";
        final Accounts accounts = objectMapper.readValue(json, Accounts.class);
        assertEquals("username", accounts.getUser("username").getUsername());
        assertEquals("password", accounts.getUser("username").getPassword());
        assertEquals("title", accounts.getUser("username").getNoteOverview().getNotes().get(0).getTitle());

    }
}
