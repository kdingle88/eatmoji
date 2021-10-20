package com.kmd.eatmoji.dto;

import com.google.common.base.Objects;
import com.kmd.eatmoji.models.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FollowingDTO {


    private String username;
    private String name;
    private String city;
    private List<EatmojiDTO> eatmojis = new ArrayList<>();


    public FollowingDTO(User user) {
        this.username = user.getUsername();
        this.name = user.getName();
        this.city = user.getCity();
        user.getEatmojis().forEach(eatmoji -> this.eatmojis.add(new EatmojiDTO(eatmoji)));


    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public List<EatmojiDTO> getEatmojis() {
        return eatmojis;
    }

    public void setEatmojis(List<EatmojiDTO> eatmojis) {
        this.eatmojis = eatmojis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FollowingDTO that = (FollowingDTO) o;
        return Objects.equal(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }

    @Override
    public String toString() {
        return "FollowingDTO{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", eatmojis=" + eatmojis +
                '}';
    }
}
