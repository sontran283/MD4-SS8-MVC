package com.ra.service;

import com.ra.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> finAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
