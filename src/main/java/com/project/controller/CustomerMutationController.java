package com.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.project.model.Customer;
import com.project.repository.CustomerRepository;

@Controller
public class CustomerMutationController {

    @Autowired
    private CustomerRepository customerRepository;

    @MutationMapping
    public Customer createCustomer(@Argument String name, @Argument String email) {
        Customer customer = new Customer(name, email);
        return customerRepository.save(customer);
    }

    @MutationMapping
    public Customer updateCustomer(@Argument String id, @Argument String name, @Argument String email) {

        Optional<Customer> existingCustomerOpt = customerRepository.findById(id);
        
        if (existingCustomerOpt.isPresent()) {
            Customer existingCustomer = existingCustomerOpt.get();

            if (name != null) {
                existingCustomer.setName(name);
            }
            if (email != null) {
                existingCustomer.setEmail(email);
            }

            return customerRepository.save(existingCustomer);
        } else {
            throw new RuntimeException("Customer not found with ID: " + id);
        }
    }

    @QueryMapping
    public Customer getCustomerById(@Argument String id) {
        Optional<Customer> customerOpt = customerRepository.findById(id);
        return customerOpt.orElse(null);  
    }

    @QueryMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();  
    }
    
    @MutationMapping
    public Boolean deleteCustomer(@Argument String id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;  
        } else {
            return false;  
        }
    }
}
