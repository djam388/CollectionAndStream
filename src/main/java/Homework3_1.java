
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        Map<String, Integer> wordFrequencies = new HashMap<>();
        String regex = "[\\{А-Яа-яA-Za-z\\}]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
//            if (matcher.group(0).toLowerCase().equals("а")) {
//                System.out.println("Full match: " + matcher.group(0));
//            }
//            if (wordFrequencies.containsKey(matcher.group(0).toLowerCase())){
//                int mapVal = wordFrequencies.get(matcher.group(0).toLowerCase());
//                mapVal++;
//                wordFrequencies.put(matcher.group(0).toLowerCase(), mapVal);
//            } else {
//                wordFrequencies.put(matcher.group(0).toLowerCase(), 1);
//            }
            wordFrequencies.put(matcher.group(0).toLowerCase(), wordFrequencies.getOrDefault(matcher.group(0).toLowerCase(), 0) + 1);
        }







//        for (String word : words) {
//            if (word.equals("а")) {
//                System.out.println("found letter 'а'");
//            }
//            wordFrequencies.put(word.toLowerCase(), wordFrequencies.getOrDefault(word, 0) + 1);
//        }


        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        return wordFrequencies;

    }
}
