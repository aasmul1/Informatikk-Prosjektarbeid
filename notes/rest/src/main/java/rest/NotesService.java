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

@Service
public class NotesService {

  private Accounts accounts;
  private static final AccountsPersistence PERSISTENCE = new AccountsPersistence();
  // private Path fileLocation;

  public NotesService(Accounts accounts) {
    this.accounts = accounts;
    PERSISTENCE.setFilePath("springbootserver-notes.json");
    save();
  }

  @Autowired
  public NotesService() {
    PERSISTENCE.setFilePath("springbootserver-notes.json");
    try {
      this.accounts = loadAccounts();
    } catch (Exception e) {
      this.accounts = manuallyCreateAccounts();
      save();
    }
  }

  public void setTestMode() {
    PERSISTENCE.setFilePath("springbootserver-test.json");
    this.accounts = createTestAccounts();
    save();
    loadAccounts();
  }

  public void setNormalMode() {
    PERSISTENCE.setFilePath("springbootserver-notes.json");
    this.accounts = loadAccounts();
    save();
  }

  public Accounts createTestAccounts() {
    NoteOverview noteOverview = new NoteOverview();
    NoteOverview noteOverview2 = new NoteOverview();
    Accounts accounts = new Accounts();

    noteOverview.addNote(new Note("title", "text"));
    noteOverview2.addNote(new Note("title", "text"));
    noteOverview.addNote(new Note("title2", "text2"));
    noteOverview2.addNote(new Note("title2", "text2"));
    accounts.addUser(new User("testuserone", "Password1", noteOverview));
    accounts.addUser(new User("testusertwo", "Password2", noteOverview2));
    return accounts;
  }

  public AccountsPersistence getPersistence() {
    return PERSISTENCE;
  }

  private static Accounts loadAccounts() {
    try {
      return PERSISTENCE.loadAccounts();
    } catch (Exception e) {
      throw new FileException();
    }
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
    return accounts.getUser(username);
  }

  public NoteOverview getNoteOverviewByUsername(String username) {
    if (accounts.getUser(username) == null) {
      throw new IllegalArgumentException();
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

  public void updateNotes(String username) {
    save();
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
    NoteOverview noteOverview = getNoteOverviewByUsername(username);
    noteOverview.sortNotesByCreatedDate();
    save();
  }

  public void sortNotesByLastEditedDate(String username) {
    NoteOverview noteOverview = getNoteOverviewByUsername(username);
    noteOverview.sortNotesByLastEditedDate();
    save();
  }

  public void sortNotesByTitle(String username) {
    NoteOverview noteOverview = getNoteOverviewByUsername(username);
    noteOverview.sortNotesByTitle();
    save();
  }

  public Note getNote(String username, int index) {
    return getUserByUsername(username).getNoteByIndex(index);
  }
}
