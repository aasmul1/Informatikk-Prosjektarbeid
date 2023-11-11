# Core
The core module represents the essential engine of the application, consisting of pure Java code that constitutes the central operating logic. This core is designed to be independent of user interface considerations, focusing on the key tasks and processes that the application needs to execute.

## JSON File Format
___
Our project utilizes JSON (JavaScript Object Notation) as the data interchange format for storing and retrieving information. JSON is a lightweight and human-readable data format that is widely supported in various programming languages. This section provides an overview of the JSON file format used in our project.

### File Structure

In our project, JSON files are structured as follows:

```sh
{"title":"Titel ","text":"text", "created":"createdDate","edited":"editedDate"}
```


### Classes
- [Accounts.java](src/main/java/core/Accounts.java): 
- [CreatedDateComparator.java](src/main/java/core/CreatedDateComparator.java):
- [EditedDateComparator.java](src/main/java/core/EditedDateComparator.java):
- [Errors.java](src/main/java/core/Errors.java):
- [Note.java](src/main/java/core/Note.java):
- [NoteOverview.java](src/main/java/core/NoteOverview.java):
- [TitleComparator.java](src/main/java/core/TitleComparator.java):

### Tests