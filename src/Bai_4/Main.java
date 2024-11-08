package Bai_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập vào 3 giá trị cho a, b và c
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter c: ");
        double c = scanner.nextDouble();

        // Tạo đối tượng QuadraticEquation
        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        // Tính delta
        double delta = equation.getDiscriminant();

        // Kiểm tra và hiển thị nghiệm
        if (delta > 0) {
            System.out.println("The equation has two roots: " + equation.getRoot1() + " and " + equation.getRoot2());
        } else if (delta == 0) {
            System.out.println("The equation has one root: " + equation.getRoot1());
        } else {
            System.out.println("The equation has no roots");
        }

        scanner.close();
    }
}
