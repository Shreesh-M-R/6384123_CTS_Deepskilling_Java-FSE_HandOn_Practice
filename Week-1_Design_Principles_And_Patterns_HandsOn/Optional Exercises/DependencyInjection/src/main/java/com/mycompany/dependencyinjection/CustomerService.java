
package com.mycompany.dependencyinjection;

public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void displayCustomerById(int id) {
    System.out.println(customerRepository.findCustomerById(id));    
    }
}


