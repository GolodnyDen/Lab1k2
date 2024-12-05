import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "C:/Users/User/Desktop/Lab1k2/Lab6/info.txt";
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        Map<String, Integer> wordCountMap = new HashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().toLowerCase();
            String[] words = line.split("\\W+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }
        }

        scanner.close();

        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCountMap.entrySet());

        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        System.out.println("Топ-10 самых часто встречающихся слов:");
        for (int i = 0; i < Math.min(10, list.size()); i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " - " + entry.getValue());
        }
    }
}

