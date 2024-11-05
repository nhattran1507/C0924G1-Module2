package Bai_1.Bai_tap;

import java.util.Scanner;

public class ArrayElementDeletion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Khai báo và khởi tạo mảng số nguyên
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Mảng mẫu có 10 phần tử
        int N = array.length;

        // In mảng ban đầu
        System.out.println("Original Array:");
        for (int i = 0; i < N; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // Bước 2: Nhập X là phần tử cần xoá
        System.out.print("Enter the element to delete: ");
        int X = scanner.nextInt();

        // Bước 3: Tìm X trong mảng
        int index_del = -1;
        for (int i = 0; i < N; i++) {
            if (array[i] == X) {
                index_del = i;
                break;
            }
        }

        // Kiểm tra nếu X xuất hiện trong mảng
        if (index_del == -1) {
            System.out.println("Element " + X + " not found in the array.");
        } else {
            // Bước 4: Thực hiện xoá phần tử X khỏi mảng
            for (int i = index_del; i < N - 1; i++) {
                array[i] = array[i + 1]; // Ghi đè phần tử phía sau lên phần tử cần xoá
            }
            N--; // Giảm kích thước mảng sau khi xoá

            // Bước 5: In ra mảng sau khi xoá
            System.out.println("Array after deletion:");
            for (int i = 0; i < N; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
