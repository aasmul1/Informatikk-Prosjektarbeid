package ui.controllers;

import java.io.IOException;

import core.UserValidation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController extends AbstractController{

  /**
   * Input fields
   */
  @FXML
  private TextField usernameInput, passwordInput; 

  @FXML 
  private TextArea errorMessage;

  /**
   * Button to initialize login
   */
  @FXML
  private Button loginButton; 

  @FXML private Button createUserButton;

  @FXML
  public void createUserActionButton(ActionEvent event) throws IOException{
    
  }
  
  @FXML
  public void loginUser(ActionEvent event) throws IOException{

    String username = usernameInput.getText();
    String password = passwordInput.getText();
    try{
    UserValidation.checkValidUsername(username);
    UserValidation.checkValidPassword(password);
    UserValidation.isNotExistingUser(username,
          password, null);
    UserValidation.isValidLogin(username, password, null);

    //her trengs logikk for å sette scene
    }catch(IllegalAccessError e){
        errorMessage.setText(e.getMessage());
    }
  }

  public void loadLoginInfo(){

  }

}
