package Bai_3;

import java.util.Scanner;

public class ColumnSumInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 2: Nhập kích thước của ma trận từ người dùng
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        // Tạo và nhập liệu cho ma trận số thực
        double[][] matrix = new double[rows][cols];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextDouble();
            }
        }

        // Hỏi người dùng muốn tính tổng của cột nào
        System.out.print("Enter the index of the column you want to sum (starting from 0): ");
        int columnIndex = scanner.nextInt();

        // Kiểm tra cột có hợp lệ hay không
        if (columnIndex < 0 || columnIndex >= cols) {
            System.out.println("Invalid column index.");
        } else {
            // Bước 1: Tính tổng các phần tử của cột được chọn
            double sum = 0;
            for (int i = 0; i < rows; i++) {
                sum += matrix[i][columnIndex];
            }
            System.out.println("The sum of elements in column " + columnIndex + " is: " + sum);
        }

        scanner.close();
    }
}

