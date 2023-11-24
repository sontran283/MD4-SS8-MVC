package com.ra.service;

import com.ra.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceIMPL implements ICustomerService {
    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add( new Customer(1, "John", "john@rikkei.academy", "Hanoi"));
        customerList.add( new Customer(2, "Bill", "bill@rikkei.academy", "Danang"));
        customerList.add( new Customer(3, "Alex", "alex@rikkei.academy", "Saigon"));
        customerList.add( new Customer(4, "Adam", "adam@rikkei.academy", "Beijin"));
        customerList.add( new Customer(5, "Sophia", "sophia@rikkei.academy", "Miami"));
        customerList.add( new Customer(6, "Rose", "rose@rikkei.academy", "Newyork"));
    }

    @Override
    public List<Customer> finAll() {
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        if (findById(customer.getId()) == null) {
            customerList.add(customer);
        } else {
            customerList.set(customerList.indexOf(customer), customer);
        }
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Customer customer) {
        customerList.add(id, customer);
    }

    @Override
    public void remove(int id) {
        customerList.remove(findById(id));
    }

    @Override
    public int getNewId() {
        int idMax = 0;
        for (Customer customer : customerList) {
            if (customer.getId() > idMax) {
                idMax = customer.getId();
            }
        }
        return (idMax + 1);
    }

    @Override
    public List<Customer> finByName(String name) {
        List<Customer> customersSearch = new ArrayList<>();
        for (Customer customer : customerList) {
            if (customer.getName().toLowerCase().contains(name.toLowerCase().trim())) {
                customersSearch.add(customer);
            }
        }
        return customersSearch;
    }
}
