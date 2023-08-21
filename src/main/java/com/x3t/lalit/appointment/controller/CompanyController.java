package com.x3t.lalit.appointment.controller;

import com.x3t.lalit.appointment.exception.CompanyNotFoundException;
import com.x3t.lalit.appointment.model.Company;
import com.x3t.lalit.appointment.service.CompanyService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() throws CompanyNotFoundException {
       return new ResponseEntity<>(companyService.findAllCompanies(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable("id") String id)
            throws CompanyNotFoundException {

        return new ResponseEntity<>(companyService.getCompany(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Company> saveCompany(@Valid @RequestBody Company company)
            throws CompanyNotFoundException {
        return new ResponseEntity<>(companyService.saveCompany(company), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Company> updateCompany(@Valid @RequestBody Company company, @PathVariable("id") String id)
            throws CompanyNotFoundException{

        return new ResponseEntity<>(companyService.updateCompany(company, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteCompany(@PathVariable("id") String id)
            throws CompanyNotFoundException {

        return new ResponseEntity<>(companyService.deleteCompany(id), HttpStatus.ACCEPTED);
    }


}
