# UI

To set up the user interface for our application, the groups utilized JavaFX to generate FXML files for all scenes. Each scene has its own controller, which are responsible for handling specific UI functionalities. To ensure clearity in the project the controller´s name match the fxml-file, such as Login.fxml and LoginController.java. 

The UI module includes all visual compentets, layout and elements the user interact with. It is crucial for providing a user-friendly experience while interaction with the application. 

The UI also includes classes for data-access in the application, which are vital for managing interactions with the core logic. 

### **Structure**
The UI module seperates controller, dataaccess classes and FXML files, to enchance organization. The dataaccess classes are seperated in an own directory/folder `dataaccess`, positioned at the same level as the internal ui directory. 
Controllers are located in the `ui/controllers` directory. The FXML files are located in `ui/resources`. 

Class diagram for the controllers you can find [here](../diagrams/README.md)

#

### **The UI module consists of the following classes**

#### Controller classes 

- [AbstractController.java](src/main/java/ui/controllers/AbstractController.java) 
- [AppController.java](src/main/java/ui/controllers/AppController.java)
- [CreateUserController.java](src/main/java/ui/controllers/CreateUserController.java)
- [LoginController.java](src/main/java/ui/controllers/LoginController.java)
- [NoteController.java](src/main/java/ui/controllers/NoteController.java)
- [NoteEditController.java](src/main/java/ui/controllers/NoteEditController.java)


The `AbstractController` class is an abstract class for all the controller classes in the UI module. The class includes methodes to transition between different scenes, and establishes connection with data access.

The `LoginController` initiates the application's start scene and manages login functionality. It also includes a button to create a user, leading to the `CreateUserController` scene. The `AppController` administers the scene displaying all user notes. The `NoteController` handles the creation of new notes, while the `NoteEditController` is responsible for editing existing notes.

#

#### FXML files 

- [App.fxml](src/main/resources/ui/App.fxml)
- [CreateUser.fxml](src/main/resources/ui/CreateUser.fxml)
- [Login.fxml](src/main/resources/ui/Login.fxml)
- [Note.fxml](src/main/resources/ui/Note.fxml)
- [NoteEdit.fxml](src/main/resources/ui/NoteEdit.fxml)

The FXML files define the stucture of the user interface. 

#

#### DataAccess classes

- [NoteAccess.fxml](src/main/java/dataaccess/NotesAccess.java)
- [LocalNoteAccess.fxml](src/main/java/dataaccess/LocalNotesAccess.java)
- [RemoteNoteAccess.fxml](src/main/java/dataaccess/RemoteNotesAccess.java)

 The `NotesAccess` interface serves as a brigde between the application`s UI and core logic by defining the essential methods for users and note related operations. 

`RemoteNotesAccess` extends the NotesAccess interface and is responsible for handling user data stored on a remote server. The class communicates with the server through HTTP requests, and managing user actions like authenticating user logins, and handling note operations remotely. 

`LocalNotesAccess` also extends the NotesAccess interface, but gets data stored locally in accounts.json, which is located on user.home. Its main functionality include handling user logins, managing note operations and, updating the local storage after each relevant operation. 

 ### **Test classes for UI**

 We have written a test classes for all controllers. 

 ### Test classes 

 #### Controller tests
- [AppControllerTest.java](src/test/java/ui/controllers/AppControllerTest.java)
- [CreateUserControllerTest.java](src/test/java/ui/controllers/CreateUserControllerTest.java)
- [LoginControllerTest.java](src/test/java/ui/controllers/LoginControllerTest.java)
- [NoteControllerTest.java](src/test/java/ui/controllers/NoteControllerTest.java)
- [NoteEditControllerTest.java](src/test/java/ui/controllers/NoteEditControllerTest.java)

#### DataAccess test
- [RemoteNotesAccessTest.java](src/test/java/dataaccess/RemoteNotesAccessTest.java)

### Test Coverage
For the UI module we aimed to test as much as we could. The test coverage for this module is X. Testing the UI extensiavly is important because these tests simulate real user interactions, and helps us catch bugs and issues early that might be missed by other testing methods. 
 
 The goal of testing is to ensure the application functions well, and provides a user-friendly experience. 


 