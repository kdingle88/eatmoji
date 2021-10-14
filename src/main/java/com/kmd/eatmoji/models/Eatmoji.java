package com.kmd.eatmoji.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.base.Objects;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "eatmojis")
public class Eatmoji {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;


    @NotBlank
    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    private Date createdOn = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_on")
    private Date modifiedOn = new Date();

    @JsonManagedReference
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(mappedBy = "bookmarks", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("bookmarks")
    private Set<User> bookmarkedUsers = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "eatmoji_dishes", joinColumns = {
            @JoinColumn(name = "eatmoji_id", referencedColumnName = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "dish_id", referencedColumnName = "id") })
    private List<Dish> dishes = new ArrayList<>();




    public Eatmoji() {

    }

    public Eatmoji(Long id, String imageUrl, Date createdOn, Date modifiedOn, User user, Set<User> bookmarkedUsers, List<Dish> dishes) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.user = user;
        this.bookmarkedUsers = bookmarkedUsers;
        this.dishes = dishes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<User> getBookmarkedUsers() {
        return bookmarkedUsers;
    }

    public void setBookmarkedUsers(Set<User> bookmarkedUsers) {
        this.bookmarkedUsers = bookmarkedUsers;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eatmoji eatmoji = (Eatmoji) o;
        return Objects.equal(id, eatmoji.id) && Objects.equal(imageUrl, eatmoji.imageUrl) && Objects.equal(createdOn, eatmoji.createdOn) && Objects.equal(modifiedOn, eatmoji.modifiedOn) && Objects.equal(user, eatmoji.user) && Objects.equal(bookmarkedUsers, eatmoji.bookmarkedUsers) && Objects.equal(dishes, eatmoji.dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, imageUrl, createdOn, modifiedOn, user, bookmarkedUsers, dishes);
    }

    @Override
    public String toString() {
        return "Eatmoji{" +
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
