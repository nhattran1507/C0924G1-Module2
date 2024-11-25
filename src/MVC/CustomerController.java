package MVC;

public class CustomerController {
    private Customer customer;
    private CustomerView view;

    public CustomerController(Customer customer, CustomerView view) {
        this.customer = customer;
        this.view = view;
    }

    public void updateCustomerName(String name) {
        try {
            customer.setName(name);
            view.displayMessage("Customer name updated to: " + name);
        } catch (IllegalArgumentException e) {
            view.displayError("Failed to update name: " + e.getMessage());
        }
    }

    public void updateCustomerEmail(String email) {
        try {
            customer.setEmail(email);
            view.displayMessage("Customer email updated to: " + email);
        } catch (IllegalArgumentException e) {
            view.displayError("Failed to update email: " + e.getMessage());
        }
    }

    public void displayCustomer() {
        view.displayCustomerDetails(customer);
    }
}
