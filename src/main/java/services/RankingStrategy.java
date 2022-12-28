package services;

import java.util.List;

public interface RankingStrategy<T> {
    List<T> rank(List<T> objects);
}
