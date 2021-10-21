package com.kmd.eatmoji.repository;

import com.kmd.eatmoji.models.Dish;
import com.kmd.eatmoji.models.ERole;
import com.kmd.eatmoji.models.EmojiRating;
import com.kmd.eatmoji.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmojiRatingRepository extends JpaRepository<EmojiRating, Long> {
//    @Query(value = "SELECT er FROM EmojiRating AS er WHERE er.colons=:colons")
    EmojiRating getEmojiRatingByColons(@Param("rating") String colons);

}