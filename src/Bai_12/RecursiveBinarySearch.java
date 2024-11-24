package Bai_12;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveBinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = inputArray(scanner);

        sortArray(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
        
        System.out.print("Enter the value to search: ");
        int value = scanner.nextInt();

        int result = binarySearch(array, 0, array.length - 1, value);

        displayResult(value, result);
    }

    public static int[] inputArray(Scanner scanner) {
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void sortArray(int[] array) {
        Arrays.sort(array);
    }

    public static int binarySearch(int[] array, int left, int right, int value) {
        if (left <= right) {
            int middle = left + (right - left) / 2;

            if (array[middle] == value) {
                return middle;
            }

            if (array[middle] < value) {
                return binarySearch(array, middle + 1, right, value);
            }

            return binarySearch(array, left, middle - 1, value);
        }
        return -1;
    }

    public static void displayResult(int value, int result) {
        if (result != -1) {
            System.out.println("Value " + value + " found at index " + result + ".");
        } else {
            System.out.println("Value " + value + " not found in the array.");
        }
    }
}
