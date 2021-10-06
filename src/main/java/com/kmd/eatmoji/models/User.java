package com.kmd.eatmoji.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "users",
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

    @NotBlank
    @Size(max = 120)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Eatmoji> myEatMojis;

    @OneToMany(mappedBy = "admin")
    private List<EmojiRating> myEmojiRatings;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "bookmarks", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "eatMoji_id", referencedColumnName = "id") })
    private Set<Eatmoji> bookmarks;

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(Long id, String username, String email, String password, Set<Role> roles, Set<Eatmoji> myEatMojis, List<EmojiRating> myEmojiRatings, Set<Eatmoji> bookmarks) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.myEatMojis = myEatMojis;
        this.myEmojiRatings = myEmojiRatings;
        this.bookmarks = bookmarks;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Eatmoji> getMyEatMojis() {
        return myEatMojis;
    }

    public void setMyEatMojis(Set<Eatmoji> myEatMojis) {
        this.myEatMojis = myEatMojis;
    }

    public List<EmojiRating> getMyEmojiRatings() {
        return myEmojiRatings;
    }

    public void setMyEmojiRatings(List<EmojiRating> myEmojiRatings) {
        this.myEmojiRatings = myEmojiRatings;
    }

    public Set<Eatmoji> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(Set<Eatmoji> bookmarks) {
        this.bookmarks = bookmarks;
    }
}
