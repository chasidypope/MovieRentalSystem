import java.util.List;
import java.util.Scanner;

public class MovieRentalApp {
    public static void main(String[] args) {
        MovieRentalSystem system = new MovieRentalSystem();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Load movies from file");
            System.out.println("2. Add new movie");
            System.out.println("3. List all movies");
            System.out.println("4. Calculate total rental cost");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter file name (e.g., movies.txt): ");
                    String filename = scanner.nextLine();
                    if (system.loadMoviesFromFile(filename)) {
                        System.out.println("Movies loaded successfully.");
                    } else {
                        System.out.println("Failed to load movies.");
                    }
                    break;
                case "2":
                    try {
                        System.out.print("Enter movie title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter genre: ");
                        String genre = scanner.nextLine();
                        System.out.print("Enter price: ");
                        double price = Double.parseDouble(scanner.nextLine());
                        System.out.print("Is rented? (yes/no): ");
                        boolean rented = scanner.nextLine().equalsIgnoreCase("yes");
                        System.out.print("Enter rating (1-5): ");
                        int rating = Integer.parseInt(scanner.nextLine());


                        system.addMovie(title, genre, price, rented, rating);
                        System.out.println("Movie added successfully.");
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please try again.");
                    }
                    break;
                case "3":

                    List<String> moviesList = system.listMovies();
                    if (moviesList.isEmpty()) {
                        System.out.println("No movies available.");
                    } else {
                        for (String movie : moviesList) {
                            System.out.println(movie);
                        }
                    }
                    break;
                case "4":
                    double total = system.calculateTotalRentalCost();
                    System.out.printf("Total rental cost: $%.2f\n", total);
                    break;
                case "5":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}