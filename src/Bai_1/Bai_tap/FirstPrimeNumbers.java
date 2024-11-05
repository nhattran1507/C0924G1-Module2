package Bai_1.Bai_tap;

import java.util.Scanner;

public class FirstPrimeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of prime numbers to display: ");
        int numbers = scanner.nextInt();  // Bước 1: Lấy số lượng số nguyên tố cần in ra từ bàn phím

        int count = 0;    // Bước 2: Biến đếm số lượng số nguyên tố đã tìm thấy
        int N = 2;        // Bước 3: Bắt đầu từ số 2 để kiểm tra số nguyên tố

        System.out.println("The first " + numbers + " prime numbers are:");
        while (count < numbers) {         // Bước 4: Lặp cho đến khi tìm đủ số nguyên tố cần in ra
            if (isPrime(N)) {             // Kiểm tra nếu N là số nguyên tố
                System.out.print(N + " "); // In số nguyên tố
                count++;                  // Tăng biến đếm khi tìm thấy số nguyên tố
            }
            N++;                          // Tăng N lên 1 để kiểm tra số tiếp theo
        }

        scanner.close();
    }

    // Hàm kiểm tra một số có phải là số nguyên tố không
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
