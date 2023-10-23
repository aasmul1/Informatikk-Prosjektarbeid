package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController extends AbstractController{

  /**
   * Input fields
   */
  @FXML
  private TextField username, password; 

  /**
   * Button to initialize login
   */
  @FXML
  private Button loginButton; 
  
}
