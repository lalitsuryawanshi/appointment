package com.x3t.lalit.appointment.repository;

import com.x3t.lalit.appointment.model.Appointment;
import com.x3t.lalit.appointment.model.AppointmentDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentDateRepository extends JpaRepository<AppointmentDate, Long> {

}
