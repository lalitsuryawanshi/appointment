package com.x3t.lalit.appointment.service;

import com.x3t.lalit.appointment.exception.CustomerNotFoundException;
import com.x3t.lalit.appointment.model.Customer;
import com.x3t.lalit.appointment.repository.CustomerRepository;
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
            throw new CustomerNotFoundException("Customer Not Found");
        }
        return OptionalCustomer.get();
    }

    @Override
    public boolean deleteCustomer(String id) {

        Optional<Customer> OptionalCustomer = customerRepository.findById(Long.valueOf(id));

        if(OptionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Customer Not Found");
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
        if(OptionalCustomer.isPresent()){
            Customer found = customerRepository.findById(Long.valueOf(id)).get();
            found.setName(received.getName());
            found.setEmail(received.getEmail());
            found.setPhone(received.getPhone());
            found.setAddress(received.getAddress());

            updated = customerRepository.save(found);
        }
        return updated;
    }
}
