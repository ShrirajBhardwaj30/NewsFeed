package dao;

import java.util.HashMap;
import java.util.Map;

public class PostCollections {
    private Map<String, Post> posts;
    private static PostCollections postCollections = null;

    private PostCollections() {
        this.posts = new HashMap<String, Post>();
    }

    public static synchronized PostCollections getInstance() {
         if (postCollections == null) {
             postCollections = new PostCollections();
         }
         return postCollections;
    }

    public Map<String, Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        posts.put(post.getPostId(), post);
    }

    public Post getPost(String pid) {
        return posts.getOrDefault(pid, null);
    }
}
