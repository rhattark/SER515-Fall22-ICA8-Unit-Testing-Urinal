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
    void isValidUrinal_validString_someOnes() {
        String someOnes = "0101";
        assertTrue(urinals.isValidUrinal(someOnes));
        System.out.println("====== Rhishabh Hattarki == TEST TWO EXECUTED =======");
    }

    @Test
    void isValidUrinal_invalidString_noZeros() {
        String noZeros = "1111";
        assertFalse(urinals.isValidUrinal(noZeros));
        System.out.println("====== Rhishabh Hattarki == TEST THREE EXECUTED =======");
    }

    @Test
    void isValidUrinal_invalidString_someOnes() {
        String someOnes = "0110";
        assertFalse(urinals.isValidUrinal(someOnes));
        System.out.println("====== Rhishabh Hattarki == TEST FOUR EXECUTED =======");
    }

    @Test
    void isValidUrinal_invalidString_Empty() {
        String empty = "";
        assertFalse(urinals.isValidUrinal(empty));
        System.out.println("====== Rhishabh Hattarki == TEST FIVE EXECUTED =======");
    }

    @Test
    void isValidUrinal_invalidString_TooLong() {
        String tooLong = "101010101010101010101";
        assertFalse(urinals.isValidUrinal(tooLong));
        System.out.println("====== Rhishabh Hattarki == TEST SIX EXECUTED =======");
    }

    @Test
    void isValidUrinal_validString_onlyOne() {
        String onlyOne = "1";
        assertTrue(urinals.isValidUrinal(onlyOne));
        System.out.println("====== Rhishabh Hattarki == TEST SEVEN EXECUTED =======");
    }
}