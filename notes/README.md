# Notes 

## Project description
___
Our app is an intuitive note-taking application designed for ease and efficiency. Users must log in with username and password, or create a user to use the app. When logging in, all notes are stored. Users can swiftly create new notes, and when they return, making modifications or deleting notes is easy. All notes are initially presented in a clear list, organized chronologically based on their creation date. To cater to individual preferences, we've incorporated a sorting feature. Users can choose to sort their notes based on 'Created date', 'Last edited date', or alphabetically by 'Title (A-Z)'. This added functionality ensures that users have quick access to their information, streamlining their note management process.

## Project structure
___

Diagram of project structure here TODO LAG DIAGRAM
TODO LEGG VED LINKER PÅ "HERE"
### **Modules**
### `core` ### 
Read more about the core-module here
### `integrationtest` ###
Read more about the integrationtest-module here
### `report` ###
Read more about the report-module here
### `rest` ###
Read more about the rest-module here
### `ui` ###
Read more about the ui-module here

### **Diagrams**
Diagrams for our Notes-App can be found here TODO LINK

## JSON File Format
___
Our project utilizes JSON (JavaScript Object Notation) as the data interchange format for storing and retrieving information. JSON is a lightweight and human-readable data format that is widely supported in various programming languages. This section provides an overview of the JSON file format used in our project.

### File Structure

In our project, JSON files are structured as follows:

```
{"title":"Titel ","text":"text", "created":"createdDate","edited":"editedDate"}

```

## Functionality of the application
___

- Log in to an already existing user or create a new user
- Creating notes
    - Add title and text
- Editing notes
    - Edit title and/or text
    - The note will get "last edited date"
- Deleting notes
- Sorting the list of notes based on
    - Created date
    - Last edited date
    - Alphabetically (A-Z)

### **User Stories**

User Stories can be find [here](../notes/UserStories.md). They are linked up with the issues in GitLab.

## User interface
___
User interface of the application
- Note overview user interface [here](../docs/pictures/Notes-App-ui2.png)
- Note user interface here [here](../docs/pictures/Notes-App-ui1.png)






