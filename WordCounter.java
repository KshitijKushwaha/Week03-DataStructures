import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class WordCounter {
    public static void main(String[] args) {
        String filePath = "C:\\java\\Practice\\Capgemini\\Week 3\\Linear and Binary Search\\long-doc.txt";
        String targetWord = "Lorem";
        int wordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        wordCount++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        System.out.println("The word \"" + targetWord + "\" appears " + wordCount + " times in the file.");
    }
}