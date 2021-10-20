package com.kmd.eatmoji.dto;

import com.google.common.base.Objects;

public class BookmarkDTO {

    private String currentUser;
    private Long eatmojiToBookmark;

    public BookmarkDTO (String currentUser, Long eatmojiToBookmark) {
        this.currentUser = currentUser;
        this.eatmojiToBookmark = eatmojiToBookmark;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public Long getEatmojiToBookmark() {
        return eatmojiToBookmark;
    }

    public void setEatmojiToBookmark(Long eatmojiToBookmark) {
        this.eatmojiToBookmark = eatmojiToBookmark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookmarkDTO that = (BookmarkDTO) o;
        return Objects.equal(currentUser, that.currentUser) && Objects.equal(eatmojiToBookmark, that.eatmojiToBookmark);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(currentUser, eatmojiToBookmark);
    }

    @Override
    public String toString() {
        return "BookmarkDTO{" +
                "currentUser='" + currentUser + '\'' +
                ", eatmojiToBookmark=" + eatmojiToBookmark +
                '}';
    }
}
