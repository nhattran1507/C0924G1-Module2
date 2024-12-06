package case_study_2.service;

import case_study_2.entity.Customer;

public interface ICustomerService extends IService<Customer, String> {
    void update(Customer customer);

    void remove(String customerId);
}
