import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    @org.junit.jupiter.api.Test
    void isValidUrinal_validString_noOnes() {
        Urinals urinals = new Urinals();
        String noOnes = "0000";
        assertTrue(urinals.isValidUrinal(noOnes));
    }
}