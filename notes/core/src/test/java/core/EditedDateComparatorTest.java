package core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class EditedDateComparatorTest {
    
     LocalDate today = LocalDate.now();
    LocalDate yesterday = today.minusDays(1);
    LocalDate dayBeforeYesterday = today.minusDays(2);

    Note earlierNote = new Note("Earlier Note", "This note was edited earlier.", dayBeforeYesterday, yesterday);
    Note laterNote = new Note("Later Note", "This note was edited today.", dayBeforeYesterday, today);

    // Create an instance of your comparator
    EditedDateComparator comparator = new EditedDateComparator();

}
