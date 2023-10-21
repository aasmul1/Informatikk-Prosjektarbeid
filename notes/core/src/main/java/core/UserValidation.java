package core;

import java.util.regex.Pattern;

public class UserValidation {

    private static final Pattern USERNAME_REGEX = Pattern.compile("^([a-åA-Å]{5,})$");
    private static final Pattern PASSWORD_REGEX = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])"
      + "(?=.*[a-zA-Z]).{8,}$");

    private static boolean isValidRegex(Pattern regex, String string) {
        return regex.matcher(string).matches();
    }

    public static void checkValidUsername(String username) {
        if(isEmpty(username)) {
            throw new IllegalArgumentException(Errors.USERNAME_FIELD_EMPTY.getMessage());
        }
        if(!isValidRegex(USERNAME_REGEX, username)) {
            throw new IllegalArgumentException(Errors.INVALID_USERNAME.getMessage());
        }
    }

    public static void checkValidPassword(String password) {
        if (isEmpty(password)) {
          throw new IllegalArgumentException(Errors.PWD_FIELD_EMPTY.getMessage());
        }
        if (!isValidRegex(PASSWORD_REGEX, password)) {
          throw new IllegalArgumentException(Errors.INVALID_PWD.getMessage());
        }
    }

    public static void isNotExistingUser(String email, String password, Accounts accounts) {
        if (accounts.getUser(email, password) == null) {
          throw new IllegalArgumentException(Errors.NOT_REGISTERED.getMessage());
        }
    }

    public static void checkValidUser(String username, String password) {
        allFieldsEmpty(username, password);
        checkValidUsername(username);
        checkValidPassword(password);
    }

    public static void allFieldsEmpty(String username, String password) {
        if(isEmpty(username) && isEmpty(password)) {
            throw new IllegalArgumentException(Errors.EVERYTHING_EMPTY.getMessage());
        }
    }

    public static void isValidLogin(String username, String password, Accounts accounts) {
        if(!accounts.checkValidUserLogin(username, password)) {
            throw new IllegalArgumentException(Errors.INVALID_USERNAME_AND_OR_PWD.getMessage());
        }
    }

    public static boolean isEmpty(String string) {
        if (string.equals("")) {
            return true;
        }
        return true;
    }
}
