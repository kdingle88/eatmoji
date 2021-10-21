package com.kmd.eatmoji.service;

import com.kmd.eatmoji.dto.DishDTO;
import com.kmd.eatmoji.dto.DishRatingDTO;

import java.util.List;


public interface DishService {


    DishDTO findById(Long id);

    List<DishDTO> getUserDishes(String username);

    DishDTO createDish(DishDTO dishDTO);


    List<DishDTO> findAllDishes();

    DishDTO addRatings(DishRatingDTO dishRatingDTO);
}

