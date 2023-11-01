package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.dto.EventDTO;
import com.dreamhire.DreamHire.model.Company;
import com.dreamhire.DreamHire.model.Event;
import com.dreamhire.DreamHire.model.JobPost;
import com.dreamhire.DreamHire.repository.CompanyRepo;
import com.dreamhire.DreamHire.repository.CustomDataRepo;
import com.dreamhire.DreamHire.repository.EventRepo;
import com.dreamhire.DreamHire.repository.SystemUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin

@RestController

@RequestMapping("/api/v1/event")

public class EventController {

    @Autowired
    private SystemUserRepo systemUserRepo;

    @Autowired
    private CustomDataRepo customDataRepo;

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private CompanyRepo companyRepo;



    @PostMapping("/save/{id}")


    public ResponseEntity<?> saveEvent(@PathVariable int id, @RequestBody EventDTO eventDTO){
        Event event = new Event();
        event.setAuthor(systemUserRepo.findById(eventDTO.getSystemUserID()).get().getEmail());
        event.setCompanyName(eventDTO.getCompanyName());
        event.setTitle(eventDTO.getTitle());
        event.setCover(eventDTO.getCover());
        event.setStartTime(eventDTO.getStartTime());
        event.setEndTime(eventDTO.getEndTime());
        event.setDate(eventDTO.getDate());
        event.setCompany(companyRepo.findById(id));
        eventRepo.save(event);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @GetMapping("/getallevents")
    public ResponseEntity<List> getAllEvents(){
        List<Event> events = eventRepo.getAllValidateEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }
    @GetMapping(path = "/getEvent/{id}")
    public ResponseEntity<?> getEvent(@PathVariable int id){
        Event event = eventRepo.findById(id);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @GetMapping(path = "/getScheduledEvents/{id}")
    public ResponseEntity<?> getScheduledEvents(@PathVariable int id){
        List<Event> events = eventRepo.getAllEventsByComId(id);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }


}
