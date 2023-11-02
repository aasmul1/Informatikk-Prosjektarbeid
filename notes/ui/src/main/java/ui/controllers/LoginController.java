package ui.controllers;

import java.io.IOException;

import core.UserValidation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController extends AbstractController {

    /**
     * Input fields
     */
    @FXML
    private TextField usernameInput, passwordInput;

    @FXML
    private Text errorMessage;

    /**
     * Button to initialize login
     */
    @FXML
    private Button loginButton;

    @FXML
    private Button createUserButton;

    @FXML
    public void createUserAction(ActionEvent event) throws IOException {
        setScene(Controllers.CREATE_USER, event, getDataAccess());
    }

    /**
     * Handles the user login action
     * Initiates the user login process by first accessing and retrieving user
     * information .json-file
     * Displays any issues directly on the UI.
     * 
     * @param event when clicking on "logg inn"
     * @throws IOException if something goes wrong when reading from file
     */
    @FXML
    public void loginUserAction(ActionEvent event) throws IOException {
        String username = usernameInput.getText();
        String password = passwordInput.getText();
        try {
            UserValidation.checkValidUsername(username);
            UserValidation.checkValidPassword(password);
            UserValidation.isNotExistingUser(username, password, getDataAccess().readAccounts());
            UserValidation.isValidLogin(username, password, getDataAccess().readAccounts());
            dataAccess.userLogin(username, password);

            setScene(Controllers.NOTEOVERVIEW, event, getDataAccess());

        } catch (IllegalArgumentException e) {
            errorMessage.setText(e.getMessage());
        }
    }
}