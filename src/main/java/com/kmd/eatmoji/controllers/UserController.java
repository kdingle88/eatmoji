package com.kmd.eatmoji.controllers;

import com.kmd.eatmoji.models.Eatmoji;
import com.kmd.eatmoji.models.User;
import com.kmd.eatmoji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String username) {

        return userService.getAllUsers(username);
    }

    @GetMapping("{username}")
    public User getUser(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("{username}/eatmojis")
    public ResponseEntity<List<Eatmoji>> getUserEatmojis(@PathVariable String username) {

        return userService.getUserEatmojis(username);
    }

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
