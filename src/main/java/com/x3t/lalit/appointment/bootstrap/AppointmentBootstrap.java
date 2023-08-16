package com.x3t.lalit.appointment.bootstrap;

import com.x3t.lalit.appointment.model.TimeslotAM;
import com.x3t.lalit.appointment.repository.CustomerRepository;
import com.x3t.lalit.appointment.model.Customer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppointmentBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CustomerRepository customerRepository;

    public AppointmentBootstrap(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        customerRepository.saveAll(getCustomers());
    }

    private List<Customer> getCustomers(){
       List<Customer> customerList = new ArrayList<>();
       customerList.add(new Customer(1L, "John Doe", "jdoe@email.com", "123456", "Cork"));
       customerList.add(new Customer(2L, "Jane Doe", "jane@email.com", "234567", "Dublin"));
       customerList.add(new Customer(3L, "Sam Joe", "sjoe@email.com", "345678", "Limerick"));
       return customerList;
    }

    private TimeslotAM getTimeslotAM(){
        TimeslotAM timeslotAM = new TimeslotAM();

        return  timeslotAM;
    }
}
