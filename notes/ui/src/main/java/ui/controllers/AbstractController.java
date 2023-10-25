package ui.controllers;

public abstract class AbstractController{

    public enum Controllers{
        LOGIN("Login.fxml", new LoginController()),
        HOMEPAGE("App.fxml", new AppController()),
        NOTE("Note.fxml", new NoteController()),
        NOTE_EDIT("NoteEdit.fxml", new NoteEditController());
        // CREATE_USER("CreateUser.fxml", new CreateUserController());
        
        
    

        private final String fxml;
        private final AbstractController abstractController;

    Controllers(String fxml, AbstractController abstractController) {
      this.fxml = "views/" + fxml;
      this.abstractController = abstractController;
    }

    public AbstractController getControllerInstance() {
      return this.abstractController;
    }

    public String getFxmlString() {
      return this.fxml;
    }
    }




}