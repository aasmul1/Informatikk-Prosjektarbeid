package core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountsTest {

    private Accounts accounts;
    NoteOverview noteOverview = new NoteOverview();

    @BeforeEach
    public void setUp() {
        accounts = new Accounts();
    }

    @Test
    public void testAddUser() {
        User newUser = new User("testUser", "testPassword", noteOverview);

        // Try adding a new user, should succeed because user does not exist yet.
        assertDoesNotThrow(() -> accounts.addUser(newUser));

        // Try adding the same user again, should throw an exception because user already exists.
        assertThrows(IllegalStateException.class, () -> accounts.addUser(newUser));
    }

    @Test
    public void testRemoveUser() {
        User user = new User("testUser", "testPassword", noteOverview);

        // Try removing a user that hasn't been added, should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> accounts.removeUser(user));

        // Now, add the user and then try removing, should succeed.
        accounts.addUser(user);
        assertDoesNotThrow(() -> accounts.removeUser(user));
    }

    
}
