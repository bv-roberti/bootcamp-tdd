package com.devsuperior.bds02.controllers;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.services.CityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cities")
public class CityController {

  @Autowired private CityService cityService;

  @GetMapping
  public ResponseEntity<List<CityDTO>> findAll() {

    return ResponseEntity.ok().body(cityService.findAll());
  }
  ;

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<CityDTO> delete(@PathVariable Long id) {

    try {
      cityService.delete(id);

      return ResponseEntity.noContent().build();

    } catch (EmptyResultDataAccessException e) {
      return ResponseEntity.notFound().build();
    } catch (DataIntegrityViolationException e) {
      return ResponseEntity.badRequest().build();
    }
  }
  ;
}
