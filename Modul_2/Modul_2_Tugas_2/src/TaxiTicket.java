public class TaxiTicket {
    public String pName;
    public String sLocation;
    public String dest;
    public double prc;
    private double duration;
    private double speed;

    private static final double MIN_SPEED = 5;
    private static final double MAX_SPEED = 100;

    public TaxiTicket(String passengerName, String startLocation, String destination,
                      double price, double duration, double speed) {
        this.pName = passengerName;
        this.sLocation = startLocation;
        this.dest = destination;
        this.prc = price;
        this.duration = duration;
        this.speed = speed;
    }

    public void cS() {
        System.out.println("Your taxi is heading to " + dest);
    }

    public void dED() {
        System.out.println("Estimated travel duration: " + duration + " minutes");
    }

    public void dR() {
        System.out.println("Route: " + sLocation + " -> " + dest);
    }

    public void sLowDown(double speedReduction) {
        speed -= speedReduction;
        if (speed < MIN_SPEED) {
            speed = MIN_SPEED;
        }
        duration += speedReduction * 0.5;
        System.out.println("Taxi slowed down! Current speed: " + speed + " km/h");
    }

    public void speedUp(double speedIncrease) {
        speed += speedIncrease;
        if (speed > MAX_SPEED) {
            speed = MAX_SPEED;
        }
        System.out.println("Taxi sped up! Current speed: " + speed + " km/h");
    }

    public void dI() {
        System.out.println("Passenger Name : " + pName);
        System.out.println("Start Location : " + sLocation);
        System.out.println("Destination    : " + dest);
        System.out.println("Price          : " + prc);
        System.out.println("Final Price    : " + (prc + (prc * 0.1))); // Price including 10% tax
    }

    public void detailedInfo() {
        dI();
        System.out.println("Duration       : " + duration + " minutes");
        System.out.println("Speed          : " + speed + " km/h");
    }

    public static void main(String[] args) {
        TaxiTicket ticket = new TaxiTicket("Alice", "Downtown", "Airport", 50.0, 30.0, 60.0);

        ticket.detailedInfo();

        ticket.cS();

        ticket.dR();
        ticket.dED();

        ticket.sLowDown(20);
        ticket.speedUp(15);
    }
}
