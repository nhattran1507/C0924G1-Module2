package Bai_13;

public class InsertionSortExample {

    public static void main(String[] args) {
        int[] list = inputArray();
        System.out.println("Mảng ban đầu:");
        printArray(list);
        insertionSort(list);
        System.out.println("Mảng sau khi sắp xếp:");
        printArray(list);
    }

    public static int[] inputArray() {
        return new int[]{8, 3, 5, 7, 2, 4, 1};
    }

    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int key = list[i];
            int j = i - 1;

            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = key;
            System.out.print("Bước " + i + ": ");
            printArray(list);
        }
    }

    public static void printArray(int[] list) {
        InsertionSortSteps.displayArray(list);
    }
}
