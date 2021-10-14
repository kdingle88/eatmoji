package com.kmd.eatmoji.service;

import com.kmd.eatmoji.models.Eatmoji;
import com.kmd.eatmoji.models.User;
import com.kmd.eatmoji.repository.UserRepository;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private ModelMapper mapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }


    public List<User> getUsers(String username) {

        List<User> users = new ArrayList<User>();

        if (username == null) {
            userRepository.findAll().forEach(users::add);

        } else {
            userRepository.findByUsernameContaining(username).forEach(users::add);
        }

        return users;

    }


    public User getUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return user;

    }

    public ResponseEntity<List<Eatmoji>> getUserEatmojis(String username) {

        try {

            User user = this.getUserByUsername(username);

            List<Eatmoji> userEatmojis = user.getEatmojis();


            if (userEatmojis.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(userEatmojis, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<Set<User>> getUserFollowers(String username) {

        try {
            User user = this.getUserByUsername(username);

            Set<User> followers = user.getFollowers();

            if (followers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(followers, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<Set<User>> getUserFollowing(String username) {

        try {
            User user = this.getUserByUsername(username);

            Set<User> following = user.getFollowing();

            if (following.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(following, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Set<Eatmoji>> getUserBookmarks(String username) {
        try {
            User user = this.getUserByUsername(username);

            Set<Eatmoji> bookmarks = user.getBookmarks();

            if (bookmarks.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(bookmarks, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public User getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User Not Found with userId: " + userId));

        return user;

    }
}
