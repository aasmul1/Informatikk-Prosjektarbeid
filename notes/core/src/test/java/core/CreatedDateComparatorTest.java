package core;

import java.time.LocalDate;

public class CreatedDateComparatorTest {

    LocalDate today = LocalDate.now();
    LocalDate yesterday = today.minusDays(1);
    LocalDate dayBeforeYesterday = today.minusDays(2);

    Note earlierCreatedNote = new Note("Earlier Created Note", "This note was created earlier.", dayBeforeYesterday, yesterday);
    Note laterCreatedNote = new Note("Later Created Note", "This note was created today.", yesterday, today);

    // Create an instance of your comparator
    CreatedDateComparator comparator = new CreatedDateComparator();
    


}
