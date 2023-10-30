package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import core.Accounts;
import core.NoteOverview;
import core.User;

/**
 * @RestController marks the class as a web controller, capable of handling HTTP requests in a RESTful web service, such as JSON
 * @RequestMapping(NotesController.NOTES_SERVICE_PATH) sets the base URI for all endpoints handled by this controller
 * 
 * This means that all the mappings defined in this controller will start with /notes in their URI
 * 
 */
@RestController 
@RequestMapping(NotesController.NOTES_SERVICE_PATH) 
public class NotesController {

    public static final String NOTES_SERVICE_PATH = "notes";  
    private final NotesService notesService;  

    @Autowired
    public NotesController(final NotesService notesService) {
        this.notesService = notesService;
    }  

    // localhost:8080//notes/login?username={username}&password={password}
    @GetMapping(path = "login")
    public User userLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        if (notesService.userLogin(username, password)) {
            return notesService.getUserByUsername(username);
            }
        else {
            return null;
        }
    } 
  

    @GetMapping
    public Accounts getAccounts() {
        return notesService.getAccounts();
    }  


    
}
