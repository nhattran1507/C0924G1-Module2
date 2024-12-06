package case_study_2.service.impl;

import case_study_2.entity.Customer;
import case_study_2.repository.CustomerRepository;
import case_study_2.service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private final CustomerRepository repository = new CustomerRepository();

    @Override
    public void add(Customer customer) {
        repository.addCustomer(customer);
    }

    @Override
    public Customer findById(String customerId) {
        return repository.findCustomerById(customerId);
    }

    @Override
    public void update(String id1, String id2, int preferenceLevel) {

    }

    @Override
    public void remove(String id1, String id2) {

    }

    @Override
    public void update(Customer customer) {
        repository.updateCustomer(customer);
    }

    @Override
    public void remove(String customerId) {
        repository.removeCustomer(customerId);
    }

    @Override
    public List<Customer> getAll() {
        return repository.getAll();
    }
}
