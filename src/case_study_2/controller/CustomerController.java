package case_study_2.controller;

import case_study_2.entity.Customer;
import case_study_2.repository.CustomerRepository;

import java.util.List;

public class CustomerController {
    private final CustomerRepository customerRepository = new CustomerRepository();

    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
        System.out.println("Khách hàng đã được thêm thành công.");
    }

    public Customer findCustomerById(String id) {
        Customer customer = customerRepository.findCustomerById(id);
        if (customer == null) {
            System.out.println("Không tìm thấy khách hàng với ID: " + id);
        }
        return customer;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerRepository.getAll();
        if (customers.isEmpty()) {
            System.out.println("Không có khách hàng nào.");
        }
        return customers;
    }

    public void removeCustomer(String id) {
        customerRepository.removeCustomer(id);
        System.out.println("Khách hàng với ID " + id + " đã được xóa.");
    }
}
