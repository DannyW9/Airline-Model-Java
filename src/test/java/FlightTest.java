import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    private Plane plane;
    private Flight flight;
    private Passenger passenger1;
    private Passenger passenger2;

    @Before
    public void setUp() {
        plane = new Plane(PlaneType.BOEING747);
        flight = new Flight(plane, "FR213", AirportCode.CDG, AirportCode.GLA, "11:00");
        passenger1 = new Passenger("Dave", 2);
        passenger2 = new Passenger("Gemma", 3);
        }

    @Test
    public void hasPlane() {
        assertEquals(5, flight.getPlane().getCapacity());
    }

    @Test
    public void hasPassengers__StartsAt0() {
        assertEquals(0, flight.getPassengers());
    }

    @Test
    public void hasFlightNumber() {
        assertEquals("FR213", flight.getFlightNumber());
    }

    @Test
    public void hasDestination() {
        assertEquals(AirportCode.CDG, flight.getDestination());
    }

    @Test
    public void hasDepartureAirport() {
        assertEquals(AirportCode.GLA, flight.getDepartureAirport());
    }

    @Test
    public void hasDepartureTime() {
        assertEquals("11:00", flight.getDepartureTime());
    }

    @Test
    public void canCalculateAvailableSeats__noPassengers() {
        assertEquals(5, flight.availableSeats());
    }

    @Test
    public void canBookPassengerOntoFlight() {
        flight.bookPassenger(passenger1);
        assertEquals(1, flight.getPassengers());
    }

    @Test
    public void canBookMultiplePassengersOntoFlight() {
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        assertEquals(2, flight.getPassengers());
    }

    @Test
    public void canCalculateAvailableSeats__withPassengersBooked() {
        flight.bookPassenger(passenger1);
        assertEquals(4, flight.availableSeats());
    }
}
