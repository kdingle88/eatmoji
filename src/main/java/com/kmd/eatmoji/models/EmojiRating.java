package com.kmd.eatmoji.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.base.Objects;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "emoji_ratings")
public class EmojiRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    public Long id;


//    @NotBlank
    @Column(name = "name")
    private String name;

//    @NotBlank
    @Column(name = "type")
    private String type;

    @NotBlank
    @Column(name = "colons", nullable = false, updatable = false)
    private String colons;

    @Column(name = "skin")
    private String skin;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "custom_category")
    private String customCategory;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User creator;

    @ManyToMany(mappedBy = "ratings", fetch = FetchType.EAGER)
    private List<Dish> dishes = new ArrayList<>();

    public EmojiRating() {

    }

    public EmojiRating(String name, String type, String colons) {
        this.name = name;
        this.type = type;
        this.colons = colons;
    }

    public EmojiRating(Long id, String name, String type, String colons, String skin, String imageUrl, String customCategory, User creator, List<Dish> dishes) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.colons = colons;
        this.skin = skin;
        this.imageUrl = imageUrl;
        this.customCategory = customCategory;
        this.creator = creator;
        this.dishes = dishes;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColons() {
        return colons;
    }

    public void setColons(String colons) {
        this.colons = colons;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCustomCategory() {
        return customCategory;
    }

    public void setCustomCategory(String customCategory) {
        this.customCategory = customCategory;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
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
        EmojiRating that = (EmojiRating) o;
        return Objects.equal(id, that.id) && Objects.equal(name, that.name) && Objects.equal(type, that.type) && Objects.equal(colons, that.colons) && Objects.equal(skin, that.skin) && Objects.equal(imageUrl, that.imageUrl) && Objects.equal(customCategory, that.customCategory) && Objects.equal(creator, that.creator) && Objects.equal(dishes, that.dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, type, colons, skin, imageUrl, customCategory, creator, dishes);
    }

    @Override
    public String toString() {
        return "EmojiRating{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", colons='" + colons + '\'' +
                ", skin='" + skin + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", customCategory='" + customCategory + '\'' +
                ", creator=" + creator +
                ", dishes=" + dishes +
                '}';
    }
}

