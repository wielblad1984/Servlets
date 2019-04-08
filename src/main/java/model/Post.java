package model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Post {

    private static int ID_COUNTER=0;

    private Instant date;
    private String text;
    private User user;
    private int id;
    private List<Comment>comments;


    public Post(String text, User user) {
        this.id = ID_COUNTER;
        this.date=Instant.now();
        this.text = text;
        this.user = user;
        this.comments=new ArrayList<>();
        ID_COUNTER ++;
    }
    public void addComment(Comment comment){
        this.comments.add(comment);

    }

    public List<Comment> getComments() {
        return comments;
    }

    public int getId() {
        return id;
    }

    public Instant getDate() {
        return date;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(date, post.date) &&
                Objects.equals(text, post.text) &&
                Objects.equals(user, post.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, text, user);
    }

    @Override
    public String toString() {
        return "Post{" +
                "date=" + date +
                ", text='" + text + '\'' +
                ", user=" + user +
                '}';
    }
}
