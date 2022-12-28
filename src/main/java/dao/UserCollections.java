package dao;

import java.util.HashMap;
import java.util.Map;

public class UserCollections {
    private Map<String, User> users;
    private static UserCollections userCollections = null;

    private UserCollections() {
        this.users = new HashMap<String, User>();
    }

    public static synchronized UserCollections getInstance() {
        if (userCollections == null) {
            userCollections = new UserCollections();
        }
        return userCollections;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public User addUser(User user) {
        users.put(user.getUserId(), user);
        return user;
    }

    public User getUser(String uid) {
        return users.getOrDefault(uid, null);
    }
}

