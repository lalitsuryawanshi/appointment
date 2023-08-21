package com.x3t.lalit.appointment.service.impl;

import com.x3t.lalit.appointment.exception.EngineerNotFoundException;
import com.x3t.lalit.appointment.model.Engineer;
import com.x3t.lalit.appointment.repository.EngineerRepository;
import com.x3t.lalit.appointment.service.EngineerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EngineerServiceImpl implements EngineerService {

    private final EngineerRepository engineerRepository;

    public EngineerServiceImpl(EngineerRepository engineerRepository) {
        this.engineerRepository = engineerRepository;
    }

    @Override
    public List<Engineer> findAllEngineers() {
        return engineerRepository.findAll();
    }

    @Override
    public Engineer saveEngineer(Engineer engineer) {
        return engineerRepository.save(engineer);
    }

    @Override
    public Engineer getEngineer(String id) {

        Optional<Engineer> OptionalEngineer = engineerRepository.findById(Long.valueOf(id));

        if(OptionalEngineer.isEmpty()) {
            log.error("Engineer id not found. Id: " + id);
            throw new EngineerNotFoundException("Engineer with ID ("+id+") is not found.");
        }
        return OptionalEngineer.get();
    }

    @Override
    public boolean deleteEngineer(String id) {

        Optional<Engineer> OptionalEngineer = engineerRepository.findById(Long.valueOf(id));

        if(OptionalEngineer.isEmpty()) {
            log.error("Engineer id not found. Id: " + id);
            throw new EngineerNotFoundException("Engineer with ID ("+id+") is not found.");
        } else {
            Engineer toDelete = OptionalEngineer.get();
            engineerRepository.delete(toDelete);
            return true;
        }
    }

    @Override
    public Engineer updateEngineer(Engineer received, String id) {
        Engineer updated = null;
        Optional<Engineer> OptionalEngineer = engineerRepository.findById(Long.valueOf(id));

        if(OptionalEngineer.isEmpty()) {
            log.error("Engineer id not found. Id: " + id);
            throw new EngineerNotFoundException("Engineer with ID ("+id+") is not found.");
        } else {
            Engineer found = engineerRepository.findById(Long.valueOf(id)).get();
            found.setName(received.getName());
            updated = engineerRepository.save(found);
        }
        return updated;
    }
}
