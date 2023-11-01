package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.SavedEvents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SavedEventsRepo extends JpaRepository<SavedEvents, Integer> {
    List<SavedEvents> getSavedEventsByCandidateId(int id);

    @Query(value = "DELETE FROM saved_events WHERE can_id = :id AND event_id=:eventId;", nativeQuery = true)
    void deleteSavedEvent(int id, int eventId);
}
