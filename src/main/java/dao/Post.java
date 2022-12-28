package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Post {
    private String postId;
    private String data;

    private int likes;
    private int dislikes;

    private List<Comment> commentList;

    public Post(String data) {
        this.postId = UUID.randomUUID().toString();
        this.data = data;
        this.commentList = new ArrayList<>();
    }

    public String getPostId() {
        return postId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getLikes() {
        return likes;
    }

    public int addLikes() {
        likes = likes + 1;
        return likes;
    }

    public int removeLikes() {
        likes = likes - 1;
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public int addDisLikes() {
        dislikes = dislikes + 1;
        return dislikes;
    }

    public int removeDislikes() {
        dislikes = dislikes - 1;
        return dislikes;
    }


    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public void addComment(Comment comment) {
        this.commentList.add(comment);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(postId, post.postId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId);
    }
}
