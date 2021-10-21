package com.kmd.eatmoji.dto;

import com.google.common.base.Objects;
import com.kmd.eatmoji.models.EmojiRating;

import java.util.ArrayList;
import java.util.List;

public class DishRatingDTO {
    private Long dishId;
    private List<String> emojiRatings = new ArrayList<>();

    public DishRatingDTO (Long dishId, List<String> emojiRatings) {
        this.dishId = dishId;
        emojiRatings.forEach(emoji -> this.emojiRatings.add(emoji));
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public List<String> getEmojiRatings() {
        return emojiRatings;
    }

    public void setEmojiRatings(List<String> emojiRatings) {
        this.emojiRatings = emojiRatings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishRatingDTO that = (DishRatingDTO) o;
        return Objects.equal(dishId, that.dishId) && Objects.equal(emojiRatings, that.emojiRatings);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dishId, emojiRatings);
    }

    @Override
    public String toString() {
        return "DishRatingDTO{" +
                "dishId=" + dishId +
                ", emojiRatings=" + emojiRatings +
                '}';
    }
}
