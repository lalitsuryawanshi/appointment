package com.x3t.lalit.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.x3t.lalit.appointment.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
