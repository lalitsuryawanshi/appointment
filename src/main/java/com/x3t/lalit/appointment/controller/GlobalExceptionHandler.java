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

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    //TODO need to refactor to reduce repeating code
    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<Object> handleCompanyNotFoundException(
            CompanyNotFoundException ex) {

        List<String> details = new ArrayList<String>();
        details.add(ex.getMessage());

        ApiError err = new ApiError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                "Company Not Found" ,
                details);

        return ResponseEntityBuilder.build(err);
    }

    @ExceptionHandler(EngineerNotFoundException.class)
    public ResponseEntity<Object> handleEngineerNotFoundException(
            EngineerNotFoundException ex) {

        List<String> details = new ArrayList<String>();
        details.add(ex.getMessage());

        ApiError err = new ApiError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                "Engineer Not Found" ,
                details);

        return ResponseEntityBuilder.build(err);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object> handleCustomerNotFoundException(
            CustomerNotFoundException ex) {

        List<String> details = new ArrayList<String>();
        details.add(ex.getMessage());

        ApiError err = new ApiError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                "Customer Not Found" ,
                details);

        return ResponseEntityBuilder.build(err);
    }
}
