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

    public User getLoggedInUser();

    public void addNote(Note note);

    public void updateNote();

    public NoteOverview getUserNoteOverview();

    public void setNoteToEdit(Note noteToEdit);

    public Note getNoteToEdit();

    public void deleteNote(int index);

    public void sortNotesByCreatedDate();

    public void sortNotesByTitle();

    public void sortNotesByLastEditedDate();
}
