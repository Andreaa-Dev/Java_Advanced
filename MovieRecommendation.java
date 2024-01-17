import java.util.*;

class Movie {
    private String title;
    private Set<String> genres;

    public Movie(String title, Set<String> genres) {
        this.title = title;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public Set<String> getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genres=" + genres +
                '}';
    }
}

public class MovieRecommendation{

    public static List<Movie> recommendMovies(List<Movie> allMovies, Set<String> userPreferences, int topN) {
        List<Movie> recommendedMovies = new ArrayList<>();

        for (Movie movie : allMovies) {
            double similarity = calculateSimilarity(movie.getGenres(), userPreferences);
            if (similarity > 0.5) {  // Adjust the threshold based on desired similarity level
                recommendedMovies.add(movie);
            }
        }

        recommendedMovies.sort(Comparator.comparingDouble(movie -> calculateSimilarity(movie.getGenres(), userPreferences)));
        Collections.reverse(recommendedMovies);
        
        return recommendedMovies.subList(0, Math.min(topN, recommendedMovies.size()));
    }

    private static double calculateSimilarity(Set<String> genres1, Set<String> genres2) {
        // Calculate cosine similarity between two sets of genres
        Set<String> intersection = new HashSet<>(genres1);
        intersection.retainAll(genres2);

        double dotProduct = intersection.size();
        double norm1 = Math.sqrt(genres1.size());
        double norm2 = Math.sqrt(genres2.size());

        if (norm1 == 0 || norm2 == 0) {
            return 0;  // Avoid division by zero
        }

        return dotProduct / (norm1 * norm2);
    }

    public static void main(String[] args) {
        // Example usage
        List<Movie> allMovies = Arrays.asList(
                new Movie("Movie1", new HashSet<>(Arrays.asList("Action", "Adventure"))),
                new Movie("Movie2", new HashSet<>(Arrays.asList("Comedy", "Romance"))),
                new Movie("Movie3", new HashSet<>(Arrays.asList("Action", "Drama")))
        );

        Set<String> userPreferences = new HashSet<>(Arrays.asList("Action", "Adventure"));

        int topN = 2;
        List<Movie> recommendedMovies = recommendMovies(allMovies, userPreferences, topN);

        System.out.println("Recommended Movies:");
        for (Movie movie : recommendedMovies) {
            System.out.println(movie);
        }
    }
}
