package MVC;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create initial data
        Customer customer = new Customer(1, "John Doe", "john.doe@example.com");
        CustomerView view = new CustomerView();
        CustomerController controller = new CustomerController(customer, view);

        // Display initial details
        controller.displayCustomer();

        // Update details through user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter new name for customer:");
        String newName = scanner.nextLine();
        controller.updateCustomerName(newName);

        System.out.println("Enter new email for customer:");
        String newEmail = scanner.nextLine();
        controller.updateCustomerEmail(newEmail);

        // Display updated details
        controller.displayCustomer();

        scanner.close();
    }
}