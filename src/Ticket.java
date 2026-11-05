public class Ticket {
    private String customerName;
    private String movieName;
    private double basePrice;

    public Ticket(String Tname, String movName, double bPrice) {
        customerName = Tname;
        movieName = movName;
        basePrice = bPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMovieName() {
        return movieName;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double calculatePrice() {
        return basePrice;
    }

    public double calculateTotalPrice(int seatCount) {
        return calculatePrice() * seatCount;
    }

    public void displayTicket(int seatCount) {
        System.out.println("Customer: " + getCustomerName());
        System.out.println("Movie: " + getMovieName());
        System.out.println("Price: Rs." + calculatePrice());
        System.out.println("Ticket Type: " + getClass().getSimpleName());
        System.out.println("Number of Seats: " + seatCount);
        System.out.println("Price per Ticket: Rs." + calculatePrice());

        double totalPrice = calculatePrice() * seatCount;

        System.out.println("Total Price: Rs." + totalPrice);
    }

}
