
public class Movie {

    private int movieId;
    private String movieName;
    private double duration;
    private double ticketPrice;
    private int availableSeats;

    public Movie(int movID, String movName, double dr, double tickPrice, int avSeats) {
        movieId = movID;
        movieName = movName;
        duration = dr;
        ticketPrice = tickPrice;
        availableSeats = avSeats;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public double getDuration() {
        return duration;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setTicketPrice(double tickPrice) {
        if (tickPrice >= 0) {
            ticketPrice = tickPrice;
        } else {
            System.out.println("Invalid amount!");
        }
    }

    public boolean reduceSeats(int count) {
        if (count <= 0) {
            return false;
        }
        if (count > availableSeats) {
            return false;
        }
        availableSeats = availableSeats - count;
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
