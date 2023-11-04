package rest;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.Accounts;
import core.Note;
import core.NoteOverview;
import core.User;
import json.AccountsPersistence;
import rest.exceptions.FileException;
import rest.exceptions.UserNotFoundException;

@Service
public class NotesService {

    private Accounts accounts;
    private static final AccountsPersistence PERSISTENCE = new AccountsPersistence();
    // private Path fileLocation;

    public NotesService(Accounts accounts) {
        // TODO: get saved users in json
        this.accounts = accounts;
        PERSISTENCE.setFilePath("springbootserver-notes.json");
    }

    @Autowired
    public NotesService() {
        this(manuallyCreateAccounts());
        save();
    }

    public AccountsPersistence getPersistence() {
        return PERSISTENCE;
    }

    private static Accounts manuallyCreateAccounts() {
        Accounts acc = new Accounts();
        // For testing
        NoteOverview noteOverview = new NoteOverview();
        NoteOverview noteOverview2 = new NoteOverview();
        noteOverview.addNote(new Note("title", "text"));
        noteOverview2.addNote(new Note("title", "text"));
        noteOverview.addNote(new Note("title2", "text2"));
        noteOverview2.addNote(new Note("title2", "text2"));
        acc.addUser(new User("userone", "Password1", noteOverview));
        acc.addUser(new User("usertwo", "Password2", noteOverview2));
        return acc;
    }

    public Accounts getAccounts() {
        return accounts;
    }

    public boolean validLogin(String username, String password) {
        return accounts.checkValidUserLogin(username, password);
    }

    public User getUserByUsername(String username) {
        if (accounts.getUser(username) == null) {
            throw new UserNotFoundException();
        }
        return accounts.getUser(username);
    }

    public NoteOverview getNoteOverviewByUsername(String username) {
        if (accounts.getUser(username) == null) {
            throw new UserNotFoundException();
        }
        return accounts.getUser(username).getNoteOverview();
    }

    protected void save() {
        try {
            PERSISTENCE.saveAccounts(accounts);
        } catch (IOException e) {
            throw new FileException();
        }
    }

    public Note updateNote(Note note) {
        save();
        return note;
    }

    public void addNote(String username, Note note) {
        getUserByUsername(username).addNote(note);
        save();
    }

    public void createUser(User user) {
        accounts.addUser(user);
        save();
    }

    public NoteOverview getUserNoteOverview(String username) {
        return getUserByUsername(username).getNoteOverview();
    }

    public void deleteNote(String username, int index) {
        getUserByUsername(username).getNoteOverview().deleteNote(index);
        save();
    }

    public User getUser(String username, String password) {
        return accounts.getUser(username, password);
    }

    public void sortNotesByCreatedDate(String username) {
        getNoteOverviewByUsername(username).sortNotesByCreatedDate();
        save();
    }

    public void sortNotesByLastEditedDate(String username) {
        getNoteOverviewByUsername(username).sortNotesByLastEditedDate();
        save();
    }

    public void sortNotesByTitle(String username) {
        getNoteOverviewByUsername(username).sortNotesByTitle();
        save();
    }
}
