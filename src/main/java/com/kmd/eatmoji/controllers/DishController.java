package com.kmd.eatmoji.controllers;

import com.kmd.eatmoji.dto.DishDTO;
import com.kmd.eatmoji.models.Dish;
import com.kmd.eatmoji.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/dishes")
@RestController
public class DishController {

    private final DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping()
    public DishDTO createDish(@RequestBody DishDTO dishDTO) {

        return this.dishService.createDish(dishDTO);
    }

    @GetMapping("{id}")
    public DishDTO findById(@PathVariable Long id) {


        return this.dishService.findById(id);
    }


}
