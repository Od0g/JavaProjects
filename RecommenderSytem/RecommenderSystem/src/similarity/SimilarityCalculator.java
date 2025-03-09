package similarity;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SimilarityCalculator {
    
    // Similaridade de Cosseno
    public static double cosineSimilarity(Map<String, Double> user1Ratings, Map<String, Double> user2Ratings) {
        double dotProduct = 0.0;
        double norm1 = 0.0;
        double norm2 = 0.0;

        Set<String> commonItems = new HashSet<>(user1Ratings.keySet());
        commonItems.retainAll(user2Ratings.keySet());

        for (String item : commonItems) {
            double r1 = user1Ratings.get(item);
            double r2 = user2Ratings.get(item);
            dotProduct += r1 * r2;
            norm1 += Math.pow(r1, 2);
            norm2 += Math.pow(r2, 2);
        }

        if (norm1 == 0 || norm2 == 0) return 0;
        return dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
    }
}