package com.devsuperior.bds02.repositories;

import com.devsuperior.bds02.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends JpaRepository<City, Long> {}
