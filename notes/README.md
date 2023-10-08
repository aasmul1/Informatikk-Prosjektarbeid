# Notes description 

Our app is an intuitive note-taking application. Users can easily create new notes and later return to make changes or delete them entirely. All notes are presented in a clear list, organized chronologically based on when they were created.

The app has two main functions

 - Creating a new note
- Editing old notes

## The application

![Image Alt Text](../docs/pictures/Notes.jpg)

## Build and running of project


To set up the project, you have to be in root level `GR2311` 

```
mvn clean install
```


To run the projekt, when in root level run:

```
cd ui
mvn javafx:run
```



## Testing of project

The project 

To run all tests, run: 

```
mvn test
```

To only run `graphical` test:

```
cd ui
mvn test
```

To only run `core` tests:

```
cd core
mvn test
```

## User Stories
User Stories can you find [here](../notes/UserStories.md). They are linked up with the issues in GitLab.




