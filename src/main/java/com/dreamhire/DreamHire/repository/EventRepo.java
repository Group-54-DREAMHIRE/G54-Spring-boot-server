package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event, Integer> {

}
