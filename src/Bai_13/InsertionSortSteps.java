package Bai_13;

public class InsertionSortSteps {
    public static void insertionSort(int[] arr) {
        System.out.println("Ban đầu: ");
        printArray(arr);

        for (int i = 1; i < arr.length; i++) {
            insertElement(arr, i);
            System.out.println("Bước " + i + ": ");
            printArray(arr);
        }
    }

    public static void insertElement(int[] arr, int index) {
        int key = arr[index];
        int j = index - 1;

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }


    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] array = {8, 4, 6, 3, 7}; // Định nghĩa mảng
        System.out.println("Thuật toán sắp xếp chèn:");
        insertionSort(array);
    }
}
