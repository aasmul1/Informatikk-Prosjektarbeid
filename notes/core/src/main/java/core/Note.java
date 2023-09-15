package core;

import java.time.LocalDate;

public class Note {
    private String title;
    private String text;
    private LocalDate date;
    
    public Note(String title, String text) {
        this.title = title;
        this.text = text;
        this.date = LocalDate.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }
    
    public void updateDate() {
        this.date = LocalDate.now();
    }    
}
