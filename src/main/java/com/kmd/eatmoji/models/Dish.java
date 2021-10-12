
package com.kmd.eatmoji.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.base.Objects;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @NotBlank
    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @NotBlank
    @Column(name = "name", nullable = false)
    @Size(max = 50)
    private String name;

    @NotBlank
    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "city")
    @Size(max = 50)
    private String city;

    @Column(name = "zip")
    @Size(max = 50)
    private String zip;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    private Date createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_on")
    private Date modifiedOn;

    @JsonManagedReference
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User creator;

    @ManyToMany(mappedBy = "dishes", fetch = FetchType.EAGER)
    private Set<Eatmoji> eatmojis = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "dish_ratings", joinColumns = {
            @JoinColumn(name = "dish_id", referencedColumnName = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "emojiRating_id", referencedColumnName = "id") })
    private List<EmojiRating> ratings;

    public Dish() {
    }

    public Dish(Long id, String imageUrl, String city, String zip, Date createdOn, Date modifiedOn, User creator, Set<Eatmoji> eatmojis, List<EmojiRating> ratings) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.city = city;
        this.zip = zip;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.creator = creator;
        this.eatmojis = eatmojis;
        this.ratings = ratings;
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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Set<Eatmoji> getEatmojis() {
        return eatmojis;
    }

    public void setEatmojis(Set<Eatmoji> eatmojis) {
        this.eatmojis = eatmojis;
    }

    public List<EmojiRating> getRatings() {
        return ratings;
    }

    public void setRatings(List<EmojiRating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Objects.equal(id, dish.id) && Objects.equal(imageUrl, dish.imageUrl) && Objects.equal(city, dish.city) && Objects.equal(zip, dish.zip) && Objects.equal(createdOn, dish.createdOn) && Objects.equal(modifiedOn, dish.modifiedOn) && Objects.equal(creator, dish.creator) && Objects.equal(eatmojis, dish.eatmojis) && Objects.equal(ratings, dish.ratings);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, imageUrl, city, zip, createdOn, modifiedOn, creator, eatmojis, ratings);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedOn=" + modifiedOn +
                ", creator=" + creator +
                ", eatmojis=" + eatmojis +
                ", ratings=" + ratings +
                '}';
    }
}


