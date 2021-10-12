package com.kmd.eatmoji.service;

import com.kmd.eatmoji.models.Dish;
import com.kmd.eatmoji.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {

    private final DishRepository dishRepository;

    @Autowired
    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public ResponseEntity<List<Dish>> getAllDishes(String city) {

        try {
            List<Dish> dishes = new ArrayList<>();

            if (city == null) {
                dishRepository.findAll().forEach(dishes::add);

            } else {
                dishRepository.findByCityContaining(city).forEach(dishes::add);
            }
            if (dishes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(dishes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

