import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MovieRentalSystem {
    private List<Movie> movies = new ArrayList<>();

    // Load movies from file
    public boolean loadMoviesFromFile(String filename) {
        movies.clear(); // clear previous data
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

    // Add movie to list
    public void addMovie(String title, String genre, double price, boolean rented, int rating) {
        movies.add(new Movie(title, genre, price, rented, rating));
    }

    // List movies
    public List<String> listMovies() {
        List<String> list = new ArrayList<>();
        for (Movie movie : movies) {
            list.add(movie.toString());
        }
        return list;
    }

    // Calculate total rental cost
    public double calculateTotalRentalCost() {
        double total = 0;
        for (Movie movie : movies) {
            if (movie.isRented()) {
                total += movie.getPrice();
            }
        }
        return total;
    }
}

