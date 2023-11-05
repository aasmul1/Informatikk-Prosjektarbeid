package dataaccess;

import java.io.IOException;
import core.Accounts;
import core.Note;
import core.NoteOverview;
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

    /**
     * Gets the logged in user.
     * 
     * @return logged in user
     */
    public User getLoggedInUser();

    /**
     * Adds a new note to the logged in user
     */
    public void addNote(Note note);

    /**
     * 
     * 
     * @param username
     */
    public void updateNotes(String username);

    /**
     * Gets the noteoverview of the logged in user
     * 
     * @return noteoverview
     */
    public NoteOverview getUserNoteOverview();

    /**
     * Deletes note of the logged in user
     * 
     * @param index of the note
     */
    public void deleteNote(int index);

    /**
     * Sorts notes by created date
     */
    public void sortNotesByCreatedDate();

    /**
     * Sorts notes by title
     */
    public void sortNotesByTitle();

    /**
     * Sorts notes by edited date
     */
    public void sortNotesByLastEditedDate();

    /**
     * Gets note by username and index
     * 
     * @param username
     * @param index
     * @return
     */
    public Note getNote(String username, int index);

    /**
     * Sets selected note index
     * 
     * @param index
     */
    public void setSelectedIndex(int index);
    
    public int getSelectedIndex();
}
