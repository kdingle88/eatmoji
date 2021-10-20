
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


    @Column(name = "image_url")
    private String imageUrl;

    @NotBlank
    @Column(name = "name", nullable = false)
    @Size(max = 50)
    private String name;


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
    private Date createdOn = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_on")
    private Date modifiedOn = new Date();

    @JsonManagedReference
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User creator;

    @ManyToMany(mappedBy = "dishes", fetch = FetchType.EAGER)
    private Set<Eatmoji> eatmojis = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "dish_ratings", joinColumns = {
            @JoinColumn(name = "dish_id", referencedColumnName = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "emoji_rating_id", referencedColumnName = "id") })
    private List<EmojiRating> ratings;

    public Dish() {
    }

    public Dish(Long id, String imageUrl, String name, String description, String city, String zip, Date createdOn, Date modifiedOn, User creator, Set<Eatmoji> eatmojis, List<EmojiRating> ratings) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.description = description;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return Objects.equal(id, dish.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
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


