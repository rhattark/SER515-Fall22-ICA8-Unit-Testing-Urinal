import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

        if (!(urinal.charAt(0) == '0' || urinal.charAt(0) == '1')) {
            return false;
        }

        for (int i = 1; i < uLen; i++) {
            char cur = urinal.charAt(i);
            char prev = urinal.charAt(i-1);

            if (!(cur == '0' || cur == '1')) {
                return false;
            }

            if (cur == '1' && prev == '1') {
                return false;
            }
        }

        return true;
    }

    public int countFreeUrinals(String urinal) {
        if (!isValidUrinal(urinal)) {
            return -1;
        }

        int count = 0;
        char[] urinals = urinal.toCharArray();
        int uLen = urinals.length;

        for (int i = 0; i < uLen; i++) {
            char cur = urinals[i];

            if (cur == '1' ||
                    (i > 0 && urinals[i-1] == '1') ||
                    (i < uLen - 1 && urinals[i+1] == '1')) {
                continue;
            }

            urinals[i] = '1';
            count++;
        }

        return count;
    }

    public List<String> readUrinalsFrom(String path) throws IOException {
        List<String> urinalList = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();

            while (line != null) {
                if (line.equals("-1")) {
                    break;
                }

                urinalList.add(line);
                line = reader.readLine();
            }
        }

        return urinalList;
    }

    public void writeResultsTo(String path, List<Integer> results) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (int result : results) {
                writer.append(String.valueOf(result) + "\n");
            }
        }
    }

    public void deleteContentsOfDirectory(File directory) {
        File[] filesInDirectory = directory.listFiles();

        if (filesInDirectory != null) {
            for (File file : filesInDirectory) {
                if (file.isDirectory()) {
                    deleteContentsOfDirectory(file);
                }
                file.delete();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("basic structure");
    }
}
