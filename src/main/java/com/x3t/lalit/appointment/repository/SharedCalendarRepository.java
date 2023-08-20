package com.x3t.lalit.appointment.repository;

import com.x3t.lalit.appointment.model.AppointmentDate;
import com.x3t.lalit.appointment.model.SharedCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SharedCalendarRepository extends JpaRepository<SharedCalendar, Long> {


}
