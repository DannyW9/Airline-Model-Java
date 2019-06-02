import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FlightTest {

    private Plane plane;
    private Flight flight;
    private Passenger passenger1;
    private Passenger passenger2;

    @Before
    public void setUp() {
        plane = new Plane(PlaneType.BEECHCRAFT1900);
        flight = new Flight(plane, "FR213", AirportCode.CDG, AirportCode.GLA);
        flight.determineSeatNumbers();
        flight.setDepartureTime(2019, 6, 25, 13, 00, 00);
        passenger1 = new Passenger("Dave", 2);
        passenger2 = new Passenger("Gemma", 3);
        }

    @Test
    public void hasPlane() {
        assertEquals(3, flight.getPlane().getCapacity());
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
        assertNotEquals(null , flight.getDepartureTime());
    }

    @Test
    public void hasSeatNumbers() {
        assertEquals(3, flight.getSeatNumbers());
    }

    @Test
    public void canCalculateAvailableSeats__noPassengers() {
        assertEquals(3, flight.availableSeats());
    }

    @Test
    public void canBookPassengerOntoFlight() {
        flight.bookPassenger(passenger1);
        assertEquals(1, flight.getPassengers());
        assertEquals(2, flight.getSeatNumbers());
        assertNotEquals(0, passenger1.getSeatNumber());
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
        assertEquals(2, flight.availableSeats());
    }

    @Test
    public void cannotBookPassenger__NoSpace() {
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger1);
        assertEquals(3, flight.getPassengers());
    }

    @Test
    public void canAssignFlightToPassenger() {
        flight.assignFlight(passenger1);
        assertEquals("FR213", passenger1.getFlight());
    }

    @Test
    public void canAssignSeatNumber() {
        flight.assignSeatNumber(passenger1);
        assertEquals(2, flight.getSeatNumbers());
        assertNotEquals(0, passenger1.getSeatNumber());
    }
}
