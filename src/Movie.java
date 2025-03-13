public class Movie {
    private String title;
    private String genre;
    private double price;
    private boolean rented;
    private int rating;

    public Movie(String title, String genre, double price, boolean rented, int rating) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.rented = rented;
        this.rating = rating;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    public boolean isRented() {
        return rented;
    }

    public int getRating() {
        return rating;
    }

    // Convert to CSV
    public String toCSV() {
        return title + "," + genre + "," + price + "," + (rented ? "yes" : "no") + "," + rating;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Genre: " + genre + ", Price: $" + price + ", Rented: " + (rented ? "yes" : "no") + ", Rating: " + rating;
    }
}