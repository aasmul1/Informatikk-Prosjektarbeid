package dataaccess;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import core.Accounts;
import core.Note;
import core.User;

public class RemoteNotesAccess implements NotesAccess{

    @Override
    public void createUser(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }

    @Override
    public Accounts readAccounts() throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readAccounts'");
    }

    @Override
    public User readUser(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readUser'");
    }

    @Override
    public User userLogin(String username, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userLogin'");
    }


    @Override
    public void uploadFile(File file) throws IOException, InterruptedException, URISyntaxException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'uploadFile'");
    }

    @Override
    public Note getUserNote(String title, String text) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserNote'");
    }

    @Override
    public User getLoggedInUser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLoggedInUser'");
    }
  
}
