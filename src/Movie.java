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
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public double getPrice() { return price; }
    public boolean isRented() { return rented; }
    public int getRating() { return rating; }

    // Setters
    public void setRented(boolean rented) { this.rented = rented; }

    @Override
    public String toString() {
        return title + " (" + genre + ") - $" + price + " - " +
                (rented ? "Rented" : "Available") + " - Rating: " + rating + "/5";
    }
}