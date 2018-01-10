package com.tony.admindashboard.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tony.admindashboard.models.Event;
import com.tony.admindashboard.repositories.EventRepository;

@Service
public class EventService {
	private EventRepository eventRepository;

	public EventService(EventRepository eventRepository){
		this.eventRepository = eventRepository;
	}

	public ArrayList<Event> all() {
		return (ArrayList<Event>)eventRepository.findAll();
	}

	public Event findById(long id){
		return eventRepository.findOne(id);
	}

	// public Event findByName(String name) {
	// 	return eventRepository.findByName(name);
	// }

	public void create(Event event) {
		System.out.println(event.getName());
		eventRepository.save(event);
	}

	public void update(Event event) {
		eventRepository.save(event);
	}

	public void destroy(long id) {
		eventRepository.delete(id);
	}
}
