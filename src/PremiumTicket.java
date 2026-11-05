
public class PremiumTicket extends Ticket {

    public PremiumTicket(String Tname, String movName, double bPrice) {
        super(Tname, movName, bPrice);
    }

    @Override
    public double calculatePrice() {
        return getBasePrice() + 500;
    }
}
