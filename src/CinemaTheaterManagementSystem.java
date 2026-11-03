
import java.util.ArrayList;
import java.util.Scanner;

public class CinemaTheaterManagementSystem {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Movie> movies = new ArrayList<>();

    public static void main(String[] args) {
        Movie m1 = new Movie(1, "menna awith gorillek", 120, 1000, 60);
        Movie m2 = new Movie(2, "Ranja", 100, 900, 89);
        Movie m3 = new Movie(3, "ispooder man", 120, 130, 20);

        movies.add(m1);
        movies.add(m2);
        movies.add(m3);

        System.out.println("========================================");
        System.out.println("    CINEMA THEATRE MANAGEMENT SYSTEM    ");
        System.out.println("========================================");

        int choice = 0;

        while (choice != 3) {
            System.out.println("\n1. View Available Movies");
            System.out.println("2. Book Tickets");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.println("\n==== Available Movies ====");

                for (int i = 0; i < movies.size(); i++) {
                    movies.get(i).displayMoviedetails();
                    System.out.println(" ");
                }
            } else if (choice == 2) {

                System.out.println("\n==== Available Movies ====");

                for (int i = 0; i < movies.size(); i++) {
                    movies.get(i).displayMoviedetails();
                    System.out.println(" ");
                }
                System.out.println("Enter Movie ID : ");
                int movieID = input.nextInt();
                input.nextLine();
                // is this for book a ticket
                Movie selectedMovie = null;

                for (int i = 0; i < movies.size(); i++) {
                    if (movies.get(i).getMovieID() == movieID) {
                        selectedMovie = movies.get(i);
                        break;
                    }
                }
                if (selectedMovie == null) {
                    System.out.println("Movie not found !");
                } else {
                    System.out.println("Enter customer name : ");
                    String cusName = input.nextLine();

                    if (cusName == "") {
                        System.out.println("Customer name cannot be empty!");
                    } else {
                        System.out.println("\n===== TICKET TYPES =====");
                        System.out.println("1. Standard Ticket");
                        System.out.println("2. Premium Ticket (+ Rs.500)");
                        System.out.println("3. Student Ticket (20% discount)");
                        System.out.println("Select Ticket Type:");
                        int ticketType = input.nextInt();

                        System.out.println("Enter number of seats : ");
                        int seatCount = input.nextInt();

                        boolean seatsAvailable = selectedMovie.reduceSeats(seatCount);

                        if (seatsAvailable == false) {
                            System.out.println("Booking failed, Invalid number of seats!");
                        } else {
                            Ticket selectedTicket = null;

                            if (ticketType == 1) {
                                selectedTicket = new StandardTicket(cusName, selectedMovie.getMoviename(),
                                        selectedMovie.getTicketprice());
                            } else if (ticketType == 2) {
                                selectedTicket = new PremiumTicket(cusName, selectedMovie.getMoviename(),
                                        selectedMovie.getTicketprice());

                            } else if (ticketType == 3) {
                                selectedTicket = new StudentTicket(cusName, selectedMovie.getMoviename(),
                                        selectedMovie.getTicketprice());
                            } else {
                                System.out.println("Invalid ticket type!");
                            }
                            if (selectedTicket != null) {
                                System.out.println("\n========== BOOKING CONFIRMED ==========");
                                selectedTicket.displayTicket(seatCount);
                                System.out.println("Remaining seats : " + selectedMovie.getAvailableseats());
                                System.out.println("");
                            }
                        }
                    }
                }

            } else if (choice == 3) {
                System.out.println("Thankyou for visiting!");
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }
        input.close();
    }
}