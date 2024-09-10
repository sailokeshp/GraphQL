package com.amigoscode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerMutationController {

    @Autowired
    private CustomerRepository customerRepository;

    @MutationMapping
    public Customer createCustomer(@Argument String name, @Argument String email) {
        Customer customer = new Customer(name, email);
        return customerRepository.save(customer);
    }
}
