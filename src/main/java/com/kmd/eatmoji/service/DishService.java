package com.kmd.eatmoji.service;

import com.kmd.eatmoji.dto.DishDTO;

import java.util.List;


public interface DishService {


    DishDTO findById(Long id);

    List<DishDTO> getUserDishes(String username);

    DishDTO createDish(DishDTO dishDTO);
}

