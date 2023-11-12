# UI
TODO indtroduction 

To construct the user interface for our application, the groups utilized JavaFX to generate FXML files for all scenes. 

To handle user inputs and execute the wanted functionality, the group utilized controller classes. Each UI scene is assignied one controller.

### The UI module consists of the following classes 

#### Controller classes 
```
- AbstractController.java
- AppController.java
- CreateUserController.java
- LoginController.java
- NoteController.java
- NoteEditController.java
```

The `AbstractController` class serves as a foundational controller for all the controller classes in the UI. The class has an overview of all fxml scenes and the corresponding controllers, includes methodes to transition between different scenes, and establishes a connection with data source in NoteAccess. 

The `LoginController` initiates the application's start scene and manages login functionality. It also includes a button to create a user, leading to the `CreateUserController` scene. The `AppController` administers the scene displaying all user notes. The `NoteController` handles the creation of new notes, while the `NoteEditController` is responsible for editing existing notes.


#### FXML files 

The FXML files are located under ../ui/src/main/resources/ui/
```
- App.fxml
- CreateUser.fxml
- Login.fxml
- Note.fxml
- NoteEdit.fxml
```
The FXML files defines the stucture of the user interface. 

#### DatAccess classes
```
- NoteAccess.java
- LocalNotesAccess.java
- RemoteNotesAccess.java
```
 The `NotesAccess` interface serves as a brigde between the application`s UI and core logic by defining the essential methods for users and note related operations. 

`RemoteNotesAccess` extends the NotesAccess interface and is responsible for handling user data stored on a remote server /externally. The class communicates with the server through HTTP requests, and managing user actions like authenticating user logins, and handling note operations remotely. 

`LocalNotesAccess` also extends the NotesAccess interface, but focuses on local data storage. The class manages user data locally, in a file named "Accounts.json." Its main functionality include handling user logins, managing note operations and, updating the local storage after each relevant operation. 


## Test Coverage 