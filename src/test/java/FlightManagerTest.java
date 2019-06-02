import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    private Plane plane;
    private Flight flight1;
    private Passenger passenger1;
    private Passenger passenger2;
    private FlightManager flightManager;

    @Before
    public void setUp() {
        plane = new Plane(PlaneType.BOEING747);
        flight1 = new Flight(plane, "FR213", AirportCode.PRG, AirportCode.DUB, "13:00");
        flight1.determineSeatNumbers();
        passenger1 = new Passenger("Dave", 2);
        passenger2 = new Passenger("Gemma", 3);
        flightManager = new FlightManager();
    }

    @Test
    public void canDetermineWeightReservedForBaggage() {
        assertEquals(10, flightManager.reservedBagWeight(flight1));
    }

    @Test
    public void canDetermineHowMuchBaggageWeightIsCurrentlyBooked__NoPassengers() {
    assertEquals(0, flightManager.bookedBagWeight(flight1));
    }

    @Test
    public void canCalculateIndividualBagWeight() {
        assertEquals(2, flightManager.calculateBagWeight(flight1));
    }

    @Test
    public void canDetermineHowMuchBaggageWeightIsCurrentlyBooked__WithPassengers() {
        flight1.bookPassenger(passenger1);
        flight1.bookPassenger(passenger2);
        assertEquals(10, flightManager.bookedBagWeight(flight1));
    }

    @Test
    public void canDetermineRemainingWeightReservedForBaggage() {
        flight1.bookPassenger(passenger1);
        assertEquals(6, flightManager.remainingBagWeight(flight1));
    }

    @Test
    public void canBookPassengerOntoPlane() {
        flightManager.bookPassengerOnFlight(flight1, passenger1);
        assertEquals(1, flight1.getPassengers());
        assertEquals(4, flightManager.bookedBagWeight(flight1));
        assertEquals(6, flightManager.remainingBagWeight(flight1));
        assertEquals("FR213", passenger1.getFlight());
    }

    @Test
    public void cannotBookPassengerOntoPlane__BagsOverWeight() {
        flightManager.bookPassengerOnFlight(flight1, passenger1);
        flightManager.bookPassengerOnFlight(flight1, passenger1);
        flightManager.bookPassengerOnFlight(flight1, passenger1);
        assertEquals(2, flight1.getPassengers());
        assertEquals(8, flightManager.bookedBagWeight(flight1));
        assertEquals(2, flightManager.remainingBagWeight(flight1));
    }
}
