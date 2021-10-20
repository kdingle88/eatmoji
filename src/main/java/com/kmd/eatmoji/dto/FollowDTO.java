package com.kmd.eatmoji.dto;

import com.google.common.base.Objects;

public class FollowDTO {

    private String currentUser;
    private String userToFollow;

    public FollowDTO(String currentUser, String userToFollow) {
        this.currentUser = currentUser;
        this.userToFollow = userToFollow;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public String getUserToFollow() {
        return userToFollow;
    }

    public void setUserToFollow(String userToFollow) {
        this.userToFollow = userToFollow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FollowDTO followDTO = (FollowDTO) o;
        return Objects.equal(currentUser, followDTO.currentUser) && Objects.equal(userToFollow, followDTO.userToFollow);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(currentUser, userToFollow);
    }

    @Override
    public String toString() {
        return "FollowDTO{" +
                "currentUser='" + currentUser + '\'' +
                ", userToFollow='" + userToFollow + '\'' +
                '}';
    }
}
