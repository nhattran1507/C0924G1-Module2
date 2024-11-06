package Bai_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 2: Nhập kích thước của ma trận
        System.out.print("Nhập kích thước của ma trận vuông: ");
        int n = scanner.nextInt();

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

