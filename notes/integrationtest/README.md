# Integrationtest

### Reason for implementing integrationstests

The group is working on creating test code for all classes and methods in the project, including application tests and mock tests. Although an integration test may seem unnecessary, it plays a vital role. Even if individual tests pass, there's a chance that the modules may not work together correctly. The integration test checks if separate modules of the application function together as intended.

### Implementation of module in Notes

The integration test module checks if the JavaFX client application effectively connects and communicates with a Spring Boot server. Through Maven and the safe-fail plugin, the integration test module, during testing, initiates the server application with a test configuration.