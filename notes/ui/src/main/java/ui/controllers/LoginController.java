package ui.controllers;

import java.io.IOException;

import core.UserValidation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController extends AbstractController{

  /**
   * Input fields
   */
  @FXML
  private TextField usernameinput, passwordInput; 

  @FXML 
  private Text errorMessage;

  /**
   * Button to initialize login
   */
  @FXML
  private Button loginButton; 
  
  @FXML
  public void loginUser(ActionEvent event) throws IOException{

    String username = usernameinput.getText();
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

}
