package MVC_2;

public class CustomerService {
    private final CustomerController controller;

    public CustomerService(CustomerController controller) {
        this.controller = controller;
    }

    public void addCustomerWithValidation(String id, String name, double loanAmount) throws DuplicateCustomerException {
        if (controller.isCustomerIdExists(id)) {
            throw new DuplicateCustomerException("Customer ID already exists!");
        }
        if (loanAmount < 0) {
            throw new IllegalArgumentException("Loan amount cannot be negative.");
        }
        controller.addCustomer(id, name, loanAmount);
    }
}
