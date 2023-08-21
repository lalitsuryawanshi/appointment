package com.x3t.lalit.appointment.utils;

import com.x3t.lalit.appointment.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ResponseEntityBuilder {

    public static ResponseEntity<Object> build(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    public static ApiError buildApiError(Exception ex, String message) {

        List<String> details = new ArrayList<String>();
        details.add(ex.getMessage());

        return new ApiError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                message ,
                details);

    }

}
