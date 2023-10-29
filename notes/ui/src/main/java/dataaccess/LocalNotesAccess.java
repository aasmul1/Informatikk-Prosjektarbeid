package dataaccess;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import core.Accounts;
import core.Note;
import core.User;
import json.NotesPersistence;

public class LocalNotesAccess implements NotesAccess{

    private Accounts accounts;
    private User user = new User(null, null, null);
    private File test;
    private final NotesPersistence persistence = new NotesPersistence(test);

    /**
   * Loads accounts from json-file.
   */
    public LocalNotesAccess(){
        // persistence.setFilePath("Accounts.json");
        try {
            // this.accounts = persistence.initializeStorage();
        } catch (IllegalStateException e) {
            this.accounts = new Accounts();
            try {
                // persistence.saveAccounts(accounts);
            } catch (IllegalStateException e1) {
                System.out.println(e1.getMessage());
        }
    }
    }
    
    

    @Override
    public void createUser(User user) {
        if (user != null) {
            accounts.addUser(user);
          }
          try {
            // persistence.saveAccounts(accounts);
          } catch (IllegalStateException e) {
            e.printStackTrace();
          }
    }

    @Override
    public Accounts readAccounts() throws IOException {
        persistence.readNoteOverview();
        return accounts; // må fikse
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'uploadFile'");
    }

    @Override
    public Note getUserNote(String title, String username) {
        User user = accounts.getUser(username);
        for (Note note : user.getNoteOverview()) {
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
