# __Notes-App__

The Notes-App is a simple application designed to help users create, edit, manage, and securely log in to handle their notes. For a more detailed description of the app, please refer to [this README file](/notes/README.md).

## Eclicse-Che
Open [this](https://che.stud.ntnu.no/#https://gitlab.stud.idi.ntnu.no/it1901/groups-2023/gr2311/gr2311?new) link. 

TODO skrive hvordan man kjører i ecplise

## Building and running the application
___

The project requires Maven for building and running the app from the command line. Hoewever, when running the application within Eclipse Che, Maven is not necessary. 

The application can be ran in two different ways: locally or remote. 

### Running the application locally 
1) Change the directory to the notes folder
2) Execute a clean build of the Maven project and install the package into the local repository
3) Run the JavaFX application user interface module with Maven

```sh
1) 
cd notes

2)
mvn clean install
#Tests can be skipped with mvn clean install -Dmaven.test.skip

3)
mvn javafx:run -pl ui
```
### Running the application remote

1) Change the directory to the notes folder
2) Execute a clean build of the Maven project and install the package into the local repository
3) Start server
4) Open a new terminal window. Run the JavaFX application user interface module with Maven

```sh
1) 
cd notes

2)
mvn clean install
#Tests can be skipped with mvn clean install -Dmaven.test.skip

3)
mvn spring-boot:run -pl rest
 
4) 
mvn javafx:run -pl ui -P remoteapp
#Must be written in a separate terminal window after repeating step 1) 

```

## Testing 
___

To run all tests, run: 

```sh
1)
cd notes

2)
mvn test

#To get a report of the tests, run this command. 
3)
mvn jacoco:report
#Report can be found under /report/target/site/index.html
```

To only run `graphical` test:

```sh 
1)
cd ui

2)
mvn test
```

To only run `core` tests:

```sh
1)
cd core

2)
mvn test
```
