package ui.controllers;

import java.io.IOException;

import core.Note;
import dataaccess.NotesAccess;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import ui.App;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public abstract class AbstractController{

    protected NotesAccess dataAccess;

    public enum Controllers{
        LOGIN("Login.fxml", new LoginController()),
        NOTEOVERVIEW("App.fxml", new AppController()),
        NOTE("Note.fxml", new NoteController()),
        NOTE_EDIT("NoteEdit.fxml", new NoteEditController()),
        CREATE_USER("CreateUser.fxml", new CreateUserController());

        private final String fxml;
        private final AbstractController abstractController;

    Controllers(String fxml, AbstractController abstractController) {
      	this.fxml = "ui/" + fxml;
      	this.abstractController = abstractController;
    }

    public AbstractController getControllerInstance() {
      	return this.abstractController;
    }

    public String getFxmlString() {
      	return this.fxml;
    }
    }
    
    public void setDataAccess(NotesAccess dataAccess) {
    	this.dataAccess = dataAccess;
    }

    public NotesAccess getDataAccess() {
    	return this.dataAccess;
    }

	
	public void setScene(Controllers type, Event event, NotesAccess dataAccess, Note note){
		
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    try {
      		AbstractController controller = type.getControllerInstance();
      		FXMLLoader loader = new FXMLLoader();
      		loader.setController(controller);
      		loader.setLocation(App.class.getResource(type.getFxmlString()));
      		controller.setDataAccess(dataAccess);
      		Parent parent = loader.load();
      		if (controller instanceof AppController) {
        		((AppController) controller).loadAppInfo();
      		} else if (controller instanceof CreateUserController) {
        		((CreateUserController) controller).loadCreateUserInfo();
      		} else if (controller instanceof LoginController) {
        		((LoginController) controller).loadLoginInfo();
      		} else if (controller instanceof NoteController) {
        		((NoteController) controller).loadAddNoteInfo();
      		} else if (controller instanceof NoteEditController) {
        		((NoteEditController) controller).loadEditInfo(note);
      		}
      Scene newScene = new Scene(parent);
      stage.setScene(newScene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}  


}
