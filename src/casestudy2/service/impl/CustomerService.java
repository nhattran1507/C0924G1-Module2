package casestudy2.service.impl;

import casestudy2.entity.Customer;
import casestudy2.repository.CustomerRepository;
import casestudy2.service.ICustomerService;

import java.util.Map;

public class CustomerService implements ICustomerService {
    private final CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public Map<String, Customer> getAll() {
        return customerRepository.getAll();
    }
    @Override
    public void add(Customer customer) {
        customerRepository.addCustomer(customer);
    }
    @Override
    public Customer findById(String id) {
        return customerRepository.findCustomerById(id);
    }
    @Override
    public void update(Customer customer) {
        customerRepository.updateCustomer(customer);
    }

    @Override
    public void remove(String id) {
        customerRepository.removeCustomerById(id);
    }

    @Override
    public Customer findCustomerByDetail(String name, String phone, String address) {
        return customerRepository.findCustomerByDetail(name, phone, address);
    }
}
