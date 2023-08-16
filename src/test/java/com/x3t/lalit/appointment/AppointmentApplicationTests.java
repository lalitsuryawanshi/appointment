package com.x3t.lalit.appointment;

import com.x3t.lalit.appointment.controller.CustomerController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AppointmentApplicationTests {

	@Autowired
	private CustomerController customerController;

	@Test
	void contextLoads() {
		assertThat(customerController).isNotNull();
	}

}
