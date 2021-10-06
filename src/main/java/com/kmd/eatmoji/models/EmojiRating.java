package com.kmd.eatmoji.models;

import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "emoji_ratings")
public class EmojiRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    public Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank
    @Column(name = "type", nullable = false, unique = true)
    private String type;

    @NotBlank
    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User admin;

    public EmojiRating() {

    }

    public EmojiRating(Long id, String name, String type, String imageUrl, User admin) {

        this.id = id;
        this.name = name;
        this.type = type;
        this.imageUrl = imageUrl;
        this.admin = admin;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public User getAdmin() {
        return admin;
    }

    public void setUser(User admin) {
        this.admin = admin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EmojiRating other = (EmojiRating) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "EmojiRating [id=" + id + ", name=" + name + ", type=" + type + ", imageUrl=" + imageUrl + ", user="
                + admin + "]";
    }



}

