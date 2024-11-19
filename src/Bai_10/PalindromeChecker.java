package Bai_10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeChecker {
    public static void main(String[] args) {
        // Chuỗi cần kiểm tra
        String input = "Able was I ere I saw Elba";

        // Chuẩn hóa chuỗi (loại bỏ khoảng trắng và ký tự đặc biệt, chuyển về chữ thường)
        String normalizedString = input.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        // Tạo stack và queue
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Đưa các ký tự vào stack và queue
        for (char c : normalizedString.toCharArray()) {
            stack.push(c);
            queue.add(c);
        }

        // So sánh từng ký tự trong stack và queue
        boolean isPalindrome = true;
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.poll())) {
                isPalindrome = false;
                break;
            }
        }

        // Kết quả
        if (isPalindrome) {
            System.out.println("Chuỗi \"" + input + "\" là chuỗi Palindrome.");
        } else {
            System.out.println("Chuỗi \"" + input + "\" không phải là chuỗi Palindrome.");
        }
    }
}
