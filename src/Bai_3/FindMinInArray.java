package Bai_3;

import java.util.Scanner;

public class FindMinInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Khai báo mảng số nguyên với SIZE phần tử
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        // Bước 2: Nhập giá trị cho các phần tử trong mảng từ bàn phím
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        // Bước 3: Gọi phần tử đầu tiên là phần tử có giá trị nhỏ nhất
        int min = array[0];

        // Bước 4: Duyệt mảng từ phần tử thứ 2 đến hết mảng
        for (int i = 1; i < size; i++) {
            if (array[i] < min) {
                min = array[i];  // Cập nhật giá trị nhỏ nhất nếu tìm thấy giá trị nhỏ hơn
            }
        }

        // Bước 5: Kết thúc duyệt mảng và in ra giá trị nhỏ nhất
        System.out.println("The smallest element in the array is: " + min);

        scanner.close();
    }
}
