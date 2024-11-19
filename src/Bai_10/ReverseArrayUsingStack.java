package Bai_10;

import java.util.Stack;

public class ReverseArrayUsingStack {
    // Hàm đảo ngược mảng sử dụng Stack
    public static void reverseArray(int[] array) {
        // Bước 1: Khởi tạo một Stack
        Stack<Integer> stack = new Stack<>();

        // Bước 2: Đưa từng phần tử của mảng vào Stack (Push)
        for (int element : array) {
            stack.push(element);
        }

        // Bước 3: Lấy lần lượt các phần tử từ Stack và gán lại vào mảng
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop(); // Pop từ Stack và gán vào mảng
        }
    }

    public static void main(String[] args) {
        // Khởi tạo mảng ban đầu
        int[] array = {1, 2, 3, 4, 5};

        System.out.println("Mảng ban đầu:");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();

        // Đảo ngược mảng
        reverseArray(array);

        System.out.println("Mảng sau khi đảo ngược:");
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}
