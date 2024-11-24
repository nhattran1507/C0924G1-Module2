package Bai_14;

import java.util.Scanner;

// Lớp ngoại lệ tùy chỉnh để xử lý lỗi tam giác không hợp lệ
class IllegalTriangleException extends Exception {
    public IllegalTriangleException(String message) {
        super(message);
    }
}

class TriangleValidation {

    // Phương thức chính để chạy chương trình
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            double[] sides = inputTriangleSides(scanner); // Nhập cạnh của tam giác
            validateTriangle(sides[0], sides[1], sides[2]); // Kiểm tra tính hợp lệ
            System.out.println("Các cạnh nhập vào tạo thành một tam giác hợp lệ.");
        } catch (IllegalTriangleException e) {
            System.err.println("Lỗi: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi: Giá trị nhập vào không hợp lệ.");
        }
        // Đóng scanner
    }

    // Hàm nhập các cạnh của tam giác
    public static double[] inputTriangleSides(Scanner scanner) {
        double[] sides = new double[3];
        System.out.print("Nhập cạnh thứ nhất: ");
        sides[0] = scanner.nextDouble();

        System.out.print("Nhập cạnh thứ hai: ");
        sides[1] = scanner.nextDouble();

        System.out.print("Nhập cạnh thứ ba: ");
        sides[2] = scanner.nextDouble();

        return sides;
    }

    // Hàm kiểm tra tính hợp lệ của tam giác
    public static void validateTriangle(double a, double b, double c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Cạnh của tam giác không được âm hoặc bằng 0.");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Tổng hai cạnh phải lớn hơn cạnh còn lại.");
        }
    }
}
