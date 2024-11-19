package Bai_10;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCountTreeMap {
    public static void main(String[] args) {
        // Tạo đối tượng Scanner để nhập văn bản từ người dùng
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập văn bản:");
        String input = scanner.nextLine();

        // Chuyển văn bản thành chữ thường và loại bỏ các ký tự đặc biệt
        input = input.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");

        // Tách văn bản thành các từ
        String[] words = input.split("\\s+");

        // Tạo TreeMap để lưu trữ từ và số lần xuất hiện
        TreeMap<String, Integer> wordCountMap = new TreeMap<>();

        // Duyệt qua các từ trong mảng words
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            // Nếu từ đã tồn tại trong map, tăng giá trị lên 1
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        // Hiển thị các từ và số lần xuất hiện theo thứ tự bảng chữ cái
        System.out.println("Số lần xuất hiện của các từ:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

