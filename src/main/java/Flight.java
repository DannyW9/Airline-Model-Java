import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Flight {

    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private AirportCode destination;
    private AirportCode departureAirport;
    private String departureTime;
    private ArrayList<Integer> seatNumbers;

    public Flight(Plane plane, String flightNumber, AirportCode destination, AirportCode departureAirport, String departureTime){
        this.passengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.seatNumbers = new ArrayList<Integer>();
    }


    public Plane getPlane() {
        return this.plane;
    }

    public int getPassengers() {
        return this.passengers.size();
    }

    public AirportCode getDestination() {
        return this.destination;
    }

    public AirportCode getDepartureAirport() {
        return this.departureAirport;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public int getSeatNumbers() {
        return this.seatNumbers.size();
    }

    public int availableSeats() {
        return (this.plane.getCapacity() - this.getPassengers());
    }

    public void assignFlight(Passenger passenger){
        passenger.assignFlight(this);
    }

    public ArrayList<Passenger> getPassengerList() {
        return this.passengers;
    }

    public void randomiseSeatNumbers() {
        Collections.shuffle(this.seatNumbers);
    }

    public void determineSeatNumbers() {
        int capacity = this.getPlane().getCapacity();
        for (int i = 1; i <= capacity; i++) {
            this.seatNumbers.add(i);
        }
        randomiseSeatNumbers();
    }

    public void assignSeatNumber(Passenger passenger) {
        passenger.assignSeatNumber(seatNumbers.get(0));
        seatNumbers.remove(0);
    }

    public void bookPassenger(Passenger passenger) {
        if (availableSeats() > 0) {
            this.passengers.add(passenger);
            assignFlight(passenger);
            assignSeatNumber(passenger);
        }
    }

}
