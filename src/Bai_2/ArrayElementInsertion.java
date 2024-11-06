package Bai_2;

import java.util.Scanner;

public class ArrayElementInsertion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Khai báo và khởi tạo mảng số nguyên với kích thước N
        System.out.print("Enter the size of the array (N): ");
        int N = scanner.nextInt();
        int[] array = new int[N + 1]; // Tạo mảng có kích thước N+1 để chèn thêm phần tử

        // Nhập các phần tử cho mảng
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }

        // In mảng ban đầu
        System.out.println("Original Array:");
        for (int i = 0; i < N; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // Bước 2: Nhập X là số cần chèn
        System.out.print("Enter the value to insert: ");
        int X = scanner.nextInt();

        // Bước 3: Nhập vào vị trí index cần chèn X vào trong mảng
        System.out.print("Enter the position to insert the value (index): ");
        int index = scanner.nextInt();

        // Bước 4: Kiểm tra điều kiện chèn
        if (index < 0 || index > N) {
            System.out.println("Cannot insert the element at the given index.");
        } else {
            // Bước 5: Dịch chuyển các phần tử và chèn X vào vị trí index
            for (int i = N; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = X; // Chèn X vào vị trí index

            // Bước 6: In ra mảng sau khi chèn
            System.out.println("Array after insertion:");
            for (int i = 0; i <= N; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
