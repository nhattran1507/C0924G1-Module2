package Bai_16;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "Product.dat";
        ProductFileManager manager = new ProductFileManager(filePath);
        Scanner scanner = new Scanner(System.in);
        List<Product> products = manager.readProducts();

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Delete Product");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Product product = createProduct(scanner);
                    products.add(product);
                    manager.writeProducts(products);
                    System.out.println("Product added.");
                    break;
                case 2:
                    if (products.isEmpty()) {
                        System.out.println("No products added.");
                    } else {
                        System.out.println("Product List:");
                        products.forEach(System.out::println);
                    }
                    break;
                case 3:
                    System.out.print("Input product ID to delete: ");
                    String idToDelete = scanner.nextLine();
                    if (deleteProductById(products, idToDelete, scanner)) {
                        manager.writeProducts(products);
                    }
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static Product createProduct(Scanner scanner) {
        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter product manufacturer: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Enter product description: ");
        String description = scanner.nextLine();

        return new Product(id, name, price, manufacturer, description);
    }

    private static boolean deleteProductById(List<Product> products, String id, Scanner scanner) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                System.out.println("Product Details: " + product);
                System.out.print("Are you sure you want to delete this product? (Y/N): ");
                String confirm = scanner.nextLine().trim().toLowerCase();

                if (confirm.equals("y")) {
                    products.remove(product);
                    System.out.println("Product deleted.");
                    return true;
                } else {
                    System.out.println("Deletion cancelled.");
                    return false;
                }
            }
        }
        System.out.println("Product ID not found.");
        return false;
    }
}
