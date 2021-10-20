package com.kmd.eatmoji.service.impl;

import com.kmd.eatmoji.dto.*;
import com.kmd.eatmoji.exception.ResourceNotFoundException;
import com.kmd.eatmoji.models.Eatmoji;
import com.kmd.eatmoji.models.User;
import com.kmd.eatmoji.repository.EatmojiRepository;
import com.kmd.eatmoji.repository.UserRepository;
import com.kmd.eatmoji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EatmojiRepository eatmojiRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, EatmojiRepository eatmojiRepository) {
        this.userRepository = userRepository;
        this.eatmojiRepository = eatmojiRepository;
    }
    //    @Override
//    public UserDTO findById(Long id) {
//        return null;
//    }

    @Override
    public UserDTO findByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException(username));

        return new UserDTO(user);
    }

    public List<FollowerDTO> getFollowers(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException(username));

        return user.getFollowers()
                .stream()
                .map(follower -> new FollowerDTO(follower))
                .collect(Collectors.toList());
    }

    public List<FollowingDTO> getFollowing(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException(username));

        return user.getFollowing()
                .stream()
                .map(follow -> new FollowingDTO(follow))
                .collect(Collectors.toList());

    }

    public List<EatmojiDTO> getBookmarks(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException(username));

        return user.getBookmarks()
                .stream()
                .map(bookmark -> new EatmojiDTO(bookmark))
                .collect(Collectors.toList());


    }


    public List<FollowingDTO> changeFollowing(FollowDTO followDTO) {
        String currentUserName = followDTO.getCurrentUser();
        String userToFollowName = followDTO.getUserToFollow();

        User currentUser = userRepository.findByUsername(currentUserName)
                .orElseThrow(() -> new ResourceNotFoundException(currentUserName));

        User userToFollow = userRepository.findByUsername(userToFollowName)
                .orElseThrow(() -> new ResourceNotFoundException(userToFollowName));

        System.out.println(currentUserName);
        System.out.println(userToFollowName);
        System.out.println(currentUser.getFollowing().contains(userToFollow));

        if (currentUser.getFollowing().contains(userToFollow)) {

            currentUser.removeFollowing(userToFollow);
        } else {
            currentUser.addFollowing(userToFollow);
        }
        User updatedUserToFollow = userRepository.save(userToFollow);
        User updatedCurrentUser = userRepository.save(currentUser);


        return updatedCurrentUser.getFollowing()
                .stream()
                .map(follow -> new FollowingDTO(follow))
                .collect(Collectors.toList());
    }

    @Override
    public List<EatmojiDTO> changeBookmark(BookmarkDTO bookmarkDTO) {
        User currentUser = userRepository.findByUsername(bookmarkDTO.getCurrentUser())
                .orElseThrow(() -> new ResourceNotFoundException(bookmarkDTO.getCurrentUser()));

        Eatmoji bookmarkedEatmoji = eatmojiRepository.findById(bookmarkDTO.getEatmojiToBookmark())
                .orElseThrow(() -> new ResourceNotFoundException(bookmarkDTO.getEatmojiToBookmark()));

        System.out.println(bookmarkDTO.getCurrentUser());
        System.out.println(bookmarkDTO.getEatmojiToBookmark());
        System.out.println(currentUser.getBookmarks().contains(bookmarkedEatmoji));

        if (currentUser.getBookmarks().contains(bookmarkedEatmoji)) {

            currentUser.removeBookmark(bookmarkedEatmoji);
            bookmarkedEatmoji.removeBookmarkedUser(currentUser);
        } else {
            currentUser.addBookmark(bookmarkedEatmoji);
            bookmarkedEatmoji.addBookmarkedUser(currentUser);
        }
        User updatedCurrentUser = userRepository.save(currentUser);
        Eatmoji updatedEatmoji = eatmojiRepository.save(bookmarkedEatmoji);


        return updatedCurrentUser.getBookmarks()
                .stream()
                .map(bookmark -> new EatmojiDTO(bookmark))
                .collect(Collectors.toList());
    }


    @Override
    public List<UserDTO> findAll() {
        return null;
    }

    @Override
    public UserDTO convertAndSave(UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
