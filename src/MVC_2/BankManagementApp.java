package MVC_2;

import java.util.Scanner;

public class BankManagementApp {
    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        CustomerController controller = new CustomerController(view);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Bank Loan Management System");
                System.out.println("1. Add Customer");
                System.out.println("2. Display All Customers");
                System.out.println("3. Find Customer By ID");
                System.out.println("4. Delete Customer");
                System.out.println("5. Update Customer");
                System.out.println("6. Load Customers From CSV");
                System.out.println("7. Exit");
                System.out.print("Choose an option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
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
                        break;

                    case 2:
                        controller.displayAllCustomers();
                        break;

                    case 3:
                        System.out.print("Enter Customer ID to Search: ");
                        String searchId = scanner.nextLine();
                        controller.findCustomerById(searchId);
                        break;

                    case 4:
                        System.out.print("Enter Customer ID to Delete: ");
                        String deleteId = scanner.nextLine();
                        controller.deleteCustomer(deleteId);
                        break;

                    case 5:
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
                        break;

                    case 6:
                        System.out.print("Enter CSV file path: ");
                        String filePath = scanner.nextLine();
                        controller.loadCustomersFromCSV(filePath);
                        break;

                    case 7:
                        System.out.println("Exiting the program. Goodbye!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (DuplicateCustomerException e) {
                view.printError(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}


