package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import core.Accounts;
import core.Note;
import core.NoteOverview;
import core.User;
import json.AccountsPersistence;
import rest.exceptions.InvalidLoginException;
import rest.exceptions.NoteNotFoundException;
import rest.exceptions.UserAlreadyExistsException;
import rest.exceptions.UserNotFoundException;

/**
 * @RestController marks the class as a web controller, capable of handling HTTP
 *                 requests in a RESTful web service, such as JSON
 * @RequestMapping(NotesController.NOTES_SERVICE_PATH) sets the base URI for all
 *                                                     endpoints handled by this
 *                                                     controller
 * 
 *                                                     This means that all the
 *                                                     mappings defined in this
 *                                                     controller will start
 *                                                     with /notes in their URI
 * 
 */
@RestController
@RequestMapping(NotesController.NOTES_SERVICE_PATH)
public class NotesController {

    //TODO: Fix proper error handling
    public static final String NOTES_SERVICE_PATH = "notes";
    private final NotesService notesService;

    @Autowired
    public NotesController(final NotesService notesService) {
        this.notesService = notesService;
    }

    /**
     * Gets the accounts 
     * 
     * @return the accounts
     */
    @GetMapping(path = "accounts")
    public ResponseEntity<?> getAccounts() {
        // TODO: find out which method is best for GET. This alternative is different
        // from the rest.
        try {
            Accounts accounts = notesService.getAccounts();
            return ResponseEntity.ok(accounts);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error retrieving accounts: " + e.getMessage());
        }
    }

    /**
     * Gets the user if it exists
     * 
     * @param username
     * @return the user with the matching username
     * @throws UserNotFoundException if user with username not exists
     */
    // localhost:8080/notes/user?username={username}
    @GetMapping(path = "user")
    public User getUser(@RequestParam String username) {
        if (notesService.getUserByUsername(username) == null) {
            throw new UserNotFoundException();
        }
        return notesService.getUserByUsername(username);
    }

    // localhost:8080/notes/user/note?username={username}&index={index}
    @GetMapping(path = "user/note")
    public Note getNote(@RequestParam String username, @RequestParam String index) {
        if (notesService.getNote(username, Integer.parseInt(index)) == null) {
            throw new NoteNotFoundException();
        }
        return notesService.getNote(username, Integer.parseInt(index));
    }

    /**
     * Gets users noteoverview if user exists
     * 
     * @param username
     * @return the users noteoverview
     * @throws UserNotFoundException if user with username not exists
     */
    // localhost:8080/notes/user/noteOverview?username={username}
    @GetMapping(path = "user/noteOverview")
    public NoteOverview userNoteOverview(@RequestParam("username") String username) {
        if (notesService.getNoteOverviewByUsername(username) == null) {
            throw new UserNotFoundException();
        }
        return notesService.getNoteOverviewByUsername(username);
    }

    /**
     * Creates new user if a user with same username not exists
     * 
     * @param user
     * @throws UserAlreadyExistsException if user with same username already exists
     */
    // localhost:8080/notes/create-user?user={user}
    @PutMapping(path = "create-user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody User user) {
        try {
            notesService.createUser(user);
        } catch (Exception e) {
            throw new UserAlreadyExistsException();
        }
    }

    /**
     * Creates new note if note with same title not exists
     * 
     * @param note
     * @param username
     */
    @PutMapping(path = "create-note", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createNote(@RequestBody Note note, @RequestParam("username") String username) {
        notesService.addNote(username, note);
    }

    /**
     * Deletes note if it exists
     * 
     * @param username
     * @param index
     */
    // localhost:8080/notes/delete-note?username={username}&index={index}
    @DeleteMapping(path = "delete-note")
    public void deleteNote(@RequestParam String username, @RequestParam int index) {
        // TODO: NoteNotFoundException if note is not found
        notesService.deleteNote(username, index);
    }

    /**
     * Authenticates login information - username and password.
     * Using post because GET will expose user data
     * 
     * @param username
     * @param password
     * @return
     */
    // localhost:8080/notes/authenticate-user?username={username}&password={password}
    @PostMapping(path = "authenticate-user")
    public User authenticateUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        if (!notesService.validLogin(username, password)) {
            throw new InvalidLoginException();
        }
        return notesService.getUser(username, password);
    }

    /**
     * Sorts list of notes by creation date
     * 
     * @param username
     */
    // localhost:8080/notes/user/sort-created?username={username}
    @PostMapping(path = "user/sort-created")
    public void sortNotesByCreatedDate(@RequestParam String username) {
        notesService.sortNotesByCreatedDate(username);
    }

    /**
     * Sorts list of notes by title
     * 
     * @param username
     */
    // localhost:8080/notes/user/sort-title?username={username}
    @PostMapping(path = "user/sort-title")
    public void sortNotesByTitle(@RequestParam String username) {
        notesService.sortNotesByTitle(username);
    }

    /**
     * Sorts list of notes by title
     * 
     * @param username
     */
    // localhost:8080/notes/user/sort-edited?username={username}
    @PostMapping(path = "user/sort-edited")
    public void sortNotesByLastEditedDate(@RequestParam String username) {
        notesService.sortNotesByLastEditedDate(username);
    }

    /**
     * 
     * @return objectmapper with Accounts module
     */
    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        return AccountsPersistence.getObjectMapper();
    }

    @PostMapping(path = "test-mode") 
    public void setTestMode() {
        notesService.setTestMode();
    }

    @PostMapping(path = "normal-mode")
    public void setNormalMode() {
        notesService.setNormalMode();
    }
}
