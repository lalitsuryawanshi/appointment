package com.x3t.lalit.appointment.repository;

import com.x3t.lalit.appointment.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void findAllTest() {

        List<Customer> personList = customerRepository.findAll();
        assertEquals(personList.size(), 3);
    }

    @Test
    void findByIdTest() {

        Optional<Customer> customer = this.customerRepository.findById(2L);
        assertTrue(customer.isPresent());
    }

}
