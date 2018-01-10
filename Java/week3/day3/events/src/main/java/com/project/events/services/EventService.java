package com.project.events.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.project.events.models.Event;
import com.project.events.repositories.EventRepository;

@Service
public class EventService {
	private EventRepository eventRepository;
	
	public EventService(EventRepository eventRepository){
		this.eventRepository=eventRepository;
	}

	public ArrayList<Event> all() {
		return (ArrayList<Event>) eventRepository.findAll();
	}

	public Event findById(long id) {
		return (Event) eventRepository.findOne(id);
	}

	public void create(Event event) {
		eventRepository.save(event);
	}

	public void update(Event event) {
		eventRepository.save(event);
	}

	public void destroy(long id) {
		eventRepository.delete(id);
	}
}
