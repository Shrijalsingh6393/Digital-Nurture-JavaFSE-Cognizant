package com.pattern.di;

public class CustomerService {
    private final CustomerRepository repository;

    // Constructor injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer getCustomerById(String id) {
        return repository.findCustomerById(id);
    }
}
