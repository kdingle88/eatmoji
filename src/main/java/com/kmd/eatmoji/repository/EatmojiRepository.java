package com.kmd.eatmoji.repository;

import com.kmd.eatmoji.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EatmojiRepository extends JpaRepository<User, Long> {

}