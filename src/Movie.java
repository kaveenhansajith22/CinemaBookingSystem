
public class Movie {

    private int movieId;
    private String movieName;
    private double duration;
    private double ticketPrice;
    private int availableSeats;

    public Movie(int movID, String movName, double dr, double tickPrice, int avSeats) {// Constructor
        movieId = movID;
        movieName = movName;
        duration = dr;
        ticketPrice = tickPrice;
        availableSeats = avSeats;
    }

    public int getMovieId() {// getter
        return movieId;
    }

    public String getMovieName() {// getter
        return movieName;
    }

    public double getDuration() {// getter
        return duration;
    }

    public double getTicketPrice() {// getter
        return ticketPrice;
    }

    public int getAvailableSeats() {// getter
        return availableSeats;
    }

    public void setTicketPrice(double tickPrice) {// setter, Setters are using to set or edit an encapsulated data
        if (tickPrice >= 0) {
            ticketPrice = tickPrice;
        } else {
            System.out.println("Invalid amount!");
        }
    }

    public boolean reduceSeats(int count) {// reduce seat function
        if (count <= 0) {// validating seats(seats cannot be minus)
            return false;
        }
        if (count > availableSeats) {
            return false;
        }
        availableSeats = availableSeats - count;// reducing seats after customer book seats huttp
        return true;
    }

    public void displayMovieDetails() {
        System.out.println("Movie ID: " + getMovieId());
        System.out.println("Movie Name: " + getMovieName());
        System.out.println("Duration: " + getDuration() + " min");
        System.out.println("Ticket Price: Rs." + getTicketPrice());
        System.out.println("Available Seats: " + getAvailableSeats());
    }
}
