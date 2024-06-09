package DStructers_algorithms;
import java.util.*;

public class week5_t1 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Input
            int N = scanner.nextInt(); // Number of words
            int K = scanner.nextInt(); // Number of symbols in text

            scanner.nextLine();
            String[] words = scanner.nextLine().split(" "); // Words in the dictionary
            String text = scanner.nextLine(); // Corrupted text

            Set<String> wordSet = new HashSet<>(Arrays.asList(words));

            int[] prevValidWordIndex = new int[K + 1];

            Arrays.fill(prevValidWordIndex, -1);

            prevValidWordIndex[0] = 0;

            for (int i = 0; i <= K; i++) {
                if (prevValidWordIndex[i] != -1) {
                    for (int j = 0; j< words.length; j++) {
                        int end = i + words[j].length();
                        if (end <= K && text.substring(i, end).equals(words[j])) {
                            prevValidWordIndex[end] = i;
                            System.out.println(i + " " + end);
                        }//После прохода по всему тексту массив
                        // prevValidWordIndex содержит информацию о том, где заканчиваются слова в тексте.
                    }
                }
            }

            // reconstruct
            StringBuilder reconstructedText = new StringBuilder();
            int index = K;
            while (index > 0) {
                int prevIndex = prevValidWordIndex[index];
                reconstructedText.insert(0, text.substring(prevIndex, index) + " ");
                index = prevIndex;
            }

            // Output
            System.out.println(reconstructedText.toString().trim());
        }
    }

