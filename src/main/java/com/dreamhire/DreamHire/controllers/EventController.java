package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.dto.EventDTO;
import com.dreamhire.DreamHire.model.Company;
import com.dreamhire.DreamHire.model.Event;
import com.dreamhire.DreamHire.repository.CompanyRepo;
import com.dreamhire.DreamHire.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/event")
public class EventController {
    @Autowired
    private EventRepo eventRepo;
    @Autowired
    private CompanyRepo companyRepo;

    @PostMapping(path = "/save/{id}")
    public ResponseEntity<?> saveEvent(@PathVariable int id, @RequestBody EventDTO eventDTO){
        Event event = new Event(eventDTO);
        event.setCompany(companyRepo.findById(eventDTO.getCompanyID()));
        eventRepo.save(event);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }
}
