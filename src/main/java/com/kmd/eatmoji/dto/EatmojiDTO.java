package com.kmd.eatmoji.dto;

import com.google.common.base.Objects;
import com.kmd.eatmoji.models.Eatmoji;

import java.util.*;

public class EatmojiDTO {

    private Long id;
    private String name;
    private String imageUrl;
    private Date createdOn;
    private Date modifiedOn;
    private String user;
    private Set<String> bookmarkedUsers = new HashSet<>();
    private List<Long> dishes = new ArrayList<>();

    public EatmojiDTO(Eatmoji eatmoji) {

        this.id = eatmoji.getId();
        this.name = eatmoji.getName();
        this.imageUrl = eatmoji.getImageUrl();
        this.createdOn = eatmoji.getCreatedOn();
        this.modifiedOn = eatmoji.getModifiedOn();
        this.user = eatmoji.getUser().getUsername();
        eatmoji.getBookmarkedUsers().forEach(user -> this.bookmarkedUsers.add(user.getUsername()));
        eatmoji.getDishes().forEach(dish -> this.dishes.add(dish.getId()));

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Set<String> getBookmarkedUsers() {
        return bookmarkedUsers;
    }

    public void setBookmarkedUsers(Set<String> bookmarkedUsers) {
        this.bookmarkedUsers = bookmarkedUsers;
    }

    public List<Long> getDishes() {
        return dishes;
    }

    public void setDishes(List<Long> dishes) {
        this.dishes = dishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EatmojiDTO that = (EatmojiDTO) o;
        return Objects.equal(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "EatmojiDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedOn=" + modifiedOn +
                ", user=" + user +
                ", bookmarkedUsers=" + bookmarkedUsers +
                ", dishes=" + dishes +
                '}';
    }
}
