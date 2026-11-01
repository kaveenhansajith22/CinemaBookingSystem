
public class StudentTicket extends Ticket {

    public StudentTicket(String Tname, String movName, double bPrice) {
        super(Tname, movName, bPrice);
    }

    @Override
    public double calculatePrice() {
        return getBasePrice() * 0.80;
    }
}
