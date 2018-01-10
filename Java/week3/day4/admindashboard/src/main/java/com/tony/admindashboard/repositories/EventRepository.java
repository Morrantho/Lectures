package com.tony.admindashboard.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tony.admindashboard.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
	// public Event findByEmail(String email);
}
