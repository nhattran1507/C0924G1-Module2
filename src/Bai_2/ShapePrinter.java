package Bai_2;

import java.util.Scanner;

public class ShapePrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    printRectangle(scanner);
                    break;
                case 2:
                    printSquareTriangle(scanner);
                    break;
                case 3:
                    printIsoscelesTriangle(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public static void printRectangle(Scanner scanner) {
        System.out.print("Enter the width of the rectangle: ");
        int width = scanner.nextInt();
        System.out.print("Enter the height of the rectangle: ");
        int height = scanner.nextInt();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // Kiểm tra nếu ô hiện tại nằm ở viền
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println(); //
        }
    }

    public static void printSquareTriangle(Scanner scanner) {
        System.out.println("Choose the corner of the square triangle:");
        System.out.println("1. Top-left");
        System.out.println("2. Top-right");
        System.out.println("3. Bottom-left");
        System.out.println("4. Bottom-right");
        System.out.print("Choose an option: ");
        int cornerChoice = scanner.nextInt();

        System.out.print("Enter the height of the triangle: ");
        int height = scanner.nextInt();

        switch (cornerChoice) {
            case 1: // Top-left
                for (int i = height; i > 0; i--) {
                    for (int j = 0; j < i; j++) {
                        if (i == height || j == 0 || j == i - 1) {
                            System.out.print("* ");
                        } else {
                            System.out.print("  ");
                        }
                    }
                    System.out.println();
                }
                break;

            case 2: // Top-right
                for (int i = height; i > 0; i--) {
                    for (int j = 0; j < height - i; j++) {
                        System.out.print("  ");
                    }
                    for (int j = 0; j < i; j++) {
                        if (i == height || j == 0 || j == i - 1) {
                            System.out.print("* ");
                        } else {
                            System.out.print("  ");
                        }
                    }
                    System.out.println();
                }
                break;

            case 3: // Bottom-left
                for (int i = 1; i <= height; i++) {
                    for (int j = 0; j < i; j++) {
                        if (i == height || j == 0 || j == i - 1) {
                            System.out.print("* ");
                        } else {
                            System.out.print("  ");
                        }
                    }
                    System.out.println();
                }
                break;

            case 4: // Bottom-right
                for (int i = 1; i <= height; i++) {
                    for (int j = 0; j < height - i; j++) {
                        System.out.print("  ");
                    }
                    for (int j = 0; j < i; j++) {
                        if (i == height || j == 0 || j == i - 1) {
                            System.out.print("* ");
                        } else {
                            System.out.print("  ");
                        }
                    }
                    System.out.println();
                }
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void printIsoscelesTriangle(Scanner scanner) {
        System.out.print("Enter the height of the isosceles triangle: ");
        int height = scanner.nextInt();

        for (int i = 1; i <= height; i++) {
            for (int j = 0; j < height - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                if (j == 0 || j == 2 * i - 2 || i == height) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}