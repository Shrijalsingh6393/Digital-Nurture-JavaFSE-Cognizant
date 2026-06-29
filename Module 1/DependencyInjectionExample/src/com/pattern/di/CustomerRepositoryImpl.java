package com.pattern.di;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(String id) {
        // In a real app, this would query a database. Here we return a stub.
        System.out.println("[CustomerRepositoryImpl] Looking up customer with ID: " + id);
        return new Customer(id, "John Doe");
    }
}
