package MVC;

public class CustomerController {
    private Customer customer;
    private CustomerView view;

    public CustomerController(Customer customer, CustomerView view) {
        this.customer = customer;
        this.view = view;
    }

    public void updateCustomerName(String name) {
        customer.setName(name);
        view.displayMessage("Customer name updated to: " + name);
    }

    public void updateCustomerEmail(String email) {
        customer.setEmail(email);
        view.displayMessage("Customer email updated to: " + email);
    }

    public void displayCustomer() {
        view.displayCustomerDetails(customer);
    }
}
