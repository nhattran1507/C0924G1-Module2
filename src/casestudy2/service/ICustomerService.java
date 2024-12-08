package casestudy2.service;

import casestudy2.entity.Customer;

public interface ICustomerService extends IService<Customer> {
    Customer findCustomerByDetail(String name, String phone, String address);
}
