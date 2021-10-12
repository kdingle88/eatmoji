package com.kmd.eatmoji.controllers;

import com.kmd.eatmoji.models.User;
import com.kmd.eatmoji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    private final UserService userService;

    @Autowired
    public TestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String allAccess() {
        return "Public Feed.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MAKER') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Dish Feed.";
    }

    @GetMapping("/maker")
    @PreAuthorize("hasRole('MAKER')")
    public String restaurantAccess() {
        return "MAKER menu where makers can CRUD their that will be available in Eatmoji description section.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin page. May not need this in real app";
    }

    @GetMapping("/authpoint")
    public User returnCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {

        User currentUser = userService.getUserByUsername(userDetails.getUsername());

        return currentUser;
    }
}
