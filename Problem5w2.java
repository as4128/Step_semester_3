import java.util.*;

public class Problem5w2 {

    static void printFilteredWordFrequency(String feedback) {

        // Convert to lowercase
        feedback = feedback.toLowerCase();

        // Remove punctuation
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        // Split into words
        String[] words = feedback.split("\\s+");

        // Stop words
        HashSet<String> stopWords = new HashSet<>();

        stopWords.add("the");
        stopWords.add("was");
        stopWords.add("and");
        stopWords.add("a");
        stopWords.add("is");
        stopWords.add("of");
        stopWords.add("in");

        // Frequency map
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            if (stopWords.contains(word)) {
                continue;
            }

            frequency.put(
                word,
                frequency.getOrDefault(word, 0) + 1
            );
        }

        // Convert map entries to list
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(frequency.entrySet());

        // Sort by count in descending order
        Collections.sort(list,
            (entry1, entry2) ->
                entry2.getValue() - entry1.getValue()
        );

        // Print result
        for (Map.Entry<String, Integer> entry : list) {

            System.out.println(
                entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter feedback paragraph:");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);

        sc.close();
    }
}