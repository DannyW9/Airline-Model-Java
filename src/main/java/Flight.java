import java.util.ArrayList;

public class Flight {

    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private AirportCode destination;
    private AirportCode departureAirport;
    private String departureTime;

    public Flight(Plane plane, String flightNumber, AirportCode destination, AirportCode departureAirport, String departureTime){
        this.passengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
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

    public int availableSeats() {
        return (this.plane.getCapacity() - this.getPassengers());
    }

    public void bookPassenger(Passenger passenger) {
        if (availableSeats() > 0) {
            this.passengers.add(passenger);
        }
    }

    public ArrayList<Passenger> getPassengerList() {
        return this.passengers;
    }
}
