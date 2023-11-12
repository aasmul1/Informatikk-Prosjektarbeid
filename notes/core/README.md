# Core
The core module is the main part of the application. It's made up of important Java code that runs the main functions of the app. This part is separate from the user interface, and it deals with the main tasks and processes that the app needs to do.

### **Structure**
In the core directory, there are two subfolders: core and json. The core folder contains code related to logic, while the json folder houses the code for file management.

Class diagram of the core class can be found [here](/diagrams/README.md). TODO fikse link

### JSON File Format
#
Our project utilizes JSON (JavaScript Object Notation) as the data interchange format for storing and retrieving information. JSON is a lightweight and human-readable data format that is widely supported in various programming languages. This section provides an overview of the JSON file format used in our project.

### File Structure

In our project, JSON files are structured as follows:

```sh
{"title":"Titel ","text":"text", "created":"createdDate","edited":"editedDate"}
```
#

### **Classes**
**core**
- [Accounts.java](src/main/java/core/Accounts.java): 
- [CreatedDateComparator.java](src/main/java/core/CreatedDateComparator.java):
- [EditedDateComparator.java](src/main/java/core/EditedDateComparator.java):
- [Errors.java](src/main/java/core/Errors.java):
- [Note.java](src/main/java/core/Note.java):
- [NoteOverview.java](src/main/java/core/NoteOverview.java):
- [TitleComparator.java](src/main/java/core/TitleComparator.java):

`Note` class handles represents an individual note. It enforces non-empty title and text through validation in the setters. `NoteOverview` manages a collection of Note objects, and has functionality such as add, remove and sort notes. 

The three classes `CreatedDateComaprator`, `EditedDateComaprator` and `TitleComaprator` is the comparator classes with logic for sorting the notes, and they are implemented in `NoteOverview`. 

`User` class represents an individual user in the application. Each User object has a username, password and an associated NoteOverview object, with all the users notes. 
`UserValidation` class is responsible for ensuring that username and password inputs is in the right format according to the requirements. 


`Accounts` class contains logic for managing all users of the app, it allows adding new users, checking if a given user exists in the system, and removing users. The class provides methods to validate user login. 

`Errors` enum is a collection of predefined error messages, where each enum constant represents a spesific type of scenario. 
#

**json**
- [AccountsPersistence.java](src/main/java(json/AccountsPersistance.java))

    **internal**

    - [AccountsDeserializer.java](src/main/java/json/internal/AccountsDeserializer.java)
    - [AccountsModule.java](src/main/java/json/internal/AccountsModule.java)
    - [AccountsSerializer.java](src/main/java/json/internal/AccountsSerializer.java)
    - [NoteDeserializer.java](src/main/java/json/internal/NoteDeserializer.java)
    - [NoteOverviewDeserializer.java](src/main/java/json/internal/NoteOverviewDeserializer.java)
    - [NoteOverviewSerializer.java](src/main/java/json/internal/NoteOverviewSerializer.java)
    - [NoteSerializer.java](src/main/java/json/internal/NoteSerializer.java)
    - [UserDeserializer.java](src/main/java/json/internal/UserDeserializer.java)
    - [UserSerializer.java](src/main/java/json/internal/UserSerializer.java) 

### **Tests**
#
### Test classes
TODO skrive om tester, testdekningsgrad

**core tests**
- [AccountsTest.java](src/test/java/core/AccountsTest.java)
- [CreatedDateComparatorTest.java](src/test/java/core/CreatedDateComparatorTest.java)
- [EditedDateComparatorTest.java](src/test/java/core/EditedDateComparatorTest.java)
- [NoteOverviewTest.java](src/test/java/core/NoteOverviewTest.java)
- [NoteTest.java](src/test/java/core/NoteTest.java)
- [TitleComparatorTest.java](src/test/java/core/TitleComparatorTest.java)
- [UserTest.java](src/test/java/core/UserTest.java)
- [UserValidationTest.java](src/test/java/core/UserValidationTest.java)

**json tests**
- [AccountsPersistanceTest.java](src/test/java/json/AccountsPersistanceTest.java)

    **internal**
    - [AccountsJsonTest.java](src/test/java/json/internal/AccountsJsonTest.java)

### Test coverage
#



