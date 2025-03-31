import javax.swing.SwingUtilities;

public class MovieRentalApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MovieRentalGUI::new);
    }
}