import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

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

    @Test
    void isValidUrinal_validString_onlyZero() {
        String onlyZero = "0";
        assertTrue(urinals.isValidUrinal(onlyZero));
        System.out.println("====== Rhishabh Hattarki == TEST EIGHT EXECUTED =======");
    }

    @Test
    void isValidUrinal_invalidString_randomCharacters() {
        String random = "adfewf";
        assertFalse(urinals.isValidUrinal(random));
        System.out.println("====== Rhishabh Hattarki == TEST NINE EXECUTED =======");
    }

    @Test
    void countFreeUrinals_5Zeros() {
        String fiveZeros = "00000";
        assertEquals(3, urinals.countFreeUrinals(fiveZeros));
        System.out.println("====== Rhishabh Hattarki == TEST TEN EXECUTED =======");
    }

    @Test
    void countFreeUrinals_4Zeros() {
        String fourZeros = "0000";
        assertEquals(2, urinals.countFreeUrinals(fourZeros));
        System.out.println("====== Rhishabh Hattarki == TEST ELEVEN EXECUTED =======");
    }

    @Test
    void countFreeUrinals_3ZerosBetween1s() {
        String three0sBetween1s = "10001";
        assertEquals(1, urinals.countFreeUrinals(three0sBetween1s));
        System.out.println("====== Rhishabh Hattarki == TEST TWELVE EXECUTED =======");
    }

    @Test
    void countFreeUrinals_2ZerosBetween1s() {
        String two0sBetween1s = "1001";
        assertEquals(0, urinals.countFreeUrinals(two0sBetween1s));
        System.out.println("====== Rhishabh Hattarki == TEST THIRTEEN EXECUTED =======");
    }

    @Test
    void countFreeUrinals_3ZerosAfter01() {
        String three0sAfter01 = "01000";
        assertEquals(1, urinals.countFreeUrinals(three0sAfter01));
        System.out.println("====== Rhishabh Hattarki == TEST FOURTEEN EXECUTED =======");
    }

    @Test
    void countFreeUrinals_invalid_0One1() {
        String zero11 = "011";
        assertEquals(-1, urinals.countFreeUrinals(zero11));
        System.out.println("====== Rhishabh Hattarki == TEST FIFTEEN EXECUTED =======");
    }

    @Test
    void countFreeUrinals_invalid_randomCharacters() {
        String random = "01234";
        assertEquals(-1, urinals.countFreeUrinals(random));
        System.out.println("====== Rhishabh Hattarki == TEST SIXTEEN EXECUTED =======");
    }

    @Test
    void countFreeUrinals_onlyZero() {
        String zero = "0";
        assertEquals(1, urinals.countFreeUrinals(zero));
        System.out.println("====== Rhishabh Hattarki == TEST SEVENTEEN EXECUTED =======");
    }

    @Test
    void countFreeUrinals_alternate0s1s() {
        String alternate = "01010";
        assertEquals(0, urinals.countFreeUrinals(alternate));
        System.out.println("====== Rhishabh Hattarki == TEST EIGHTEEN EXECUTED =======");
    }

    @Test
    void readUrinalsFrom_fileDoesNotExist() {
        String fileName = "urinal.dat";
        assertThrows(IOException.class, () -> urinals.readUrinalsFrom(fileName));
        System.out.println("====== Rhishabh Hattarki == TEST NINETEEN EXECUTED =======");
    }

    @Test
    void readUrinalsFrom_readsCorrectly() throws IOException {
        String filePath = "src/test/resources/input/urinal.dat";
        List<String> urinalList = List.of("10001", "1001");
        assertEquals(urinalList, urinals.readUrinalsFrom(filePath));
        System.out.println("====== Rhishabh Hattarki == TEST TWENTY EXECUTED =======");
    }

    @Test
    void readUrinalsFrom_readsCorrectly_endsWithMinus1() throws IOException {
        String filePath = "src/test/resources/input/urinal-1.dat";
        List<String> urinalList = List.of("10001", "1001");
        assertEquals(urinalList, urinals.readUrinalsFrom(filePath));
        System.out.println("====== Rhishabh Hattarki == TEST TWENTY ONE EXECUTED =======");
    }

}