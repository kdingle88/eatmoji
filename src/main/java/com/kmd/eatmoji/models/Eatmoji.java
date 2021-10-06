package com.kmd.eatmoji.models;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "eatMojis")
public class Eatmoji {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @NotBlank
    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    private Date createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_on")
    private Date modifiedOn;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(mappedBy = "bookmarks", fetch = FetchType.LAZY)
    private List<User> bookmarkedUsers;




    public Eatmoji() {

    }

    public Eatmoji(Long id, String imageUrl, Date createdOn, Date modifiedOn, User user, List<User> bookmarkedUsers) {
        super();
        this.id = id;
        this.imageUrl = imageUrl;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.user = user;
        this.bookmarkedUsers = bookmarkedUsers;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<User> getBookmarkedUsers() {
        return bookmarkedUsers;
    }

    public void setBookmarkedUsers(List<User> bookmarkedUsers) {
        this.bookmarkedUsers = bookmarkedUsers;
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
        Eatmoji other = (Eatmoji) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "EatMoji [id=" + id + ", imageUrl=" + imageUrl + ", createdOn=" + createdOn + ", modifiedOn="
                + modifiedOn + ", user=" + user + ", bookmarkedUsers=" + bookmarkedUsers + "]";
    }



}
