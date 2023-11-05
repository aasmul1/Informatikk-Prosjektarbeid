package dataaccess;

import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;

import core.Accounts;
import core.Note;
import core.NoteOverview;
import core.User;
import json.AccountsPersistence;

public class LocalNotesAccess implements NotesAccess {

    private Accounts accounts;
    private User user;
    private final AccountsPersistence persistence = new AccountsPersistence();

    /**
     * Loads accounts from json-file.
     */
    public LocalNotesAccess() {
        persistence.setFilePath("Accounts.json");
        try {
          this.accounts = persistence.loadAccounts();
        } catch (IllegalStateException | IOException e) {
          this.accounts = new Accounts();
          try {
            persistence.saveAccounts(accounts);
          } catch (IllegalStateException | IOException e1) {
            System.out.println(e1.getMessage());
          }
        }
    }

    @Override
    public void createUser(User user) {
        if (user != null) {
            accounts.addUser(user);
            update();
        }
    }

    @Override
    public Accounts readAccounts() throws IOException {
        return persistence.loadAccounts();
    }

    @Override
    public User userLogin(String username, String password) {
        this.user = accounts.getUser(username, password);
        return user;

    }

    @Override
    public User getLoggedInUser() {
        if (user == null)
            throw new IllegalArgumentException("User not logged in"); // TODO: user not logged inn error
        return this.user;
    }

    @Override
    public void addNote(Note note) {
        getLoggedInUser().addNote(note);
        update();
    }

    @Override
    public void updateNotes(String username) {
        update();
    }

    public void update() {
        try {
            persistence.saveAccounts(accounts);
        } catch (StreamWriteException e) {
            // TODO: error
        } catch (DatabindException e) {
            // TODO: error
        } catch (IOException e) {
            // TODO: error
        }
    }

    @Override
    public NoteOverview getUserNoteOverview() {
        return getLoggedInUser().getNoteOverview();
    }

    @Override
    public void deleteNote(int index) {
        getUserNoteOverview().deleteNote(index);
        update();
    }

    @Override
    public void sortNotesByCreatedDate() {
        getUserNoteOverview().sortNotesByCreatedDate();
        update();
    }

    @Override
    public void sortNotesByTitle() {
        getUserNoteOverview().sortNotesByTitle();
        update();
    }

    @Override
    public void sortNotesByLastEditedDate() {
        getUserNoteOverview().sortNotesByLastEditedDate();
        update();
    }

    @Override
    public Note getNote(String username, int index) {
        return user.getNoteByIndex(index);
    }

    @Override
    public void setSelectedIndex(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSelectedIndex'");
    }

    @Override
    public int getSelectedIndex() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSelectedIndex'");
    }
}
