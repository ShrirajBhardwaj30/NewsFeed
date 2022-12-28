package services;

import dao.Post;

import java.util.Comparator;
import java.util.List;

public class SimplePostRankingStrategy implements RankingStrategy<Post> {
    private static SimplePostRankingStrategy instance = null;
    private SimplePostRankingStrategy() {}

    @Override
    public List<Post> rank(List<Post> objects) {
        objects.sort((Comparator.comparingInt(Post::getLikes).reversed()));
        return objects;
    }

    public static synchronized SimplePostRankingStrategy getInstance() {
        if (instance == null) {
            instance = new SimplePostRankingStrategy();
        }
        return instance;
    }
}
