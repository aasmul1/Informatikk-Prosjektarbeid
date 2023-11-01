package dataaccess;

import java.io.IOException;

import core.Accounts;
import core.Note;
import core.NoteOverview;
import core.User;

public class RemoteNotesAccess implements NotesAccess {

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
    public User userLogin(String username, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userLogin'");
    }

    @Override
    public User getLoggedInUser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLoggedInUser'");
    }

    @Override
    public void addNote(Note note) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addNote'");
    }

    @Override
    public void updateNote() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateNote'");
    }

    @Override
    public NoteOverview getUserNoteOverview() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsersNoteOverview'");
    }

    @Override
    public void setNoteToEdit(Note noteToEdit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNoteToEdit'");
    }

    @Override
    public Note getNoteToEdit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNoteToEdit'");
    }

    @Override
    public void deleteNote(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteNote'");
    }

    @Override
    public void sortNotesByCreatedDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sortNotesByCreatedDate'");
    }

    @Override
    public void sortNotesByTitle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sortNotesByTitle'");
    }

    @Override
    public void sortNotesByLastEditedDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sortNotesByLastEditedDate'");
    }

}
