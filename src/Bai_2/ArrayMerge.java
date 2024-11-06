package Bai_2;

import java.util.Scanner;

public class ArrayMerge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Tạo hai mảng với kích thước cho trước
        System.out.print("Enter the size of the first array: ");
        int size1 = scanner.nextInt();
        int[] array1 = new int[size1];

        System.out.print("Enter the size of the second array: ");
        int size2 = scanner.nextInt();
        int[] array2 = new int[size2];

        // Bước 2: Nhập giá trị cho các phần tử trong mảng 1
        System.out.println("Enter elements of the first array:");
        for (int i = 0; i < size1; i++) {
            array1[i] = scanner.nextInt();
        }

        // Nhập giá trị cho các phần tử trong mảng 2
        System.out.println("Enter elements of the second array:");
        for (int i = 0; i < size2; i++) {
            array2[i] = scanner.nextInt();
        }

        // Bước 3: Tạo mảng thứ 3 với kích thước bằng tổng kích thước của mảng 1 và mảng 2
        int[] array3 = new int[size1 + size2];

        // Bước 4: Gán các phần tử của mảng 1 vào mảng thứ 3
        for (int i = 0; i < size1; i++) {
            array3[i] = array1[i];
        }

        // Bước 5: Gán các phần tử của mảng 2 vào mảng thứ 3, bắt đầu từ vị trí tiếp theo
        for (int i = 0; i < size2; i++) {
            array3[size1 + i] = array2[i];
        }

        // In mảng thứ 3 sau khi gộp
        System.out.println("Merged Array:");
        for (int i = 0; i < array3.length; i++) {
            System.out.print(array3[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}
