
# RestServer 

The team chose to use the SpringBoot-framework to establish the REST server.

### Structure 

The Notes RestServer consists of the following classes:

- [NotesService.java](src/main/java/rest/NotesService.java): Service class, responsible for managing user accounts, notes, and various operations.
- [NotesController.java](src/main/java/rest/NotesController.java): REST controller class, handles HTTP requests and defines API endpoints. 
- [RestServerApplication.java](src/main/java/rest/RestServerApplication.java): Contains the start method for the server application and configures CORS.

### Supported Requests

For all methodes the Host is `localhost:8080`.

**Accounts**

- Get Accounts: 
    - Request: GET `/notes/accounts`
    - Response: Returns a list of user accounts.

**Users and Authentication**

- Get User by Username
    - Request: GET `/notes/user?username={username}`
    - Response: Returns the user with the specified username.

- Authenticate User
    - Request: POST `/notes/authenticate-user?username={username}&password={password}`
    - Response: Authenticates a user with the provided username and password.

- Create User
    - Request: PUT `/notes/create-user`
    - Content-Type: application/json
    - Response: Creates a new user.


