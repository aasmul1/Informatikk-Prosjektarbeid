# Release-3
In Release 3, the group intends to delivering the final version of the Notes app. Throughout this release, our primary focus has been on implementing robust login functionality, establishing a reliable API and server connection, and conducting extensive code enhancements across the application. In addition we have thoroughly written a comprehensive suite of tests to ensure the stability and reliability of the entire system. 

## Work Habits
In Release 3, we have built upon the successful work habits established in the previous release while also making improvements to our workflow. We have elevated our commitment by creating more comprehensive and detailed commit messages, to further promote clear and informative communication. 

### Task Management
In Release 3, we actively embraced GitLab's task management features more, enhancing our ability to clearly define the tasks associated with each issue. This approach ensures that all group members have a clear understanding of the specific tasks and goals related to any given issue, further optimizing our development process.

TODO

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
In Release 3, we continued to prioritize code quality and readability, building upon our previous implemented tools Checkstyle and spotbugs. We actively addressed and improved upon the issues that Checkstyle had previously identified, ensuring a more consistent code style. Additionally, we used SpotBugs to detect and resolve common Java issues, resulting in enhanced overall code quality.

We have significantly improved the test coverage for this release, for all modules. Just as in our previous releases, we've maintained our utilization of Jacoco, a tool that evaluates the extent of code coverage achieved by our testing endeavors. Notably, this release introduces a dedicated module report to consolidate all test results into a single comprehensive report, improving the overall testing process.

### Controller Organization 


### AccountsPersistence.java

### Error class 




