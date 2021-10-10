package com.devsuperior.bds02.repositories;

import com.devsuperior.bds02.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends JpaRepository<Event, Long> {}
