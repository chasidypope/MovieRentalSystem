import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MovieRentalSystem {
    private final List<Movie> movies = new ArrayList<>();

    public boolean loadMoviesFromFile(String filename) {
        movies.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String title = data[0].trim();
                    String genre = data[1].trim();
                    double price = Double.parseDouble(data[2].trim());
                    boolean rented = data[3].trim().equalsIgnoreCase("yes");
                    int rating = Integer.parseInt(data[4].trim());
                    movies.add(new Movie(title, genre, price, rented, rating));
                }
            }
            return true;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading movies: " + e.getMessage());
            return false;
        }
    }

    public void addMovie(String title, String genre, double price, boolean rented, int rating) {
        movies.add(new Movie(title, genre, price, rented, rating));
    }

    public List<String> listMovies() {
        List<String> movieList = new ArrayList<>();
        for (Movie movie : movies) {
            movieList.add(movie.toString());
        }
        return movieList;
    }

    public double calculateTotalRentalCost() {
        double total = 0;
        for (Movie movie : movies) {
            if (movie.isRented()) {
                total += movie.getPrice();
            }
        }
        return total;
    }

    public List<Movie> getAllMovies() {
        return movies;
    }
}