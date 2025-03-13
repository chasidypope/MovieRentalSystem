import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MovieRentalGUI extends JFrame {
    private MovieRentalSystem system = new MovieRentalSystem();
    private JTextArea outputArea = new JTextArea();

    public MovieRentalGUI() {
        setTitle("Movie Rental System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        JPanel panel = new JPanel();

        JButton loadButton = new JButton("Load Movies");
        JButton addButton = new JButton("Add Movie");
        JButton listButton = new JButton("List Movies");
        JButton totalButton = new JButton("Total Rental Cost");

        panel.add(loadButton);
        panel.add(addButton);
        panel.add(listButton);
        panel.add(totalButton);

        add(panel, BorderLayout.SOUTH);

        // Action Listeners
        loadButton.addActionListener((ActionEvent e) -> loadMovies());
        addButton.addActionListener((ActionEvent e) -> addMovie());
        listButton.addActionListener((ActionEvent e) -> listMovies());
        totalButton.addActionListener((ActionEvent e) -> calculateTotal());

        setVisible(true);
    }

    private void loadMovies() {
        String filename = JOptionPane.showInputDialog(this, "Enter file name (e.g., movies.txt):");
        if (filename != null && !filename.isEmpty()) {
            boolean success = system.loadMoviesFromFile(filename);
            outputArea.setText(success ? "Movies loaded successfully!\n" : "Failed to load movies.\n");
        }
    }

    private void addMovie() {
        try {
            String title = JOptionPane.showInputDialog(this, "Enter title:");
            String genre = JOptionPane.showInputDialog(this, "Enter genre:");
            double price = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter price:"));
            String rentedInput = JOptionPane.showInputDialog(this, "Is rented? (yes/no):");
            boolean rented = rentedInput.equalsIgnoreCase("yes");
            int rating = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter rating (1-5):"));

            system.addMovie(title, genre, price, rented, rating);
            outputArea.setText("Movie added successfully!\n");
        } catch (Exception ex) {
            outputArea.setText("Invalid input. Please try again.\n");
        }
    }

    private void listMovies() {
        List<String> movies = system.listMovies();
        if (movies.isEmpty()) {
            outputArea.setText("No movies available.\n");
        } else {
            outputArea.setText("");
            for (String movie : movies) {
                outputArea.append(movie + "\n");
            }
        }
    }

    private void calculateTotal() {
        double total = system.calculateTotalRentalCost();
        outputArea.setText("Total Rental Cost for rented movies: $" + total + "\n");
    }

    public static void main(String[] args) {
        new MovieRentalGUI();
    }
}
