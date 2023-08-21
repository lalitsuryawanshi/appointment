package com.x3t.lalit.appointment.service.impl;

import com.x3t.lalit.appointment.exception.CompanyNotFoundException;
import com.x3t.lalit.appointment.model.Company;
import com.x3t.lalit.appointment.repository.CompanyRepository;
import com.x3t.lalit.appointment.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company getCompany(String id) {

        return companyRepository.findById(Long.valueOf(id))
                .orElseThrow( ()
                                -> new CompanyNotFoundException(
                                "Company with ID ("+id+") is not found.")
                );
    }

    @Override
    public boolean deleteCompany(String id) {

        Optional<Company> OptionalCompany = companyRepository.findById(Long.valueOf(id));

        if (OptionalCompany.isEmpty()) {
            log.error("Company id not found. Id: " + id);
            throw new CompanyNotFoundException("Company with ID ("+id+") is not found.");
        } else {
            Company toDelete = OptionalCompany.get();
            companyRepository.delete(toDelete);
            return true;
        }
    }

    @Override
    public Company updateCompany(Company received, String id) {
        Company updated = null;
        Optional<Company> OptionalCompany = companyRepository.findById(Long.valueOf(id));

        if (OptionalCompany.isEmpty()) {
            log.error("Company id not found. Id: " + id);
            throw new CompanyNotFoundException("Company with ID ("+id+") is not found.");
        } else {
            Company found = companyRepository.findById(Long.valueOf(id)).get();
            found.setName(received.getName());
            updated = companyRepository.save(found);
        }
        return updated;
    }
}
