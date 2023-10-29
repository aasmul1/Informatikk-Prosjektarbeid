package core;

import org.junit.jupiter.api.BeforeEach;

public class TitleComparatorTest {

    private Note noteA;
    private Note noteB;
    private Note noteC;

    // Create an instance of your comparator
    private TitleComparator comparator;

    @BeforeEach
    public void setUp() {
        noteA = new Note("A", "Text to A");
        noteB = new Note("B", "Text to B");
        noteC = new Note("C", "Text to C");

        comparator = new TitleComparator();
    }
    
}
