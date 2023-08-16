package com.x3t.lalit.appointment.service;

import com.x3t.lalit.appointment.model.Customer;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CustomerService {

    List<Customer> findAllCustomers();

    Customer saveCustomer(Customer customer);

    Customer getCustomer(String id);

    boolean deleteCustomer(String id);

    Customer updateCustomer(Customer customer, String id);

}
