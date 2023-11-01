package dataaccess;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import core.Accounts;
import core.Note;
import core.User;
import json.AccountsPersistence;

public class LocalNotesAccess implements NotesAccess{

    private Accounts accounts;
    private User user = new User(null, null, null);
    private File test;
    private final AccountsPersistence persistence = new AccountsPersistence();

    /**
   * Loads accounts from json-file.
   */
    public LocalNotesAccess(){
        persistence.setFilePath("Accounts.json");
        try {
            this.accounts = persistence.loadAccounts();
            if (this.accounts == null) {
                this.accounts = new Accounts();
            }
        } catch (IllegalArgumentException | IOException e) {
        }
    }
    
    @Override
    public void createUser(User user) {
        if (user != null) {
            accounts.addUser(user);
          }
          try {
            persistence.saveAccounts(accounts);;
          } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
          }
    }

    @Override
    public Accounts readAccounts() throws IOException {
        return persistence.loadAccounts();
    }

    @Override
    public User readUser(String username) {
        if (accounts.getUser(username) instanceof User) {
            return (User) accounts.getUser(username);
          }
          return  null;
    }

    @Override
    public User userLogin(String username, String password) {
        return accounts.getUser(username, password);
        
    }

    @Override
    public void uploadFile(File file) throws IOException, InterruptedException, URISyntaxException {
        throw new UnsupportedOperationException("Unimplemented method 'uploadFile'");
    }

    @Override
    public Note getUserNote(String title, String username) {
        User user = accounts.getUser(username);

        for (Note note : user.getNoteOverview().getNotes()) {
            if(note.getTitle().equals(title)){
                return note;
            }
        }
        return null;
    }

    @Override
    public User getLoggedInUser() {
        return this.user;
    }
}
