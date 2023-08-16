package com.x3t.lalit.appointment.service.impl;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    public Optional<String> getCurrentAuditor() {
        return Optional.of("SYSTEM"); //TODO to be replaced by spring security user
    }

}
