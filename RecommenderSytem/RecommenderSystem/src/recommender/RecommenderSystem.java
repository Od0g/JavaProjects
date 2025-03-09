package recommender;

import model.RatingData;
import similarity.SimilarityCalculator;
import java.util.*;

public class RecommenderSystem {
    private final RatingData ratingData;

    public RecommenderSystem(RatingData ratingData) {
        this.ratingData = ratingData;
    }

    public List<String> recommendItems(String targetUser) {
        Map<String, Double> targetRatings = ratingData.getUserRatings(targetUser);
        Map<String, Double> weightedSums = new HashMap<>();
        Map<String, Double> simSums = new HashMap<>();

        for (String otherUser : ratingData.getAllUsers()) {
            if (otherUser.equals(targetUser)) continue;

            Map<String, Double> otherRatings = ratingData.getUserRatings(otherUser);
            double sim = SimilarityCalculator.cosineSimilarity(targetRatings, otherRatings);
            
            if (sim <= 0) continue;

            for (String item : otherRatings.keySet()) {
                if (!targetRatings.containsKey(item)) {
                    weightedSums.put(item, weightedSums.getOrDefault(item, 0.0) + otherRatings.get(item) * sim);
                    simSums.put(item, simSums.getOrDefault(item, 0.0) + sim);
                }
            }
        }

        Map<String, Double> rankings = new HashMap<>();
        for (String item : weightedSums.keySet()) {
            rankings.put(item, weightedSums.get(item) / simSums.get(item));
        }

        return rankings.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .toList();
    }
}