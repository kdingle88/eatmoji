package com.kmd.eatmoji;

import com.kmd.eatmoji.exception.ResourceNotFoundException;
import com.kmd.eatmoji.models.Eatmoji;
import com.kmd.eatmoji.models.User;
import com.kmd.eatmoji.repository.EatmojiRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EatmojiRepositoryTests {

    private final EatmojiRepository eatmojiRepository;

    @Autowired
    public EatmojiRepositoryTests(EatmojiRepository eatmojiRepository) {
        this.eatmojiRepository = eatmojiRepository;
    }

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveEatmojiTest() {

        Eatmoji eatmoji = new Eatmoji();

        eatmoji.setName("Tasty Food");
        eatmoji.setImageUrl("www.tasty.com/img");

        eatmojiRepository.save(eatmoji);

        Eatmoji tasty = eatmojiRepository.findById(1L)
                .orElseThrow(() -> new ResourceNotFoundException(1L));

        Assertions.assertEquals(tasty.getId(), 1L);

    }

    @Test
    @Order(2)
    public void getEatmojiTest() {
        Eatmoji tasty = eatmojiRepository.findById(1L)
                .orElseThrow(() -> new ResourceNotFoundException(1L));

        Assertions.assertEquals(tasty.getId(), 1L);
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void updateEatmojiTest() {
        Eatmoji eatmoji = eatmojiRepository.findById(1L)
                .orElseThrow(() -> new ResourceNotFoundException(1L));


        eatmoji.setName("changed");
        eatmojiRepository.save(eatmoji);

        Assertions.assertEquals(eatmoji.getName(), "changed");
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void deleteEatmojiTest() {
        Eatmoji eatmoji = eatmojiRepository.findById(1L)
                .orElseThrow(() -> new ResourceNotFoundException(1L));

        eatmojiRepository.delete(eatmoji);

        List<Eatmoji> eatmojis = eatmojiRepository.findAll();


        Assertions.assertEquals(eatmojis.isEmpty(), true);
    }
}
