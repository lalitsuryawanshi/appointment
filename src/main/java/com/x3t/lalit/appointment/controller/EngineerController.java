package com.x3t.lalit.appointment.controller;

import com.x3t.lalit.appointment.exception.EngineerNotFoundException;
import com.x3t.lalit.appointment.model.Engineer;
import com.x3t.lalit.appointment.service.EngineerService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/engineers")
public class EngineerController {

    private final EngineerService engineerService;

    public EngineerController(EngineerService engineerService) {
        this.engineerService = engineerService;
    }

    @GetMapping
    public ResponseEntity<List<Engineer>> getAllEngineers()
            throws EngineerNotFoundException {
       return new ResponseEntity<>(engineerService.findAllEngineers(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Engineer> getEngineer(@PathVariable("id") String id)
            throws EngineerNotFoundException {

        return new ResponseEntity<>(engineerService.getEngineer(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Engineer> saveEngineer(@Valid @RequestBody Engineer engineer)
            throws EngineerNotFoundException {
        return new ResponseEntity<>(engineerService.saveEngineer(engineer), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Engineer> updateCompany(@Valid @RequestBody Engineer engineer,
                                                  @PathVariable("id") String id)
            throws EngineerNotFoundException {

        return new ResponseEntity<>(engineerService.updateEngineer(engineer, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteEngineer(@PathVariable("id") String id)
            throws EngineerNotFoundException{

        return new ResponseEntity<>(engineerService.deleteEngineer(id), HttpStatus.ACCEPTED);
    }


}
