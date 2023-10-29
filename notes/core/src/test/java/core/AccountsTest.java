package core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        user1 = new User("defaultUser1", "defaultPassword1", noteOverview1); // Changed this line
        user2 = new User("defaultUser2", "defaultPassword2", noteOverview2); // Changed this line
    
        // It might be a good idea to add the users here, as you had initially commented out.
        accounts.addUser(user1);
        accounts.addUser(user2);
    }

    @Test
    public void getAccountsTest(){
        assertNotNull(accounts.getAccounts());
    }

    @Test
    public void testAddUser() {
        NoteOverview noteOverview = new NoteOverview();
        User newUser = new User("testUser", "testPassword", noteOverview);

        // Try adding a new user, should succeed because user does not exist yet.
        assertDoesNotThrow(() -> accounts.addUser(newUser));

        // Try adding the same user again, should throw an exception because user already exists.
        assertThrows(IllegalStateException.class, () -> accounts.addUser(newUser));

        //Test if accounts now contains newUser
        assertTrue(accounts.contains(newUser));
    }

    // @Test
    // public void containsTest(){
    //     assertTrue(accounts.contains(user1));
    // }

    @Test
    public void testRemoveUser() {
        NoteOverview noteOverview = new NoteOverview();
        User user = new User("testUser", "testPassword", noteOverview);

        // Try removing a user that hasn't been added, should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> accounts.removeUser(user));

        // Now, add the user and then try removing, should succeed.
        accounts.addUser(user);
        assertDoesNotThrow(() -> accounts.removeUser(user));
    }

    @Test
    public void testIndexOf(){
        assertEquals(0,accounts.indexOf(user1) );
        assertEquals(1,accounts.indexOf(user2) );
    }

    @Test
    public void testGetUser(){

        assertEquals(user1, accounts.getUser("defaultUser1"));
        assertEquals(user1, accounts.getUser("defaultUser1","defaultPassword1"));

        //Wrong password to username
        assertEquals(null, accounts.getUser("defaultUser2", "defaultPassword1"));
    }


    @Test
    public void testValidUserLogin() {
        NoteOverview noteOverview = new NoteOverview();
        String username = "validUser";
        String password = "validPassword";

        User validUser = new User(username, password, noteOverview);
        accounts.addUser(validUser);

        // Test if login valid for a valid user.
        assertTrue(accounts.checkValidUserLogin(username, password));

        // Test login valid for invalid password.
        assertFalse(accounts.checkValidUserLogin(username, "invalidPassword"));

        // Test login valid for nonexistent user.
        assertFalse(accounts.checkValidUserLogin("invalidUser", password));
    }


    

    
}
