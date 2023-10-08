// package json.internal;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import java.util.Arrays;

// import org.junit.jupiter.api.Test;

// import com.fasterxml.jackson.databind.ObjectMapper;

// import core.Note;
// import core.NoteOverview;

// public class NoteOverviewJsonTest {
//     private final ObjectMapper objectMapper = new ObjectMapper();
//     {
//         objectMapper.registerModule(new NoteOverviewModule());
//     }

//     protected void assertEqualsIgnoreWhitespace(final String expected, final String actual) throws Exception {
//         assertEquals(expected, actual.replaceAll("\\s+", ""));
// }

//     @Test
//     public void testNoteOverviewSerialization() throws Exception {
//         final String actualJson = objectMapper
//                 .writeValueAsString(new NoteOverview(Arrays.asList(new Note("title", "text"), new Note("title2", "text2")) ));
//         final String expectedJson =
//                 "[{\"title\":\"title\",\"text\":\"text\"},{\"title\":\"title2\",\"text\":\"text2\"}]";
//         assertEqualsIgnoreWhitespace(expectedJson, actualJson);
//     }

//     @Test
//     public void testNoteOverviewDeserialization() throws Exception {
//         final String json = "[{\"title\":\"title\",\"text\":\"text\"},{\"title\":\"title2\",\"text\":\"text2\"}]";
//         final NoteOverview noteOverview = objectMapper.readValue(json, NoteOverview.class);
//         assertEquals(2, noteOverview.getNotes().size());
//         assertEquals("title", noteOverview.getNotes().get(0).getTitle());
//         assertEquals("text", noteOverview.getNotes().get(0).getText());
//         assertEquals("title2", noteOverview.getNotes().get(1).getTitle());
//         assertEquals("text2", noteOverview.getNotes().get(1).getText());

//     }

// }
