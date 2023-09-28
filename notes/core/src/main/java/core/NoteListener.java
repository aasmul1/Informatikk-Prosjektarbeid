package core;

import java.util.Collection;

public interface NoteListener {
    
    public void noteChanged(Collection<NoteListener> listeners, Note note);

}
