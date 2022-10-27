/**
 * This class is used to track the urinals that are occupied.
 * Main goal is to calculate the number of vacant urinals considering the
 * previously occupied urinals and the unwritten urinal rule.
 *
 * @author Rhishabh Suhas Hattarki - rhattark
 */
public class Urinals {

    public boolean isValidUrinal(String urinal) {
        int uLen = urinal.length();

        if (uLen < 1 || uLen > 20) {
            return false;
        }

        for (int i = 1; i < uLen; i++) {
            char cur = urinal.charAt(i);
            char prev = urinal.charAt(i-1);

            if (cur == '1' && prev == '1') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("basic structure");
    }
}
