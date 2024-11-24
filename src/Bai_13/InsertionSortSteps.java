package Bai_13;

import java.util.Scanner;

public class InsertionSortSteps {

    public static void main(String[] args) {
        int[] array = getInputArray();
        System.out.println("Mảng ban đầu:");
        displayArray(array);
        System.out.println("Các bước thực hiện thuật toán sắp xếp chèn:");
        insertionSort(array);
    }

    public static int[] getInputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử trong mảng: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void displayArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
            System.out.print("Bước " + i + ": ");
            displayArray(array);
        }
    }
}
