package com.devsuperior.bds02.services;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepo;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CityService {

  @Autowired private CityRepo cityRepo;

  public List<CityDTO> findAll() {
    return cityRepo.findAll(Sort.by("name")).stream()
        .map(a -> new CityDTO(a))
        .collect(Collectors.toList());
  }

  public CityDTO create(CityDTO city) {

    City newCity = new City();
    newCity.setName(city.getName());

    return new CityDTO(cityRepo.save(newCity));
  }

  public void delete(Long id) {
    cityRepo.deleteById(id);
  }
}
