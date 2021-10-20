package com.kmd.eatmoji;

import com.kmd.eatmoji.exception.ResourceNotFoundException;
import com.kmd.eatmoji.models.Dish;
import com.kmd.eatmoji.models.Eatmoji;
import com.kmd.eatmoji.repository.DishRepository;
import com.kmd.eatmoji.repository.EatmojiRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DishRepositoryTests {

    private final DishRepository dishRepository;

    @Autowired
    public DishRepositoryTests(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveDishTest() {

        Dish dish = new Dish();

        dish.setName("Pizza");
        dish.setImageUrl("pizza.edu/cheese");
        dish.setCity("Chicago");
        dish.setZip("343423");

        dishRepository.save(dish);

        Dish pizza = dishRepository.findById(1L)
                .orElseThrow(() -> new ResourceNotFoundException(1L));

        Assertions.assertEquals(pizza.getId(), 1L);

    }

    @Test
    @Order(2)
    public void getDishTest() {
        Dish pizza = dishRepository.findById(1L)
                .orElseThrow(() -> new ResourceNotFoundException(1L));

        Assertions.assertEquals(pizza.getId(), 1L);
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void updateDishTest() {
        Dish dish = dishRepository.findById(1L)
                .orElseThrow(() -> new ResourceNotFoundException(1L));


        dish.setName("sausage");
        dishRepository.save(dish);

        Assertions.assertEquals(dish.getName(), "sausage");
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void deleteDishTest() {
        Dish dish = dishRepository.findById(1L)
                .orElseThrow(() -> new ResourceNotFoundException(1L));

        dishRepository.delete(dish);

        List<Dish> dishes = dishRepository.findAll();


        Assertions.assertEquals(dishes.isEmpty(), true);
    }
}
