package com.kmd.eatmoji.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.Objects;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;


    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @JsonIgnore
    @NotBlank
    @Size(max = 120)
    private String password;


    @Size(max = 100)
    private String name;

    @Size(max = 50)
    private String city;

    @Size(max = 50)
    private String zip;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    private Date createdOn = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_on")
    private Date modifiedOn = new Date();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<Eatmoji> eatmojis = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "creator")
    private List<Dish> dishes = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "creator")
    private List<EmojiRating> emojiRatings = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "bookmarks", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "eatmoji_id", referencedColumnName = "id")})
    @JsonIgnoreProperties("bookmarkedUsers")
    private Set<Eatmoji> bookmarks = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "follows", joinColumns = {
            @JoinColumn(name = "followed_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "follower_id", referencedColumnName = "id")})
    @JsonIgnoreProperties("following")
    private Set<User> followers = new HashSet<>();

    @ManyToMany(mappedBy = "followers", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("followers")
    private Set<User> following = new HashSet<>();


    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(Long id, String username, String email, String password, String name, String city, String zip, Date createdOn, Date modifiedOn, Set<Role> roles, List<Eatmoji> eatmojis, List<Dish> dishes, List<EmojiRating> emojiRatings, Set<Eatmoji> bookmarks, Set<User> followers, Set<User> following) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.city = city;
        this.zip = zip;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.roles = roles;
        this.eatmojis = eatmojis;
        this.dishes = dishes;
        this.emojiRatings = emojiRatings;
        this.bookmarks = bookmarks;
        this.followers = followers;
        this.following = following;
    }

    public void addFollowing(User user) {
        following.add(user);
        user.getFollowers().add(this);
    }

    public void removeFollowing(User user) {
        following.remove(user);
        user.getFollowers().remove(this);
    }


    public void addBookmark(Eatmoji toBookmark) {
        bookmarks.add(toBookmark);
        //Then add user to Eatmoji's bookmarkedUsers. Both will be ran in service
    }

    public void removeBookmark(Eatmoji removeBookmark) {
        bookmarks.remove(removeBookmark);
        //Then remove user from Eatmoji's bookmarkedUsers. Both will be ran in service
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
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
        User user = (User) o;
        return Objects.equal(id, user.id) && Objects.equal(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, username);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
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
