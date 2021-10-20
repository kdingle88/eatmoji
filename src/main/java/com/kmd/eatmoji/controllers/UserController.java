package com.kmd.eatmoji.controllers;

import com.kmd.eatmoji.dto.*;
import com.kmd.eatmoji.models.Eatmoji;
import com.kmd.eatmoji.models.User;
import com.kmd.eatmoji.service.DishService;
import com.kmd.eatmoji.service.EatmojiService;
import com.kmd.eatmoji.service.OldUserService;
import com.kmd.eatmoji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private final EatmojiService eatmojiService;
    private final DishService dishService;

    @Autowired
    public UserController(UserService userService, EatmojiService eatmojiService, DishService dishService) {
        this.userService = userService;
        this.eatmojiService = eatmojiService;
        this.dishService = dishService;
    }

    //    @GetMapping
//    public ResponseEntity<List<UserDTO>> getUsers(@RequestParam(required = false) String username) {
//
//
//        List<User> users = userService.getUsers(username);
//
//        List<UserDTO> usersDTO = new ArrayList<>();
//
//        users.forEach(user -> {
//            UserDTO userDTO = new UserDTO(user);
//
//            usersDTO.add(userDTO);
//        });
//
//        if (usersDTO.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//
//        return new ResponseEntity<>(usersDTO, HttpStatus.OK);
//    }



    @GetMapping("{username}")
    public UserDTO getUser(@PathVariable String username) {

        return this.userService.findByUsername(username);

    }


    @GetMapping("{username}/eatmojis")
    public List<EatmojiDTO> getUserEatmojis(@PathVariable String username) {

        return this.eatmojiService.getUserEatmojis(username);
    }

    @GetMapping("{username}/followers")
    public List<FollowerDTO> getFollowers(@PathVariable String username) {

        return this.userService.getFollowers(username);
    }

    @GetMapping("{username}/following")
    public List<FollowingDTO> getFollowing(@PathVariable String username) {

        return this.userService.getFollowing(username);
    }

    @GetMapping("{username}/bookmarks")
    public List<EatmojiDTO> getBookmarks(@PathVariable String username) {

        return this.userService.getBookmarks(username);
    }

    @GetMapping("{username}/dishes")
    public List<DishDTO> getDishes(@PathVariable String username) {

        return this.dishService.getUserDishes(username);
    }



    @PutMapping("changefollowing")
    public List<FollowingDTO> changeFollowing(@RequestBody FollowDTO followDTO ) {

        return this.userService.changeFollowing(followDTO);
    }

    @PutMapping("changebookmark")
    public List<EatmojiDTO> changeBookmarks(@RequestBody BookmarkDTO bookmarkDTO ) {

        return this.userService.changeBookmark(bookmarkDTO);
    }





    // Delete Mapping eatmojis

//    @GetMapping("{username}/bookmarks")
//    public ResponseEntity<Set<Eatmoji>> getUserBookmarks(@PathVariable String username) {
//
//        return userService.getUserBookmarks(username);
//    }
//
//    @GetMapping("{username}/followers")
//    public ResponseEntity<Set<User>> getUserFollowers(@PathVariable String username) {
//
//        return userService.getUserFollowers(username);
//    }
//
//    @GetMapping("{username}/following")
//    public ResponseEntity<Set<User>> getUserFollowing(@PathVariable String username) {
//
//        return userService.getUserFollowing(username);
//    }


}
