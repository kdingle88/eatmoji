package com.kmd.eatmoji.dto;

import com.google.common.base.Objects;
import com.kmd.eatmoji.models.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

public class UserDTO {
    private Long id;
    @NotBlank
    @Size(min = 5, max = 15, message = "Username must be between 5 and 15 characters.")
    private String username;

    @Email
    private String email;
    private String name;
    private String city;
    private String zip;
    private Date createdOn;
    private Date modifiedOn;
    private Set<String> roles = new HashSet<>();
    private List<Long> eatmojis = new ArrayList<>();
    private List<Long> dishes = new ArrayList<>();
    private List<Long> emojiRatings = new ArrayList<>();
    private Set<Long> bookmarks = new HashSet<>();
    private Set<String> followers = new HashSet<>();
    private Set<String> following = new HashSet<>();

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.name = user.getName();
        this.city = user.getCity();
        this.zip = user.getZip();
        this.createdOn = user.getCreatedOn();
        this.modifiedOn = user.getModifiedOn();
        user.getRoles().forEach(role -> this.roles.add(role.getName().name()));
        user.getEatmojis().forEach(eatmoji -> this.eatmojis.add(eatmoji.getId()));
        user.getDishes().forEach(dish -> this.dishes.add(dish.getId()));
        user.getEmojiRatings().forEach(rating -> this.emojiRatings.add(rating.getId()));
        user.getBookmarks().forEach(bookmark -> this.bookmarks.add(bookmark.getId()));
        user.getFollowers().forEach(follower -> this.followers.add(follower.getUsername()));
        user.getFollowing().forEach(follow -> this.following.add(follow.getUsername()));

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<String> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<String> followers) {
        this.followers = followers;
    }

    public Set<String> getFollowing() {
        return following;
    }

    public void setFollowing(Set<String> following) {
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
                ", name='" + name + '\'' +
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
