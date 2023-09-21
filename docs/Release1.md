## Release-1

In this release we have created a MVP for the project / app. Out focus areas has been creating the folder- and codestructure, reading/saving to file in JSON, and creating a prototype. We have implemented the following classes in core

```
Note.java
NoteOverview.java
NoteOverviewListener.java
```

For the moment the only logic which is utilized is in Note.java and `NoteOverview.java`. We are using _jackson_ as our way to save and write to file. This is implemented in `NotesPersistence.java`.

As userinterface we have one main class `App.java` with two FXML-files: `App.fxml` and `Note.fxml`. For these two we have two controller classes: `AppController.java` and `NoteController.java`

When app is launched, the first scene is defined by `App.fxml`. When new note is created `Note.fxml` scene is portrayed. When a Note-object is created, it is saved in `NoteOverview.java`. 
