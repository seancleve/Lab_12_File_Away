import javax.swing.*;
import java.io.*;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser("src");
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    lineCount++;
                    wordCount += line.split("\\s+").length;
                    charCount += line.length();
                }

                // Summary report
                System.out.println("\n--- Summary Report ---");
                System.out.println("File Name: " + file.getName());
                System.out.println("Number of Lines: " + lineCount);
                System.out.println("Number of Words: " + wordCount);
                System.out.println("Number of Characters: " + charCount);
            } catch (IOException e) {
                System.out.println("An error occurred while reading the file.");
                e.printStackTrace();
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}
