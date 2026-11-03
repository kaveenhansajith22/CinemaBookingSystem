
public class StudentTicket extends Ticket {// inherits from the parent class Ticket in Ticket.java

    public StudentTicket(String Tname, String movName, double bPrice) {// Constructor inherits since the Ticket parent
                                                                       // class has a constructor hutto
        super(Tname, movName, bPrice);
    }

    @Override // polymorphism used from the Ticket.java parent class
    public double calculatePrice() {
        return getBasePrice() * 0.80;
    }
}
