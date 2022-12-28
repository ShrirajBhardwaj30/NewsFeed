package controller;

import dao.Comment;
import dao.Post;
import dao.User;
import services.*;

import java.util.List;

public class MainController {
    private static NewsFeedServices newsFeedServices = new NewsFeedServices(SimplePostRankingStrategy.getInstance());
    public static void main(String []args) throws UserNotPresentException, PostNotPresentException {
        User shriraj = UserServices.registerUser("Shriraj");
        User venkat = UserServices.registerUser("Venkat");
        User arjun = UserServices.registerUser("arjun");

        // shriraj -> venkat -> arjun
        UserServices.follow(shriraj, venkat);
        UserServices.follow(shriraj, arjun);
        UserServices.follow(venkat, arjun);

        Post ShrirajPost = new Post("Shriraj Posts");
        Post ArjunPost = new Post("Arjun Posts");
        Post VenkatPost = new Post("Venkat Posts");

        PostServices.addPost(ShrirajPost, shriraj);
        PostServices.addPost(ArjunPost, arjun);
        PostServices.addPost(VenkatPost, venkat);

        PostServices.addLike(ShrirajPost);
        PostServices.addLike(ArjunPost);
        PostServices.addLike(VenkatPost);
        PostServices.addLike(ArjunPost);

        Comment ShrirajComment = new Comment("adding first comment to arjun");

        PostServices.addComment(ArjunPost, ShrirajComment);

        List<Post> feedShriraj = newsFeedServices.getFeed(shriraj);
        List<Post> feedArjun = newsFeedServices.getFeed(arjun);
        List<Post> feedVenkat = newsFeedServices.getFeed(venkat);

        System.out.println("feedVenkat");
    }
}
