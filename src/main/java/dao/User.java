package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class User {
    private String userId;

    private String name;

    private List<Post> posts;

    private List<User> followers;

    public User(String name) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.followers = new ArrayList<User>();
        this.posts = new ArrayList<Post>();
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public String getUserId() {
        return userId;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public void addFollowers(User following) {
        this.followers.add(following);
    }

    public void removeFollowers(User following) {
        int index = this.followers.indexOf(following);
        if (index != -1) {
            this.followers.remove(index);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId.equals(user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
