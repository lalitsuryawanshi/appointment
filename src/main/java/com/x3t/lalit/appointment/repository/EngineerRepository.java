package com.x3t.lalit.appointment.repository;

import com.x3t.lalit.appointment.model.Engineer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineerRepository extends JpaRepository<Engineer, Long> {

}
