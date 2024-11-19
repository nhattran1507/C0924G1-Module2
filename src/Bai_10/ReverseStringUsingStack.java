package Bai_10;

import java.util.Stack;

public class ReverseStringUsingStack {

    // Hàm đảo ngược chuỗi sử dụng Stack
    public static String reverseString(String input) {
        // Bước 1: Tạo một Stack rỗng
        Stack<String> wStack = new Stack<>();

        // Bước 2: Tách từ từ chuỗi ban đầu và đưa vào Stack
        String[] words = input.split(" "); // Sử dụng phương thức split() để tách từ
        for (String word : words) {
            wStack.push(word); // Push từng từ vào Stack
        }

        // Bước 3: Lấy lần lượt các từ từ Stack và nối vào chuỗi kết quả
        StringBuilder output = new StringBuilder(); // Sử dụng StringBuilder để nối chuỗi
        while (!wStack.isEmpty()) {
            output.append(wStack.pop()); // Pop từ Stack
            if (!wStack.isEmpty()) {
                output.append(" "); // Thêm khoảng trắng nếu còn từ
            }
        }

        return output.toString(); // Trả về chuỗi kết quả
    }

    public static void main(String[] args) {
        // Chuỗi đầu vào
        String input = "Hello world this is a test";

        System.out.println("Chuỗi ban đầu:");
        System.out.println(input);

        // Đảo ngược chuỗi
        String reversed = reverseString(input);

        System.out.println("Chuỗi sau khi đảo ngược:");
        System.out.println(reversed);
    }
}
