import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    Urinals urinals;
    static int testCount;

    @BeforeEach
    void setupIndividual() {
        urinals = new Urinals();
    }

    @BeforeAll
    static void setupOverall() {
        testCount = 0;
    }

    @AfterEach
    void postTestIndividual() {
        System.out.println("====== Rhishabh Hattarki == TEST " + (++testCount) + " EXECUTED =======");
    }

    @Test
    void isValidUrinal_validString_noOnes() {
        String noOnes = "0000";
        assertTrue(urinals.isValidUrinal(noOnes));
    }
}