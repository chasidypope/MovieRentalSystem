import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class MovieRentalSystemTest {
    private MovieRentalSystem system;

    @BeforeEach
    void setUp() {
        system = new MovieRentalSystem();
    }

    @Test
    void testLoadMoviesFromFile() {
        boolean result = system.loadMovies("movies.txt");
        assertTrue(result, "Movies should be loaded successfully");
    }

    @Test
    void testAddMovie() {
        Movie movie = new Movie("Inception", "Sci-Fi", 4.5, true, 5);
        system.addMovie(movie);
        assertTrue(system.getMovies().contains(movie), "Movie should be added successfully");
    }

    @Test
    void testDeleteMovie() {
        Movie movie = new Movie("Titanic", "Drama", 3.5, false, 4);
        system.addMovie(movie);
        boolean result = system.removeMovie("Titanic");
        assertTrue(result, "Movie should be removed successfully");
    }

    @Test
    void testUpdateMovie() {
        Movie movie = new Movie("Avatar", "Action", 4.0, true, 5);
        system.addMovie(movie);
        boolean updated = system.updateMovie("Avatar", "Fantasy", 4.2, false, 3);
        assertTrue(updated, "Movie details should be updated");
    }

    @Test
    void testInvalidFileLoad() {
        boolean result = system.loadMovies("nonexistent.txt");
        assertFalse(result, "Loading a nonexistent file should return false");
    }

    @Test
    void testInvalidUserInputHandling() {
        assertThrows(NumberFormatException.class, () -> {
            system.handleUserInput("invalid_number");
        }, "Invalid input should throw an exception");
    }
}
