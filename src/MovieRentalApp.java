import java.util.*;

/*
  Dms Movie project that includes attributes such as title, genre, rental price,
  availability status, rating, and rental duration.
 */
class Movie {
    private String title;
    private String genre;
    private double rentalPrice;
    private boolean available;
    private double rating;
    private int rentalDuration;

    // Constructor to initialize movie details
    public Movie(String title, String genre, double rentalPrice, boolean available, double rating) {
        this.title = title;
        this.genre = genre;
        this.rentalPrice = rentalPrice;
        this.available = available;
        this.rating = rating;
        this.rentalDuration = 0;
    }

    // Getter - to access movie attributes
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public double getRentalPrice() { return rentalPrice; }
    public boolean isAvailable() { return available; }
    public double getRating() { return rating; }
    public int getRentalDuration() { return rentalDuration; }

    // Setter - to modify movie attributes
    public void setRentalPrice(double rentalPrice) { this.rentalPrice = rentalPrice; }
    public void setAvailability(boolean available) { this.available = available; }
    public void setRating(double rating) { this.rating = rating; }
    public void setRentalDuration(int duration) { this.rentalDuration = duration; }

    //  to calculate total rental cost based on duration
    public double calculateTotalRentalCost() {
        return rentalDuration * rentalPrice;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Genre: " + genre + ", Price: $" + rentalPrice + ", Available: " + available + ", Rating: " + rating;
    }
}

/*
 Manages a collection of movies with CRUD operations and rental cost calculation.
 */
class MovieRentalSystem {
    private List<Movie> movies = new ArrayList<>();

    //  to add a new movie to the collection
    public void addMovie(Movie movie) {
        movies.add(movie);
        System.out.println("Movie added successfully!");
    }

    //  to display all available movies
    public void displayMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies available :( ");
            return;
        }
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    //  to remove a movie by title
    public void removeMovie(String title) {
        if (movies.removeIf(movie -> movie.getTitle().equalsIgnoreCase(title))) {
            System.out.println("Movie removed successfully.");
        } else {
            System.out.println("Error: Movie not found!");
        }
    }

    //  to update movie details such as price, availability, and rating
    public void updateMovie(String title, double newPrice, boolean newAvailability, double newRating) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                movie.setRentalPrice(newPrice);
                movie.setAvailability(newAvailability);
                movie.setRating(newRating);
                System.out.println("Movie updated successfully!");
                return;
            }
        }
        System.out.println("Error: Movie not found!");
    }

    //  to calculate total rental cost for a movie based on rental duration
    public void calculateRentalCost(String title, int duration) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                movie.setRentalDuration(duration);
                System.out.println("Total rental cost: $" + movie.calculateTotalRentalCost());
                return;
            }
        }
        System.out.println("Error: Movie not found!");
    }
}

/*
 Main application class for the Movie Rental Management System.
 Provides a menu-driven interface for users to interact with the system.
 */
public class MovieRentalApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieRentalSystem system = new MovieRentalSystem();

        while (true) {
            try {
                // Display menu options
                System.out.println("\nMovie Rental Management System");
                System.out.println("1. Add Movie");
                System.out.println("2. Display Movies");
                System.out.println("3. Remove Movie");
                System.out.println("4. Update Movie");
                System.out.println("5. Calculate Rental Cost");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1:
                        // Add a new movie
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine().trim();
                        System.out.print("Enter genre: ");
                        String genre = scanner.nextLine().trim();
                        System.out.print("Enter rental price: ");
                        double price = Double.parseDouble(scanner.nextLine().trim());
                        System.out.print("Enter rating (0-5): ");
                        double rating = Double.parseDouble(scanner.nextLine().trim());
                        System.out.print("Is available? (yes/no): ");
                        boolean available = Boolean.parseBoolean(scanner.nextLine().trim());
                        system.addMovie(new Movie(title, genre, price, available, rating));
                        break;
                    case 2:
                        // Display movies
                        system.displayMovies();
                        break;
                    case 3:
                        // Remove a movie
                        System.out.print("Enter movie title to remove: ");
                        title = scanner.nextLine().trim();
                        system.removeMovie(title);
                        break;
                    case 4:
                        // Update movie details
                        System.out.print("Enter movie title to update: ");
                        title = scanner.nextLine().trim();
                        System.out.print("Enter new rental price: ");
                        price = Double.parseDouble(scanner.nextLine().trim());
                        System.out.print("Is available? (yes/no): ");
                        available = Boolean.parseBoolean(scanner.nextLine().trim());
                        System.out.print("Enter new rating (0-5): ");
                        rating = Double.parseDouble(scanner.nextLine().trim());
                        system.updateMovie(title, price, available, rating);
                        break;
                    case 5:
                        // Calculate rental cost
                        System.out.print("Enter movie title: ");
                        title = scanner.nextLine().trim();
                        System.out.print("Enter rental duration (days): ");
                        int duration = Integer.parseInt(scanner.nextLine().trim());
                        system.calculateRentalCost(title, duration);
                        break;
                    case 6:
                        // Exit program
                        System.out.println("Exiting program.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1-6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input!");
            }
        }
    }
}