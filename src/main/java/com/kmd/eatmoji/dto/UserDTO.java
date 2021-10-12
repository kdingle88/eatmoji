package com.kmd.eatmoji.dto;

import com.google.common.base.Objects;
import com.kmd.eatmoji.models.Dish;
import com.kmd.eatmoji.models.Eatmoji;
import com.kmd.eatmoji.models.EmojiRating;
import com.kmd.eatmoji.models.User;

import java.util.List;
import java.util.Set;

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String city;
    private String zip;
    private Set roles;
    private List<Eatmoji> eatmojis;
    private List<Dish> dishes;
    private List<EmojiRating> emojiRatings;
    private Set<Eatmoji> bookmarks;
    private Set<User> followers;
    private Set<User> following;

    public UserDTO(User user) {

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

    public Set getRoles() {
        return roles;
    }

    public void setRoles(Set roles) {
        this.roles = roles;
    }

    public List<Eatmoji> getEatmojis() {
        return eatmojis;
    }

    public void setEatmojis(List<Eatmoji> eatmojis) {
        this.eatmojis = eatmojis;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<EmojiRating> getEmojiRatings() {
        return emojiRatings;
    }

    public void setEmojiRatings(List<EmojiRating> emojiRatings) {
        this.emojiRatings = emojiRatings;
    }

    public Set<Eatmoji> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(Set<Eatmoji> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }

    public Set<User> getFollowing() {
        return following;
    }

    public void setFollowing(Set<User> following) {
        this.following = following;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equal(id, userDTO.id) && Objects.equal(username, userDTO.username) && Objects.equal(email, userDTO.email) && Objects.equal(city, userDTO.city) && Objects.equal(zip, userDTO.zip) && Objects.equal(roles, userDTO.roles) && Objects.equal(eatmojis, userDTO.eatmojis) && Objects.equal(dishes, userDTO.dishes) && Objects.equal(emojiRatings, userDTO.emojiRatings) && Objects.equal(bookmarks, userDTO.bookmarks) && Objects.equal(followers, userDTO.followers) && Objects.equal(following, userDTO.following);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, username, email, city, zip, roles, eatmojis, dishes, emojiRatings, bookmarks, followers, following);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
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
