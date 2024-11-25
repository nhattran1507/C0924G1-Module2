package Bai_14;

import java.util.Scanner;

public class TriangleValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Nhập cạnh thứ nhất: ");
                double side1 = scanner.nextDouble();

                System.out.print("Nhập cạnh thứ hai: ");
                double side2 = scanner.nextDouble();

                System.out.print("Nhập cạnh thứ ba: ");
                double side3 = scanner.nextDouble();

                validateTriangle(side1, side2, side3);

                System.out.println("Ba cạnh tạo thành một tam giác hợp lệ.");
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Lỗi số: " + e.getMessage());
            } catch (IllegalTriangleException e) {
                System.out.println("Lỗi tam giác: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Lỗi: Vui lòng nhập số hợp lệ.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    public static void validateTriangle(double side1, double side2, double side3) throws IllegalTriangleException, NumberFormatException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new NumberFormatException("Các cạnh phải là số dương và lớn hơn 0.");
        }
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new IllegalTriangleException("Tổng hai cạnh bất kỳ phải lớn hơn cạnh còn lại.");
        }
    }
}

