package Bai_10;

import java.util.Scanner;

public class change {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
            try {
                System.out.println("Nhập vào số nguyên dương (>0):");
                String input = sc.nextLine(); // Đọc chuỗi đầu vào
                n = Integer.parseInt(input); // Chuyển chuỗi thành số nguyên
                if (n > 0) {
                    break; // Thoát vòng lặp nếu n hợp lệ
                }
            } catch (NumberFormatException e) {
                System.out.println("Đầu vào không hợp lệ! Vui lòng nhập một số nguyên.");
            }
        }


        String nhiPhan = "";
        while (n > 0) {
            nhiPhan = (n % 2) + nhiPhan;
            n= n / 2;
        }
        System.out.println("số hệ nhị phân là " + nhiPhan);
    }
}
