# UI
TODO indtroduction 

To construct the user interface for our application, the groups utilized JavaFX to generate FXML files for all scenes. 

To handle user inputs and execute the wanted functionality, the group utilized controller classes. Each UI scene is assignied one controller.

### The UI module consists of the following classes 

#### Controller classes 

- [AbstractController.java](src/main/java/ui/controllers/AbstractController.java)
- [AppController.java](src/main/java/ui/controllers/AppController.java)
- [CreateUserController.java](src/main/java/ui/controllers/CreateUserController.java)
- [LoginController.java](src/main/java/ui/controllers/LoginController.java)
- [NoteController.java](src/main/java/ui/controllers/NoteController.java)
- [NoteEditController.java](src/main/java/ui/controllers/NoteEditController.java)


The `AbstractController` class is an abstract class for all the controller classes in the UI module. The class includes methodes to transition between different scenes, and establishes connection with data access.

The `LoginController` initiates the application's start scene and manages login functionality. It also includes a button to create a user, leading to the `CreateUserController` scene. The `AppController` administers the scene displaying all user notes. The `NoteController` handles the creation of new notes, while the `NoteEditController` is responsible for editing existing notes.


#### FXML files 

- [App.fxml](src/main/resources/ui/App.fxml)
- [CreateUser.fxml](src/main/resources/ui/CreateUser.fxml)
- [Login.fxml](src/main/resources/ui/Login.fxml)
- [Note.fxml](src/main/resources/ui/Note.fxml)
- [NoteEdit.fxml](src/main/resources/ui/NoteEdit.fxml)

The FXML files are located under `/ui/src/main/resources/ui/` and defines the stucture of the user interface. 

#### DatAccess classes

- [NoteAccess.fxml](src/main/java/dataaccess/NotesAccess.java)
- [LocalNoteAccess.fxml](src/main/java/dataaccess/LocalNotesAccess.java)
- [RemoteNoteAccess.fxml](src/main/java/dataaccess/RemoteNotesAccess.java)

 The `NotesAccess` interface serves as a brigde between the application`s UI and core logic by defining the essential methods for users and note related operations. 

`RemoteNotesAccess` extends the NotesAccess interface and is responsible for handling user data stored on a remote server. The class communicates with the server through HTTP requests, and managing user actions like authenticating user logins, and handling note operations remotely. 

`LocalNotesAccess` also extends the NotesAccess interface, but gets data stored locally in accounts.json, which is located on user.home. Its main functionality include handling user logins, managing note operations and, updating the local storage after each relevant operation. 

## Test Coverage 
