package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.Event;
import com.dreamhire.DreamHire.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepo extends JpaRepository<Event, Integer> {
<<<<<<< HEAD

    @Query(value = "SELECT * FROM events WHERE validate=true  ", nativeQuery = true)
    List<Event> getAllValidateEvents();

=======
    Event findById(int id);
    @Query(value = "SELECT * FROM events WHERE validate=true ", nativeQuery = true)
    List<Event> getAllValidateEvents();
>>>>>>> nishan
}
