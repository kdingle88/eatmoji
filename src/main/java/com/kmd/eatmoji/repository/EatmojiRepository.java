package com.kmd.eatmoji.repository;

import com.kmd.eatmoji.models.Eatmoji;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EatmojiRepository extends JpaRepository<Eatmoji, Long> {
    @Query(value = "SELECT e FROM Eatmoji AS e WHERE e.user.username=:username")
    List<Eatmoji> getAllEatmojisByUsername(@Param("username") String username);

}