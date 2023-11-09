package rest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;

import core.User;
import json.AccountsPersistence;
import rest.exceptions.UserNotFoundException;

@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ContextConfiguration(classes = { NotesController.class, NotesService.class, RestServerApplication.class })
@WebMvcTest
public class RestServerApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private NotesService notesService;

    private ObjectMapper objectMapper;

    private String getUrl(String... segments) {
        String url = "/" + NotesController.NOTES_SERVICE_PATH;
        for (String seg : segments) {
            url = url + "/" + seg;
        }
        return url;
    }

    @BeforeAll
    public void setup() throws IllegalStateException, IOException {
        objectMapper = AccountsPersistence.getObjectMapper();
        notesService.setTestMode();
    }

    @Test
    public void contextLoads() throws Exception {
        assertNotNull(objectMapper);
    }

    @Test
    public void testGetUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(getUrl("user?username=12345"))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof UserNotFoundException))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
        mockMvc.perform(MockMvcRequestBuilders.get(getUrl("user?username=testuserone"))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAuthenticateUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(getUrl("authenticate-user?username=testuserone&password=Password1"))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.post(getUrl("authenticate-user?username=testuserone&password=p"))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof UserNotFoundException))
                .andExpect(result -> assertTrue(result.getResolvedException().getMessage().equals("Invalid login")));
    }

    @Test
    public void testCreateUser() throws Exception {
        User user = new User("testuserthree", "Password3", null);

        mockMvc.perform(MockMvcRequestBuilders.put(getUrl("create-user"))
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
                .content(objectMapper.writeValueAsString(user)).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get(getUrl("user?username=testuserthree"))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc.perform(
                MockMvcRequestBuilders.post(getUrl("authenticate-user?username=testuserthree&password=Password3"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.put(getUrl("create-user"))
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
                .content(objectMapper.writeValueAsString(user)).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isConflict());
    }

    @Test
    public void testGetNote() throws Exception {
        // user/note?username={username}&index={index}
        mockMvc.perform(MockMvcRequestBuilders.get(getUrl("user/note?username=testuserone&index=0"))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        //TODO: uncomment test after exceptions is 100% fixed
        // mockMvc.perform(MockMvcRequestBuilders.get(getUrl("user/note?username=testuserone&index=3"))
        //         .accept(MediaType.APPLICATION_JSON))
        //         .andExpect(MockMvcResultMatchers.status().isNotFound())
        //         .andExpect(result -> assertTrue(result.getResolvedException() instanceof NoteNotFoundException));

    }

    @Test
    public void testDeleteNote() {
        
    }

    @AfterAll
    public void tearDown() {
        Path.of(System.getProperty("user.home")
                + "/springbootserver-test.json").toFile().delete();
    }
}
