package Bai_14;

import java.util.Scanner;

public class TriangleValidation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Nhập 3 cạnh của tam giác
            System.out.print("Nhập cạnh thứ nhất: ");
            double side1 = scanner.nextDouble();
            System.out.print("Nhập cạnh thứ hai: ");
            double side2 = scanner.nextDouble();
            System.out.print("Nhập cạnh thứ ba: ");
            double side3 = scanner.nextDouble();

            // Kiểm tra tính hợp lệ của tam giác
            validateTriangle(side1, side2, side3);

            // Nếu hợp lệ, in thông báo
            System.out.println("Ba cạnh tạo thành một tam giác hợp lệ.");

        } catch (IllegalTriangleException e) {
            // Xử lý ngoại lệ nếu tam giác không hợp lệ
            System.out.println("Lỗi: " + e.getMessage());
        } catch (Exception e) {
            // Xử lý các lỗi nhập liệu khác (ví dụ nhập ký tự thay vì số)
            System.out.println("Lỗi: Vui lòng nhập số hợp lệ.");
        } finally {
            scanner.close();
        }
    }

    // Phương thức kiểm tra tam giác
    public static void validateTriangle(double side1, double side2, double side3) throws IllegalTriangleException {
        // Kiểm tra nếu cạnh nào âm
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalTriangleException("Các cạnh của tam giác phải là số dương.");
        }

        // Kiểm tra tổng hai cạnh không lớn hơn cạnh còn lại
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new IllegalTriangleException("Tổng hai cạnh bất kỳ phải lớn hơn cạnh còn lại.");
        }
    }
}
