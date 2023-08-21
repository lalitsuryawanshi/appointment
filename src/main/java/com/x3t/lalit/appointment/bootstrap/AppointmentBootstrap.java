package com.x3t.lalit.appointment.bootstrap;

import com.x3t.lalit.appointment.model.*;
import com.x3t.lalit.appointment.model.enums.Timeslot;
import com.x3t.lalit.appointment.repository.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AppointmentBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CustomerRepository customerRepository;
    private final SharedCalendarRepository sharedCalendarRepository;
    private final CompanyRepository companyRepository;
    private final EngineerRepository engineerRepository;
    private final AppointmentDateRepository appointmentDateRepository;

    private final AppointmentRepository appointmentRepository;


    public AppointmentBootstrap(CustomerRepository customerRepository,
                                SharedCalendarRepository sharedCalendarRepository,
                                CompanyRepository companyRepository,
                                EngineerRepository engineerRepository,
                                AppointmentDateRepository appointmentDateRepository,
                                AppointmentRepository appointmentRepository) {

        this.customerRepository = customerRepository;
        this.sharedCalendarRepository = sharedCalendarRepository;
        this.companyRepository = companyRepository;
        this.engineerRepository = engineerRepository;
        this.appointmentDateRepository = appointmentDateRepository;
        this.appointmentRepository = appointmentRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        List<SharedCalendar> cals = populateCalendar();
        sharedCalendarRepository.saveAll(cals);

        SharedCalendar calendarDate = sharedCalendarRepository.findById(1L).get();

        List<Company> companyList = companyRepository.saveAll(getCompanies());
        List<Customer> customers = customerRepository.saveAll(getCustomers());
        List<Engineer> engineers = engineerRepository.saveAll(getEngineers());


        AppointmentDate appointmentDate = new AppointmentDate();
        appointmentDate.setCalendarDate(calendarDate);

        appointmentDate = appointmentDateRepository.save(appointmentDate);

        Appointment appointment = new Appointment();
        appointment.setCompany(companyRepository.findById(1L).get());
        appointment.setCustomer(customerRepository.findById(1L).get());
        appointment.setTimeslot(Timeslot.AM);
        appointment.setEngineer1(engineerRepository.findById(1L).get());
        appointment.setEngineer2(engineerRepository.findById(2L).get());

        appointment = appointmentRepository.save(appointment);

        calendarDate.setCalendarDate(appointmentDate.getCalendarDate().getCalendarDate());

        appointmentDate.setCalendarDate(calendarDate);

        appointmentDate = appointmentDateRepository.save(appointmentDate);

        appointment.setAppointmentDate(appointmentDate);
        appointment = appointmentRepository.save(appointment);

        System.out.println("Appointment : "+appointment.getId());
    }

    private List<Company> getCompanies() {
        List<Company> companyList = new ArrayList<>();
        companyList.add(new Company(1L, "Company X"));
        return companyList;
    }

    private List<Customer> getCustomers(){
       List<Customer> customerList = new ArrayList<>();
       customerList.add(new Customer(1L, "John Customer"));
       customerList.add(new Customer(2L, "Jane Customer"));
       customerList.add(new Customer(3L, "Sam Customer"));
       return customerList;
    }

    private List<Engineer> getEngineers(){
        List<Engineer> engineerList = new ArrayList<>();
        engineerList.add(new Engineer(1L, "John Engineer"));
        engineerList.add(new Engineer(2L, "Jane Engineer"));
        engineerList.add(new Engineer(3L, "Sam Engineer"));
        return engineerList;
    }

    private List<SharedCalendar> populateCalendar(){

        List<SharedCalendar> calList = new ArrayList<>();

        SharedCalendar cal1 = new SharedCalendar();
        cal1.setCalendarDate(LocalDate.of(2023, 9, 1));

        SharedCalendar cal2 = new SharedCalendar();
        cal2.setCalendarDate(LocalDate.of(2023, 9, 2));

        SharedCalendar cal3 = new SharedCalendar();
        cal3.setCalendarDate(LocalDate.of(2023, 9, 3));

        SharedCalendar cal4 = new SharedCalendar();
        cal4.setCalendarDate(LocalDate.of(2023, 9, 4));

        SharedCalendar cal5 = new SharedCalendar();
        cal5.setCalendarDate(LocalDate.of(2023, 9, 5));

        SharedCalendar cal6 = new SharedCalendar();
        cal6.setCalendarDate(LocalDate.of(2023, 9, 6));

        SharedCalendar cal7 = new SharedCalendar();
        cal7.setCalendarDate(LocalDate.of(2023, 9, 7));

        SharedCalendar cal8 = new SharedCalendar();
        cal8.setCalendarDate(LocalDate.of(2023, 9, 8));

        SharedCalendar cal9 = new SharedCalendar();
        cal9.setCalendarDate(LocalDate.of(2023, 9, 9));

        SharedCalendar cal10 = new SharedCalendar();
        cal10.setCalendarDate(LocalDate.of(2023, 9, 10));

        calList.add(cal1);
        calList.add(cal2);
        calList.add(cal3);
        calList.add(cal4);
        calList.add(cal5);
        calList.add(cal6);
        calList.add(cal7);
        calList.add(cal8);
        calList.add(cal9);
        calList.add(cal10);

        return calList;
    }

}
