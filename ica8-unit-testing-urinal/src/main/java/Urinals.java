import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to track the urinals that are occupied.
 * Main goal is to calculate the number of vacant urinals considering the
 * previously occupied urinals and the unwritten urinal rule.
 * Urinal Rule: 2 people cannot pee while being in adjacent urinals
 *
 * @author Rhishabh Suhas Hattarki - rhattark
 */
public class Urinals {

    /**
     * Check whether the given urinal encoded string is valid,
     * check for urinal rule,
     * check for any bad inputs - anything other than 1 or 0,
     * check for size of input string
     *
     * @param urinal encoded string where 1 represents occupied and 0 represents unoccupied urinal
     * @return boolean - whether urinal string is valid or not
     */
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

    /**
     * Count the number of free urinals in the encoded urinal string
     * It follows the urinal rule - 1 person cannot pee in a urinal that has another person
     * peeing in the adjacent urinal.
     *
     * @param urinal encoded string where 1 represents occupied and 0 represents unoccupied urinal
     * @return int - count of all free urinals in the encoded string
     */
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

    /**
     * Read all the encoded urinal strings from the file at the given path and return
     * the list of the same.
     *
     * @param path this is the relative path of the file where urinal data is located
     * @return List of all the encoded urinal strings read from the file at the given path
     * @throws IOException if there are issues with reading a file
     */
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

    /**
     * Write the results obtained after computing the free urinals
     * based on the list passed. Each result will be printed on a separate line.
     * If the file already exists, a new file with the next version will be created.
     *
     * @param path destination relative path of the file where the results need to be stored
     * @param results list of all the integer results after computing count of free urinals
     * @throws IOException if there are issues with writing a file
     */
    public void writeResultsTo(String path, List<Integer> results) throws IOException {
        path = confirmPath(path);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (int result : results) {
                String nextLine = result + "\n";
                writer.append(nextLine);
            }
        }
    }

    /**
     * Find whether the current path/filename is okay to use. If this file already exists,
     * a new file with the latest version needs to be created. This will return the latest
     * potential path with the correct version number.
     *
     * @param path destination relative path of the file where the results need to be stored
     * @return String - confirmed path with the latest version
     */
    private String confirmPath(String path) {
        File file = new File(path);
        int count = 1;
        String[] split = path.split("\\.");
        String fileName = split[0];
        String extension = split[1];

        while (file.exists()) {
            path = fileName + count + "." + extension;
            file = new File(path);
            count++;
        }

        return path;
    }

    /**
     * Deletes all the files in the given directory,
     * if it contains any directory, it deletes all the files within that recursively
     *
     * @param directory that needs to be cleared
     */
    public void deleteContentsOfDirectory(File directory) {
        File[] filesInDirectory = directory.listFiles();

        if (filesInDirectory != null) {
            for (File file : filesInDirectory) {
                if (file.isDirectory()) {
                    deleteContentsOfDirectory(file);
                }
                if (!file.delete()) {
                    break;
                }
            }
        }
    }

    /**
     * Reads the file from the input path,
     * parses it and retrieves the encoded urinal strings,
     * calculates the free urinals left in the string,
     * writes the results to the output path
     *
     * @param inputPath relative path of the input file
     * @param outputPath relative path of the output file
     * @throws IOException if there are issues with either read or write
     */
    public void readCountAndWrite(String inputPath, String outputPath) throws IOException {
        List<String> urinals = readUrinalsFrom(inputPath);
        List<Integer> allFreeUrinals = new ArrayList<>();

        for (String urinalRow : urinals) {
            int freeUrinals = countFreeUrinals(urinalRow);
            allFreeUrinals.add(freeUrinals);
        }

        writeResultsTo(outputPath, allFreeUrinals);
    }

    /**
     * Example usage of the class urinals.
     * Checkout the tests to understand all the functionalities in more detail.
     *
     * @param args arguments passed to main
     */
    public static void main(String[] args) {
        System.out.println("basic structure");
    }
}
