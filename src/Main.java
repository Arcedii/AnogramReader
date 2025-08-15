import java.util.LinkedHashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // calea relativă către fișier
        String inputFile = "sample.txt";

        // Păstrăm ordinea grupurilor după prima apariție
        Map<String, List<String>> anagramGroups = new LinkedHashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(Path.of(inputFile), StandardCharsets.UTF_8)) {
            String word;
            while ((word = reader.readLine()) != null) {
                word = word.trim();
                if (word.isEmpty()) continue;

                // Grupăm fără a ține cont de registru, afișăm ortografia inițială
                String sortedKey = sortWordLowercased(word);
                anagramGroups.computeIfAbsent(sortedKey, k -> new ArrayList<>()).add(word);
            }
        } catch (IOException e) {
            System.err.println("Read Error: " + e.getMessage());
            System.err.println("Path: " + Path.of(inputFile).toAbsolutePath());
            System.exit(2);
        }

        // sortăm cuvintele din fiecare grup (fără a ține cont de majuscule și minuscule)
        for (List<String> group : anagramGroups.values()) {
            group.sort(String::compareToIgnoreCase);
            System.out.println(String.join(" ", group));
        }
    }

    // Convertim la litere mici și sortăm caracterele
    private static String sortWordLowercased(String word) {
        char[] chars = word.toLowerCase(Locale.ROOT).toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
