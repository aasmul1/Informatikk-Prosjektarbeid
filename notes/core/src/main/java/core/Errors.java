package core;

/**
 * Error class for core module.
 */
public enum Errors {
  USERNAME_FIELD_EMPTY("Please enter a username."),
  PWD_FIELD_EMPTY("Please enter a password."),
  EVERYTHING_EMPTY("All fields must be filled out."),
  INVALID_USERNAME("Name should only contain letters, and be at least five letters."),
  INVALID_PWD("Invalid password, must be at least 8 characters and contain at least 1 digit and 1 lower and uppercase letter."),
  WRONG_PASSWORD("Wrong password"),
  NOT_REGISTERED("This user is not registered."),
  NOT_EQUAL_PASSWORD("Passwords do not match."),
  NOT_EQUAL_USERNAME("Usernames do not match"),
  EQUAL_NOTE_TITLE("Note with that title already exists"),
  NOTE_DOESNT_EXIST("This note was not deleted since it doesn't exist"),
  INVALID_CREATE_DATE("Note cannot be created after it was edited"),
  EXISTING_USER("User already exists"),
  NOT_EXISTING_USER("User does not exist!"),
  SELECT_NOTE("Pick a note"),
  EMPTY_TITLE("Please write a title"),
  EMPTY_TEXT("Please write a text"),
  INVALID_INDEX("Note doesn't exist");

  private final String errorMessage;

  /**
   * Constructor for Error.
   *
   * @param errorMessage with proper error message.
   */
  Errors(final String errorMessage) {
    this.errorMessage = errorMessage;
  }

  /**
   * Get method for getting error message.
   *
   * @return the error message.
   */
  public String getMessage() {
    return errorMessage;
  }
}
