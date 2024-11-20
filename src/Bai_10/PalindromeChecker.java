package Bai_10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeChecker {

    public static void main(String[] args) {
        String input = getUserInput();
        boolean isPalindrome = checkPalindrome(input);
        if (isPalindrome) {
            System.out.println("Chuỗi \"" + input + "\" là chuỗi Palindrome.");
        } else {
            System.out.println("Chuỗi \"" + input + "\" không phải là chuỗi Palindrome.");
        }
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi cần kiểm tra Palindrome:");
        return scanner.nextLine();
    }

    private static boolean checkPalindrome(String input) {

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        String normalizedString = input.toLowerCase();
        fillStackAndQueue(normalizedString, stack, queue);
        return compareStackAndQueue(stack, queue);
    }

    private static void fillStackAndQueue(String input, Stack<Character> stack, Queue<Character> queue) {
        for (char c : input.toCharArray()) {
            stack.push(c);
            queue.add(c);
        }
    }

    private static boolean compareStackAndQueue(Stack<Character> stack, Queue<Character> queue) {
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.poll())) {
                return false;
            }
        }
        return true;
    }
}
