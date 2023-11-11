# Release-3
In Release 3, the group intends to delivering the final version of the Notes app. Throughout this release, our primary focus has been on implementing login functionality, establishing a reliable API and server connection, and making significant improvements to the code quality throughout the application. In addition we have thoroughly written a comprehensive set of tests to ensure the stability and reliability of the entire application. 

## Work Habits
In Release 3, we have built upon the successful work habits established in the previous release, while also making improvements to our workflow. Before the start of the last sprint, the group discussed and agreed that a slight adjustment to task management was necessary. 

### Commit messages 
The team realized the importance for clearer communication and agreed we needed more detailed commit messages. ..... Each of our merge requests is also linked to a specific branch and issue, removing the need for extensive merge commit messages, since we don't squash commits. By maintaining individual commit histories for all issues in GitLab, it is unnecessary to duplicate this information in an extra merge commit message.  


### Task Management
In Release 3, we actively embraced GitLab's task management features more. This enhanced our ability to clearly define the smaller tasks associated with each issue. This approach ensures that all group members have a clear understanding of the specific tasks and goals related to any given issue, further optimizing our development process, while also organizing what is left to do in an issue. 

TODO
- Pair programming 

## New Features 

### New classes:
In Release 3, several new classes have been introduced across different modules. To improve the applications functionality we have implemented user login, this has introduced several new files across different modules. We have also introduced `AbstractController.java´, establishes a foundational framework for all controllers in our application. Further details about this can be found under code improvement.

The integration test class NotesAppIT.java has been introduced, serving as an integration test class to ensure the application's functionality. Additionally, the group has introduced essential classes and files necessary for configuring a RESTful application.

### UI: 

#### Controller classes:
``````
- AbstractController.java
- LoginController.java
- CreateUserController.java
``````
#### FXML Files:
```
- Login.fxml
- CreateUser.fxml
```

#### DataAccess classes:
```
- LocalNotesAcess.java
- NotesAccess.java
- RemoteNotesAccess.java
```
___
### Core:
```
- User.java
- Accounts.java
- Errors.java
```
___
### RestServer:
```
- NotesController.java
- NotesService.java
- RestServerApplication.java

Execptions classes:
    - ApiError.java
    - AppException.java
    - FileException.java
    - NoteNotFoundException.java
    - UserAlreaduExistsException.java
    - UserNotFoundException.java
```
___
### IntegrationTest
```
- NotesAppIT.java
```
___


## New User Story for release 3 
```
User Login (US-5): "A user desire a secure and efficient login process to access their notes within the application. If the user does not have an existing account, they should also be able to create one."
```

## Code improvments 
In Release 3, we continued to prioritize code quality and readability, building upon our previous implemented tools Checkstyle and spotbugs. We actively addressed and improved issues that Checkstyle had previously identified, ensuring a more consistent code style. Additionally, we used SpotBugs to detect and resolve common Java issues, resulting in enhanced overall code quality.

An important change in this release involves the reallocation of core logic responsibilities from the controllers to the core module via data access. Consequently, our controllers now primarily handle user interface interactions, while the critical logic resides within the core module. This architectural shift enhances code clarity and maintainability.

### Test Coverage 
We have significantly improved the test coverage for this release, for all modules. Just as in our previous releases, we have used Jacoco to evaluate the extent of test coverage. This release also introduces a dedicated module `report´ to compile all test results into a single unified report, which improves the overall testing process.

For this release, our goal was to achieve atleast 90% test coverage for each module. Esspesially with a focus on testing all fundamental functionalities of the code. For more detailed information on individual test coverage scores, refer to the module's readme.

### Controller Organization 
In the UI module, we have introduced several significant changes to the controllers to improve code structure. Firstly, we have restructured our controllers by placing them in a dedicated folder / directory. This approach enhances the overall structure our codebase, and makes it easier to navigate to the many controllers. 

For code consistency in our application, we have implemented an abstract controller, allowing us to share methods and properties between different controllers. This reduces redundancy and establishes a unified coding standard throughout the application.

TODO
- unesseccary imports removed
- test coverage is at acepliable level

### AccountsPersistence.java

### Error class 



