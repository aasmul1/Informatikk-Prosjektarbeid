package core;

public class User {
    private String username;
    private String password;
    private NoteOverview noteOverview;
    
    public User(String username, String password, NoteOverview noteOverview) {
        this.username = username;
        this.password = password;
        this.noteOverview = new NoteOverview();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        UserValidation.checkValidUsername(username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        UserValidation.checkValidPassword(password);
        this.password = password;
    }
}
