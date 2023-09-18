package json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import core.NoteOverview;
import json.internal.NoteOverviewModule;

public class NotesPersistence {
    
    private ObjectMapper mapper = new ObjectMapper().registerModule(new NoteOverviewModule());

    public void writeNoteOverview(NoteOverview noteOverview) {
        try {
            mapper.writeValue(new File("src/main/resources/noteOverview.json"), noteOverview);
        } catch (IOException e) {
            System.out.println("Failed to write to file.");
            e.printStackTrace();
        }
    }

    public NoteOverview readNoteOverview() {
        NoteOverview noteOverview;
        try {
            noteOverview = mapper.readValue(new File("src/main/resources/noteOverview.json"), NoteOverview.class);
        } catch (IOException e) {
            System.out.println("Failed to read from file.");
            e.printStackTrace();
            return null;
        }
        return noteOverview;
    }


    public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
    }


}
