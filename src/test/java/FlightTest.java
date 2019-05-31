import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    private Plane plane;
    private Flight flight;

    @Before
    public void setUp() {
        this.plane = new Plane(PlaneType.BOEING747);
        this.flight = new Flight(plane, "FR213", AirportCode.CDG, AirportCode.GLA, "11:00");
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
}
