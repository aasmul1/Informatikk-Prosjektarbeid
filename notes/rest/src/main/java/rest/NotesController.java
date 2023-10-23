package rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController marks the class as a web controller, capable of handling HTTP requests in a RESTful web service, such as JSON
 * @RequestMapping(NotesController.NOTES_SERVICE_PATH) sets the base URI for all endpoints handled by this controller
 * 
 * This means that all the mappings defined in this controller will start with /noteOverveiw in their URI
 * 
 */
@RestController 
@RequestMapping(NotesController.NOTES_SERVICE_PATH) 
public class NotesController {

    
    //localhost:8080//noteOverveiw 
    public static final String NOTES_SERVICE_PATH = "noteOverveiw";


    
}
