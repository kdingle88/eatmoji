package com.kmd.eatmoji.controllers;

import com.kmd.eatmoji.dto.UserDTO;
import com.kmd.eatmoji.models.Eatmoji;
import com.kmd.eatmoji.models.User;
import com.kmd.eatmoji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/users")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers(@RequestParam(required = false) String username) {


        List<User> users = userService.getUsers(username);

        List<UserDTO> usersDTO = new ArrayList<>();

        users.forEach(user -> {
            UserDTO userDTO = new UserDTO(user);

            usersDTO.add(userDTO);
        });

        if (usersDTO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(usersDTO, HttpStatus.OK);
    }



    @GetMapping("{username}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String username) {
        User user = userService.getUserByUsername(username);

        UserDTO userDTO = new UserDTO(user);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);

    }


    @GetMapping("{username}/eatmojis")
    public ResponseEntity<List<Eatmoji>> getUserEatmojis(@PathVariable String username) {

        return userService.getUserEatmojis(username);
    }





    // Delete Mapping eatmojis

    @GetMapping("{username}/bookmarks")
    public ResponseEntity<Set<Eatmoji>> getUserBookmarks(@PathVariable String username) {

        return userService.getUserBookmarks(username);
    }

    @GetMapping("{username}/followers")
    public ResponseEntity<Set<User>> getUserFollowers(@PathVariable String username) {

        return userService.getUserFollowers(username);
    }

    @GetMapping("{username}/following")
    public ResponseEntity<Set<User>> getUserFollowing(@PathVariable String username) {

        return userService.getUserFollowing(username);
    }


}
