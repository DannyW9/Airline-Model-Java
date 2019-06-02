import java.util.Random;

public class Passenger {

    private String name;
    private int noOfBags;
    private String flight;
    private Integer seatNumber;

    public Passenger(String name, int noOfBags) {
        this.name = name;
        this.noOfBags = noOfBags;
        this.flight = "";
        this.seatNumber = null;
    }

    public String getName() {
        return this.name;
    }

    public int getBags() {
        return this.noOfBags;
    }

    public String getFlight() {
        return this.flight;
    }

    public int getSeatNumber(){
        return this.seatNumber;
    }

    public void assignFlight(Flight flight) {
        this.flight = flight.getFlightNumber();
    }

//    public void assignSeatNumber(Flight flight) {
//        Random random = new Random();
//        int max = flight.getPlane().getCapacity();
//        this.seatNumber = random.nextInt(max) + 1;

    public void assignSeatNumber(int seat) {
        this.seatNumber = seat;


    }


}
