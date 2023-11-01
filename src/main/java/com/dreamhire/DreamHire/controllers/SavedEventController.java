package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.dto.SavedEventsDTO;
import com.dreamhire.DreamHire.model.SavedEvents;
import com.dreamhire.DreamHire.repository.CandidateRepo;
import com.dreamhire.DreamHire.repository.EventRepo;
import com.dreamhire.DreamHire.repository.SavedEventsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/savedEvents")
public class SavedEventController {
    @Autowired
    private SavedEventsRepo savedEventsRepo;
    @Autowired
    private EventRepo eventRepo;
    @Autowired
    private CandidateRepo candidateRepo;

    @PostMapping(path = "/save/{id}")
    public ResponseEntity<?> saveEvent(@PathVariable int id, @RequestBody SavedEventsDTO savedEvent) {
        SavedEvents savedEvents = new SavedEvents();
        savedEvents.setEvent(eventRepo.findById(savedEvent.getEventId()));
        savedEvents.setCandidate(candidateRepo.findById(id));
        savedEventsRepo.save(savedEvents);
        return new ResponseEntity<>("Successfully saved", HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable int id){
        savedEventsRepo.deleteById(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    @GetMapping(path = "/getAll/{id}")
    public ResponseEntity<?> getSavedEvents(@PathVariable int id){
        List<SavedEvents> savedEvents = savedEventsRepo.getSavedEventsByCandidateId(id);
        return new ResponseEntity<>(savedEvents, HttpStatus.OK);
    }
}
