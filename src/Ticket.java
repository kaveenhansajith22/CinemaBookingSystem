public class Ticket {
    private String customerName;// Encapsulated
    private String movieName;// Encapsulated
    private double basePrice;// Encapsulated

    public Ticket(String Tname, String movName, double bPrice) { // constructor
        customerName = Tname;
        movieName = movName;
        basePrice = bPrice;
    }

    public String getCustomerName() {// getter, Getters are using to access the encapsulated data.
        return customerName;
    }

    public String getMovieName() {// getter
        return movieName;
    }

    public double getBasePrice() {// getter
        return basePrice;
    }

    public double calculatePrice() {
        return basePrice;
    }

    public double calculateTotalPrice(int seatCount) {// calculate total price multiply by seat count
        return calculatePrice() * seatCount;
    }

    public void displayTicket(int seatCount) {// display ticket details function
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
