package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RatingData {
    private final Map<String, Map<String, Double>> userItemRatings;

    public RatingData() {
        userItemRatings = new HashMap<>();
    }

    public void addRating(String user, String item, Double rating) {
        userItemRatings.putIfAbsent(user, new HashMap<>());
        userItemRatings.get(user).put(item, rating);
    }

    public Map<String, Double> getUserRatings(String user) {
        return userItemRatings.getOrDefault(user, new HashMap<>());
    }

    // Método adicionado para resolver o erro!
    public Set<String> getAllUsers() {
        return userItemRatings.keySet();
    }
}