import java.io.*;
import java.util.*;

public class MovieRentalSystem {
    private List<Movie> movies; // Stores all movies in the system

    // Constructor
    public MovieRentalSystem() {
        this.movies = new ArrayList<>();
    }

    //  ADD MOVIE
    public boolean addMovie(String title, String genre, int releaseYear, boolean available, int rating) {
        if (rating < 0 || rating > 5) {
            System.out.println("Error: Rating must be between 0 and 5.");
            return false;
        }
        Movie newMovie = new Movie(title, genre, releaseYear, available, rating);
        movies.add(newMovie);
        return true;
    }

    //  READ MOVIES FROM FILE
    public boolean loadMoviesFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String title = data[0].trim();
                    String genre = data[1].trim();
                    int releaseYear = Integer.parseInt(data[2].trim());
                    boolean available = data[3].trim().equalsIgnoreCase("yes");
                    int rating = Integer.parseInt(data[4].trim());

                    addMovie(title, genre, releaseYear, available, rating);
                }
            }
            return true;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading movies: " + e.getMessage());
            return false;
        }
    }

    //  DISPLAY MOVIES
    public List<Movie> getMovies() {
        return new ArrayList<>(movies); // Return a copy to prevent modification
    }

    public void displayMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies available.");
            return;
        }
        System.out.println("List of Movies:");
        for (Movie movie : movies) {
            System.out.println(movie); // Assumes Movie class has a proper toString()
        }
    }

    //  UPDATE MOVIE DETAILS
    public boolean updateMovie(String title, String newGenre, int newYear, boolean newAvailable, int newRating) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                movie.setGenre(newGenre);
                movie.setReleaseYear(newYear);
                movie.setAvailable(newAvailable);
                movie.setRating(newRating);
                return true;
            }
        }
        return false;
    }

    // REMOVE MOVIE
    public boolean removeMovie(String title) {
        Iterator<Movie> iterator = movies.iterator();
        while (iterator.hasNext()) {
            Movie movie = iterator.next();
            if (movie.getTitle().equalsIgnoreCase(title)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    //  CALCULATE TOTAL RENTAL COST
    public double calculateTotalRental(int daysRented) {
        if (daysRented <= 0) {
            System.out.println("Error: Days rented must be greater than 0.");
            return 0;
        }
        return movies.size() * daysRented * 2.5; // Assuming $2.5 per movie per day
    }
}