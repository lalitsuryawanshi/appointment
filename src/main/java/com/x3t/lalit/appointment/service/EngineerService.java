package com.x3t.lalit.appointment.service;

import org.springframework.stereotype.Service;
import com.x3t.lalit.appointment.model.Engineer;
import java.util.List;

@Service
public interface EngineerService {

    List<Engineer> findAllEngineers();

    Engineer saveEngineer(Engineer engineer);

    Engineer getEngineer(String id);

    boolean deleteEngineer(String id);

    Engineer updateEngineer(Engineer engineer, String id);

}
