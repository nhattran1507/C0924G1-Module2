package Bai_13;

import java.util.Scanner;

public class InsertionSortVisualization {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = inputArray(scanner);
        System.out.println("Quá trình sắp xếp chèn:");
        insertionSort(array);
        System.out.println("Mảng sau khi sắp xếp:");
        printArray(array);
        scanner.close();
    }

    public static int[] inputArray(Scanner scanner) {
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Nhập các phần tử của mảng: ");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
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
            printArray(array);
        }
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
