package case_study_2.controller;

import case_study_2.entity.Customer;
import case_study_2.repository.CustomerRepository;

import java.util.List;

public class CustomerController {
    private final CustomerRepository customerRepository = new CustomerRepository();

    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    public Customer findCustomerById(String id) {
        Customer customer = customerRepository.findCustomerById(id);
        if (customer.isEmpty()) {
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
    }

    public void updateCustomer(Customer updatedCustomer) {
        customerRepository.updateCustomer(updatedCustomer);
    }
    public Customer checkCustomer(String name, String phone, String address) {
        customerRepository.findCustomerByDetails(name, phone, address);
        return null;
    }
}
