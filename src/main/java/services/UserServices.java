package services;

import dao.User;
import dao.UserCollections;

public class UserServices {

    public static User registerUser(String name) {
        User user = new User(name);
        user.setName(name);
        return UserCollections.getInstance().addUser(user);
    }

    public static void follow(String follower, String followee) throws UserNotPresentException {
        User Follower = UserCollections.getInstance().getUser(follower);
        User Followee = UserCollections.getInstance().getUser(followee);

        if (Followee == null || Follower == null) {
            throw new UserNotPresentException("user doens't exist");
        }

        Follower.addFollowers(Followee);
    }

    public static void follow(User follower, User followee) throws UserNotPresentException {
        follow(follower.getUserId(), followee.getUserId());
    }

    public static void unfollow(String follower, String followee) throws UserNotPresentException {
        User Follower = UserCollections.getInstance().getUser(follower);
        User Followee = UserCollections.getInstance().getUser(followee);

        if (Followee == null || Follower == null) {
            throw new UserNotPresentException("user doens't exist");
        }

        Follower.removeFollowers(Followee);
    }

    public static void unfollow(User follower, User followee) throws UserNotPresentException {
        unfollow(follower.getUserId(), followee.getUserId());
    }
}
