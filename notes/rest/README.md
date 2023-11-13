
# RestServer 

The team chose to use the SpringBoot-framework to establish the REST server. 

### Structure 

The Notes RestServer consists of the following classes:

- [NotesService.java](src/main/java/rest/NotesService.java): Service class, responsible for managing user accounts, notes, and various operations.
- [NotesController.java](src/main/java/rest/NotesController.java): REST controller class, handles HTTP requests and defines API endpoints. 
- [RestServerApplication.java](src/main/java/rest/RestServerApplication.java): Contains the start method for the server application and configures CORS.

Class diagram for rest module you can find [here](../diagrams/README.md).

### Supported Requests

For all methodes the Host is `localhost:8080`.

**Accounts**

- Get Accounts: 
    - Request: GET `/notes/accounts`
    - Response: Returns a list of user accounts. If successful the HTTP status is set to 200 OK. If an exception is thrown the status is set to 500 Internal Server Error. 

**Users and Authentication**

- Get User by Username
    - Request: GET `/notes/user?username={username}`
    - Response: Returns the user object with the specified username, and 200 OK response if successful. Otherwise it returns a 404 Not Found response.

- Authenticate User
    - Request: POST `/notes/authenticate-user?username={username}&password={password}`
    - Response: Authenticates the user with the provided username and password.If this is successful, the response includes the user information with an HTTP status code of 200 OK. In case of unsuccessful authentication, a response with a status code of 404 Not Found is returned.

- Create User
    - Request: PUT `/notes/create-user`
    - Content-Type: application/json
    - Response: Creates a new user. A successful creation will result in a 200 OK response. Otherwise, a response with a status code of 409 and the message "......." will be received.

```
{
  "username" : "User",

  "password" : "Password1",
}
```

- Users NoteOverview:
    - Request: GET `/notes/user/noteOverview?username={username}`
    - Response: Retrieves the note overview for a specific user, if this is successfull the HTTP status is set to 200 OK, else it is set to 404 Not Found. 

**Notes**
- Get User`s Note By Index
    - Request: GET `/notes/user/note?username={username}&index={index}`
    - Response: Returns the note object for the specified index and user. 

- Create Note
    - Request: PUT `/notes/create-note?username={username}
    - Content-Type: application/json
    - Response: Creates a new note for the specified user. A successful creation of a user will result in a 200 OK response. Otherwise, a response with a status code of 409 and the message "........." will be received.

- Delete Note
    - Request: DELETE `/notes/delete-note?username={username}&index={index}`
    - Response: Deletes a note for the specified index and user. If the note was deleted successfully the response will be 200 OK. //TODO

- Sort Notes by Created Date
    - Request: POST `/notes/user/sort-created?username={username}`
    - Response: Sorts the user's notes list by created date.

- Sort Notes by Title
    - Request: POST `/notes/user/sort-title?username={username}`
    - Response: Sorts the user's notes list by title.

- Sort Notes by Last Edited Date
    - Request: POST `/notes/user/sort-edited?username={username}`
    - Response: Sorts the user's notes list by last edited date.

**Test and Normal Modes**
- Set Test Mode
    - Request: POST `/notes/test-mode`
    - Response: Sets the server to test mode.

- Set Normal Mode
    - Request: POST `/notes/normal-mode`
    - Response: Sets the server to normal mode.




