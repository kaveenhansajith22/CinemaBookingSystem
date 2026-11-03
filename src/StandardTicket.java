public class StandardTicket extends Ticket {// inherits from the parent class Ticket in Ticket.java

    public StandardTicket(String Tname, String movName, double bPrice) {// Constructor inherits since the Ticket parent
                                                                        // class has a constructor hutto
        super(Tname, movName, bPrice);
    }

    @Override // polymorphism used from the Ticket.java parent class
    public double calculatePrice() {
        return getBasePrice();
    }
}