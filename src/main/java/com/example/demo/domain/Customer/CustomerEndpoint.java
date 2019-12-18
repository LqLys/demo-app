package com.example.demo.domain.Customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/customer")
public class CustomerEndpoint {

    private final CustomerRepository customerRepository;

    public CustomerEndpoint(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(path = "/getCustomers")
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping(path = "/add")
    public Customer addCustomer(){
        Customer customer = new Customer();
        customer.setFirstName("jacek");
        customer.setLastName("placek");
        return customerRepository.save(customer);
    }
}
