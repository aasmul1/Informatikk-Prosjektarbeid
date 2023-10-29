package dataaccess;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import core.Accounts;
import core.Note;
import core.User;

public interface NotesAccess {


	/**
   * Gets all the accounts registred to use Notes.
   *
   * @return all the users
   * @throws IOException if not found
   */
  
  public Accounts readAccounts() throws IOException;

  /**
   * Get a specific user by username.
   *
   * @param username of the user to get
   * @return the user
   */
  public User readUser(String username);


  /**
   * Method to log in as a regular user.
   *
   * @param username of the user
   * @param password of the user
   * @return the user
   */
  public User userLogin(String username, String password);


  /**
   * Creates a new user and adds it to Accounts.
   *
   * @param user the user to create
   */
  public void createUser(User user);

 

    
  public void uploadFile(File file) throws IOException, InterruptedException, URISyntaxException;  
  
  public Note getUserNote(String title, String username);

  public User getLoggedInUser();
}
