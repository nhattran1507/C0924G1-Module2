package MVC_2;

import java.util.Scanner;

public class BankManagementApp {
    private final CustomerView view = new CustomerView();
    private final CustomerController controller = new CustomerController(view);
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new BankManagementApp().run();
    }

    public void run() {
        while (true) {
            try {
                displayMenu();
                int choice = Integer.parseInt(scanner.nextLine());
                handleMenuChoice(choice);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private void displayMenu() {
        System.out.println("Bank Loan Management System");
        System.out.println("1. Add Customer");
        System.out.println("2. Display All Customers");
        System.out.println("3. Find Customer By ID");
        System.out.println("4. Delete Customer");
        System.out.println("5. Update Customer");
        System.out.println("6. Load Customers From CSV");
        System.out.println("7. Exit");
        System.out.print("Choose an option: ");
    }



    private void handleMenuChoice(int choice) {
        switch (choice) {
            case 1 -> {
                try {
                    addCustomer();
                } catch (DuplicateCustomerException e) {
                    throw new RuntimeException(e);
                }
            }
            case 2 -> controller.displayAllCustomers();
            case 3 -> findCustomerById();
            case 4 -> deleteCustomer();
            case 5 -> updateCustomer();
            case 6 -> loadCustomersFromCSV();
            case 7 -> exitProgram();
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    private void addCustomer() throws DuplicateCustomerException {
        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Loan Amount: ");
        double loanAmount = Double.parseDouble(scanner.nextLine());

        if (loanAmount < 0) {
            throw new IllegalArgumentException("Loan amount cannot be negative.");
        }

        controller.addCustomer(id, name, loanAmount);
    }

    private void findCustomerById() {
        System.out.print("Enter Customer ID to Search: ");
        String searchId = scanner.nextLine();
        controller.findCustomerById(searchId);
    }

    private void deleteCustomer() {
        System.out.print("Enter Customer ID to Delete: ");
        String deleteId = scanner.nextLine();
        controller.deleteCustomer(deleteId);
    }

    private void updateCustomer() {
        System.out.print("Enter Customer ID to Update: ");
        String updateId = scanner.nextLine();
        System.out.print("Enter New Customer Name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter New Loan Amount: ");
        double newLoanAmount = Double.parseDouble(scanner.nextLine());

        if (newLoanAmount < 0) {
            throw new IllegalArgumentException("Loan amount cannot be negative.");
        }

        controller.updateCustomer(updateId, newName, newLoanAmount);
    }

    private void loadCustomersFromCSV() {
        System.out.print("Enter CSV file path: ");
        String filePath = scanner.nextLine();
        controller.loadCustomersFromCSV(filePath);
    }

    private void exitProgram() {
        System.out.println("Exiting the program. Goodbye!");
        scanner.close();
        System.exit(0);
    }
}
