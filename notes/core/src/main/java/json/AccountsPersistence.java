package json;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import core.Accounts;
import core.NoteOverview;
import core.User;
import json.internal.AccountsModule;

public class AccountsPersistence {
    
    private ObjectMapper mapper = new ObjectMapper().registerModule(new AccountsModule());
    private final File storageFile;
    private final File exampleFile = new File("src/main/resources/example_noteOverview.json");
    

    public AccountsPersistence(File storageFile) {
        this.storageFile = storageFile;
        initializeStorage();
    }

    public void initializeStorage() {
        if (!storageFile.exists()) {
            try {
                Files.copy(exampleFile.toPath(), storageFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Initialized storage file with example data.");
            } catch (IOException e) {
                System.out.println("Failed to initialize storage file.");
                e.printStackTrace();
            }
        }
    }

    public void writeAccounts(Accounts accounts) {
        try {
            mapper.writeValue(storageFile, accounts);
        } catch (IOException e) {
            System.out.println("Failed to write to file.");
            e.printStackTrace();
        }
    }

    public Accounts readAccounts() {
        Accounts accounts;
        try {
            accounts = mapper.readValue(new File("src/main/resources/noteOverview.json"), Accounts.class);
        } 
        catch (MismatchedInputException x) {
            Accounts newAccounts = new Accounts();
            writeAccounts(newAccounts);
            System.out.println("File was empty, added new NoteOverview");
            return newAccounts;
        }
        catch (IOException e) {
            System.out.println("Failed to read from file.");
            e.printStackTrace();
            return null;
        }
        return accounts;
    }
    // public void writeNoteOverview(NoteOverview noteOverview) {
    //     try {
    //         mapper.writeValue(storageFile, noteOverview);
    //     } catch (IOException e) {
    //         System.out.println("Failed to write to file.");
    //         e.printStackTrace();
    //     }
    // }

    // public NoteOverview readNoteOverview() {
    //     NoteOverview noteOverview;
    //     try {
    //         noteOverview = mapper.readValue(new File("src/main/resources/noteOverview.json"), NoteOverview.class);
    //     } 
    //     catch (MismatchedInputException x) {
    //         NoteOverview newNoteOverview = new NoteOverview();
    //         writeNoteOverview(newNoteOverview);
    //         System.out.println("File was empty, added new NoteOverview");
    //         return newNoteOverview;
    //     }
    //     catch (IOException e) {
    //         System.out.println("Failed to read from file.");
    //         e.printStackTrace();
    //         return null;
    //     }
    //     return noteOverview;
    // }
}
