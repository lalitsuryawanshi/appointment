package com.x3t.lalit.appointment.utils;

import com.x3t.lalit.appointment.model.ApiError;
import org.springframework.http.ResponseEntity;

public class ResponseEntityBuilder {

    public static ResponseEntity<Object> build(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}
