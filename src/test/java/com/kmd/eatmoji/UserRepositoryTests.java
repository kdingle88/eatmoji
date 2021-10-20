package com.kmd.eatmoji;

import com.kmd.eatmoji.exception.ResourceNotFoundException;
import com.kmd.eatmoji.models.User;
import com.kmd.eatmoji.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTests {



    private final UserRepository userRepository;

    @Autowired
    public UserRepositoryTests(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveUserTest() {

        User user = new User();

        user.setName("Keith");
        user.setUsername("kdingle");
        user.setPassword("12345abcde");
        user.setCity("Chicago");
        user.setZip("353q2");
        user.setEmail("test@test.com");

        userRepository.save(user);

        User keith = userRepository.findByUsername("kdingle")
                .orElseThrow(() -> new ResourceNotFoundException("kdingle"));

        Assertions.assertEquals(keith.getUsername(), "kdingle");
    }

    @Test
    @Order(2)
    public void getUserTest() {
        User user = userRepository.findByUsername("kdingle")
                .orElseThrow(() -> new ResourceNotFoundException("kdingle"));


        Assertions.assertEquals(user.getUsername(), "kdingle");
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void updateUserTest() {
        User user = userRepository.findByUsername("kdingle")
                .orElseThrow(() -> new ResourceNotFoundException("kdingle"));


        user.setName("Bob");
        userRepository.save(user);

        Assertions.assertEquals(user.getName(), "Bob");
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void deleteUserTest() {
        User user = userRepository.findByUsername("kdingle")
                .orElseThrow(() -> new ResourceNotFoundException("kdingle"));

        userRepository.delete(user);

        List<User> users = userRepository.findAll();


        Assertions.assertEquals(users.isEmpty(), true);
    }
}
