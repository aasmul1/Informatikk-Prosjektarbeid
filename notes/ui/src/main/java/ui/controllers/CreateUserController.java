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

public class CreateUserController extends AbstractController {

  @FXML
  private TextField createUsernameInput;
  @FXML
  private TextField createPasswordInput;
  @FXML
  private TextField confirmPasswordInput;
  @FXML
  private Button createUser;
  @FXML
  private Text errorMessageDisplay;

  private String username;
  private String password;
  private String confirmPassword;

  @FXML
  private void createUser(ActionEvent event) throws IOException {

    try {
      UserValidation.checkValidUsername(createUsernameInput.getText());
      username = createUsernameInput.getText();
      UserValidation.checkValidPassword(createPasswordInput.getText());
      password = createPasswordInput.getText();
      confirmPassword = confirmPasswordInput.getText().trim();
      UserValidation.checkEqualPassword(password, confirmPassword);

      NoteOverview noteOverview = new NoteOverview(); // empty noteoverview
      User user = new User(username, password, noteOverview);
      getDataAccess().createUser(user);

      setScene(Controllers.LOGIN, event, getDataAccess());

    } catch (IllegalArgumentException e) {
      errorMessageDisplay.setText(e.getMessage());
    }
  }
}
