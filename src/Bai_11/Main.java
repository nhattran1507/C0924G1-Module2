package Bai_11;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ProductManager productManager = new ProductManager();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Product Management ===");
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product by ID");
            System.out.println("3. Delete Product by ID");
            System.out.println("4. Display All Products");
            System.out.println("5. Search Product by Name");
            System.out.println("6. Sort Products by Price (Ascending)");
            System.out.println("7. Sort Products by Price (Descending)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    editProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    productManager.displayProducts();
                    break;
                case 5:
                    searchProductByName();
                    break;
                case 6:
                    productManager.sortProductsByPriceAscending();
                    productManager.displayProducts();
                    break;
                case 7:
                    productManager.sortProductsByPriceDescending();
                    productManager.displayProducts();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }

    private static void addProduct() {
        System.out.print("Enter product ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = Double.parseDouble(scanner.nextLine());
        productManager.addProduct(new Product(id, name, price));
    }

    private static void editProduct() {
        System.out.print("Enter product ID to edit: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter new product name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new product price: ");
        double newPrice = Double.parseDouble(scanner.nextLine());
        productManager.editProduct(id, newName, newPrice);
    }

    private static void deleteProduct() {
        System.out.print("Enter product ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        productManager.deleteProduct(id);
    }

    private static void searchProductByName() {
        System.out.print("Enter product name to search: ");
        String name = scanner.nextLine();
        productManager.searchProductByName(name);
    }
}

