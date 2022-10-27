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

    @Test
    void isValidUrinal_validString_noOnes() {
        String noOnes = "0000";
        assertTrue(urinals.isValidUrinal(noOnes));
        System.out.println("====== Rhishabh Hattarki == TEST ONE EXECUTED =======");
    }

    @Test
    void isValidUrinal_invalidString_noZeros() {
        String noZeros = "1111";
        assertFalse(urinals.isValidUrinal(noZeros));
        System.out.println("====== Rhishabh Hattarki == TEST TWO EXECUTED =======");
    }
}