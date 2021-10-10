package com.devsuperior.bds02.services;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repositories.CityRepo;
import com.devsuperior.bds02.repositories.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

  @Autowired private EventRepo eventRepo;

  @Autowired private CityRepo city;

  public EventDTO updaate(EventDTO event, Long id) {

    Event evt = eventRepo.getOne(id);
    evt.setEvent(event.getName(), event.getDate(), event.getUrl(), city.getOne(event.getCityId()));

    return new EventDTO(eventRepo.save(evt));
  }
  ;
}
