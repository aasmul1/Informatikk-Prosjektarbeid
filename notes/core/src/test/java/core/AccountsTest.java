package core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountsTest {

    private Accounts accounts;
    private User user1;
    private User user2;

    @BeforeEach
    public void setUp() {
        accounts = new Accounts();
        NoteOverview noteOverview1 = new NoteOverview();
        NoteOverview noteOverview2 = new NoteOverview();

        user1 = new User("defaultUserONE", "defaultPassword1", noteOverview1); // Changed this line
        user2 = new User("defaultUserTWO", "defaultPassword2", noteOverview2); // Changed this line

        accounts.addUser(user1);
        accounts.addUser(user2);
    }

    @Test
    public void getAccountsTest() {
        assertNotNull(accounts.getAccounts());
    }

    @Test
    public void testAddUser() {
        NoteOverview noteOverview = new NoteOverview();
        User newUser = new User("testUser", "testPassword1", noteOverview);

        // Try adding a new user, should succeed because user does not exist yet.
        assertDoesNotThrow(() -> accounts.addUser(newUser));

        // Try adding the same user again, should throw an exception because user
        // already exists.
        assertThrows(IllegalStateException.class, () -> accounts.addUser(newUser));

        // Test if accounts now contains newUser
        assertTrue(accounts.containsUser(newUser));
    }

    @Test
    public void containsTest() {
        assertTrue(accounts.containsUser(user1));
    }

    @Test
    public void testRemoveUser() {
        NoteOverview noteOverview = new NoteOverview();
        User user = new User("testUser", "testPassword1", noteOverview);

        // Try removing a user that hasn't been added, should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> accounts.removeUser(user));

        // Now, add the user and then try removing, should succeed.
        accounts.addUser(user);
        assertDoesNotThrow(() -> accounts.removeUser(user));
    }

    @Test
    public void testIterator() {
        Iterator<User> userIterator = accounts.iterator();
        assertTrue(userIterator.hasNext());
        assertEquals(user1, userIterator.next());
        assertTrue(userIterator.hasNext());
        assertEquals(user2, userIterator.next());
        assertFalse(userIterator.hasNext());
    }

    @Test
    public void testGetUser() {

        assertEquals(user1, accounts.getUser("defaultUserONE"));
        assertEquals(user1, accounts.getUser("defaultUserONE", "defaultPassword1"));

        // Wrong password to username
        assertEquals(null, accounts.getUser("defaultUserTWO", "defaultPassword1"));
    }

    @Test
    public void testValidUserLogin() {
        NoteOverview noteOverview = new NoteOverview();
        String username = "validUser";
        String password = "validPassword1";

        User validUser = new User(username, password, noteOverview);
        accounts.addUser(validUser);

        // Test if login valid for a valid user.
        assertTrue(accounts.checkValidUserLogin(username, password));

        // Test login valid for invalid password.
        assertFalse(accounts.checkValidUserLogin(username, "invalidPassword1"));

        // Test login valid for nonexistent user.
        assertFalse(accounts.checkValidUserLogin("invalidUser", password));
    }

    /* @Test
    public void testUpdateUserObject() {

        // Updates user1 info
        user1.setUsername("updatedUsername");
        user1.setPassword("updatedPassword1");

        // Update the user1 object in the accounts
        int index = accounts.indexOf(user1);
        accounts.updateUserObject(user1, index);

        // Retrieve the updated user based on the changed username
        User updatedUserFromAccounts = accounts.getUser("updatedUsername");

        assertNotNull(updatedUserFromAccounts); // Ensure the user is retrieved successfully
        assertEquals("updatedUsername", updatedUserFromAccounts.getUsername()); // Check updated username
        assertEquals("updatedPassword1", updatedUserFromAccounts.getPassword()); // Check updated password
    } */

    /* @Test
    public void testUserInfoChanged() {
        // Update user1 attributes
        user1.setUsername("changedUsername");
        user1.setPassword("changedPassword1");

        // Notify that the user info has changed
        accounts.userInfoChanged(user1);

        // Check that the user info in accounts is  updated
        User updatedUser = accounts.getUser("changedUsername");
        assertNotNull(updatedUser);
        assertEquals("changedPassword1", updatedUser.getPassword());
    } */

}
