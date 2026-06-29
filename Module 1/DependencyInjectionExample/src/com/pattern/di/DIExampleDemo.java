package com.pattern.di;

public class DIExampleDemo {
    public static void main(String[] args) {
        // Create concrete repository
        CustomerRepository repository = new CustomerRepositoryImpl();
        // Inject repository into service via constructor
        CustomerService service = new CustomerService(repository);

        // Use the service to find a customer
        String searchId = "C001";
        Customer customer = service.getCustomerById(searchId);
        System.out.println("[Demo] Retrieved Customer -> ID: " + customer.getId() + ", Name: " + customer.getName());
    }
}
