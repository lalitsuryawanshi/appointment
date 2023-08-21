package com.x3t.lalit.appointment.controller;

import com.x3t.lalit.appointment.exception.CompanyNotFoundException;
import com.x3t.lalit.appointment.exception.CustomerNotFoundException;
import com.x3t.lalit.appointment.exception.EngineerNotFoundException;
import com.x3t.lalit.appointment.model.ApiError;
import com.x3t.lalit.appointment.utils.ResponseEntityBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.x3t.lalit.appointment.utils.ResponseEntityBuilder.buildApiError;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<Object> handleCompanyNotFoundException(
            CompanyNotFoundException ex) {

        return ResponseEntityBuilder.build(buildApiError(ex, "Company not Found"));
    }

    @ExceptionHandler(EngineerNotFoundException.class)
    public ResponseEntity<Object> handleEngineerNotFoundException(
            EngineerNotFoundException ex) {

        return ResponseEntityBuilder.build(buildApiError(ex, "Engineer not Found"));
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object> handleCustomerNotFoundException(
            CustomerNotFoundException ex) {

        return ResponseEntityBuilder.build(buildApiError(ex, "Customer not Found"));
    }


}
