package com.devsuperior.bds02.controllers;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.services.EventService;
import javax.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/events")
public class EventController {

  private final EventService eventService;

  public EventController(EventService eventService) {
    this.eventService = eventService;
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<EventDTO> update(@PathVariable Long id, @RequestBody EventDTO evt) {

    try {
      EventDTO result = eventService.updaate(evt, id);

      return ResponseEntity.ok().body(result);

    } catch (EntityNotFoundException e) {
      return ResponseEntity.notFound().build();

    } catch (DataIntegrityViolationException e) {
      return ResponseEntity.badRequest().build();
    }
  }
}
