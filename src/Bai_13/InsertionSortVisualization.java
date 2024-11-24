package Bai_13;

import java.util.Scanner;

public class InsertionSortVisualization {

    // Hàm sắp xếp chèn và hiển thị các bước
    public static void insertionSortWithSteps(int[] arr) {
        System.out.println("Ban đầu: ");
        printArray(arr);

        for (int i = 1; i < arr.length; i++) {
            insertElement(arr, i); // Chèn phần tử tại vị trí `i`
            System.out.println("Bước " + i + ": ");
            printArray(arr); // Hiển thị trạng thái sau mỗi bước
        }
    }

    // Hàm chèn phần tử vào đúng vị trí trong mảng con
    public static void insertElement(int[] arr, int index) {
        int key = arr[index];
        int j = index - 1;

        // Dịch chuyển các phần tử lớn hơn `key` sang phải
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key; // Chèn phần tử `key` vào đúng vị trí
    }

    // Hàm in mảng
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Hàm đọc mảng từ người dùng
    public static int[] inputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử của mảng: ");
        int n = scanner.nextInt(); // Nhập số lượng phần tử

        int[] array = new int[n];
        System.out.println("Nhập các phần tử của mảng: ");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt(); // Nhập từng phần tử
        }
        return array;
    }

    // Hàm main
    public static void main(String[] args) {
        // Đọc mảng từ người dùng
        int[] array = inputArray();

        // Hiển thị các bước sắp xếp
        System.out.println("Thuật toán sắp xếp chèn:");
        insertionSortWithSteps(array);

        // Hiển thị kết quả sau khi sắp xếp
        System.out.println("Mảng sau khi sắp xếp: ");
        printArray(array);
    }
}
