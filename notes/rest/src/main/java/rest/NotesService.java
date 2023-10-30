package rest;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;

import core.Accounts;
import core.Note;
import core.NoteOverview;
import core.User;
import json.AccountsPersistence;

@Service
public class NotesService {

    private Accounts accounts;
    private static final AccountsPersistence PERSISTENCE = new AccountsPersistence();
    private Path fileLocation;


    public NotesService(Accounts accounts) {
        this.accounts = accounts;
        PERSISTENCE.setFilePath("springbootserver-notes.json");
        try {
            Accounts acc = new Accounts();
            accounts = acc;
            acc.addUser(new User("olav", "passord", new NoteOverview()));
            PERSISTENCE.saveAccounts(acc);
            accounts = PERSISTENCE.loadAccounts();
        } catch (StreamWriteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DatabindException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      }
      
      @Autowired
      public NotesService() {
          this(manuallyCreateAccounts());
      }

    private static Accounts manuallyCreateAccounts() {
        Accounts acc = new Accounts();
        NoteOverview noteOverview = new NoteOverview();
        noteOverview.addNote(new Note("title", "text"));
        acc.addUser(new User("olav", "passord1", noteOverview));
        return acc;
      }


    public Accounts getAccounts() {
        return accounts;
    }
    
    public boolean userLogin(String username, String password) {
        return accounts.checkValidUserLogin(username, password);
    }

    public User getUserByUsername(String username) {
        return accounts.getUser(username);
    }


    
}
