import utils.TicketInfo;

public class MainApp {
    public static void main(String[] args) {
        TaxiTicket ticket = new TaxiTicket(new TicketInfo("Alice", "Downtown", "Airport", 50.0), 30.0, 60.0);

        ticket.detailedInfo();

        ticket.checkStatus();

        ticket.displayRoute();
        ticket.displayEstimatedDuration();

        ticket.sLowDown(20);
        ticket.speedUp(15);
    }
}
