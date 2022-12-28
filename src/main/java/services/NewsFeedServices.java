package services;


import dao.Post;
import dao.User;
import dao.UserCollections;

import java.util.List;
import java.util.stream.Collectors;

public class NewsFeedServices {
    private RankingStrategy<Post> PostRankingStrategy;

    public NewsFeedServices(RankingStrategy<Post> postRankingStrategy) {
        this.PostRankingStrategy = postRankingStrategy;
    }

    public List<Post> getFeed(String userId) throws UserNotPresentException {
        User user = UserCollections.getInstance().getUser(userId);
        if (user == null) {
            throw new UserNotPresentException("user doesn't exists");
        }
        List<Post> posts = user.getFollowers().stream()
                .map(User::getPosts).flatMap(List::stream).collect(Collectors.toList());
        return this.PostRankingStrategy.rank(posts);
    }

    public List<Post> getFeed(User user) throws UserNotPresentException {
        return getFeed(user.getUserId());
    }
}
