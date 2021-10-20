package com.kmd.eatmoji.service;


import com.kmd.eatmoji.dto.*;

import java.util.List;

public interface UserService {

    UserDTO findByUsername(String username);

    List<FollowerDTO> getFollowers(String username);

    List<FollowingDTO> getFollowing(String username);

    List<EatmojiDTO> getBookmarks(String username);

    List<UserDTO> findAll();

    UserDTO convertAndSave(UserDTO userDTO);

    void deleteById(Long id);

    List<FollowingDTO> changeFollowing(FollowDTO followDTO);

    List<EatmojiDTO> changeBookmark(BookmarkDTO bookmarkDTO);




//    List<EatmojiDTO> getUserEatmojis(String username);
}
