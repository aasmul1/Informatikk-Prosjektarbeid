package core;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserValidationTest {

    private User testUser;
    private NoteOverview noteOverview;

    @BeforeEach
    public void setUp() {
        testUser = new User("Username", "Pasword123", noteOverview);
    }
    
    @Test
    public void testUserCredentials(){
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> testUser.setUsername("2"));
        String password = testUser.getPassword();
        Assertions.assertThrows(IllegalArgumentException.class, () -> testUser.setPassword("password"));
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> testUser.setUsername(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> testUser.setPassword(""));
        String username = testUser.getUsername();

        Assertions.assertDoesNotThrow(() -> UserValidation.checkValidUser(username, password));

        Assertions.assertThrows(IllegalArgumentException.class, () -> UserValidation.checkEqualPassword("password1", "password2"));
        Accounts accounts = new Accounts();
        accounts.addUser(testUser);
        Assertions.assertDoesNotThrow(() -> UserValidation.isValidLogin(username, password, accounts));
        Assertions.assertThrows(IllegalArgumentException.class, () -> UserValidation.isValidLogin("Username", "Password123", accounts));
        Assertions.assertThrows(IllegalArgumentException.class, () -> UserValidation.isNotExistingUser("email@emaile.com", "Password!", accounts));
        assertThrows(IllegalArgumentException.class, () -> UserValidation.allFieldsEmpty("", ""));
    }
    
}
