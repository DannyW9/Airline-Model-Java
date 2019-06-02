import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PassengerTest {

    private Passenger passenger;
    private Plane plane;
    private Flight flight;

    @Before
    public void setUp() {
        passenger = new Passenger("Dave", 2);
        plane = new Plane(PlaneType.BEECHCRAFT1900);
        flight = new Flight(plane, "FR213", AirportCode.CDG, AirportCode.GLA, "11:00");
    }

    @Test
    public void hasName() {
        assertEquals("Dave", passenger.getName());
    }

    @Test
    public void hasBags() {
        assertEquals(2, passenger.getBags());
    }

    @Test
    public void hasFlight() {
        assertEquals("", passenger.getFlight());
    }

    @Test
    public void canAssignFlight() {
        passenger.assignFlight(flight);
        assertEquals("FR213", passenger.getFlight());
    }

    @Test
    public void canAssignRandomSeatNumber() {
//        passenger.assignSeatNumber(flight);
        passenger.assignSeatNumber(2);
        assertEquals(2, passenger.getSeatNumber());
//        assertNotEquals(0, passenger.getSeatNumber());
    }
}
