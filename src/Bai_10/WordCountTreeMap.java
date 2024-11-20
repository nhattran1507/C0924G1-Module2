package Bai_10;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCountTreeMap {

    public static void main(String[] args) {

        String input = getInputText();

        TreeMap<String, Integer> wordCountMap = countWordsAndSpecialChars(input);

        displayWordCount(wordCountMap);
    }


    private static String getInputText() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập văn bản:");
        return scanner.nextLine().toLowerCase();
    }


    private static TreeMap<String, Integer> countWordsAndSpecialChars(String input) {
        TreeMap<String, Integer> wordCountMap = new TreeMap<>();
        StringBuilder wordBuilder = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                wordBuilder.append(c);
            } else if (Character.isWhitespace(c)) {
                addWordToMap(wordBuilder.toString(), wordCountMap);
                wordBuilder.setLength(0);
            } else {
                addWordToMap(wordBuilder.toString(), wordCountMap);
                wordBuilder.setLength(0);

                String specialChar = String.valueOf(c);
                wordCountMap.put(specialChar, wordCountMap.getOrDefault(specialChar, 0) + 1);
            }
        }


        addWordToMap(wordBuilder.toString(), wordCountMap);

        return wordCountMap;
    }


    private static void addWordToMap(String word, TreeMap<String, Integer> wordCountMap) {
        if (!word.isEmpty()) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
    }


    private static void displayWordCount(TreeMap<String, Integer> wordCountMap) {
        System.out.println("Số lần xuất hiện của từ và ký tự đặc biệt:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
