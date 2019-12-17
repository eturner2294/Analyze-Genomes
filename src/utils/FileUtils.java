package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    /**
     * Open a file given the path
     *
     * @param fileName the path of the file to open
     * @return the file
     */
    public static File openFile(String fileName) {
        File file = new File(fileName);

        //Return empty if file exists
        if (!file.exists()) {
            return null;
        }

        return file;
    }

    /**
     * Get a string from a given file.
     *
     * @param fileName the path of the file to get the string from
     * @return a string of the contents on the file.
     */
    public static String getStringFromTextFile(String fileName) {
        File file = openFile(fileName);

        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                sb.append(currentLine);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return sb.toString();
    }

    /**
     * Open multiple files given the path in a list
     * @param fileNames List of files to open
     * @return a list of files
     */
    public static List<File> openMultipleFiles(List<String> fileNames){
        List<File> files = new ArrayList<>();

        for(String fileName : fileNames){
            openFile(fileName);
        }

        return files;
    }

    /**
     * Open multiple files from an array of paths
     * @param fileNames An array of strings being the filenames
     * @return a list of files.
     */
    public static List<File> openMultipleFiles(String[] fileNames){
        List<File> files = new ArrayList<>();

        for(String fileName : fileNames){
            files.add(openFile(fileName));
        }

        return files;
    }
}
