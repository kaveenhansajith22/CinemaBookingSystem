
import java.util.ArrayList;
import java.util.Scanner;

public class CinemaManagementSystem {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Movie> movies = new ArrayList<>();

        // Creating movie objects
        Movie movie1 = new Movie(
            1, "Forest Jungle", 150, 2000, 60
        );

        Movie movie2 = new Movie(
            2, "Space Adventure", 120, 1500, 45
        );

        Movie movie3 = new Movie(
            3, "Love Story", 110, 1200, 35
        );

        // Adding movies to the list
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);

        System.out.println("==================================");
        System.out.println("  CINEMA THEATRE MANAGEMENT SYSTEM");
        System.out.println("==================================");

        int choice;

        do {

            System.out.println("\n1. View Available Movies");
            System.out.println("2. Book Tickets");
            System.out.println("3. Exit");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    displayMovies(movies);
                    break;

                case 2:
                    bookTickets(movies);
                    break;

                case 3:
                    System.out.println("Thank you for visiting!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 3);

        input.close();
    }

    // Display all available movies
    public static void displayMovies(ArrayList<Movie> movies) {

        System.out.println("\n========== AVAILABLE MOVIES ==========");

        for (Movie movie : movies) {

            System.out.println();

            movie.displayMovieDetails();

            System.out.println("--------------------------------------");
        }
    }

    // Find a movie using its ID
    public static Movie findMovieById(ArrayList<Movie> movies, int id) {

        for (Movie movie : movies) {

            if (movie.getMovieId() == id) {
                return movie;
            }
        }

        return null;
    }

    // Book tickets
    public static void bookTickets(ArrayList<Movie> movies) {

        displayMovies(movies);

        int movieId = readInt("\nEnter Movie ID: ");

        Movie selectedMovie = findMovieById(movies, movieId);

        if (selectedMovie == null) {

            System.out.println("Movie not found!");
            return;
        }

        System.out.print("Enter Customer Name: ");
        String customerName = input.nextLine().trim();

        if (customerName.isEmpty()) {

            System.out.println("Customer name cannot be empty!");
            return;
        }

        System.out.println("\n========== TICKET TYPES ==========");
        System.out.println("1. Standard Ticket");
        System.out.println("2. Premium Ticket (+ Rs.500)");
        System.out.println("3. Student Ticket (20% discount)");

        int ticketChoice = readInt("Select Ticket Type: ");

        Ticket selectedTicket;

        switch (ticketChoice) {

            case 1:
                selectedTicket = new StandardTicket(
                    customerName,
                    selectedMovie.getMovieName(),
                    selectedMovie.getTicketPrice()
                );
                break;

            case 2:
                selectedTicket = new PremiumTicket(
                    customerName,
                    selectedMovie.getMovieName(),
                    selectedMovie.getTicketPrice()
                );
                break;

            case 3:
                selectedTicket = new StudentTicket(
                    customerName,
                    selectedMovie.getMovieName(),
                    selectedMovie.getTicketPrice()
                );
                break;

            default:
                System.out.println("Invalid ticket type!");
                return;
        }

        int seatCount = readInt("Enter Number of Seats: ");

        // Check and reduce available seats
        boolean bookingSuccessful = selectedMovie.reduceSeats(seatCount);

        if (!bookingSuccessful) {

            System.out.println(
                "Booking failed! Invalid number of seats or insufficient seats."
            );

            return;
        }

        // Display booking details
        System.out.println("\n========== BOOKING CONFIRMED ==========");

        selectedTicket.displayTicket(seatCount);

        System.out.println(
            "Remaining Seats: " + selectedMovie.getAvailableSeats()
        );

        System.out.println("=======================================");
    }

    // Read an integer safely
    public static int readInt(String message) {

        while (true) {

            System.out.print(message);

            String value = input.nextLine();

            try {

                return Integer.parseInt(value);

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number!");
            }
        }
    }
}
