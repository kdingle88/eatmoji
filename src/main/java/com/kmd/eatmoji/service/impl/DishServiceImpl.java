package com.kmd.eatmoji.service.impl;

import com.kmd.eatmoji.dto.DishDTO;
import com.kmd.eatmoji.dto.DishRatingDTO;
import com.kmd.eatmoji.exception.ResourceNotFoundException;
import com.kmd.eatmoji.models.Dish;
import com.kmd.eatmoji.models.EmojiRating;
import com.kmd.eatmoji.models.User;
import com.kmd.eatmoji.repository.DishRepository;
import com.kmd.eatmoji.repository.EmojiRatingRepository;
import com.kmd.eatmoji.repository.UserRepository;
import com.kmd.eatmoji.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;
    private final UserRepository userRepository;
    private final EmojiRatingRepository emojiRatingRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository, UserRepository userRepository, EmojiRatingRepository emojiRatingRepository) {
        this.dishRepository = dishRepository;
        this.userRepository = userRepository;
        this.emojiRatingRepository = emojiRatingRepository;
    }

    @Override
    public DishDTO findById(Long id) {

        Dish dish = this.dishRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        return new DishDTO(dish);
    }

    @Override
    public List<DishDTO> getUserDishes(String username) {
        return this.dishRepository
                .getAllDishesByUsername(username)
                .stream()
                .map(dish -> new DishDTO(dish))
                .collect(Collectors.toList());
    }

    @Override
    public DishDTO createDish(DishDTO dishDTO) {
        Dish dish = new Dish();
        User user = userRepository.findByUsername(dishDTO.getCreatorUsername())
                .orElseThrow(() -> new ResourceNotFoundException(dishDTO.getCreatorUsername()));

        dish.setCreator(user);
        dish.setName(dishDTO.getName());
        dish.setImageUrl(dishDTO.getImage_url());
        dish.setDescription(dishDTO.getDescription());
        dish.setCity(dishDTO.getCity());
        dish.setZip(dishDTO.getZip());

        dishRepository.save(dish);

        return new DishDTO(dish);

    }

    @Override
    public List<DishDTO> findAllDishes() {
        return this.dishRepository
                .findAll()
                .stream()
                .map(dish -> new DishDTO(dish))
                .collect(Collectors.toList());
    }

    @Override
    public DishDTO addRatings(DishRatingDTO dishRatingDTO) {
        Dish dish = dishRepository.findById(dishRatingDTO.getDishId())
                .orElseThrow(() -> new ResourceNotFoundException(dishRatingDTO.getDishId()));

        dishRatingDTO.getEmojiRatings().forEach(emoji -> {
            EmojiRating emojiRating = new EmojiRating();

            emojiRating.setColons(emoji);
            emojiRatingRepository.save(emojiRating);
        });

        dishRatingDTO.getEmojiRatings().forEach(emoji -> {
            EmojiRating savedEmojiRating = emojiRatingRepository.getEmojiRatingByColons(emoji);

            dish.getRatings().add(savedEmojiRating);
        });

        Dish updatedDish = dishRepository.save(dish);

        return new DishDTO(updatedDish);


    }
}
