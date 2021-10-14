package com.kmd.eatmoji.dto;

import com.google.common.base.Objects;
import com.kmd.eatmoji.models.User;

import java.util.*;

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String city;
    private String zip;
    private Date createdOn;
    private Date modifiedOn;
    private Set<String> roles = new HashSet<>();
    private List<Long> eatmojis = new ArrayList<>();
    private List<Long> dishes = new ArrayList<>();
    private List<Long> emojiRatings = new ArrayList<>();
    private Set<Long> bookmarks = new HashSet<>();
    private Set<Long> followers = new HashSet<>();
    private Set<Long> following = new HashSet<>();

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.city = user.getCity();
        this.zip = user.getZip();
        this.createdOn = user.getCreatedOn();
        this.modifiedOn = user.getModifiedOn();

        Set<String> roles = new HashSet<>();
        user.getRoles().forEach(role -> roles.add(role.getName().name()));

        this.setRoles(roles);

        List<Long> eatmojis = new ArrayList<>();
        user.getEatmojis().forEach(eatmoji -> eatmojis.add(eatmoji.getId()));

        this.setEatmojis(eatmojis);

        List<Long> dishes = new ArrayList<>();
        user.getDishes().forEach(dish -> dishes.add(dish.getId()));

        this.setDishes(dishes);

        List<Long> emojiRating = new ArrayList<>();
        user.getEmojiRatings().forEach(rating -> emojiRating.add(rating.getId()));

        this.setEmojiRatings(emojiRatings);

        Set<Long> bookmarks = new HashSet<>();
        user.getBookmarks().forEach(bookmark -> bookmarks.add(bookmark.getId()));

        this.setBookmarks(bookmarks);

        Set<Long> followers = new HashSet<>();
        user.getFollowers().forEach(follower -> followers.add(follower.getId()));

        this.setFollowers(followers);

        Set<Long> following = new HashSet<>();
        user.getFollowing().forEach(follow -> following.add(follow.getId()));

        this.setFollowing(following);

    }

    public User toEntity() {
        User user = new User();
        // logic adding all fields

        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public List<Long> getEatmojis() {
        return eatmojis;
    }

    public void setEatmojis(List<Long> eatmojis) {
        this.eatmojis = eatmojis;
    }

    public List<Long> getDishes() {
        return dishes;
    }

    public void setDishes(List<Long> dishes) {
        this.dishes = dishes;
    }

    public List<Long> getEmojiRatings() {
        return emojiRatings;
    }

    public void setEmojiRatings(List<Long> emojiRatings) {
        this.emojiRatings = emojiRatings;
    }

    public Set<Long> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(Set<Long> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public Set<Long> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<Long> followers) {
        this.followers = followers;
    }

    public Set<Long> getFollowing() {
        return following;
    }

    public void setFollowing(Set<Long> following) {
        this.following = following;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equal(id, userDTO.id) && Objects.equal(username, userDTO.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, username);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedOn=" + modifiedOn +
                ", roles=" + roles +
                ", eatmojis=" + eatmojis +
                ", dishes=" + dishes +
                ", emojiRatings=" + emojiRatings +
                ", bookmarks=" + bookmarks +
                ", followers=" + followers +
                ", following=" + following +
                '}';
    }
}
