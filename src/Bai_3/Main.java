package Bai_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = -1;

        // Yêu cầu người dùng nhập kích thước của ma trận vuông và kiểm tra lỗi
        while (n <= 0) {
            System.out.print("Nhập kích thước của ma trận vuông (số nguyên dương): ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n <= 0) {
                    System.out.println("Vui lòng nhập một số nguyên dương.");
                }
            } else {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập một số nguyên.");
                scanner.next(); // Xóa ký tự không hợp lệ khỏi bộ đệm
            }
        }

        // Khởi tạo ma trận
        double[][] matrix = new double[n][n];

        // Nhập các phần tử của ma trận từ người dùng
        System.out.println("Nhập các phần tử của ma trận:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Phần tử [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextDouble();
            }
        }

        // Tính tổng các phần tử trên đường chéo chính
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }

        // Hiển thị kết quả
        System.out.println("Tổng các phần tử trên đường chéo chính là: " + sum);

        scanner.close();
    }
}

