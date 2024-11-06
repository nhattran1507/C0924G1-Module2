package Bai_3;

import java.util.Scanner;

public class MatrixMaxElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Thu thập kích thước ma trận từ người dùng
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

        //  Tìm phần tử lớn nhất trong ma trận
        double maxElement = matrix[0][0];
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > maxElement) {
                    maxElement = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        // Thông báo kết quả
        System.out.println("The maximum element in the matrix is: " + maxElement);
        System.out.println("Its position is at row " + maxRow + " and column " + maxCol);

        scanner.close();
    }
}
