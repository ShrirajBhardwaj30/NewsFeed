package dao;

import java.util.Objects;
import java.util.UUID;

public class Comment {
    private String commentId;

    private String text;

    public Comment(String text) {
        this.commentId = UUID.randomUUID().toString();
        this.text = text;
    }

    public String getCommentId() {
        return commentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(commentId, comment.commentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId);
    }
}
