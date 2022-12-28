package services;

import dao.*;

public class PostServices {

    public static void addPost(Post p, String uid) throws UserNotPresentException {
        User s = UserCollections.getInstance().getUser(uid);
        if (s == null) {
            throw new UserNotPresentException("user doesn't exist with uid " + uid);
        }
        s.addPost(p);
        PostCollections.getInstance().addPost(p);
    }

    public static void addPost(Post p, User s) throws UserNotPresentException {
        addPost(p, s.getUserId());
    }

    public static void addComment(String pId, Comment c) throws PostNotPresentException {
        Post p = PostCollections.getInstance().getPost(pId);
        if (p == null) {
            throw new PostNotPresentException("post doesn't exists");
        }

        p.addComment(c);
    }

    public static void addComment(Post p, Comment c) throws PostNotPresentException {
        addComment(p.getPostId(), c);
    }

    public static void addLike(String pId) throws PostNotPresentException {
        Post p = PostCollections.getInstance().getPost(pId);
        if (p == null) {
            throw new PostNotPresentException("post doesn't exists");
        }

        p.addLikes();
    }

    public static void addLike(Post p) throws PostNotPresentException {
        addLike(p.getPostId());
    }

    public static void addDisLike(String pId) throws PostNotPresentException {
        Post p = PostCollections.getInstance().getPost(pId);
        if (p == null) {
            throw new PostNotPresentException("post doesn't exists");
        }

        p.addDisLikes();
    }

    public static void addDisLike(Post p) throws PostNotPresentException {
        addDisLike(p.getPostId());
    }
}
