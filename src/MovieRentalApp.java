import java.util.Scanner;

public class MovieRentalApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieRentalSystem system = new MovieRentalSystem();

        while (true) {
            System.out.println("\nMovie Rental System Menu:");
            System.out.println("1. Load Movies from File");
            System.out.println("2. Display Movies");
            System.out.println("3. Add Movie");
            System.out.println("4. Update Movie");
            System.out.println("5. Remove Movie");
            System.out.println("6. Calculate Total Rental Cost");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter filename: ");
                    String filename = scanner.nextLine();
                    if (system.loadMoviesFromFile(filename)) {
                        System.out.println("Movies loaded successfully.");
                    } else {
                        System.out.println("Failed to load movies.");
                    }
                    break;
                case 2:
                    system.displayMovies();
                    break;
                case 3:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter release year: ");
                    int year = scanner.nextInt();
                    System.out.print("Is it available? (yes/no): ");
                    boolean available = scanner.next().equalsIgnoreCase("yes");
                    System.out.print("Enter rating (0-5): ");
                    int rating = scanner.nextInt();
                    if (system.addMovie(title, genre, year, available, rating)) {
                        System.out.println("Movie added successfully.");
                    } else {
                        System.out.println("Invalid rating. Movie not added.");
                    }
                    break;
                case 4:
                    System.out.print("Enter movie title to update: ");
                    title = scanner.nextLine();
                    System.out.print("Enter new genre: ");
                    genre = scanner.nextLine();
                    System.out.print("Enter new release year: ");
                    year = scanner.nextInt();
                    System.out.print("Is it available? (yes/no): ");
                    available = scanner.next().equalsIgnoreCase("yes");
                    System.out.print("Enter new rating (0-5): ");
                    rating = scanner.nextInt();
                    if (system.updateMovie(title, genre, year, available, rating)) {
                        System.out.println("Movie updated successfully.");
                    } else {
                        System.out.println("Movie not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter movie title to remove: ");
                    title = scanner.nextLine();
                    if (system.removeMovie(title)) {
                        System.out.println("Movie removed.");
                    } else {
                        System.out.println("Movie not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter number of days rented: ");
                    int days = scanner.nextInt();
                    double totalCost = system.calculateTotalRental(days);
                    System.out.println("Total rental cost: $" + totalCost);
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}