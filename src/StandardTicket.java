public class StandardTicket extends Ticket {

    public StandardTicket(String Tname, String movName, double bPrice) {
        super(Tname, movName, bPrice);
    }

    @Override
    public double calculatePrice() {
        return getBasePrice();
    }
}