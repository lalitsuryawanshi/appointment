package com.x3t.lalit.appointment.service.impl;

import com.x3t.lalit.appointment.exception.CustomerNotFoundException;
import com.x3t.lalit.appointment.model.Customer;
import com.x3t.lalit.appointment.repository.CustomerRepository;
import com.x3t.lalit.appointment.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(String id) {

        Optional<Customer> OptionalCustomer = customerRepository.findById(Long.valueOf(id));

        if(OptionalCustomer.isEmpty()) {
            log.error("Customer id not found. Id: " + id);
            throw new CustomerNotFoundException("Customer with ID ("+id+") is not found.");
        }
        return OptionalCustomer.get();
    }

    @Override
    public boolean deleteCustomer(String id) {

        Optional<Customer> OptionalCustomer = customerRepository.findById(Long.valueOf(id));

        if(OptionalCustomer.isEmpty()) {
            log.error("Customer id not found. Id: " + id);
            throw new CustomerNotFoundException("Customer with ID ("+id+") is not found.");
        } else {
            Customer toDelete = OptionalCustomer.get();
            customerRepository.delete(toDelete);
            return true;
        }
    }

    @Override
    public Customer updateCustomer(Customer received, String id) {
        Customer updated = null;
        Optional<Customer> OptionalCustomer = customerRepository.findById(Long.valueOf(id));

        if(OptionalCustomer.isEmpty()){
            log.error("Customer id not found. Id: " + id);
            throw new CustomerNotFoundException("Customer with ID ("+id+") is not found.");
        } else {
            Customer found = customerRepository.findById(Long.valueOf(id)).get();
            found.setName(received.getName());

            updated = customerRepository.save(found);
        }
        return updated;
    }
}
