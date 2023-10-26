package ui.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import core.UserValidation;
import core.NoteOverview;
import core.User;

/**
 * This is the class for controlling CreateUser scene.
 */

public class CreateUserController extends AbstractController{
    
    
    @FXML private TextField inputPassword;
    @FXML private TextField inputUsername;
    @FXML private TextField inputConfirmPassword;
    @FXML private Button createUser;
    @FXML private Text errorMessageDisplay;

    private String username;
    private String password;
    private String confirmPassword;

    @FXML
    private void createUser(ActionEvent event) throws IOException {
        
        try {
            UserValidation.allFieldsEmpty(inputUsername.getText(), inputPassword.getText());
            UserValidation.checkValidUsername(inputUsername.getText());
            UserValidation.checkValidPassword(inputPassword.getText());
            confirmPassword = inputConfirmPassword.getText();
            UserValidation.checkEqualPassword(password, confirmPassword);
            username = inputUsername.getText();
            password = inputPassword.getText();

            NoteOverview noteOverview = new NoteOverview(); //empty noteoverview
            User user = new User(username, password, noteOverview);

            getDataAccess().createUser(user);

            setScene(Controllers.LOGIN, event, dataAccess, null);

        } catch (IllegalArgumentException e) {
            errorMessageDisplay.setText(e.getMessage());
        }
    }

    public void loadCreateUserInfo(){

    }
}
