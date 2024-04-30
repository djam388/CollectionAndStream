
import java.util.HashMap;
import java.util.Map;

/**
 * Класс для реализации домашнего задания номер три, часть 1.
 */
public class Homework3_1 {

    /**
     * Реализовать метод который считает количество слов встречающихся в заданном тексте.
     * @param text - заданный текст
     * @return - словарь слов и количество их появлений в данном тексте
     */
    public Map<String,Integer> countWords(String text){

        String cleanedTextFromPunctuation = text.replaceAll("[^а-яА-Яa-zA-Z\\s]", " ");

        String trimmedText = cleanedTextFromPunctuation.trim();


        String[] words = trimmedText.split("\\s+");


        Map<String, Integer> wordFrequencies = new HashMap<>();


        for (String word : words) {
            if (word.equals("а")) {
                System.out.println("found letter 'а'");
            }
            wordFrequencies.put(word.toLowerCase(), wordFrequencies.getOrDefault(word, 0) + 1);
        }


        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        //return Map.of();
        return wordFrequencies;

    }
}
