# Release-3
In Release 3, the group intends to delivering the final version of the Notes app. Throughout this release, our primary focus has been on implementing login functionality, establishing a reliable API and server connection, and making significant improvements to the code quality throughout the application. In addition, we have thoroughly written a complete set of tests to ensure the stability and reliability of the entire application. 

## Work Habits
In Release 3, we have built upon the successful work habits established in the previous release, while also making improvements to our workflow. Before the start of the last sprint, the group discussed and agreed that a slight adjustment to task management was necessary. 

Throughout the whole period, we maintained a routine of multiple weekly meetings. In these sessions,particularly at the beginning of the week, we sit down toghether and and discuss what goals we shoud have this week and what goals its realistic to achieve in the coming days. After release 2, we realised that we had a lot more work to do in the final release, so we decided to increase the frequency of out meetings. 

Out strategy involved doing larger tasks collectively, and fix smaller issues independently, minimizing the need for constant communication on less critical tasks. 

In this release, each team member was assigned a spesific segment of the project to concentrate on. This method allowed us to get a deeper understanding of our respective areas. Although we often worked in the same space, our tasks were more individualized, whcich we think led to more an effective process. 

//TODO SKRIV FERDIG HER

This was an effective solution when things were working, but the problem is when you need to fix an issue or bug, the other participants on the group were not enough into the code, so you could possibly sit alone with a huge problem to solve alone. 

. hvordan unittestene har påvirket arbeidet 
- mye endringer etterfulgt av testene, men kunne skrevet tester litt mer forsløpende 
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
In Release 3, we continued to improve the code quality and readability, building upon our previous implemented tools Checkstyle and spotbugs. We addressed and improved issues that Checkstyle had previously identified, ensuring a more consistent code. Additionally, we used SpotBugs to detect and resolve common Java issues, resulting overall better code quality.

- feilhåndtering 
- se på mer 

### Test Coverage 
We have significantly improved the overall test coverage for this release. Just as in our previous releases, we have used Jacoco to evaluate the extent of test coverage. This release also introduces a dedicated module `report´ to compile all test results into a single unified report, which simplified the overall testing process.

For this release, our goal was to achieve 90% test coverage overall for the application, with a particular focis on testing all fundamental functionalities. For more detailed information on individual test coverage scores, refer to the module's readme.

### Controller Organization 
An important change in this release involves the reallocation of core logic responsibilities from the controllers to the core module via data access. Consequently, our controllers now primarily handle user interface interactions, while the critical logic resides in the core module. This architectural change enhances code clarity.

In the UI module, we have introduced several significant changes to the controllers to improve code structure. Firstly, we have restructured our controllers by placing them in a dedicated folder / directory. This approach enhances the overall structure our codebase, and makes it easier to navigate to the many controllers. 

For code consistency in our application, we have implemented an abstract controller, allowing us to share methods and properties between different controllers. This reduces redundancy and establishes a unified coding standard throughout the application.

TODO
- unesseccary imports removed

### AccountsPersistence.java

### Error class 




