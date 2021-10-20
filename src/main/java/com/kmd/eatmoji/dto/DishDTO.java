package com.kmd.eatmoji.dto;

import com.google.common.base.Objects;
import com.kmd.eatmoji.models.Dish;

import java.util.*;


public class DishDTO {

    private Long id;
    private String name;
    private String city;
    private String zip;
    private String creatorUsername;
    private String description;
    private String image_url;
    private Date created_on;
    private Date modified_on;
   private  Set<Long> eatmojis = new HashSet<>();
   private  List<String> ratings = new ArrayList<>();

   public DishDTO() {

   }


    public DishDTO(Dish dish) {
        this.id = dish.getId();
        this.name = dish.getName();
        this.city = dish.getCity();
        this.zip = dish.getZip();
        this.creatorUsername = dish.getCreator().getUsername();
        this.description = dish.getDescription();
        this.image_url = dish.getImageUrl();
        this.created_on = dish.getCreatedOn();
        this.modified_on = dish.getModifiedOn();
        //refactor to != null instead of else
        if(dish.getEatmojis() == null) {
            dish.setEatmojis(new HashSet<>());
        } else {
            dish.getEatmojis().forEach(eatmoji -> this.eatmojis.add(eatmoji.getId()));
        }

        if (dish.getRatings() == null) {
            dish.setRatings(new ArrayList<>());

        } else {
            dish.getRatings().forEach(rating -> this.ratings.add(rating.getColons()));
        }




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

    public String getCreatorUsername() {
        return creatorUsername;
    }

    public void setCreatorUsername(String creatorUsername) {
        this.creatorUsername = creatorUsername;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    public Date getModified_on() {
        return modified_on;
    }

    public void setModified_on(Date modified_on) {
        this.modified_on = modified_on;
    }

    public Set<Long> getEatmojis() {
        return eatmojis;
    }

    public void setEatmojis(Set<Long> eatmojis) {
        this.eatmojis = eatmojis;
    }

    public List<String> getRatings() {
        return ratings;
    }

    public void setRatings(List<String> ratings) {
        this.ratings = ratings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishDTO dishDTO = (DishDTO) o;
        return Objects.equal(id, dishDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "DishDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", creatorUsername='" + creatorUsername + '\'' +
                ", description='" + description + '\'' +
                ", image_url='" + image_url + '\'' +
                ", created_on=" + created_on +
                ", modified_on=" + modified_on +
                ", eatmojis=" + eatmojis +
                ", ratings=" + ratings +
                '}';
    }
}
