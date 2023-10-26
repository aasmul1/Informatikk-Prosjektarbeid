package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import core.UserValidation;
import core.User;

/**
 * This is the class for controlling CreateUser scene.
 */

public class CreateUserController {
    
    
    @FXML private TextField inputPassword;
    @FXML private TextField inputUsername;
    @FXML private TextField inputConfirmPassword;
    @FXML private Button createUser;
    @FXML private Text errorMessageDisplay;

    private String username;
    private String password;
    private String confirmPassword;

    @FXML
    private void createUserAction(ActionEvent event) throws IOException {
        
        try {

            username = inputUsername.getText();
            password = inputPassword.getText();
            confirmPassword = inputConfirmPassword.getText();
            UserValidation.allFieldsEmpty(username, password);
            
            UserValidation.checkValidUsername(username);
            UserValidation.checkValidPassword(password);
            UserValidation.checkEqualPassword(password, confirmPassword);
            User ny = new User(username, password, null);
        } catch (IllegalArgumentException e) {
            errorMessageDisplay.setText(e.getMessage());
        }




    }



}
