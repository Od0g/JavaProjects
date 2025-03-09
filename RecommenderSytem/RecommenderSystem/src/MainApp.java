import model.RatingData;
import recommender.RecommenderSystem;

public class MainApp {
    public static void main(String[] args) {
        // 1. Inicializar estrutura de dados
        RatingData ratingData = new RatingData();
        
        // 2. Adicionar avaliações
        ratingData.addRating("Alice", "Item1", 5.0);
        ratingData.addRating("Alice", "Item2", 3.0);
        ratingData.addRating("Alice", "Item3", 4.0);
        
        ratingData.addRating("Bob", "Item1", 4.0);
        ratingData.addRating("Bob", "Item3", 5.0);
        ratingData.addRating("Bob", "Item4", 3.0);
        
        ratingData.addRating("Charlie", "Item2", 4.0);
        ratingData.addRating("Charlie", "Item3", 2.0);
        ratingData.addRating("Charlie", "Item4", 5.0);

        // 3. Criar sistema de recomendação
        RecommenderSystem recommender = new RecommenderSystem(ratingData);
        
        // 4. Gerar recomendações
        String targetUser = "Alice";
        var recommendations = recommender.recommendItems(targetUser);
        
        System.out.println("Recomendações para " + targetUser + ": " + recommendations);
    }
}