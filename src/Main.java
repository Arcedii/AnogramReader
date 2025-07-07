import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Путь к файлу относительно корня проекта
        String inputFile = "sample.txt";

        Map<String, List<String>> anagramGroups = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String word;
            while ((word = reader.readLine()) != null) {
                word = word.trim();
                if (!word.isEmpty()) {
                    String sortedWord = sortWord(word);
                    anagramGroups.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
                }
            }
        } catch (IOException e) {
            System.err.println("Read Error " + e.getMessage());
            System.err.println("Are you sure this file " + new File(inputFile).getAbsolutePath() + " existing ?");
            return;
        }


        for (List<String> group : anagramGroups.values()) {
            System.out.println(String.join(" ", group));
        }
    }

    private static String sortWord(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}