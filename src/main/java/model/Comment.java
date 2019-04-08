package model;

import java.time.Instant;
import java.util.Objects;

public class Comment {
    private String commentText;
    private String color;
    private boolean like;
    private User user;
    private Instant date;

    public Comment(String commentText, String color, boolean like, User user) {
        this.commentText = commentText;
        this.color = color;
        this.like = like;
        this.user = user;
        this.date = Instant.now();
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instant getDate() {
        return date;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return like == comment.like &&
                Objects.equals(commentText, comment.commentText) &&
                Objects.equals(color, comment.color) &&
                Objects.equals(user, comment.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentText, color, like, user);
    }
}

