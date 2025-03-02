public class Movie {
    private String title;
    private String genre;
    private int releaseYear;
    private boolean available;
    private int rating;

    public Movie(String title, String genre, int releaseYear, boolean available, int rating) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.available = available;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return title + " (" + releaseYear + ") - " + genre + " - Rating: " + rating + " - Available: " + (available ? "Yes" : "No");
    }
}