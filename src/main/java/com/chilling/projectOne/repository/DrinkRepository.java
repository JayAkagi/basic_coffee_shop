package com.chilling.projectOne.repository;

import com.chilling.projectOne.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
    List<Drink> findByIsActiveTrue();
}
