package com.x3t.lalit.appointment.service;

import com.x3t.lalit.appointment.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {

    List<Company> findAllCompanies();

    Company saveCompany(Company company);

    Company getCompany(String id);

    boolean deleteCompany(String id);

    Company updateCompany(Company company, String id);

}
