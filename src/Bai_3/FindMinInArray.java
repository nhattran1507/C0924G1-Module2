package Bai_3;

import java.util.Scanner;

public class FindMinInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Khai báo mảng số nguyên với SIZE phần tử
        int size = -1;

        // Yêu cầu người dùng nhập kích thước của mảng, kiểm tra lỗi nhập
        while (size <= 0) {
            System.out.print("Enter the size of the array (positive integer): ");
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                if (size <= 0) {
                    System.out.println("Please enter a positive integer.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Xóa ký tự không hợp lệ khỏi bộ đệm
            }
        }

        // Tạo mảng với kích thước đã nhập
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
