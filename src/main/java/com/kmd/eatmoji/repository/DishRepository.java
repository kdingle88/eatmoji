package com.kmd.eatmoji.repository;

import com.kmd.eatmoji.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    List<Dish> findByCityContaining(String city);

    @Query(value = "SELECT d FROM Dish AS d WHERE d.creator.username=:username")
    List<Dish> getAllDishesByUsername(@Param("username") String username);

}
