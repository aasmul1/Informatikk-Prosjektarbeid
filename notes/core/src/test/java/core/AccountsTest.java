package core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountsTest {

        private Accounts accounts;

    @BeforeEach
    public void setUp() {
        accounts = new Accounts();
    }

    @Test
    public void testAddUser() {
        NoteOverview noteOverview = new NoteOverview();
        User newUser = new User("testUser", "testPassword", noteOverview);

        // Try adding a new user, should succeed because user does not exist yet.
        assertDoesNotThrow(() -> accounts.addUser(newUser));

        // Try adding the same user again, should throw an exception because user already exists.
        assertThrows(IllegalStateException.class, () -> accounts.addUser(newUser));
    }

    
}
