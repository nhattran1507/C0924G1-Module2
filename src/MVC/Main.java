package MVC;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(1, "John Doe", "john.doe@example.com");
        CustomerView view = new CustomerView();
        CustomerController controller = new CustomerController(customer, view);
        controller.displayCustomer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new name for customer:");
        String newName = scanner.nextLine();
        controller.updateCustomerName(newName);
        System.out.println("Enter new email for customer:");
        String newEmail = scanner.nextLine();
        controller.updateCustomerEmail(newEmail);
        controller.displayCustomer();
        scanner.close();
    }
}
