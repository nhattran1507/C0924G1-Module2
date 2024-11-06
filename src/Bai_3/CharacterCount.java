package Bai_3;

import java.util.Scanner;

public class CharacterCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Khai báo và gán giá trị cho chuỗi
        String str = "Hello, how many times does a character appear in this string?";

        // Bước 2: Nhập ký tự cần đếm từ bàn phím
        System.out.print("Nhập ký tự cần đếm: ");
        char ch = scanner.next().charAt(0);

        // Bước 3: Khai báo biến count và gán giá trị 0
        int count = 0;

        // Bước 4: Duyệt từng ký tự trong chuỗi và so sánh
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }

        // Bước 5: In ra giá trị biến đếm
        System.out.println("Ký tự '" + ch + "' xuất hiện " + count + " lần trong chuỗi.");

        scanner.close();
    }
}
