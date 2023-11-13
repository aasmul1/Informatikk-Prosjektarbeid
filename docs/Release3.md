# Release-3
In Release 3, the group intends to delivering the final version of the Notes app. Throughout this release, our primary focus has been on implementing login functionality, establishing a reliable API and server connection, and making significant improvements to the code quality throughout the application. In addition, we have thoroughly written a complete set of tests to ensure the stability and reliability of the entire application. 

## Work Habits
In Release 3, we have built upon the successful work habits established in the previous release, while also making improvements to our workflow. Before the start of the last sprint, the group discussed and agreed that a slight adjustment to task management was necessary. 

Throughout the whole period, we maintained a routine of multiple weekly meetings. In the first meeting of the week, typically held on Mondays, we sit down toghether and and discuss what goals we shoud have this week and what goals its realistic to achieve in the coming days. After release 2, we realised that we had a lot more work to do in the final release, so we decided to increase the frequency of out meetings. 

Our work strategy for the last sprint involved doing larger tasks when we sit togheter, and fix smaller issues independently, minimizing the need for constant communication on less critical tasks. Each team member was assigned a spesific segment of the project to concentrate on. This method allowed us to get a deeper understanding of our respective areas. Although we often worked in the same space, our tasks were more individualized, which we think led to more an effective process. 

This approach proved to be an effective solution when the project progressed smoothly. However, it had its drawbacks, and it could be challenging when larger problems or bugs arose, because the other team members were not as deeply familiar with the spesific segment. 
In the end, everything worked out, even though some things took some more time than expected. 

To keep eachother updated on the various parts of the code, and to maintain high code quality, we use "code review" in GitLab, where another group member reviews, and if necessary, gives feedback on the code before merging into dev branch. 
 

//TODO SKRIV FERDIG HER

Upon reflecting on our work, we've identified a work habit that should have been implemented earlier. That is the practice of creating tests more consistently and developing them as we go. Although we started with tests towards the end of Release 2, the effort required to create tests for both the core and UI modules turned out to be more work than anticipated. As we caught up with testing in Release 3, it revealed several flaws in our application, allowing us to address multiple issues. In hindsight, we acknowledge that testing more frequently would have been a better strategy, ultimately improving our code base.

- endret hvor vi knytter issues til userstoryes, usikre på 
- par progging 

### Commit messages and merge requests 
The team realized the importance for clearer communication and agreed we needed more detailed commit messages forward. Although we have aimed to improved commit messages for this release, there has not always been a pressing need for them in our collaboration, as we often work closely together and verbally communicate our changes.  

Each of our merge requests is also linked to a specific branch and issue, removing the need for extensive merge commit messages into dev, since we don't squash commits. By maintaining individual commit histories for all issues in GitLab, it is unnecessary to duplicate this information in an extra merge commit message.  

### Task Management
In Release 3, we embraced GitLab's task management features for larger or collaborative issues more. By doing this we could specify smaller tasks within each issue, which ensures a shared understanding in the group, and helped the prosess if more group members worked on the same issue. While this approach was beneficial for some issues, there is room for improvement by doing this for all our issues for a more comprehensive task management approach.

## New Features 

### New classes:
In Release 3, several new classes have been introduced across different modules. To improve the applications functionality we have implemented user login, this has introduced several new files across different modules. We have also introduced `AbstractController.java´, establishes a foundational framework for all controllers in our application. Further details about this can be found under code improvement.

The integration test class NotesAppIT.java has been introduced, serving as an integration test class to ensure the application's functionality. Additionally, the group has introduced essential classes and files necessary for configuring a RESTful application.

### UI: 

#### Controller classes:

- [AbstractController.java](../notes/ui/src/main/java/ui/controllers/AbstractController.java) 
- [LoginController.java](../notes/ui/src/main/java/ui/controllers/LoginController.java) 
- [CreateUserController.java](../notes/ui/src/main/java/ui/controllers/CreateUserController.java) 

#### FXML Files:

- [Login.fxml](../notes/ui/src/main/resources/ui/Login.fxml) 
- [CreateUser.fxml](../notes/ui/src/main/resources/ui/CreateUser.fxml) 

#### DataAccess classes:

- [LocalNotesAcess.java](../notes/ui/src/main/java/dataaccess/LocalNotesAccess.java) 
- [RemoteNotesAcess.java](../notes/ui/src/main/java/dataaccess/RemoteNotesAccess.java) 
- [NotesAcess.java](../notes/ui/src/main/java/dataaccess/NotesAccess.java) 
___
### Core:
- [Accounts.java](../notes/core/src/main/java/core/Accounts.java) 
- [User.java](../notes/core/src/main/java/core/User.java) 
- [Errors.java](../notes/core/src/main/java/core/Errors.java) 

___
### RestServer:

- [NotesController.java](../notes/rest/src/main/java/rest/NotesController.java) 
- [NotesService.java](../notes/rest/src/main/java/rest/NotesService.java) 
- [RestServerApplication.java](../notes/rest/src/main/java/rest/RestServerApplication.java) 

Execptions classes:

- [ApiError.java](../notes/rest/src/main/java/rest/exceptions/ApiError.java) 
- [AppExceptionHandler.java](../notes/rest/src/main/java/rest/exceptions/AppExceptionHandler.java) 
- [FileException.java](../notes/rest/src/main/java/rest/exceptions/FileException.java) 
- [NoteNotFoundException.java](../notes/rest/src/main/java/rest/exceptions/NoteNotFoundException.java) 
- [UserAlreadyExistsException.java](../notes/rest/src/main/java/rest/exceptions/UserAlreadyExistsException.java) 
- [UserNotFoundException.java](../notes/rest/src/main/java/rest/exceptions/UserNotFoundException.java) 

___
### IntegrationTest

- [NotesAppIT.java](../notes/integrationtest/src/test/java/NotesAppIT.java) 

___


## New User Story for release 3 
```
User Login (US-5): "A user desire a secure and efficient login process to access their notes within the application. If the user does not have an existing account, they should also be able to create one."
```

## Code improvments 
In Release 3, we continued to improve the code quality and readability, building upon our previous implemented tools Checkstyle and spotbugs. We addressed and improved issues that Checkstyle had previously identified, ensuring a more consistent code. Additionally, we used SpotBugs to detect and resolve common Java issues, resulting overall better code quality.

In Release 3, we dedicated increased attention to the usage of the checkstyle-plugin. This focus helped us to eliminate unnecessary imports, maintain consistent line spacing, and overall enhance the readability and thoroughness of our code.

- feilhåndtering 
- se på mer 

### Test Coverage 
We have significantly improved the overall test coverage for this release. Just as in our previous releases, we have used Jacoco to evaluate the extent of test coverage. This release also introduces a dedicated module `report´ to compile all test results into a single unified report, which simplified the overall testing process.

For this release, our goal was to achieve 90% test coverage overall for the application, with a particular focis on testing all fundamental functionalities. For more detailed information on individual test coverage scores, refer to the module's readme.

### Controller Organization 
An important change in this release involves the reallocation of core logic responsibilities from the controllers to the core module via data access. Consequently, our controllers now primarily handle user interface interactions, while the critical logic resides in the core module. This architectural change enhances code clarity.

In the UI module, we have introduced several significant changes to the controllers to improve code structure. Firstly, we have restructured our controllers by placing them in a dedicated folder / directory. This approach enhances the overall structure our codebase, and makes it easier to navigate to the many controllers. 

For code consistency in our application, we have implemented an abstract controller, allowing us to share methods and properties between different controllers. This reduces redundancy and establishes a unified coding standard throughout the application.


### AccountsPersistence.java

### Error class 

In Release 3, the team collectively decided to establish a way for managing error handling within the core module. The solution involved developing an Error enum class that contains all error messages. This approach ensures consistency in providing feedback to the user across the entire system.

